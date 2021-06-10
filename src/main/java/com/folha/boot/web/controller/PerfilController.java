package com.folha.boot.web.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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
import com.folha.boot.domain.CargaHorariaSemanal;
import com.folha.boot.domain.ClassesCarreira;
import com.folha.boot.domain.FaixasValoresFolhExt;
import com.folha.boot.domain.Fonte;
import com.folha.boot.domain.NiveisCargo;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.TipoBrutoLiquido;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.seguranca.GrupoUsuario;
import com.folha.boot.domain.seguranca.Perfil;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CargaHorariaSemanalService;
import com.folha.boot.service.ClassesCarreiraService;
import com.folha.boot.service.FaixasValoresFolhExtService;
import com.folha.boot.service.FonteService;
import com.folha.boot.service.NiveisCargoService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.TipoBrutoLiquidoService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.seguranca.GrupoUsuarioService;
import com.folha.boot.service.seguranca.PerfilService;
import com.folha.boot.service.seguranca.UsuarioService;


@Controller
@RequestMapping("/perfil")
public class PerfilController {

	
	String ultimoAnoMes = "";
	String ultimaBuscaNome = "";
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PerfilService service;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private ClassesCarreiraService classesCarreiraService;
	@Autowired
	private CargaHorariaSemanalService cargaHorariaSemanalService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private FonteService fonteService;
	@Autowired
	private TipoBrutoLiquidoService tipoBrutoLiquidoService;
	@Autowired
	private NiveisCargoService niveisCargoService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	private GrupoUsuarioService grupoUsuarioService;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*Lista de Operadores
	  Funcionarios Todos os Possíveis
	  Inicio da paginação*/
	
	
	@GetMapping("/paginar/operadores/{pageNo}")
	public String getPorNomePaginadoInclusao(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) ){
			return "redirect:/perfil/operadores/listar/{pageNo}" ;}
			else {		
				if(!ultimaBuscaNome.equals("")) {
					return this.findPaginatedOperador(pageNo, ultimaBuscaNome, model);}
				else {
					return "redirect:/perfil/operadores/listar/{pageNo}" ;}
			}
		}
		
	@GetMapping("/operadores/listar")
	public String listarOperadores(ModelMap model) {
		ultimaBuscaNome = "";
		return this.findPaginatedOperadores(1, model);
	}	
		
	@GetMapping("/operadores/listar/{pageNo}")
	public String findPaginatedOperadores(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<PessoaOperadores> page = pessoaOperadoresService.findPaginated(pageNo, pageSeze);
		List<PessoaOperadores> lista = page.getContent();
		return paginarOperadores(pageNo, page, lista, model);
	}
		
	public String paginarOperadores(int pageNo, Page<PessoaOperadores> page, List<PessoaOperadores> lista, ModelMap model) {			
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaOperadores", lista);
		return "/perfil/listaOperadores";	
	}	
		
	@GetMapping("/buscar/operadores/nome")
	public String getPorNomeOperador(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		//this.ultimaBuscaTurma = null;	
		return this.findPaginatedOperador(1, nome, model);
	}
		
	public String findPaginatedOperador(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 50;
		Page<PessoaOperadores> page = pessoaOperadoresService.findPaginatedNome( nome, pageNo, pageSeze);
		List<PessoaOperadores> lista = page.getContent();
		//ultimaBuscaNome = "";
		//ultimaBuscaTurma = null;
		return paginarOperadores(pageNo, page, lista, model);
	}
	//Fim da lista de operadores
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		
	
	
	
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimaBuscaNome = "";
		return this.findPaginated(1, model); 
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<Perfil> page = service.findPaginated(pageNo, pageSeze);
		List<Perfil> listaCidades = page.getContent();
		return paginar(pageNo, page, listaCidades, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String cnes, ModelMap model) {
		int pageSeze = 50;
		Page<Perfil> page = service.findPaginatedNome(pageNo, pageSeze, cnes);
		List<Perfil> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<Perfil> page, List<Perfil> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		
		//Retirando da lista quando dependendo do grupo usuario
		String grupoUsuarioLogado = "";
		List<Perfil> listaPerfis = service.buscarPorOperadorEUnidade(usuarioService.pegarOperadorLogado(), usuarioService.pegarUnidadeLogada());
		if(!listaPerfis.isEmpty()) {
			grupoUsuarioLogado = listaPerfis.get(0).getIdGrupoUsuarioFk().getNome();
		}
		
		if(!grupoUsuarioLogado.equalsIgnoreCase("MASTER")) {
			
				for( int i=lista.size();i==0;i--) {
					if(lista.get(i).getIdUnidadeFk()!=usuarioService.pegarUnidadeLogada()) {
						lista.remove(i); 
					}
					if(lista.get(i).getIdGrupoUsuarioFk().getNome().equalsIgnoreCase("MASTER")) {
						lista.remove(i); 
					}
				}
				
				//Retirando o grupo usuario folha da lista
				if(!grupoUsuarioLogado.contains("FOLHA")) {		
					for( int i=lista.size();i==0;i--) {
						if(lista.get(i).getIdGrupoUsuarioFk().getNome().contains("FOLHA")) {
							lista.remove(i);
						}
					}
				}
				
			
		}
		
		model.addAttribute("perfil", lista);
		return "/perfil/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if(pageNo<1) {pageNo = 1;}
		if( (ultimaBuscaNome.equals("")) ){
			return "redirect:/perfil/listar/{pageNo}" ;}
		else {return this.findPaginated(pageNo, ultimoAnoMes, model);}
	}
		
	@GetMapping("/buscar/nome/nome")
	public String getPorAnoMes(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		return this.findPaginated(1, nome, model);
	}
	//Fim da paginação
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Perfil perfil) {
		return "/perfil/cadastro";
	}
	
	// Dados para Atribuição
	@GetMapping("/cadastrar/{id}")
	public String cadastrar(@PathVariable("id") Long id, Perfil perfil, ModelMap model) {
		
		perfil.setIdOperadorFk(pessoaOperadoresService.buscarPorId(id));
		perfil.setId(null);
		model.addAttribute("nome", perfil.getIdOperadorFk().getIdPessoaFk().getNome());
		model.addAttribute("cpf", perfil.getIdOperadorFk().getIdPessoaFk().getCpf());
		
		return "/perfil/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Perfil perfil, RedirectAttributes attr) {
		
		if(service.perfilJaCadastrado(perfil) ==true) {
			return "redirect:/perfil/mensagem/de/ja/cadastrado";
		}
		
		if(service.jaTemPerfilNaUnidade(perfil) ==true) {
			return "redirect:/perfil/mensagem/de/ja/tem/perfil";
		}
		
		service.salvar(perfil);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/perfil/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("perfil", service.buscarPorId(id));
		model.addAttribute("nome", service.buscarPorId(id).getIdOperadorFk().getIdPessoaFk().getNome());
		model.addAttribute("cpf", service.buscarPorId(id).getIdOperadorFk().getIdPessoaFk().getCpf());
		
		return "/perfil/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Perfil perfil, RedirectAttributes attr) {	
		
		service.editar(perfil);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/perfil/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}	
	
