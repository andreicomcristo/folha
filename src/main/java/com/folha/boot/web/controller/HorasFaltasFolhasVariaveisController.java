package com.folha.boot.web.controller;

import java.util.Date;
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

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.HorasFaltasFolhasVariaveis;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.HorasFaltasFolhasVariaveisService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/horasFaltasFolhasVariaveis")
public class HorasFaltasFolhasVariaveisController {

	
	String ultimaBuscaNome = "";
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private HorasFaltasFolhasVariaveisService service;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;

	@GetMapping("/cadastrar")
	public String cadastrar(HorasFaltasFolhasVariaveis horasFaltasFolhasVariaveis) {		
		return "horasFaltasFolhasVariaveis/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(HorasFaltasFolhasVariaveis horasFaltasFolhasVariaveis, RedirectAttributes attr) {
		
		if(horasFaltasFolhasVariaveis.getObservacao()==null) {horasFaltasFolhasVariaveis.setObservacao("");}
		if(horasFaltasFolhasVariaveis.getHorasDia()==null) {horasFaltasFolhasVariaveis.setHorasDia(0);}
		if(horasFaltasFolhasVariaveis.getHorasNoite()==null) {horasFaltasFolhasVariaveis.setHorasNoite(0);}
		if(horasFaltasFolhasVariaveis.getHorasSemana()==null) {horasFaltasFolhasVariaveis.setHorasSemana(0);}
		if(horasFaltasFolhasVariaveis.getHorasFimSemana()==null) {horasFaltasFolhasVariaveis.setHorasFimSemana(0);}
		
		if(anoMesService.escalaBloqueada(horasFaltasFolhasVariaveis.getIdAnoMesFk().getNomeAnoMes(), usuarioService.pegarUnidadeLogada())==true) {
			return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}
		
		if(horasFaltasFolhasVariaveis.getIdAnoMesFk()==null  ||
				(horasFaltasFolhasVariaveis.getIdFuncionarioFk()==null)  || 
				(horasFaltasFolhasVariaveis.getHorasDia() + horasFaltasFolhasVariaveis.getHorasNoite() + horasFaltasFolhasVariaveis.getHorasSemana() + horasFaltasFolhasVariaveis.getHorasFimSemana() <=0 )
			) {
			return "redirect:/escalas/mensagem/de/nao/escolha";
		}
		
		if(  horasFaltasFolhasVariaveis.getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo().equalsIgnoreCase("T") &&
			 (horasFaltasFolhasVariaveis.getHorasDia()+ horasFaltasFolhasVariaveis.getHorasNoite()>0)	
				) {
			return "redirect:horasFaltasFolhasVariaveis/mensagem/de/nivel/incompativel";
		}
		
		if(  (!horasFaltasFolhasVariaveis.getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo().equalsIgnoreCase("T")) &&
				 (horasFaltasFolhasVariaveis.getHorasSemana()+ horasFaltasFolhasVariaveis.getHorasFimSemana()>0)	
					) {
				return "redirect:horasFaltasFolhasVariaveis/mensagem/de/nivel/incompativel";
		}
		
		
		horasFaltasFolhasVariaveis.setDtCadastro(new Date());
		horasFaltasFolhasVariaveis.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		horasFaltasFolhasVariaveis.setIdUnidadeFk(usuarioService.pegarUnidadeLogada());
		horasFaltasFolhasVariaveis.setHorasDiaDescontadas(0);
		horasFaltasFolhasVariaveis.setHorasNoiteDescontadas(0);
		horasFaltasFolhasVariaveis.setHorasSemanaDescontadas(0);
		horasFaltasFolhasVariaveis.setHorasFimSemanaDescontadas(0);
		horasFaltasFolhasVariaveis.setObservacaoSistema("");
		horasFaltasFolhasVariaveis.setIdAnoMesLancamentoFk( anoMesService.buscarPorEscalaLiberadaAtual() );
		horasFaltasFolhasVariaveis.setHorasADescontar(horasFaltasFolhasVariaveis.getHorasDia()+horasFaltasFolhasVariaveis.getHorasNoite()+horasFaltasFolhasVariaveis.getHorasSemana()+horasFaltasFolhasVariaveis.getHorasFimSemana() );
		horasFaltasFolhasVariaveis.setHorasRestantes(horasFaltasFolhasVariaveis.getHorasADescontar());
		horasFaltasFolhasVariaveis.setHorasDescontadas(0);
		
		
		service.salvar(horasFaltasFolhasVariaveis);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/horasFaltasFolhasVariaveis/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("horasFaltasFolhasVariaveis", service.buscarPorId(id));
		return "horasFaltasFolhasVariaveis/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(HorasFaltasFolhasVariaveis horasFaltasFolhasVariaveis, RedirectAttributes attr) {
		
		if(horasFaltasFolhasVariaveis.getObservacao()==null) {horasFaltasFolhasVariaveis.setObservacao("");}
		if(horasFaltasFolhasVariaveis.getHorasDia()==null) {horasFaltasFolhasVariaveis.setHorasDia(0);}
		if(horasFaltasFolhasVariaveis.getHorasNoite()==null) {horasFaltasFolhasVariaveis.setHorasNoite(0);}
		if(horasFaltasFolhasVariaveis.getHorasSemana()==null) {horasFaltasFolhasVariaveis.setHorasSemana(0);}
		if(horasFaltasFolhasVariaveis.getHorasFimSemana()==null) {horasFaltasFolhasVariaveis.setHorasFimSemana(0);}
		
		if(anoMesService.escalaBloqueada(horasFaltasFolhasVariaveis.getIdAnoMesFk().getNomeAnoMes(), usuarioService.pegarUnidadeLogada())==true) {
			return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}
		
		if(horasFaltasFolhasVariaveis.getIdAnoMesFk()==null  ||
				(horasFaltasFolhasVariaveis.getIdFuncionarioFk()==null)  || 
				(horasFaltasFolhasVariaveis.getHorasDia() + horasFaltasFolhasVariaveis.getHorasNoite() + horasFaltasFolhasVariaveis.getHorasSemana() + horasFaltasFolhasVariaveis.getHorasFimSemana() <=0 )
			) {
			return "redirect:/escalas/mensagem/de/nao/escolha";
		}
		
		if(  horasFaltasFolhasVariaveis.getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo().equalsIgnoreCase("T") &&
				 (horasFaltasFolhasVariaveis.getHorasDia()+ horasFaltasFolhasVariaveis.getHorasNoite()>0)	
					) {
				return "redirect:/horasFaltasFolhasVariaveis/mensagem/de/nivel/incompativel";
			}
			
		if(  (!horasFaltasFolhasVariaveis.getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo().equalsIgnoreCase("T")) &&
				 (horasFaltasFolhasVariaveis.getHorasSemana()+ horasFaltasFolhasVariaveis.getHorasFimSemana()>0)	
					) {
				return "redirect:/horasFaltasFolhasVariaveis/mensagem/de/nivel/incompativel";
		}
			
		
		horasFaltasFolhasVariaveis.setDtCadastro(new Date());
		horasFaltasFolhasVariaveis.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		horasFaltasFolhasVariaveis.setIdUnidadeFk(usuarioService.pegarUnidadeLogada());
		horasFaltasFolhasVariaveis.setHorasDiaDescontadas(0);
		horasFaltasFolhasVariaveis.setHorasNoiteDescontadas(0);
		horasFaltasFolhasVariaveis.setHorasSemanaDescontadas(0);
		horasFaltasFolhasVariaveis.setHorasFimSemanaDescontadas(0);
		horasFaltasFolhasVariaveis.setObservacaoSistema("");
		horasFaltasFolhasVariaveis.setIdAnoMesLancamentoFk( anoMesService.buscarPorEscalaLiberadaAtual() );
		horasFaltasFolhasVariaveis.setHorasADescontar(horasFaltasFolhasVariaveis.getHorasDia()+horasFaltasFolhasVariaveis.getHorasNoite()+horasFaltasFolhasVariaveis.getHorasSemana()+horasFaltasFolhasVariaveis.getHorasFimSemana() );
		horasFaltasFolhasVariaveis.setHorasRestantes(horasFaltasFolhasVariaveis.getHorasADescontar());
		horasFaltasFolhasVariaveis.setHorasDescontadas(0);
		
		service.editar(horasFaltasFolhasVariaveis);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/horasFaltasFolhasVariaveis/listar";
	}
	/*
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	*/
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		
		HorasFaltasFolhasVariaveis horasFaltasFolhasVariaveis = service.buscarPorId(id);
		
