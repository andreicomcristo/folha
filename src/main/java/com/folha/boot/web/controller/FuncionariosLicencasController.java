package com.folha.boot.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
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
import com.folha.boot.domain.Cargos;
import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.domain.Cids;
import com.folha.boot.domain.FuncionariosLicencas;
import com.folha.boot.domain.FuncionariosLicencasCid;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.TiposDeLicenca;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.Vinculos;
import com.folha.boot.service.CargosEspecialidadeService;
import com.folha.boot.service.CargosService;
import com.folha.boot.service.CidsService;
import com.folha.boot.service.FuncionariosLicencasService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.TiposDeLicencaService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.VinculosService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/funcionarioslicencas")
public class FuncionariosLicencasController {

	private String ultimaBuscaNome = "";
	private String ultimaBuscaCodigo = "";
	private String ultimaBuscaDescricao = "";
	
	@Autowired
	private CidsService cidsService; 
	@Autowired
	private FuncionariosLicencasService service;
	@Autowired
	private CargosService cargosService;
	@Autowired
	private CargosEspecialidadeService cargosEspecialidadeService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	private TiposDeLicencaService tiposDeLicencaService;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private VinculosService vinculosService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
    ObjectFactory<HttpSession> httpSessionFactory;
	/*///////////////////////////////////////
	 * Lista de funcionarios para cadastro de licenças
	*/
	
