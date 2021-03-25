package com.folha.boot.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.TiposDeDocumento;
import com.folha.boot.domain.Turmas;
import com.folha.boot.domain.Turnos;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.CoordenacaoEscalaService;
import com.folha.boot.service.EscalaAtalhosService;
import com.folha.boot.service.EscalaCalculosService;
import com.folha.boot.service.EscalaService;
import com.folha.boot.service.PessoaDocumentosService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.RegimesDeTrabalhoService;
import com.folha.boot.service.SimNaoService;
import com.folha.boot.service.TiposDeDocumentoService;
import com.folha.boot.service.TiposDeFolhaService;
import com.folha.boot.service.TurmasService;
import com.folha.boot.service.TurnosService;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;

@Controller
@RequestMapping("/escalas")
public class EscalaController {

	Long ultimoIdEscala =0l ;
	Long idAnoMesAtual =1l ;
	Long idCoordenacaoAtual = 1l;
	Long idUnidadeLogada = 1l;
	Long idOperadorLogado = 1l;
	Escala escalaAtual;
	
	
	@Autowired
	private EscalaService service;
	@Autowired
	private EscalaCalculosService escalaCalculosService;
	@Autowired
	private EscalaAtalhosService escalaAtalhosService;
	@Autowired
	private CodigoDiferenciadoService codigoDiferenciadoService;
	@Autowired
	private RegimesDeTrabalhoService regimesDeTrabalhoService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private CoordenacaoEscalaService coordenacaoEscalaService;
	@Autowired
	private TiposDeFolhaService tiposDeFolhaService;
	@Autowired
	private SimNaoService simNaoService;
	@Autowired
	private TurmasService turmasService;
	@Autowired
	private TurnosService turnosService;
	
	
	

		
	@GetMapping("/alterar/escala/{id}")
	public String cadastrarEscala(@PathVariable("id") Long id, Escala escala, ModelMap model) {	
		ultimoIdEscala = id;
		escala = service.buscarPorId(id);
		
		this.escalaAtual = escala;
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		
		String anoMesDaEscala = "202105";
		if(escala!=null){anoMesDaEscala = escala.getIdAnoMesFk().getNomeAnoMes();}
		int qtdDiasNoMes = escalaCalculosService.quantidadeDeDiasNoMes(anoMesDaEscala);
		String escalaCoordenacao = "ENFERMAGEM-VERDE A-ENFERMEIROS";
		if(escala!=null){escalaCoordenacao = escala.getIdCoordenacaoFk().getNomeCoordenacao()+"-"+escala.getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade()+"-"+escala.getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade();}
		String nomeDaPessoa = "NOME DA PESSOA";
		if(escala!=null){nomeDaPessoa = escala.getIdFuncionarioFk().getIdPessoaFk().getNome();}
		String cpfDaPessoa = "11111111111";
		if(escala!=null){cpfDaPessoa = escala.getIdFuncionarioFk().getIdPessoaFk().getCpf();}
		String matriculaDaPessoa = "00000000";
		if(escala!=null){matriculaDaPessoa = escala.getIdFuncionarioFk().getMatricula();}
		String chDaPessoa = "30";
		if(escala!=null){chDaPessoa = String.valueOf(escala.getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria());}
		String tipoDeFolhaDaPessoa = "TIPO DE FOLHA";
		if(escala!=null){tipoDeFolhaDaPessoa = escala.getIdTipoFolhaFk().getNomeTipoFolha();}
		String cargoDaPessoa = "CARGO";
		if(escala!=null){cargoDaPessoa = escala.getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getNomeCargo()+"-"+escala.getIdFuncionarioFk().getIdEspecialidadeAtualFk().getNomeEspecialidadeCargo();}
		
		// CALCULANDO OS DIAS DO MES
		String nomeColuna1 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 1);
		String nomeColuna2 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 2);
		String nomeColuna3 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 3);
		String nomeColuna4 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 4);
		String nomeColuna5 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 5);
		String nomeColuna6 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 6);
		String nomeColuna7 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 7);
		
		model.addAttribute("escala", escala );
		model.addAttribute("idLinha", id );
		model.addAttribute("qtdDiasNoMes", qtdDiasNoMes );
		model.addAttribute("nomeColuna1", nomeColuna1 );
		model.addAttribute("nomeColuna2", nomeColuna2 );
		model.addAttribute("nomeColuna3", nomeColuna3 );
		model.addAttribute("nomeColuna4", nomeColuna4 );
		model.addAttribute("nomeColuna5", nomeColuna5 );
		model.addAttribute("nomeColuna6", nomeColuna6 );
		model.addAttribute("nomeColuna7", nomeColuna7 );
		
		this.escalaAtual = escala;
		
		return "/escala/editar";
	}
	
	
	@GetMapping("/atalho/limpar_escala")
	public String atalhoLimparEscala( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoLimaprEscala(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/diarista_manha")
	public String atalhoDiaristaManha( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoDiaristasManha(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/diarista_tarde")
	public String atalhoDiaristaTarde( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoDiaristasTarde(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/diarista_dia")
	public String atalhoDiaristaDia( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoDiaristasDia(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/mt_dias_impares")
	public String atalhoMTDiasImpares( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoMTDiasImpares(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/mt_dias_pares")
	public String atalhoMTDiasPares( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoMTDiasPares(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	//Ciclo 1
	@GetMapping("/atalho/ciclo1_a")
	public String atalhoCiclo1A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo1_b")
	public String atalhoCiclo1B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo1_c")
	public String atalhoCiclo1C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo1_d")
	public String atalhoCiclo1D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo1_e")
	public String atalhoCiclo1E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo1_f")
	public String atalhoCiclo1F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	//Ciclo2
	@GetMapping("/atalho/ciclo2_a")
	public String atalhoCiclo2A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo2_b")
	public String atalhoCiclo2B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo2_c")
	public String atalhoCiclo2C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo2_d")
	public String atalhoCiclo2D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo2_e")
	public String atalhoCiclo2E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo2_f")
	public String atalhoCiclo2F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}

	//Ciclo4
	@GetMapping("/atalho/ciclo4_a")
	public String atalhoCiclo4A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo4_b")
	public String atalhoCiclo4B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo4_c")
	public String atalhoCiclo4C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo4_d")
	public String atalhoCiclo4D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo4_e")
	public String atalhoCiclo4E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo4_f")
	public String atalhoCiclo4F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}

	//Ciclo5
	@GetMapping("/atalho/ciclo5_a")
	public String atalhoCiclo5A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo5_b")
	public String atalhoCiclo5B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo5_c")
	public String atalhoCiclo5C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo5_d")
	public String atalhoCiclo5D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo5_e")
	public String atalhoCiclo5E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo5_f")
	public String atalhoCiclo5F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}

	//Ciclo6
	@GetMapping("/atalho/ciclo6_a")
	public String atalhoCiclo6A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo6_b")
	public String atalhoCiclo6B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo6_c")
	public String atalhoCiclo6C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo6_d")
	public String atalhoCiclo6D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo6_e")
	public String atalhoCiclo6E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo6_f")
	public String atalhoCiclo6F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}

	//Ciclo7
	@GetMapping("/atalho/ciclo7_a")
	public String atalhoCiclo7A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo7_b")
	public String atalhoCiclo7B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo7_c")
	public String atalhoCiclo7C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo7_d")
	public String atalhoCiclo7D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo7_e")
	public String atalhoCiclo7E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo7_f")
	public String atalhoCiclo7F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}

	
	
	/*
	@GetMapping("/cadastrar/{id}")
	public String cadastrarComPessoa(@PathVariable("id") Long id, ModelMap model, PessoaDocumentos pessoaDocumentos) {	
		idPessoaAtual = id;
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista", service.buscarPorPessoa(pessoaService.buscarPorId(id)));
		return "/documento/cadastro";
	}
	*/
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaDocumentos", service.buscarTodos());
		System.out.println(service.buscarTodos().toString());
		return "/documento/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Escala escala) {
		
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		
		service.salvar(escala);
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/bancos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaDocumentos", service.buscarPorId(id));
		return "/documento/cadastro";
	}
	/*
	@PostMapping("/editar")
	public String editar(PessoaDocumentos documento, RedirectAttributes attr) {
		service.editar(documento);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/documentos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista", service.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/documentos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/buscar/numero/documento")
	public String getPorNome(@RequestParam("numeroDocumento") String numeroDocumento, ModelMap model) {		
		model.addAttribute("pessoaDocumentos", service.buscarPorNome(numeroDocumento.toUpperCase().trim()));
		return "/documento/lista";
	}
	*/
	
	@ModelAttribute("idChDifSimNaoFk")
	public List<SimNao> getChDif() {
		return simNaoService.buscarTodos();
	}
	@ModelAttribute("idIncrementoDeRiscoSimNaoFk")
	public List<SimNao> getIncrementoDeRisco() {
		return simNaoService.buscarTodos();
	}
	@ModelAttribute("idCodigoDiferenciadoFk")
	public List<CodigoDiferenciado> getCodigosDiferenciado() {
		return codigoDiferenciadoService.buscarTodos();
	}
	@ModelAttribute("idRegimeFk")
	public List<RegimesDeTrabalho> getRegimesDeTrabalho() {
		return regimesDeTrabalhoService.buscarTodos();
	}
	@ModelAttribute("idTurmaFk")
	public List<Turmas> getTurma() {
		return turmasService.buscarTodos();
	}
	
	@ModelAttribute("dia01Fk")
	public List<Turnos> getTurnos01() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia02Fk")
	public List<Turnos> getTurnos02() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia03Fk")
	public List<Turnos> getTurnos03() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia04Fk")
	public List<Turnos> getTurnos04() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia05Fk")
	public List<Turnos> getTurnos05() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia06Fk")
	public List<Turnos> getTurnos06() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia07Fk")
	public List<Turnos> getTurnos07() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia08Fk")
	public List<Turnos> getTurnos08() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia09Fk")
	public List<Turnos> getTurnos09() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia10Fk")
	public List<Turnos> getTurnos10() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia11Fk")
	public List<Turnos> getTurnos11() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia12Fk")
	public List<Turnos> getTurnos12() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia13Fk")
	public List<Turnos> getTurnos13() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia14Fk")
	public List<Turnos> getTurnos14() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia15Fk")
	public List<Turnos> getTurnos15() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia16Fk")
	public List<Turnos> getTurnos16() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia17Fk")
	public List<Turnos> getTurnos17() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia18Fk")
	public List<Turnos> getTurnos18() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia19Fk")
	public List<Turnos> getTurnos19() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia20Fk")
	public List<Turnos> getTurnos20() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia21Fk")
	public List<Turnos> getTurnos21() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia22Fk")
	public List<Turnos> getTurnos22() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia23Fk")
	public List<Turnos> getTurnos23() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia24Fk")
	public List<Turnos> getTurnos24() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia25Fk")
	public List<Turnos> getTurnos25() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia26Fk")
	public List<Turnos> getTurnos26() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia27Fk")
	public List<Turnos> getTurnos27() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia28Fk")
	public List<Turnos> getTurnos28() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia29Fk")
	public List<Turnos> getTurnos29() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia30Fk")
	public List<Turnos> getTurnos30() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia31Fk")
	public List<Turnos> getTurnos31() {
		return turnosService.buscarTodos();
	}
	
}