		if(anoMesService.escalaBloqueada(horasFaltasFolhasVariaveis.getIdAnoMesFk().getNomeAnoMes(), usuarioService.pegarUnidadeLogada())==true) {
			return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}
		
		horasFaltasFolhasVariaveis.setDtCancelamento(new Date());
		horasFaltasFolhasVariaveis.setIdOperadorCancelamentoFk(usuarioService.pegarOperadorLogado());
		service.salvar(horasFaltasFolhasVariaveis); 
		model.addAttribute("success", "Cancelado com sucesso.");
		return "redirect:/horasFaltasFolhasVariaveis/listar";
	}
	/*
	@GetMapping("/buscar/nome/atividade/escala")
	public String getPorNome(@RequestParam("nomeAtividade") String nomeAtividade, ModelMap model) {	
		model.addAttribute("horasFaltasFolhasVariaveis", service.buscarNaUnidadePorNome( unidadesService.buscarPorId(idUnidadeLogada) ,nomeAtividade.toUpperCase().trim()));
		return "horasFaltasFolhasVariaveis/lista";
	}
	*/
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimaBuscaNome = "";
		return this.findPaginated(1, model);
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		return this.findPaginated(1, nome, model);
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorNomePaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if(pageNo<1) {pageNo=1;}
		
		if( (ultimaBuscaNome.equals("")) && (ultimaBuscaNome.equals("")) ){
			return "redirect:/horasFaltasFolhasVariaveis/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/horasFaltasFolhasVariaveis/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<HorasFaltasFolhasVariaveis> page = service.findPaginated( usuarioService.pegarUnidadeLogada(),pageNo, pageSeze);
		List<HorasFaltasFolhasVariaveis> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<HorasFaltasFolhasVariaveis> page = service.findPaginatedNome( usuarioService.pegarUnidadeLogada(), nome, pageNo, pageSeze);
		List<HorasFaltasFolhasVariaveis> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<HorasFaltasFolhasVariaveis> page, List<HorasFaltasFolhasVariaveis> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("horasFaltasFolhasVariaveis", lista);
		return "horasFaltasFolhasVariaveis/lista";	
	}

	
	@GetMapping("/mensagem/de/nivel/incompativel")
	public String mensagemDeNaoEscolha(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "INCOMPATIBILIDADE");
		model.addAttribute("mensagem", "Você colocou horas em disposições incompatíveis com o NÍVEL");
		
		return "alertas/nivelIncompativelComDisposicaoDasHoras";
	}

	
	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getIdAnoMesFk() {
		return anoMesService.buscarTodos();
	}	
	
	@ModelAttribute("idFuncionarioFk")
	public List<PessoaFuncionarios> getIdFuncionarioFk() {
		return pessoaFuncionariosService.buscarPorUnidade(usuarioService.pegarUnidadeLogada(), "ATIVO");
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
