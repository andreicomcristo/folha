package com.folha.boot.web.controller;

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
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Escolaridades;
import com.folha.boot.domain.EstadosCivis;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFotos;
import com.folha.boot.domain.Sexos;
import com.folha.boot.service.CidadesService;
import com.folha.boot.service.EscolaridadesService;
import com.folha.boot.service.EstadosCivisService;
import com.folha.boot.service.PessoaFotosService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.SexosService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.util.UtilidadesDeTexto;
import com.folha.boot.service.util.UtilidadesMatematicas;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;
	@Autowired
	CidadesService cidadesService;
	@Autowired
	EscolaridadesService escolaridadesService;
	@Autowired
	EstadosCivisService estadosCivisService;
	@Autowired
	SexosService sexosService;
	@Autowired
	PessoaFotosService pessoaFotosService;
	@Autowired
	PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	UnidadesService unidadesService;
	
	
	
	
	Pessoa ultimaPessoaSalva = null;
	Long idUnidadeLogada = 1l;
	Long idOperadorLogado = 1l;
	
	String ultimaBuscaNome = "";
	String ultimaBuscaCpf = "";
	
	@GetMapping("/cadastrar/inicio")
	public String cadastrarInicial(Pessoa pessoa, ModelMap model) {
		model.addAttribute("pessoa", pessoa);
		return "/pessoa/cadastroInicial";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(Pessoa pessoa, PessoaFotos pessoaFotos, ModelMap model) {
		model.addAttribute("pessoa", pessoa);
		model.addAttribute("pessoaFotos", pessoaFotos);
		
		return "/pessoa/cadastro";
	}
	
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimaBuscaNome = "";
		this.ultimaBuscaCpf = "";
		return this.findPaginated(1, model);
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<Pessoa> page = service.findPaginated(pageNo, pageSeze);
		List<Pessoa> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginatedNome(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<Pessoa> page = service.findPaginatedNome(pageNo, pageSeze, nome);
		List<Pessoa> listaCidades = page.getContent();
		return paginar(pageNo, page, listaCidades, model);
	}
	
	public String findPaginatedCpf(@PathVariable (value = "pageNo") int pageNo, String cpf, ModelMap model) {
		int pageSeze = 10;
		Page<Pessoa> page = service.findPaginatedCpf(pageNo, pageSeze, cpf);
		List<Pessoa> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	@GetMapping("/buscar/nome/paginado")
	public String getPorNomePaginado(@RequestParam("nome") String nome, ModelMap model) {
		nome=nome.toUpperCase().trim();
		this.ultimaBuscaNome = nome;
		this.ultimaBuscaCpf = "";	
		return this.findPaginatedNome(1, nome, model);
	}
	
	@GetMapping("/buscar/cpf/paginado")
	public String getPorCpfPaginado(@RequestParam("cpf") String cpf, ModelMap model) {
		cpf=cpf.toUpperCase().trim();
		cpf = UtilidadesDeTexto.limpaPontosETracosCpf(cpf);
		this.ultimaBuscaNome = "";
		this.ultimaBuscaCpf = cpf;	
		return this.findPaginatedCpf(1, cpf, model);
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorBusacaPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) && (ultimaBuscaCpf.equals("")) ){
			return "redirect:/pessoas/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedNome(pageNo, ultimaBuscaNome, model);}
			else {
				return this.findPaginatedCpf(pageNo, ultimaBuscaCpf, model);}
			}
	}
	
	
	
	public String paginar(int pageNo, Page<Pessoa> page, List<Pessoa> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("pessoa", lista);
		return "/pessoa/lista";	
	}
	
	@PostMapping("/salvar")
	public String salvar( Pessoa pessoa, PessoaFotos pessoafotos,  RedirectAttributes attr) {
		pessoa.setIdOperadorCadastroFk(pessoaOperadoresService.buscarPorId(idOperadorLogado));
		pessoa.setDtCadastro(new Date());
		
		pessoa.setIdOperadorCadastroFk(pessoaOperadoresService.buscarPorId(idOperadorLogado));
		pessoa.setDtCadastro(new Date());
		
		System.out.println("MEU CPF"+pessoa.getCpf());
		
		this.ultimaPessoaSalva = service.salvar(pessoa);
		Long id = this.ultimaPessoaSalva.getId();
		
		
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/documentos/cadastrar/"+id+"";
	}
	
	@PostMapping("/busca/por/cpf")
	public String prebuscarPorCpf(Pessoa pessoa, RedirectAttributes attr) {
		Pessoa pessoaBuscada = null;
		
		//Limpando a mascara do CPF
		if(pessoa!=null) {
			if(pessoa.getCpf()!=null) {
				pessoa.setCpf( UtilidadesDeTexto.limpaPontosETracosCpf(pessoa.getCpf()) );
			}
		}
		
		if(!service.buscarPorCpf(pessoa.getCpf()).isEmpty()) {pessoaBuscada = service.buscarPorCpf(pessoa.getCpf()).get(0);}
		
		if(pessoaBuscada!=null) {
			return "redirect:/pessoas/retroceder/editar/"+pessoaBuscada.getId()+"";
		}else {
			if(UtilidadesDeTexto.validaCpfCompleto(pessoa.getCpf()) == false) {
				return "redirect:/pessoas/mensagem/de/cpf/invalido";
			}
			
			return cadastrar(pessoa, new PessoaFotos(), new ModelMap());
		}
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", service.buscarPorId(id));
		return "redirect:/documentos/cadastrar/"+id+"";
	}
	
	@GetMapping("retroceder/editar/{id}")
	public String preEditarRetroceder(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", service.buscarPorId(id));
		return "/pessoa/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Pessoa pessoa, RedirectAttributes attr) {
		service.editar(pessoa);
		Long id = pessoa.getId();
		//attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/documentos/cadastrar/"+id+"";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	@GetMapping("/buscar/nome/pessoa")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("pessoa", service.buscarPorNome(nome.toUpperCase().trim()));
		return "/pessoa/lista";
	}
	
	@GetMapping("/mensagem/de/cpf/invalido")
	public String mensagemDeChoque(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "Dados Inválidos");
		model.addAttribute("mensagem", "CPF Inválido.");
		
		return "/choqueescala/choque";
	}
		
	@ModelAttribute("idSexoFk")
	public List<Sexos> getSexos() {
		return sexosService.buscarTodos();
	}
	
	@ModelAttribute("idSexoDeclaradoFk")
	public List<Sexos> getSexosDeclarados() {
		return sexosService.buscarTodos();
	}
	
	@ModelAttribute("idCidadeNatalFk")
	public List<Cidades> getCidades() {
		return cidadesService.buscarTodos();
	}
	
	@ModelAttribute("idEscolaridadeFk")
	public List<Escolaridades> getEscolaridades() {
		return escolaridadesService.buscarTodos();
	}
	
	@ModelAttribute("idEstadoCivilFk")
	public List<EstadosCivis> getEstadosCivis() {
		return estadosCivisService.buscarTodos();
	}
	
}
