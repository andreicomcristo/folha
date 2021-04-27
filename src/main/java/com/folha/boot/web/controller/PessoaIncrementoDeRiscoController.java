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
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.FaixasPrevidencia;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.NiveisCargo;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaCodDiferenciado;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaIncrementoDeRisco;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.UnidadeAdmiteChDif;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.FaixasValoresParametrosCalculoFolhasExtrasService;
import com.folha.boot.service.NiveisCargoService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaIncrementoDeRiscoService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.RegimesDeTrabalhoService;
import com.folha.boot.service.TiposDeFolhaService;
import com.folha.boot.service.UnidadeAdmiteChDifService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.seguranca.UsuarioService;


@Controller
@RequestMapping("/pessoaIncrementoDeRisco")
public class PessoaIncrementoDeRiscoController {

	
	Long idPessoaAtual = null;
	
	String ultimoAnoMes = "";
	String ultimaBuscaNome = "";
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PessoaIncrementoDeRiscoService service;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	private	PessoaFuncionariosService pessoaFuncionariosService;
	@Autowired
	private PessoaService pessoaService;
	
	//Buscando Funcionario Inicial
		@GetMapping("/paginar/funcionarios/{pageNo}")
		public String getPorNomePaginadoInclusao(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
			
			if( (ultimaBuscaNome.equals("")) ){
				return "redirect:/pessoaIncrementoDeRisco/listar/funcionarios/{pageNo}" ;}
			else {		
				if(!ultimaBuscaNome.equals("")) {
					return this.findPaginatedFuncionario(pageNo, ultimaBuscaNome, model);}
				else {
					return "redirect:/pessoaIncrementoDeRisco/listar/funcionarios/{pageNo}" ;}
				}
		}
		
		@GetMapping("/listar/funcionarios")
		public String listarFuncionarios(ModelMap model) {
			ultimaBuscaNome = "";
			return this.findPaginatedFuncionario(1, model);
		}	
		
		@GetMapping("/listar/funcionarios/{pageNo}")
		public String findPaginatedFuncionario(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
			int pageSeze = 10;
			Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginated(pageNo, pageSeze, usuarioService.pegarUnidadeLogada(), "ATIVO");
			List<PessoaFuncionarios> listaFuncionarios = page.getContent();
			return paginarFuncionario(pageNo, page, listaFuncionarios, model);
		}
		

		public String paginarFuncionario(int pageNo, Page<PessoaFuncionarios> page, List<PessoaFuncionarios> lista, ModelMap model) {	

			model.addAttribute("currentePage", pageNo);
			model.addAttribute("totalPages", page.getTotalPages());
			model.addAttribute("totalItems", page.getTotalElements()); 
			model.addAttribute("listaFuncionarios", lista);
			return "/pessoaIncrementoDeRisco/listafuncionario";	
		}
		
		@GetMapping("/buscar/funcionarios/nome")
		public String getPorNomeFuncionario(@RequestParam("nome") String nome, ModelMap model) {
			this.ultimaBuscaNome = nome;
			//this.ultimaBuscaTurma = null;	
			return this.findPaginatedFuncionario(1, nome, model);
		}
		
		public String findPaginatedFuncionario(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
			int pageSeze = 10;
			Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginatedNome(pageNo, pageSeze, usuarioService.pegarUnidadeLogada(), "ATIVO", nome);
			List<PessoaFuncionarios> lista = page.getContent();
			//ultimaBuscaNome = "";
			//ultimaBuscaTurma = null;
			return paginarFuncionario(pageNo, page, lista, model);
		}
		
		@GetMapping("/atribuir/{id}")//Recebe o id do funcionário da tela de lista de funcionários
		public String cadastrar(@PathVariable("id") Long id, PessoaIncrementoDeRisco pessoaIncrementoDeRisco, ModelMap model) {
			idPessoaAtual = id;
			Pessoa pessoa = pessoaFuncionariosService.buscarPorId(id).getIdPessoaFk();
			pessoaIncrementoDeRisco.setIdPessoaFk(pessoa);//relaciona as férias ao funcionário
			model.addAttribute("pessoaIncrementoDeRisco", pessoaIncrementoDeRisco);
			model.addAttribute("listaPessoaIncrementoDeRisco", service.buscarPorUnidadeEPessoa(usuarioService.pegarUnidadeLogada(), pessoa));
			model.addAttribute("idAnoMes", service.buscarMesesCompativeis(usuarioService.pegarUnidadeLogada()));
			
			return "/pessoaIncrementoDeRisco/cadastro"; 
		}
		