//		
//	@GetMapping("/exporta/excel")
//    public void downloadExcel(HttpServletResponse response, ModelMap model) throws IOException {
//        response.setContentType("application/octet-stream");
//        response.setHeader("Content-Disposition", "attachment; filename=dados.xlsx");
//        ByteArrayInputStream stream = service.exportarExcel(service.buscarTodos());
//        IOUtils.copy(stream, response.getOutputStream());
//    }
//	
//	@GetMapping(value = "/exporta/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
//	public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {
//		ByteArrayInputStream bis = service.exportarPdf(service.buscarTodos());
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Disposition", "attachment;filename=dados.pdf");
//		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
//				.body(new InputStreamResource(bis));
//	}
//	
	
	
	
	
	@GetMapping("/mensagem/de/ja/tem/perfil")
	public String mensagemDeJaTemPerfil(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "JÁ HÁ PERFIL");
		model.addAttribute("mensagem", "Este operador já tem perfil cadastrado nesta unidade.");
		
		return "/alertas/jaTemPerfilNaUnidade";
	}
	
	@GetMapping("/mensagem/de/ja/cadastrado")
	public String mensagemDePerfilJaCadastrado(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "JÁ Cadastrado");
		model.addAttribute("mensagem", "Este perfil já está cadastrado.");
		
		return "/alertas/jaTemPerfilNaUnidade";
	}
	
	
	@ModelAttribute("idGrupoUsuarioFk")
	public List<GrupoUsuario> getIdGrupoUsuarioFk() {
		
		List<GrupoUsuario> lista = grupoUsuarioService.buscarTodos(); 
		
		
		
			Perfil perfilLogado = null;
			List<Perfil> listaPerfis = service.buscarPorOperadorEUnidade(usuarioService.pegarOperadorLogado(), usuarioService.pegarUnidadeLogada());
			if(!listaPerfis.isEmpty()) {
				perfilLogado = listaPerfis.get(0);
			}
			
				if(perfilLogado!=null) {
					
					if(!perfilLogado.getIdGrupoUsuarioFk().getNome().equalsIgnoreCase("MASTER")) {
						
						if(perfilLogado.getIdGrupoUsuarioFk().getNome().equalsIgnoreCase("FOLHA_SEDE")) {
							for(int i = lista.size();i==0;i--) {
								if(!lista.get(i).getNome().contains("SEDE")) {lista.remove(i);}
							}
						}
						
						if(!perfilLogado.getIdGrupoUsuarioFk().getNome().equalsIgnoreCase("FOLHA_SEDE")) {
							if(perfilLogado.getIdGrupoUsuarioFk().getNome().contains("SEDE")) {
								for(int i = lista.size();i==0;i--) {
									if(!lista.get(i).getNome().contains("SEDE")) {lista.remove(i); }
									if(lista.get(i).getNome().contains("FOLHA_SEDE")) {lista.remove(i); }
								}
							}
						}
						
			
						if(!perfilLogado.getIdGrupoUsuarioFk().getNome().equalsIgnoreCase("FOLHA_SEDE")) {
							if(!perfilLogado.getIdGrupoUsuarioFk().getNome().contains("SEDE")) {
								for(int i = lista.size();i==0;i--) {
									if(lista.get(i).getNome().contains("SEDE")) {lista.remove(i);}
									if(lista.get(i).getNome().contains("MASTER")) {lista.remove(i); }
								}
							}
						}
		
					
					}
					
				}
			
				
		return lista;
		
		
	}
	
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getIdUnidadeRegimeFk() {
		List<Unidades> lista = unidadesService.buscarTodos(); 
		
		Perfil perfilLogado = null;
		List<Perfil> listaPerfis = service.buscarPorOperadorEUnidade(usuarioService.pegarOperadorLogado(), usuarioService.pegarUnidadeLogada());
		if(listaPerfis.isEmpty()) {
			perfilLogado = listaPerfis.get(0);
		}
		
		if(perfilLogado!=null) {
			if(!perfilLogado.getIdGrupoUsuarioFk().getNome().equalsIgnoreCase("MASTER")) {
				lista.clear();
				lista.add(usuarioService.pegarUnidadeLogada());
			}
		}
		
		return 	lista;
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
