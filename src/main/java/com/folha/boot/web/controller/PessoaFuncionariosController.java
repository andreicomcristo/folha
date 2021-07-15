package com.folha.boot.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.folha.boot.domain.HistFuncionariosCargaHoraria;
import com.folha.boot.domain.HistFuncionariosCargos;
import com.folha.boot.domain.HistFuncionariosCarreira;
import com.folha.boot.domain.HistFuncionariosClasse;
import com.folha.boot.domain.HistFuncionariosNiveisCarreira;
import com.folha.boot.domain.HistFuncionariosSituacoes;
import com.folha.boot.domain.HistFuncionariosUnidadeAtuacao;
import com.folha.boot.domain.HistFuncionariosUnidadeLotacao;
import com.folha.boot.domain.HistFuncionariosVinculos;
import com.folha.boot.domain.NiveisCarreira;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.SituacaoVariacao;
import com.folha.boot.domain.Situacoes;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.Vinculos;
import com.folha.boot.service.CargaHorariaSemanalService;
import com.folha.boot.service.CargosEspecialidadeService;
import com.folha.boot.service.CargosService;
import com.folha.boot.service.CarreirasService;
import com.folha.boot.service.ClassesCarreiraService;
import com.folha.boot.service.HistFuncionariosCargaHorariaService;
import com.folha.boot.service.HistFuncionariosCargosService;
import com.folha.boot.service.HistFuncionariosCarreiraService;
import com.folha.boot.service.HistFuncionariosClasseService;
import com.folha.boot.service.HistFuncionariosNiveisCarreiraService;
import com.folha.boot.service.HistFuncionariosSituacoesService;
import com.folha.boot.service.HistFuncionariosUnidadeAtuacaoService;
import com.folha.boot.service.HistFuncionariosUnidadeLotacaoService;
import com.folha.boot.service.HistFuncionariosVinculosService;
import com.folha.boot.service.NiveisCarreiraService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.SituacaoVariacaoService;
import com.folha.boot.service.SituacoesService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.VinculosService;
import com.folha.boot.service.seguranca.UsuarioService;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Controller
@RequestMapping("/funcionarios")
public class PessoaFuncionariosController {

	
	
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	
	Long idPessoaAtual;
	PessoaFuncionarios pessoaFuncionarios = new PessoaFuncionarios();
	
	@Autowired
	private UsuarioService usuarioService;
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
	private SituacaoVariacaoService situacaoVariacaoService;	
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private VinculosService vinculosService;
	@Autowired
	HistFuncionariosUnidadeAtuacaoService histFuncionariosUnidadeAtuacaoService;
	@Autowired
	HistFuncionariosUnidadeLotacaoService histFuncionariosUnidadeLotacaoService;
	@Autowired
	HistFuncionariosCargaHorariaService histFuncionariosCargaHorariaService;
	@Autowired
	HistFuncionariosCargosService histFuncionariosCargosService;
	@Autowired
	HistFuncionariosCarreiraService histFuncionariosCarreiraService;
	@Autowired
	HistFuncionariosClasseService histFuncionariosClasseService;
	@Autowired
	HistFuncionariosNiveisCarreiraService histFuncionariosNiveisCarreiraService;
	@Autowired
	HistFuncionariosSituacoesService histFuncionariosSituacoesService;
	@Autowired
	HistFuncionariosVinculosService histFuncionariosVinculosService;
	
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(PessoaFuncionarios funcionarios) {		
		return "funcionario/cadastro";
	}
	
	@GetMapping("/cadastrar/{id}")
	public String cadastrarComPessoa(@PathVariable("id") Long id, ModelMap model, PessoaFuncionarios pessoaFuncionarios) {	
		idPessoaAtual = id;
		this.pessoaFuncionarios.setIdPessoaFk(pessoaService.buscarPorId(id));
		
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaFuncionarios", this.pessoaFuncionarios);
		model.addAttribute("pessoaDocumentosLista10", pessoaFuncionariosService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		
		return "funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaFuncionarios", pessoaFuncionariosService.buscarTodos());
		return "funcionario/lista"; 
	}
	
