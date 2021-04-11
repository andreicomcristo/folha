package com.folha.boot.web.controller;

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
import com.folha.boot.domain.FuncionariosFerias;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.FuncionariosFeriasService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.UnidadesService;

@Controller
@RequestMapping("/funcionariosferias")
public class FuncionariosFeriasController {

	private Long idUnidadeLogada = 1l;
	private String ultimaBuscaNome = "";
	
	@Autowired
	private FuncionariosFeriasService service;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	private UnidadesService unidadesService;

	@GetMapping("/cadastrar")
	public String cadastrar(FuncionariosFerias funcionariosFerias) {
		return "/funcionarioferias/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionariosFerias", service.buscarTodos());
		return "/funcionarioferias/lista"; 
	}
	
	@GetMapping("/paginar/funcionarios/{pageNo}")
	public String getPorNomePaginadoInclusao(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) ){
			return "redirect:/funcionariosferias/listar/funcionarios/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedFuncionario(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/funcionariosferias/listar/funcionarios/{pageNo}" ;}
			}
	}
	
	@GetMapping("/listar/funcionarios")
	public String listarFuncionarios(ModelMap model) {
		ultimaBuscaNome = "";
		return this.findPaginatedFuncionario(1, model);
	}	
	
	@GetMapping("/listar/funcionarios/{pageNo}")
	public String findPaginatedFuncionario(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 5;
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginated(pageNo, pageSeze, unidadesService.buscarPorId(idUnidadeLogada), "ATIVO");
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
		//this.ultimaBuscaTurma = null;	
		return this.findPaginatedFuncionario(1, nome, model);
	}
	
	public String findPaginatedFuncionario(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 5;
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginatedNome(pageNo, pageSeze, unidadesService.buscarPorId(idUnidadeLogada), "ATIVO", nome);
		List<PessoaFuncionarios> lista = page.getContent();
		//ultimaBuscaNome = "";
		//ultimaBuscaTurma = null;
		return paginarFuncionario(pageNo, page, lista, model);
	}
	
	@GetMapping("/ferias/{id}")//Recebe o id do funcionário da tela de lista de funcionários
	public String cadastrarFerias(@PathVariable("id") Long id, FuncionariosFerias funcionariosFerias, ModelMap model) {
		PessoaFuncionarios funcionario = pessoaFuncionariosService.buscarPorId(id);
		funcionariosFerias.setIdFuncionarioFk(funcionario);//relaciona as férias ao funcionário
		model.addAttribute("funcionario", funcionario);
		model.addAttribute("feriasLista", service.buscarFuncionario(funcionario));
		return "/funcionarioferias/cadastro"; 
	}
	
				
	@PostMapping("/salvar")
	public String salvar(FuncionariosFerias funcionariosFerias, RedirectAttributes attr) {	
		
		Long idAnoFerias = service.salvar(funcionariosFerias).getId();//Após savar retorna um objeto do tipo salvo
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		
		return "redirect:/funcionariosferias/ferias/"+funcionariosFerias.getIdFuncionarioFk().getId();
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionariosFerias", service.buscarPorId(id));
		return "/funcionarioferias/cadastro";
	}
	
	
	@PostMapping("/editar")
	public String editar(FuncionariosFerias funcionariosFerias, RedirectAttributes attr) {
		service.editar(funcionariosFerias);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/funcionariosferias/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/ano/referencia")
	public String getPorNome(@RequestParam("anoReferencia") String anoReferencia, ModelMap model) {		
		model.addAttribute("funcionariosFerias", service.buscarPorAnoReferencia(anoReferencia.toUpperCase().trim()));
		return "/funcionarioferias/lista";
	}
	
	@ModelAttribute("idFuncionarioFk")
	public List<PessoaFuncionarios> getPessoaFuncionarios() {
		return pessoaFuncionariosService.buscarTodos();
	}
	
	@ModelAttribute("idOperadorCadastroFk")
	public List<PessoaOperadores> getOperadorCadastro() {
		return pessoaOperadoresService.buscarTodos();
	}
	
	@ModelAttribute("idOperadorCancelamentoFk")
	public List<PessoaOperadores> getPessoaOperadoresCancelamento() {
		return pessoaOperadoresService.buscarTodos();
	}
	
	@ModelAttribute("idUnidadeLancamentoFk")
	public List<Unidades> getTiposDeCapacitacao() {
		return unidadesService.buscarTodos();
	}
}