		@GetMapping("/atribuir/pessoa/{id}")//Recebe o id do funcionário da tela de lista de funcionários
		public String cadastrarPessoa(@PathVariable("id") Long id, PessoaIncrementoDeRisco pessoaIncrementoDeRisco, ModelMap model) {
			idPessoaAtual = id;
			Pessoa pessoa = pessoaService.buscarPorId(id);
			pessoaIncrementoDeRisco.setIdPessoaFk(pessoa);//relaciona as férias ao funcionário
			model.addAttribute("pessoaIncrementoDeRisco", pessoaIncrementoDeRisco);
			model.addAttribute("listaPessoaIncrementoDeRisco", service.buscarPorUnidadeEPessoa(usuarioService.pegarUnidadeLogada(), pessoa));
			model.addAttribute("idAnoMes", service.buscarMesesCompativeis(usuarioService.pegarUnidadeLogada()));
			
			return "/pessoaIncrementoDeRisco/cadastro"; 
		}
		

	
	
	
	
	//Métodos normais
	
	@GetMapping("/cadastrar")
	public String cadastrar(PessoaIncrementoDeRisco pessoaIncrementoDeRisco, ModelMap model) {
		
		
		
		model.addAttribute("listaPessoaIncrementoDeRisco", service.buscarPorUnidadeEPessoa(usuarioService.pegarUnidadeLogada(), pessoaService.buscarPorId(idPessoaAtual)));
		model.addAttribute("pessoaIncrementoDeRisco", pessoaIncrementoDeRisco);
		model.addAttribute("idAnoMes", service.buscarMesesCompativeis(usuarioService.pegarUnidadeLogada()));
		return "/pessoaIncrementoDeRisco/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimoAnoMes = "";
		return this.findPaginated(1, model); 
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		if(pageNo<1) {pageNo=1;}
		Page<PessoaIncrementoDeRisco> page = service.findPaginated(pageNo, pageSeze, usuarioService.pegarUnidadeLogada());
		List<PessoaIncrementoDeRisco> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<PessoaIncrementoDeRisco> page = service.findPaginatedAnoMes(pageNo, pageSeze, nome, usuarioService.pegarUnidadeLogada());
		List<PessoaIncrementoDeRisco> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<PessoaIncrementoDeRisco> page, List<PessoaIncrementoDeRisco> lista, ModelMap model) {	
		model.addAttribute("idAnoMes", service.buscarMesesCompativeis(usuarioService.pegarUnidadeLogada()));
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaPessoaIncrementoDeRisco", lista);
		return "/pessoaIncrementoDeRisco/listaUnidade";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if(pageNo<1) {pageNo=1;}
		if( (ultimoAnoMes.equals("")) ){
			return "redirect:/pessoaIncrementoDeRisco/listar/{pageNo}" ;}
		else {return this.findPaginated(pageNo, ultimoAnoMes, model);}
	}
	
	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		return this.findPaginated(1, anoMes, model);
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaIncrementoDeRisco pessoaIncrementoDeRisco, RedirectAttributes attr) {
		pessoaIncrementoDeRisco.setDtCadastro(new Date());
		pessoaIncrementoDeRisco.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		pessoaIncrementoDeRisco.setIdUnidadeFk(usuarioService.pegarUnidadeLogada());
		
		
		service.salvar(pessoaIncrementoDeRisco);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/pessoaIncrementoDeRisco/atribuir/"+idPessoaAtual;
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaIncrementoDeRisco", service.buscarPorId(id));
		return "/pessoaIncrementoDeRisco/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaIncrementoDeRisco pessoaIncrementoDeRisco, RedirectAttributes attr) {	
		pessoaIncrementoDeRisco.setDtCadastro(new Date());
		pessoaIncrementoDeRisco.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		pessoaIncrementoDeRisco.setIdUnidadeFk(usuarioService.pegarUnidadeLogada());
		
		
		service.editar(pessoaIncrementoDeRisco);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/pessoaIncrementoDeRisco/atribuir/"+idPessoaAtual;
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		PessoaIncrementoDeRisco pessoaIncrementoDeRisco = service.buscarPorId(id);
		pessoaIncrementoDeRisco.setIdOperadorCancelamentoFk(usuarioService.pegarOperadorLogado() );
		pessoaIncrementoDeRisco.setDtCancelamento(new Date());
		service.salvar(pessoaIncrementoDeRisco);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	
	@GetMapping("/herdar/de/mes") 
	public String herdarDeMes( Long anoMesInicial,  Long anoMesFinal,  ModelMap model) {		
		service.herdarDeUmMesParaOOutro(usuarioService.pegarUnidadeLogada(), usuarioService.pegarOperadorLogado() ,anoMesInicial, anoMesFinal);
		return "redirect:/pessoaIncrementoDeRisco/listar" ;
	}
	
	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("idAnoMes", service.buscarMesesCompativeis(usuarioService.pegarUnidadeLogada()));
		model.addAttribute("pessoaIncrementoDeRisco", service.buscarPorNome(nome.toUpperCase().trim(), usuarioService.pegarUnidadeLogada()));
		return "/pessoaIncrementoDeRisco/listaUnidade";
	}
	
	
	
	
	
	
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getIdUnidadeFk() {
		
		return unidadesService.buscarTodos();	
	}
	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getIdAnoMesFk() {
		return anoMesService.buscarTodos();	
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

