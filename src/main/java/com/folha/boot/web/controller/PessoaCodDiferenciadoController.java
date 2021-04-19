package com.folha.boot.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.FuncionariosFerias;
import com.folha.boot.domain.LocalidadeEscala;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaCodDiferenciado;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AtividadeEscalaService;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.PessoaCodDiferenciadoService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.SimNaoService;
import com.folha.boot.service.UnidadesService;

@Controller
@RequestMapping("/pessoaCodDiferenciado")
public class PessoaCodDiferenciadoController {

	Long idUnidadeLogada = 1l;
	Long idOperadorLogado = 1l;
	
	String ultimaBuscaNome = "";
	String ultimaBuscaUnidade = "";
	
	@Autowired
	private PessoaCodDiferenciadoService service;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private CodigoDiferenciadoService codigoDiferenciadoService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	private SimNaoService simNaoService;
	
	

	//Buscando Funcionario Inicial
	@GetMapping("/paginar/funcionarios/{pageNo}")
	public String getPorNomePaginadoInclusao(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) ){
			return "redirect:/pessoaCodDiferenciado/listar/funcionarios/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedFuncionario(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/pessoaCodDiferenciado/listar/funcionarios/{pageNo}" ;}
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
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginated(pageNo, pageSeze, unidadesService.buscarPorId(idUnidadeLogada), "ATIVO");
		List<PessoaFuncionarios> listaFuncionarios = page.getContent();
		return paginarFuncionario(pageNo, page, listaFuncionarios, model);
	}
	

	public String paginarFuncionario(int pageNo, Page<PessoaFuncionarios> page, List<PessoaFuncionarios> lista, ModelMap model) {	

		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaFuncionarios", lista);
		return "/pessoaCodDiferenciado/listafuncionario";	
	}
	
	@GetMapping("/buscar/funcionarios/nome")
	public String getPorNomeFuncionario(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		//this.ultimaBuscaTurma = null;	
		return this.findPaginatedFuncionario(1, nome, model);
	}
	
	public String findPaginatedFuncionario(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginatedNome(pageNo, pageSeze, unidadesService.buscarPorId(idUnidadeLogada), "ATIVO", nome);
		List<PessoaFuncionarios> lista = page.getContent();
		//ultimaBuscaNome = "";
		//ultimaBuscaTurma = null;
		return paginarFuncionario(pageNo, page, lista, model);
	}
	
	@GetMapping("/atribuir/cod/diferenciado/{id}")//Recebe o id do funcionário da tela de lista de funcionários
	public String cadastrar(@PathVariable("id") Long id, PessoaCodDiferenciado pessoaCodDiferenciado, ModelMap model) {
		Pessoa pessoa = pessoaFuncionariosService.buscarPorId(id).getIdPessoaFk();
		pessoaCodDiferenciado.setIdPessoaFk(pessoa);//relaciona as férias ao funcionário
		model.addAttribute("pessoaCodDiferenciado", pessoaCodDiferenciado);
		model.addAttribute("listaPessoaCodDiferenciado", service.buscarPorUnidadeEPessoa(unidadesService.buscarPorId(idUnidadeLogada), pessoa));
		
		return "/pessoaCodDiferenciado/cadastro"; 
	}
	
	@GetMapping("/atribuir/cod/diferenciado/pessoa/{id}")//Recebe o id do funcionário da tela de lista de funcionários
	public String cadastrarPessoa(@PathVariable("id") Long id, PessoaCodDiferenciado pessoaCodDiferenciado, ModelMap model) {
		Pessoa pessoa = pessoaService.buscarPorId(id);
		pessoaCodDiferenciado.setIdPessoaFk(pessoa);//relaciona as férias ao funcionário
		model.addAttribute("pessoaCodDiferenciado", pessoaCodDiferenciado);
		model.addAttribute("listaPessoaCodDiferenciado", service.buscarPorUnidadeEPessoa(unidadesService.buscarPorId(idUnidadeLogada), pessoa));
		
		return "/pessoaCodDiferenciado/cadastro"; 
	}
	
	
	//Métodos para a sede aprovar / reprovar
	@GetMapping("/valiar/cod/diferenciado/sede")//Recebe o id do funcionário da tela de lista de funcionários
	public String cadastrar( PessoaCodDiferenciado pessoaCodDiferenciado, ModelMap model) {
		model.addAttribute("pessoaCodDiferenciado", pessoaCodDiferenciado);
		model.addAttribute("listaPessoaCodDiferenciado", service.buscarPorAprovarSede());
		
		return "/pessoaCodDiferenciado/cadastroAutorizacaoSede"; 
	}
	
	@PostMapping("/salvar/aprovacao/sede")
	public String salvarAprovacaoSede(PessoaCodDiferenciado pessoaCodDiferenciado, RedirectAttributes attr) {
		pessoaCodDiferenciado.setDtConfirmacaoSede(new Date());
		pessoaCodDiferenciado.setIdOperadorConfirmacaoSedeFk(pessoaOperadoresService.buscarPorId(idOperadorLogado));
		
		if(pessoaCodDiferenciado.getIdConfirmacaoSedeSimNaoFk()==null) {
			return "redirect:/pessoaCodDiferenciado/mensagem/de/nao/escolha";
		}
		
		service.salvar(pessoaCodDiferenciado);
		attr.addFlashAttribute("success", "Sua Posição foi lançada.");
		return "redirect:/pessoaCodDiferenciado/valiar/cod/diferenciado/sede";
	}
	
	@GetMapping("/editar/aprovacao/sede/{id}")
	public String preEditarAprovacaoSede(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaCodDiferenciado", service.buscarPorId(id));
		model.addAttribute("listaPessoaCodDiferenciado", service.buscarPorAprovarSede());
		return "/pessoaCodDiferenciado/cadastroAutorizacaoSede";
	}
	
	
	
	
	//Métodos para diferenciado
	
	@GetMapping("/cadastrar")
	public String cadastrar(PessoaCodDiferenciado pessoaCodDiferenciado) {		
		return "/pessoaCodDiferenciado/cadastro";
	}
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("atividadeEscala", service.buscarNaUnidade(unidadesService.buscarPorId(idUnidadeLogada)));
		return "/atividadeescala/lista"; 
	}
	*/
	@PostMapping("/salvar")
	public String salvar(PessoaCodDiferenciado pessoaCodDiferenciado, RedirectAttributes attr) {
		pessoaCodDiferenciado.setDtCadastro(new Date());
		pessoaCodDiferenciado.setIdOperadorCadastroFk(pessoaOperadoresService.buscarPorId(idOperadorLogado));
		
		if(pessoaCodDiferenciado.getIdPessoaFk()==null  || pessoaCodDiferenciado.getIdCodDiferenciadoFk()==null || pessoaCodDiferenciado.getObservacaoCadastro().length()<1 ) {
			return "redirect:/pessoaCodDiferenciado/mensagem/de/nao/escolha";
		}
		
		
		service.salvar(pessoaCodDiferenciado);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/pessoaCodDiferenciado/atribuir/cod/diferenciado/pessoa/"+pessoaCodDiferenciado.getIdPessoaFk().getId();
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaCodDiferenciado", service.buscarPorId(id));
		return "/pessoaCodDiferenciado/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaCodDiferenciado pessoaCodDiferenciado, RedirectAttributes attr) {
		service.editar(pessoaCodDiferenciado);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/pessoaCodDiferenciado/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		PessoaCodDiferenciado pessoaCodDiferenciado = service.buscarPorId(id);
		pessoaCodDiferenciado.setDtCancelamento(new Date());
		pessoaCodDiferenciado.setIdOperadorCancelamentoFk(pessoaOperadoresService.buscarPorId(idOperadorLogado));
		service.salvar(pessoaCodDiferenciado); 
		model.addAttribute("success", "Cancelado com sucesso.");
		return "redirect:/pessoaCodDiferenciado/atribuir/cod/diferenciado/pessoa/"+pessoaCodDiferenciado.getIdPessoaFk().getId();
	}
	
	@GetMapping("/cancelar/lista/unidade/{id}")
	public String cancelarListaUnidade(@PathVariable("id") Long id, ModelMap model) {
		PessoaCodDiferenciado pessoaCodDiferenciado = service.buscarPorId(id);
		pessoaCodDiferenciado.setDtCancelamento(new Date());
		pessoaCodDiferenciado.setIdOperadorCancelamentoFk(pessoaOperadoresService.buscarPorId(idOperadorLogado));
		service.salvar(pessoaCodDiferenciado); 
		model.addAttribute("success", "Cancelado com sucesso.");
		return "redirect:/pessoaCodDiferenciado/listar/unidade";
	}
	/*
	@GetMapping("/buscar/nome/atividade/escala")
	public String getPorNome(@RequestParam("nomeAtividade") String nomeAtividade, ModelMap model) {		
		model.addAttribute("atividadeEscala", service.buscarNaUnidadePorNome( unidadesService.buscarPorId(idUnidadeLogada) ,nomeAtividade.toUpperCase().trim()));
		return "/atividadeescala/lista";
	}
	*/
	
	//Listar Sede
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimaBuscaNome = "";
		this.ultimaBuscaUnidade = "";
		return this.findPaginated(1, model);
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		this.ultimaBuscaUnidade = "";
		return this.findPaginatedNome(1, nome, model);
	}
	
	@GetMapping("/buscar/unidade")
	public String getPorUnidade(@RequestParam("unidade") String unidade, ModelMap model) {
		this.ultimaBuscaUnidade = unidade;
		this.ultimaBuscaNome = "";
		return this.findPaginatedUnidade(1, unidade, model);
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorNomePaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if(pageNo<1) {pageNo=1;}
		
		if( (ultimaBuscaNome.equals("")) && (ultimaBuscaUnidade.equals("")) ){
			return "redirect:/pessoaCodDiferenciado/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedNome(pageNo, ultimaBuscaNome, model);}
			else {
				return this.findPaginatedUnidade(pageNo, ultimaBuscaUnidade, model);}
			}
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<PessoaCodDiferenciado> page = service.findPaginated( pageNo, pageSeze);
		List<PessoaCodDiferenciado> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginatedNome(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<PessoaCodDiferenciado> page = service.findPaginatedNome(  nome, pageNo, pageSeze);
		List<PessoaCodDiferenciado> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginatedUnidade(@PathVariable (value = "pageNo") int pageNo, String unidade, ModelMap model) {
		int pageSeze = 10;
		Page<PessoaCodDiferenciado> page = service.findPaginatedUnidade(  unidade, pageNo, pageSeze);
		List<PessoaCodDiferenciado> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<PessoaCodDiferenciado> page, List<PessoaCodDiferenciado> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaPessoaCodDiferenciado", lista);
		return "/pessoaCodDiferenciado/lista";	
	}

	
	
	
	
	
	//Listar Unidade
	@GetMapping("/listar/unidade")
	public String listarUnidade(ModelMap model) {
		this.ultimaBuscaNome = "";
		this.ultimaBuscaUnidade = "";
		return this.findPaginatedUnidade(1, model);
	}
	
	@GetMapping("/buscar/nome/unidade")
	public String getPorNomeUnidade(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		this.ultimaBuscaUnidade = "";
		return this.findPaginatedNomeUnidade(1, nome, model);
	}
	
	@GetMapping("/paginar/unidade/{pageNo}")
	public String getPorNomePaginadoUnidade(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if(pageNo<1) {pageNo=1;}
		
		if( (ultimaBuscaNome.equals("")) && (ultimaBuscaUnidade.equals("")) ){
			return "redirect:/pessoaCodDiferenciado/listar/unidade/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedNomeUnidade(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/pessoaCodDiferenciado/listar/unidade/{pageNo}" ;}
			}
	}
	
	@GetMapping("/listar/unidade/{pageNo}")
	public String findPaginatedUnidade(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<PessoaCodDiferenciado> page = service.findPaginatedUnidade(unidadesService.buscarPorId(idUnidadeLogada), pageNo, pageSeze);
		List<PessoaCodDiferenciado> lista = page.getContent();
		return paginarUnidade(pageNo, page, lista, model);
	}

	public String findPaginatedNomeUnidade(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<PessoaCodDiferenciado> page = service.findPaginatedNomeUnidade(unidadesService.buscarPorId(idUnidadeLogada),  nome, pageNo, pageSeze);
		List<PessoaCodDiferenciado> lista = page.getContent();
		return paginarUnidade(pageNo, page, lista, model);
	}
		
	public String paginarUnidade(int pageNo, Page<PessoaCodDiferenciado> page, List<PessoaCodDiferenciado> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaPessoaCodDiferenciado", lista);
		return "/pessoaCodDiferenciado/listaUnidade";	
	}


	
	
	
	@GetMapping("/mensagem/de/nao/escolha")
	public String mensagemDeNaoEscolha(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "ESCOLHA");
		model.addAttribute("mensagem", "Campos obrigatórios");
		
		return "/choqueescala/obrigatorio";
	}
	
	
	@ModelAttribute("idCodDiferenciadoFkTodos")
	public List<CodigoDiferenciado> getIdCodDiferenciadoFkTodos() {
		List<CodigoDiferenciado> lista = codigoDiferenciadoService.buscarTodosQuePrecisaDeAtribuicaoRh(unidadesService.buscarPorId(idUnidadeLogada));
		return lista;
	}	
	
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getUfs() {
		List<Unidades> lista = new ArrayList<Unidades>();
		lista.add(unidadesService.buscarPorId(idUnidadeLogada));
		return lista;
	}	
	
	
	@ModelAttribute("idConfirmacaoSedeSimNaoFk")
	public List<SimNao> getIdConfirmacaoSedeSimNaoFk() {
		List<SimNao> lista = simNaoService.buscarTodos();
		return lista;
	}	
	
	
}
