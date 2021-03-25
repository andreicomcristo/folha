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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.TiposDeDocumento;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.EscalaAtalhosService;
import com.folha.boot.service.EscalaService;
import com.folha.boot.service.PessoaDocumentosService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.RegimesDeTrabalhoService;
import com.folha.boot.service.TiposDeDocumentoService;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;

@Controller
@RequestMapping("/escalas")
public class EscalaController {

	Long idAnoMesAtual =1l ;
	Long idCoordenacaoAtual = 1l;
	Long idUnidadeLogada = 1l;
	Long idOperadorLogado = 1l;
	Escala escalaAtual;
	
	
	@Autowired
	private EscalaService service;
	@Autowired
	private EscalaAtalhosService escalaAtalhosService;
	
	@Autowired
	private CodigoDiferenciadoService codigoDiferenciadoService;
	
	@Autowired
	private RegimesDeTrabalhoService regimesDeTrabalhoService;

		
	@GetMapping("/alterar/escala/{id}")
	public String cadastrarEscala(@PathVariable("id") Long id, Escala escala, ModelMap model) {	
		
		escala = service.buscarPorId(id);
		
		this.escalaAtual = escala;
		escala = service.calcularDadosEscala(escala);
	
		String anoMesDaEscala = "202105";
		if(escala!=null){anoMesDaEscala = escala.getIdAnoMesFk().getNomeAnoMes();}
		int qtdDiasNoMes = service.quantidadeDeDiasNoMes(anoMesDaEscala);
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
		String nomeColuna1 = service.obtemNomeDiaColuna(anoMesDaEscala, 1);
		String nomeColuna2 = service.obtemNomeDiaColuna(anoMesDaEscala, 2);
		String nomeColuna3 = service.obtemNomeDiaColuna(anoMesDaEscala, 3);
		String nomeColuna4 = service.obtemNomeDiaColuna(anoMesDaEscala, 4);
		String nomeColuna5 = service.obtemNomeDiaColuna(anoMesDaEscala, 5);
		String nomeColuna6 = service.obtemNomeDiaColuna(anoMesDaEscala, 6);
		String nomeColuna7 = service.obtemNomeDiaColuna(anoMesDaEscala, 7);
		
		model.addAttribute("escala", escala );
		
		model.addAttribute("anoMesDaEscala", anoMesDaEscala );
		model.addAttribute("escalaCoordenacao", escalaCoordenacao );
		model.addAttribute("nomeDaPessoa", nomeDaPessoa );
		model.addAttribute("cpfDaPessoa", cpfDaPessoa );
		model.addAttribute("matriculaDaPessoa", matriculaDaPessoa );
		model.addAttribute("cargoDaPessoa", cargoDaPessoa );
		model.addAttribute("chDaPessoa", chDaPessoa );
		model.addAttribute("tipoDeFolhaDaPessoa", tipoDeFolhaDaPessoa );
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
	
	
	@GetMapping("/atalho/ciclo1a")
	public String atalhoA(Escala escala, ModelMap model) {	
		
		System.out.println();
		
		escala = escalaAtalhosService.atalhoCiclo1A(escala);
		
		String anoMesDaEscala = "202105";
		if(escala!=null){anoMesDaEscala = escala.getIdAnoMesFk().getNomeAnoMes();}
		int qtdDiasNoMes = service.quantidadeDeDiasNoMes(anoMesDaEscala);
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
		String nomeColuna1 = service.obtemNomeDiaColuna(anoMesDaEscala, 1);
		String nomeColuna2 = service.obtemNomeDiaColuna(anoMesDaEscala, 2);
		String nomeColuna3 = service.obtemNomeDiaColuna(anoMesDaEscala, 3);
		String nomeColuna4 = service.obtemNomeDiaColuna(anoMesDaEscala, 4);
		String nomeColuna5 = service.obtemNomeDiaColuna(anoMesDaEscala, 5);
		String nomeColuna6 = service.obtemNomeDiaColuna(anoMesDaEscala, 6);
		String nomeColuna7 = service.obtemNomeDiaColuna(anoMesDaEscala, 7);
		
		model.addAttribute("escala", escala );
		
		model.addAttribute("anoMesDaEscala", anoMesDaEscala );
		model.addAttribute("escalaCoordenacao", escalaCoordenacao );
		model.addAttribute("nomeDaPessoa", nomeDaPessoa );
		model.addAttribute("cpfDaPessoa", cpfDaPessoa );
		model.addAttribute("matriculaDaPessoa", matriculaDaPessoa );
		model.addAttribute("cargoDaPessoa", cargoDaPessoa );
		model.addAttribute("chDaPessoa", chDaPessoa );
		model.addAttribute("tipoDeFolhaDaPessoa", tipoDeFolhaDaPessoa );
		model.addAttribute("qtdDiasNoMes", qtdDiasNoMes );
		model.addAttribute("nomeColuna1", nomeColuna1 );
		model.addAttribute("nomeColuna2", nomeColuna2 );
		model.addAttribute("nomeColuna3", nomeColuna3 );
		model.addAttribute("nomeColuna4", nomeColuna4 );
		model.addAttribute("nomeColuna5", nomeColuna5 );
		model.addAttribute("nomeColuna6", nomeColuna6 );
		model.addAttribute("nomeColuna7", nomeColuna7 );
		
		
		return "/escala/editar";
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
	@ModelAttribute("idCodigoDiferenciadoFk")
	public List<CodigoDiferenciado> getCodigosDiferenciado() {
		return codigoDiferenciadoService.buscarTodos();
	}
	@ModelAttribute("idRegimeFk")
	public List<RegimesDeTrabalho> getRegimesDeTrabalho() {
		return regimesDeTrabalhoService.buscarTodos();
	}
}