	@GetMapping("/listar/historico/{id}")
	public String listarHistorico(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("lista1", histFuncionariosCargaHorariaService.buscarPorFuncionario(pessoaFuncionariosService.buscarPorId(id)));
		model.addAttribute("lista2", histFuncionariosCargosService.buscarPorFuncionario(pessoaFuncionariosService.buscarPorId(id)));
		model.addAttribute("lista3", histFuncionariosCarreiraService.buscarPorFuncionario(pessoaFuncionariosService.buscarPorId(id)));
		model.addAttribute("lista4", histFuncionariosClasseService.buscarPorFuncionario(pessoaFuncionariosService.buscarPorId(id)));
		model.addAttribute("lista5", histFuncionariosNiveisCarreiraService.buscarPorFuncionario(pessoaFuncionariosService.buscarPorId(id)));
		model.addAttribute("lista6", histFuncionariosSituacoesService.buscarPorFuncionario(pessoaFuncionariosService.buscarPorId(id)));
		model.addAttribute("lista7", histFuncionariosUnidadeAtuacaoService.buscarPorFuncionario(pessoaFuncionariosService.buscarPorId(id)));
		model.addAttribute("lista8", histFuncionariosUnidadeLotacaoService.buscarPorFuncionario(pessoaFuncionariosService.buscarPorId(id)));
		model.addAttribute("lista9", histFuncionariosVinculosService.buscarPorFuncionario(pessoaFuncionariosService.buscarPorId(id)));
		
		return "funcionario/listaHistorico"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaFuncionarios funcionarios, RedirectAttributes attr) {
		
		pessoaFuncionariosService.salvar(funcionarios);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@PostMapping("/salvar/funcionario")
	public String salvarConselho(PessoaFuncionarios pessoaFuncionarios, String justificativa, RedirectAttributes attr) {
		boolean podeSalvar = true;
		pessoaFuncionarios.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		justificativa=UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(justificativa);if(justificativa.equalsIgnoreCase("")) {justificativa="O(A) OPERADOR(A) NAO APRESENTOU JUSTIFICATIVA PARA A ALTERACAO";}
		if(pessoaFuncionarios.getIdEspecialidadeAtualFk() != null) {		
			pessoaFuncionarios.setIdCargoAtualFk(pessoaFuncionarios.getIdEspecialidadeAtualFk().getIdCargoFk());
		}
		pessoaFuncionarios.setDtCadastro(new Date());
		pessoaFuncionarios.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		
		if(podeSalvar==true) {
			//Salvando
			pessoaFuncionariosService.salvar(pessoaFuncionarios);
			//Cuidando dos históriocos
			histFuncionariosUnidadeAtuacaoService.cadastrar(justificativa, pessoaFuncionarios);
			histFuncionariosUnidadeLotacaoService.cadastrar(justificativa, pessoaFuncionarios);
			histFuncionariosCargaHorariaService.cadastrar(justificativa, pessoaFuncionarios);
			histFuncionariosCargosService.cadastrar(justificativa, pessoaFuncionarios);
			histFuncionariosCarreiraService.cadastrar(justificativa, pessoaFuncionarios);
			histFuncionariosClasseService.cadastrar(justificativa, pessoaFuncionarios);
			histFuncionariosNiveisCarreiraService.cadastrar(justificativa, pessoaFuncionarios);
			histFuncionariosSituacoesService.cadastrar(justificativa, pessoaFuncionarios);
			histFuncionariosVinculosService.cadastrar(justificativa, pessoaFuncionarios);
		}
		
		if(pessoaFuncionarios.getIdUnidadeAtuacaoAtualFk()==null || pessoaFuncionarios.getIdUnidadeLotacaoAtualFk()==null) {
			attr.addFlashAttribute("success", "Não cadastrado. Escolhas Unidades de Atuação e Lotação.");
			return "funcionario/cadastro";
		}
		
		return "redirect:/funcionarios/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", pessoaService.buscarPorId(idPessoaAtual));
		model.addAttribute("pessoaFuncionarios", pessoaFuncionariosService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista10", pessoaFuncionariosService.buscarPorPessoa(pessoaService.buscarPorId(idPessoaAtual)));
		return "funcionario/cadastro";
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
	
	@ModelAttribute("idSituacaoVariacaoAtualFk")
	public List<SituacaoVariacao> getSituacaoVariacao() {
		return situacaoVariacaoService.buscarTodos();
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
