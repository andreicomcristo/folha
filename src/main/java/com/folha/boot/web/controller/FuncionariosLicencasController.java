package com.folha.boot.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.folha.boot.domain.FuncionariosLicencas;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.TiposDeLicenca;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.Vinculos;
import com.folha.boot.service.CargosEspecialidadeService;
import com.folha.boot.service.CargosService;
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
	
	
}
