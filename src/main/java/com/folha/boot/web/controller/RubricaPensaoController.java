package com.folha.boot.web.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.FuncionariosFerias;
import com.folha.boot.domain.RubricaPensao;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.BancosService;
import com.folha.boot.service.CargaHorariaSemanalService;
import com.folha.boot.service.ClassesCarreiraService;
import com.folha.boot.service.RubricaPensaoService;
import com.folha.boot.service.FonteService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.RubricaPensaoDependenteService;
import com.folha.boot.service.TipoBrutoLiquidoService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/rubricaPensao")
public class RubricaPensaoController {

	String ultimoAnoMes = "";
	String ultimoNome = "";
	String ultimaBuscaNome = "";

	@Autowired
	private RubricaPensaoService service;
	@Autowired
	private RubricaPensaoDependenteService dependenteService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private BancosService bancosService;
	@Autowired
	private ClassesCarreiraService classesCarreiraService;
	@Autowired
	private CargaHorariaSemanalService cargaHorariaSemanalService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private FonteService fonteService;
	@Autowired
	private TipoBrutoLiquidoService tipoBrutoLiquidoService;
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Paginação de funcionários */
	@GetMapping("/paginar/funcionarios/{pageNo}")
	public String getPorNomePaginadoInclusao(@PathVariable(value = "pageNo") int pageNo, ModelMap model) {

		if ((ultimaBuscaNome.equals(""))) {
			return "redirect:/rubricaPensao/funcionarios/listar/{pageNo}";
		} else {
			if (!ultimaBuscaNome.equals("")) {
				return this.findPaginatedFuncionario(pageNo, ultimaBuscaNome, model);
			} else {
				return "redirect:/rubricaPensao/funcionarios/listar/{pageNo}";
			}
		}
	}

	@GetMapping("/funcionarios/listar")
	public String listarFuncionarios(ModelMap model) {
		ultimaBuscaNome = "";
		return this.findPaginatedFuncionario(1, model);
	}