	@GetMapping("/paginar/funcionarios/{pageNo}")
	public String getPorNomePaginadoInclusao(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) ){
			return "redirect:/funcionariosferias/funcionarios/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedFuncionario(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/funcionariosferias/funcionarios/listar/{pageNo}" ;}
			}
	}
	
	@GetMapping("/funcionarios/listar") 
	public String listarFuncionarios(ModelMap model) { 
		ultimaBuscaNome = "";
		return this.findPaginatedFuncionario(1, model);
	}	
	
	@GetMapping("/funcionarios/listar/{pageNo}")
	public String findPaginatedFuncionario(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginated(pageNo, pageSeze, usuarioService.pegarUnidadeLogada(), "ATIVO");
		List<PessoaFuncionarios> listaFuncionarios = page.getContent();
		return paginarFuncionario(pageNo, page, listaFuncionarios, model);
	}
	
	public String paginarFuncionario(int pageNo, Page<PessoaFuncionarios> page, List<PessoaFuncionarios> lista, ModelMap model) {	

		
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaFuncionarios", lista);
		return "/funcionarioferias/listafuncionario";	
	}	
	
	@GetMapping("/buscar/funcionarios/nome")
	public String getPorNomeFuncionario(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		return this.findPaginatedFuncionario(1, nome, model);
	}
	
	public String findPaginatedFuncionario(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 50;
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginatedNome(pageNo, pageSeze, usuarioService.pegarUnidadeLogada(), "ATIVO", nome);
		List<PessoaFuncionarios> lista = page.getContent();
		return paginarFuncionario(pageNo, page, lista, model);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Paginação de Cids
	
	@GetMapping("/cids/listar")
	public String listarCids(ModelMap model) {
		this.ultimaBuscaCodigo = "";
		this.ultimaBuscaDescricao = "";
		return this.findPaginated(1, model);
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorNomePaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaCodigo.equals("")) && (ultimaBuscaDescricao.equals("")) ){
			return "redirect:/cids/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaCodigo.equals("")) {
				return this.findPaginatedCodigo(pageNo, ultimaBuscaCodigo, model);}
			else {
				return this.findPaginatedDescricao(pageNo, ultimaBuscaDescricao, model);}
			}
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<Cids> page = cidsService.findPaginated(pageNo, pageSeze);
		List<Cids> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginatedCodigo(@PathVariable (value = "pageNo") int pageNo, String codigo, ModelMap model) {
		int pageSeze = 10;
		Page<Cids> page = cidsService.findPaginatedCodigo(pageNo, pageSeze, codigo);
		List<Cids> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginatedDescricao(@PathVariable (value = "pageNo") int pageNo, String descricao, ModelMap model) {
		int pageSeze = 10;
		Page<Cids> page = cidsService.findPaginatedDescricao(pageNo, pageSeze, descricao);
		List<Cids> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<Cids> page, List<Cids> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("cids", lista);
		return "/cid/lista";	
	}
	
	@GetMapping("/buscar/codigo")
	public String getPorCodigo(@RequestParam("codigo") String codigo, ModelMap model) {
		this.ultimaBuscaCodigo = codigo;
		this.ultimaBuscaDescricao = "";	
		return this.findPaginatedCodigo(1, codigo, model);
	}
	
	@GetMapping("/buscar/descricao")
	public String getPorDescricao(@RequestParam("descricao") String descricao, ModelMap model) {
		this.ultimaBuscaCodigo = "";
		this.ultimaBuscaDescricao = descricao;	
		return this.findPaginatedDescricao(1, descricao, model);
	}
		
	@GetMapping("/buscar/codcid")
	public String getCidPorNome(@RequestParam("codCid") String codCid, ModelMap model) {		
		model.addAttribute("cids", cidsService.buscarPorNome(codCid.toUpperCase().trim()));
		return "/cid/lista";
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Recebe o id do funcionário da tela de lista de funcionários	
	@GetMapping("/funcionario/{id}")
	public String salvaIdFuncionarioNaSession(@PathVariable("id") Long id, Long idFuncionario) {
		
		idFuncionario = pessoaFuncionariosService.buscarPorId(id).getId();
		HttpSession session = httpSessionFactory.getObject();
		session.setAttribute("idFuncionario", idFuncionario);     
		//return "redirect:/funcionarioslicencas/pessoa/cadastrar";	
	
	return "redirect:/funcionarioslicencas/licencas/cadastrar"; 
	}
		
	@GetMapping("/licencas/cadastrar")
	public String cadastrarLicencas(FuncionariosLicencas funcionariosLicencas, FuncionariosLicencasCid funcionariosLicencasCid, ModelMap model) {
		//relaciona as licenças com funcionário
		//Pessoa pessoa = pessoaService.buscarPorId(getIdPessoaSession());
		PessoaFuncionarios funcionario = pessoaFuncionariosService.buscarPorId(getIdFuncionarioSession());				
		funcionariosLicencas.setIdFuncionarioFk(funcionario);
		//relaciona as licenças com licençasCid		
				
		if(!getIdCidSession().equals(null)){
		
			Cids cid = cidsService.buscarPorId(getIdCidSession());
			funcionariosLicencasCid.setIdCidFk(cid);
			funcionariosLicencasCid.setIdFuncionariosLicencasFk(funcionariosLicencas);
		}
				
		///////////////////////////////////////
		model.addAttribute("funcionario", funcionario);		
		model.addAttribute("funcionariosLicencasCid", funcionariosLicencasCid);
		//model.addAttribute("funcionariosLicencas", service.buscarPorFuncionario(funcionario) );////rever essa lógica
		//model.addAttribute("funcionariosFeriasPeriodos", periodosService.buscarPorFuncionarioComDias(funcionario));
	
	return "/funcionarioslicenca/cadastro"; 
	
	}
	
	//Recebe o id de funcionariosLicencasCid da tela de FuncionariosLicencas		
	@GetMapping("/cid/{id}")
	public String salvaIdCidNaSession(@PathVariable("id") Long id, Long idCid) {
		
		idCid = cidsService.buscarPorId(id).getId();
		HttpSession session = httpSessionFactory.getObject();
		session.setAttribute("idCid", idCid);     
		//return "redirect:/funcionarioslicencas/pessoa/cadastrar";	
	
	return "redirect:/funcionarioslicencas/licencas/cadastrar"; 
	}
		
	@GetMapping("/cids")
	public String vinculaCids(Cids cids, ModelMap model) {
					
		model.addAttribute("cids", cidsService.buscarTodos());
		
		return "/funcionarioslicenca/listacids"; 
	}
	
	

	
	
	
	
	
	
	
	
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(FuncionariosLicencas funcionariosLicencas) {
		return "/funcionarioslicenca/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionariosLicencas", service.buscarTodos());
		return "/funcionarioslicenca/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(FuncionariosLicencas funcionariosLicencas, RedirectAttributes attr) {
		service.salvar(funcionariosLicencas);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/funcionarioslicencas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionariosLicencas", service.buscarPorId(id));
		return "/funcionarioslicenca/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(FuncionariosLicencas funcionariosLicencas, RedirectAttributes attr) {
		service.editar(funcionariosLicencas);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/funcionarioslicencas/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/data/inicial")
	public String getPorNome(@RequestParam("dtInicial") String dtInicial, ModelMap model) {		
		model.addAttribute("funcionariosLicencas", service.buscarPorDtInicial(dtInicial.toUpperCase().trim()));
		return "/funcionarioslicenca/lista";
	}
	
	
	@ModelAttribute("idCargoAtualFk")
	public List<Cargos> getCargos() {
		return cargosService.buscarTodos();
	}
	
	@ModelAttribute("idCargoEspecialidadeAtualFk")
	public List<CargosEspecialidade> getCargosEspecialidade() {
		return cargosEspecialidadeService.buscarTodos();
	}
	
	@ModelAttribute("idFuncionarioFk")
	public List<PessoaFuncionarios> getPessoaFuncionarios() {
		return pessoaFuncionariosService.buscarTodos();
	}
	
	@ModelAttribute("idOperadorCadastroFk")
	public List<PessoaOperadores> getPessoaOperadoresCadstro() {
		return pessoaOperadoresService.buscarTodos();
	}
	
	@ModelAttribute("idOperadorCancelamentoFk")
	public List<PessoaOperadores> getPessoaOperadoresCancelamento() {
		return pessoaOperadoresService.buscarTodos();
	}
	
	@ModelAttribute("idOperadorUltimaAlteracaoFk")
	public List<PessoaOperadores> getPessoaOperadoresUltimaAlteracao() {
		return pessoaOperadoresService.buscarTodos();
	}
	
	@ModelAttribute("idTipoLicencaFk")
	public List<TiposDeLicenca> getTipoLicenca() {
		return tiposDeLicencaService.buscarTodos();
	}
	@ModelAttribute("idUnidadeAtuacaoAtualFk")
	public List<Unidades> getUnidades() { 
		return unidadesService.buscarTodos();
	}
	
	@ModelAttribute("idUnidadeLotacaoAtualFk")
	public List<Unidades> getUnidadeLotacaoAtual() {
		return unidadesService.buscarTodos();
	}
	
	@ModelAttribute("idVinculoAtualFk")
	public List<Vinculos> getVinculos() {
		return vinculosService.buscarTodos();
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
	
	//Recupera um valor da Session
	public Long getIdFuncionarioSession() {
		return Long.valueOf(request.getSession().getAttribute("idFuncionario").toString()) ;
	}
	
	public Long getIdCidSession() {
		return Long.valueOf(request.getSession().getAttribute("idCid").toString()) ;
	}
}
