package com.folha.boot.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.folha.boot.domain.CargaHorariaSemanal;
import com.folha.boot.domain.Cargos;
import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.domain.Carreiras;
import com.folha.boot.domain.ClassesCarreira;
import com.folha.boot.domain.NiveisCarreira;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.Situacoes;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.Vinculos;
import com.folha.boot.service.CargaHorariaSemanalService;
import com.folha.boot.service.CargosEspecialidadeService;
import com.folha.boot.service.CargosService;
import com.folha.boot.service.CarreirasService;
import com.folha.boot.service.ClassesCarreiraService;
import com.folha.boot.service.NiveisCarreiraService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.SituacoesService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.VinculosService;

@Controller
@RequestMapping("/funcionarios")
public class PessoaFuncionariosController {

	Long idPessoaAtual;
	PessoaFuncionarios pessoaFuncionarios = new PessoaFuncionarios();
	
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	@Autowired
	private CargaHorariaSemanalService cargaHorariaSemanalService;
	@Autowired
	private CargosEspecialidadeService cargosEspecialidadeService;
	@Autowired
	private CargosService cargosService;
	@Autowired
	private CarreirasService carreirasService;
	@Autowired
	private ClassesCarreiraService classesCarreiraService;
	@Autowired
	private NiveisCarreiraService niveisCarreiraService;
	@Autowired
	private SituacoesService situacoesService;	
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private VinculosService vinculosService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(PessoaFuncionarios funcionarios) {		
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/cadastrar/{id}")
	public String cadastrarComPessoa(@PathVariable("id") Long id, ModelMap model, PessoaFuncionarios pessoaFuncionarios) {	
		idPessoaAtual = id;
		this.pessoaFuncionarios.setIdPessoaFk(pessoaService.buscarPorId(id));
		
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaFuncionarios", this.pessoaFuncionarios);
		model.addAttribute("pessoaDocumentosLista10", pessoaFuncionariosService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaFuncionarios", pessoaFuncionariosService.buscarTodos());
		return "/funcionario/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaFuncionarios funcionarios, RedirectAttributes attr) {
		
		pessoaFuncionariosService.salvar(funcionarios);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@PostMapping("/salvar/funcionario")
	public String salvarConselho(PessoaFuncionarios pessoaFuncionarios, RedirectAttributes attr) {
		pessoaFuncionarios.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		if(pessoaFuncionarios.getIdEspecialidadeAtualFk() != null) {		
			pessoaFuncionarios.setIdCargoAtualFk(pessoaFuncionarios.getIdEspecialidadeAtualFk().getIdCargoFk());
		}
		pessoaFuncionarios.setDtCadastro(new Date());
		pessoaFuncionariosService.salvar(pessoaFuncionarios);
		
		if(pessoaFuncionarios.getIdUnidadeAtuacaoAtualFk()==null || pessoaFuncionarios.getIdUnidadeLotacaoAtualFk()==null) {
			attr.addFlashAttribute("success", "Não cadastrado. Escolhas Unidades de Atuação e Lotação.");
			return "/funcionario/cadastro";
		}
		
		return "redirect:/funcionarios/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", pessoaService.buscarPorId(idPessoaAtual));
		model.addAttribute("pessoaFuncionarios", pessoaFuncionariosService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista10", pessoaFuncionariosService.buscarPorPessoa(pessoaService.buscarPorId(idPessoaAtual)));
		return "/funcionario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaFuncionarios funcionarios, RedirectAttributes attr) {
		pessoaFuncionariosService.editar(funcionarios);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/funcionarios/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		pessoaFuncionariosService.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/excluir/funcionario/{id}")
	public String excluirEndereco(@PathVariable("id") Long id, ModelMap model) {
		pessoaFuncionariosService.excluir(id);  
		model.addAttribute("pessoa", pessoaService.buscarPorId(idPessoaAtual));
		model.addAttribute("pessoaDocumentosLista10", pessoaFuncionariosService.buscarPorPessoa(pessoaService.buscarPorId(idPessoaAtual)));
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/funcionarios/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/retroceder")
	public String retroceder() {
		return "redirect:/pessoabancos/cadastrar/"+idPessoaAtual+"";
	}
	
	@ModelAttribute("idCargaHorariaAtualFk")
	public List<CargaHorariaSemanal> getCargaHorariaSemanal() {
		return cargaHorariaSemanalService.buscarTodos();
	}
	
	@ModelAttribute("idCargoAtualFk")
	public List<Cargos> getCargo() {
		return cargosService.buscarTodos();
	}
	
	@ModelAttribute("idCarreiraAtualFk")
	public List<Carreiras> getCarreira() {
		return carreirasService.buscarTodos();
	}
	
	@ModelAttribute("idClasseCarreiraAtualFk")
	public List<ClassesCarreira> getClasseCarreira() {
		return classesCarreiraService.buscarTodos();
	}
	
	@ModelAttribute("idNivelCarreiraAtualFk")
	public List<NiveisCarreira> getNiveisCarreira() {
		return niveisCarreiraService.buscarTodos();
	}
	
	@ModelAttribute("idSituacaoAtualFk")
	public List<Situacoes> getSituacao() {
		return situacoesService.buscarTodos();
	}
	
	@ModelAttribute("idUnidadeAtuacaoAtualFk")
	public List<Unidades> getUnidadeAtuacao() {
		return unidadesService.buscarTodos();
	}
	
	@ModelAttribute("idUnidadeLotacaoAtualFk")
	public List<Unidades> getUnidadeLotacao() {
		return unidadesService.buscarTodos();
	}
	
	@ModelAttribute("idVinculoAtualFk")
	public List<Vinculos> getVinculo() {
		return vinculosService.buscarTodos();
	}
	// Qual a utilidade do parametro nesse método?
	@ModelAttribute("idEspecialidadeAtualFk")
	public List<CargosEspecialidade> getEspecialidade(PessoaFuncionarios pessoaFuncionarios) {
		return cargosEspecialidadeService.buscarTodosOrdemDeCargo();
	}
}