	@GetMapping("/funcionarios/listar/{pageNo}")
	public String findPaginatedFuncionario(@PathVariable(value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginatedDeTodasAsUnidades(pageNo, pageSeze,
				"ATIVO");
		List<PessoaFuncionarios> listaFuncionarios = page.getContent();
		return paginarFuncionario(pageNo, page, listaFuncionarios, model);
	}

	public String paginarFuncionario(int pageNo, Page<PessoaFuncionarios> page, List<PessoaFuncionarios> lista,
			ModelMap model) {
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listaFuncionarios", lista);
		return "/rubricaPensao/listafuncionario";
	}

	@GetMapping("/buscar/funcionarios/nome")
	public String getPorNomeFuncionario(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		// this.ultimaBuscaTurma = null;
		return this.findPaginatedFuncionario(1, nome, model);
	}

	public String findPaginatedFuncionario(@PathVariable(value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 50;
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginatedNomeDeTodasAsUnidades(pageNo, pageSeze,
				"ATIVO", nome);
		List<PessoaFuncionarios> lista = page.getContent();
		// ultimaBuscaNome = "";
		// ultimaBuscaTurma = null;
		return paginarFuncionario(pageNo, page, lista, model);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Fim da Paginação de funcionários */

	/*
	 * @GetMapping("/cadastrar") public String cadastrar(RubricaPensao
	 * rubricaPensao) {
	 * 
	 * return "/rubricaPensao/cadastro"; }
	 */

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimoAnoMes = "";
		this.ultimoNome = "";
		return this.findPaginated(1, model);
	}

	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<RubricaPensao> page = service.findPaginated(pageNo, pageSeze);
		List<RubricaPensao> listaCidades = page.getContent();
		return paginar(pageNo, page, listaCidades, model);
	}

	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 50;
		Page<RubricaPensao> page = service.findPaginatedAnoMes(pageNo, pageSeze, nome);
		List<RubricaPensao> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginatedNome(@PathVariable(value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 50;
		Page<RubricaPensao> page = service.findPaginatedNome(pageNo, pageSeze, nome);
		List<RubricaPensao> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String paginar(int pageNo, Page<RubricaPensao> page, List<RubricaPensao> lista, ModelMap model) {
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("rubricaPensaoLista", lista);
		return "/rubricaPensao/lista";
	}

	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		this.ultimoNome = "";
		return this.findPaginated(1, anoMes, model);
	}

	@GetMapping("/buscar/nome/nome")
	public String getPorNomeNome(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimoNome = nome;
		this.ultimoAnoMes = "";
		return this.findPaginatedNome(1, nome, model);
	}

	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable(value = "pageNo") int pageNo, ModelMap model) {
		if (pageNo < 1) {
			pageNo = 1;
		}
		if ((ultimoAnoMes.equals("")) && (ultimoNome.equals(""))) {
			return "redirect:/rubricaPensao/listar/{pageNo}";
		} else {
			if (!ultimoAnoMes.equals("")) {
				return this.findPaginated(pageNo, ultimoAnoMes, model);
			} else {
				return this.findPaginatedNome(pageNo, ultimoNome, model);
			}
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Recebe o id do funcionário da tela de lista de funcionários
	@GetMapping("/cadastrar/{id}")
	public String cadastrarPensao(@PathVariable("id") Long id, RubricaPensao rubricaPensao, ModelMap model) {

		PessoaFuncionarios funcionario = pessoaFuncionariosService.buscarPorId(id);
		//relaciona as penssões a pessoa
		Pessoa pessoa = pessoaService.buscarPorId(funcionario.getIdPessoaFk().getId());
		rubricaPensao.setIdPessoaFk(pessoa);
		rubricaPensao.setId(null);
		//funcionariosFerias.setIdFuncionarioFk(funcionario);
		///////////////////////////////////////
		//model.addAttribute("funcionario", funcionario);
		model.addAttribute("pessoa", pessoa); 
		model.addAttribute("pensao", service.buscarPorPessoa(pessoa));
		
		// MUDANCA NO NOME DA LISTA QUE TAVA DANDO CONFLITO NO HTML DOIS OBJETOS COM O MESMO NOME
		model.addAttribute("rubricaPensaoLista", service.buscarPorPessoa(pessoa));
		return "/rubricaPensao/cadastro";
	}
	
	//Método novo
	//Recebe o id do funcionário da tela de lista de funcionários
	@GetMapping("/cadastrar/pessoa/{id}")
	public String cadastrarPessoaPensao(@PathVariable("id") Long id, RubricaPensao rubricaPensao, ModelMap model) {

		Pessoa pessoa = pessoaService.buscarPorId(id);
		//relaciona as penssões a pessoa
		rubricaPensao.setIdPessoaFk(pessoa);
		rubricaPensao.setId(null);
		//funcionariosFerias.setIdFuncionarioFk(funcionario);
		///////////////////////////////////////
		
		model.addAttribute("pessoa", pessoa); 
		model.addAttribute("pensao", service.buscarPorPessoa(pessoa));
		
		// MUDANCA NO NOME DA LISTA QUE TAVA DANDO CONFLITO NO HTML DOIS OBJETOS COM O MESMO NOME
		model.addAttribute("rubricaPensaoLista", service.buscarPorPessoa(pessoa));
		return "/rubricaPensao/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar( RubricaPensao rubricaPensao, RedirectAttributes attr) {

		if (rubricaPensao.getValor() == null) {
			rubricaPensao.setValor(0.0);
		}
		if (rubricaPensao.getPercentagem() == null) {
			rubricaPensao.setPercentagem(0.0);
		}

		service.salvar(rubricaPensao);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/rubricaPensao/cadastrar/pessoa/" + rubricaPensao.getIdPessoaFk().getId();
	}

	@PostMapping("/salvar/{id}")
	public String salvar(@PathVariable("id") Long id, RubricaPensao rubricaPensao, RedirectAttributes attr) {

		if (rubricaPensao.getValor() == null) {
			rubricaPensao.setValor(0.0);
		}
		if (rubricaPensao.getPercentagem() == null) {
			rubricaPensao.setPercentagem(0.0);
		}

		service.salvar(rubricaPensao);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/rubricaPensao/cadastrar/pessoa/" + rubricaPensao.getIdPessoaFk().getId();
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		Pessoa pessoa = service.buscarPorId(id).getIdPessoaFk();
		
		// ENVIANDO O OBJETO INTEIRO PARA O HTML EM VEZ DE IR AS PARTES DELE
		RubricaPensao r = service.buscarPorId(id);
		model.addAttribute("rubricaPensao", r);
		
		//model.addAttribute("funcionario", funcionario);
		model.addAttribute("pessoa", pessoa);
		model.addAttribute("pensao", service.buscarPorId(id));
		
		// MUDANCA NO NOME DA LISTA QUE TAVA DANDO CONFLITO NO HTML DOIS OBJETOS COM O MESMO NOME
		model.addAttribute("rubricaPensaoLista", service.buscarPorPessoa(r.getIdPessoaFk()));
		
		return "/rubricaPensao/cadastro";
	}

	@PostMapping("/editar")
	public String editar(RubricaPensao rubricaPensao, RedirectAttributes attr) {
		
		if (rubricaPensao.getValor() == null) {
			rubricaPensao.setValor(0.0);
		}
		if (rubricaPensao.getPercentagem() == null) {
			rubricaPensao.setPercentagem(0.0);
		}

		service.editar(rubricaPensao);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/rubricaPensao/listar";
	}

	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		RubricaPensao r = service.buscarPorId(id);
		r.setDtCancelamento(new Date());
		r.setIdOperadorCancelamentoFk(usuarioService.pegarOperadorLogado());
		service.salvar(r);
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}

	@GetMapping("/herdar/de/mes")
	public String herdarDeMes(Long anoMesInicial, Long anoMesFinal, ModelMap model) {
		service.herdarDeUmMesParaOOutro(anoMesInicial, anoMesFinal);
		return "redirect:/rubricaPensao/listar";
	}

	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("cnesUnidade") String nome, ModelMap model) {
		model.addAttribute("rubricaPensao", service.buscarPorNome(nome.toUpperCase().trim()));
		return "/rubricaPensao/lista";
	}

	@GetMapping("/exporta/excel")
	public void downloadExcel(HttpServletResponse response, ModelMap model) throws IOException {
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=dados.xlsx");
		ByteArrayInputStream stream = service.exportarExcel(service.buscarTodos());
		IOUtils.copy(stream, response.getOutputStream());
	}

	@GetMapping(value = "/exporta/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {
		ByteArrayInputStream bis = service.exportarPdf(service.buscarTodos());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=dados.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getIdAnoMesFk() {
		return anoMesService.buscarTodos();
	}

	@ModelAttribute("idBancoFk")
	public List<Bancos> getIdBancoFk() {
		return bancosService.buscarTodos();
	}

	@ModelAttribute("idPessoaFk")
	public List<Pessoa> getIdPessoaFk() {
		return pessoaService.buscarTodos();
	}

	@ModelAttribute("idFuncionarioFk")
	public List<PessoaFuncionarios> getPessoaFuncionarios() {
		return pessoaFuncionariosService.buscarTodos();
	}

	@Autowired
	HttpServletRequest request;

	@ModelAttribute("nomeOperadorLogado")
	public String operadorLogado() {
		return request.getSession().getAttribute("operador").toString();
	}

	@ModelAttribute("nomeUnidadeLogada")
	public String unidadeLogada() {
		return request.getSession().getAttribute("unidade").toString();
	}

}
