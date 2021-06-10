package com.folha.boot.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.seguranca.Perfil;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.seguranca.PerfilService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/operadores")
public class PessoaOperadoresController {
	
	
	
	
	String ultimaBuscaNome = "";
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PessoaOperadoresService service;
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private PerfilService perfilService;

	@GetMapping("/avaliarcadastro/{id}")
	public String valiarCadastro(@PathVariable("id") Long id, ModelMap model) {
		
		PessoaOperadores operador = service.buscarPorPessoa(pessoaService.buscarPorId(id));
		//para o caso de nao estar cadastrado ainda
		if(operador==null) {
			PessoaOperadores novoOperador = new PessoaOperadores();
			novoOperador.setIdPessoaFk(pessoaService.buscarPorId(id));
			model.addAttribute("pessoaOperadores", novoOperador );
			return "/operador/cadastro";
		}
		//Para o caso de já estar cadastrado
		return "redirect:/operadores/mensagem/de/ja/cadastrado";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(PessoaOperadores operadores) {		
		return "/operador/cadastro";
	}
	
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		
		String grupoUsuarioLogado = "";
		List<Perfil> listaPerfis = perfilService.buscarPorOperadorEUnidade(usuarioService.pegarOperadorLogado(), usuarioService.pegarUnidadeLogada());
		if(!listaPerfis.isEmpty()) {
			grupoUsuarioLogado = listaPerfis.get(0).getIdGrupoUsuarioFk().getNome();
		}
		
		if(grupoUsuarioLogado.equalsIgnoreCase("MASTER")) {
			model.addAttribute("pessoaOperadores", service.buscarTodos());
		}else {
			List <PessoaOperadores> lista = new ArrayList<>();
			List <Perfil> listaPerfisNaUnidade = perfilService.buscarPorUnidade( usuarioService.pegarUnidadeLogada());
			
			for(Perfil p: listaPerfisNaUnidade) {
				if(!lista.contains(p.getIdOperadorFk())) {lista.add(p.getIdOperadorFk());}
			}
			
			model.addAttribute("pessoaOperadores", lista);
		}
		
		
		return "/operador/lista"; 
	}
	*/	
	
	
	//Inicio da Paginacao
	
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
			return "redirect:/operadores/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/operadores/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<PessoaOperadores> page = service.findPaginated( pageNo, pageSeze);
		List<PessoaOperadores> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 50;
		Page<PessoaOperadores> page = service.findPaginatedNome( nome, pageNo, pageSeze);
		List<PessoaOperadores> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<PessoaOperadores> page, List<PessoaOperadores> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		
		//Retirando os de fora da unidade quando não é Master
		String grupoUsuarioLogado = "";
		List<Perfil> listaPerfis = perfilService.buscarPorOperadorEUnidade(usuarioService.pegarOperadorLogado(), usuarioService.pegarUnidadeLogada());
		if(!listaPerfis.isEmpty()) {
			grupoUsuarioLogado = listaPerfis.get(0).getIdGrupoUsuarioFk().getNome();
		}
		
		if(!grupoUsuarioLogado.equalsIgnoreCase("MASTER")) {
			
			List<PessoaOperadores> listaA = new ArrayList<>();
			
			List <Perfil> listaPerfisNaUnidade = perfilService.buscarPorUnidade( usuarioService.pegarUnidadeLogada());
			for(Perfil p: listaPerfisNaUnidade) {
				if(!listaA.contains(p.getIdOperadorFk())) {listaA.add(p.getIdOperadorFk());}
			}
			
			model.addAttribute("pessoaOperadores", listaA);
		}else {
			model.addAttribute("pessoaOperadores", lista);
		}
		
		
		return "/operador/lista";	
	}

	
	//Fim da paginação
	
	
	
	
	//Inicio da Paginacao para cancelados
	
	@GetMapping("/listar/cancelados")
	public String listarCancelados(ModelMap model) {
		this.ultimaBuscaNome = "";
		return this.findPaginatedCancelados(1, model);
	}
	
	@GetMapping("/buscar/nome/cancelados")
	public String getPorNomeCancelados(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		return this.findPaginatedCancelados(1, nome, model);
	}
	
	@GetMapping("/paginar/cancelados/{pageNo}")
	public String getPorNomePaginadoCancelados(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if(pageNo<1) {pageNo=1;}
		
		if( (ultimaBuscaNome.equals("")) && (ultimaBuscaNome.equals("")) ){
			return "redirect:/operadores/listar/cancelados/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedCancelados(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/operadores/listar/cancelados/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/cancelados/{pageNo}")
	public String findPaginatedCancelados(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<PessoaOperadores> page = service.findPaginatedCancelados( pageNo, pageSeze);
		List<PessoaOperadores> lista = page.getContent();
		return paginarCancelados(pageNo, page, lista, model);
	}

	public String findPaginatedCancelados(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 50;
		Page<PessoaOperadores> page = service.findPaginatedNomeCancelados( nome, pageNo, pageSeze);
		List<PessoaOperadores> lista = page.getContent();
		return paginarCancelados(pageNo, page, lista, model);
	}
	
	
	
	public String paginarCancelados(int pageNo, Page<PessoaOperadores> page, List<PessoaOperadores> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		
		//Retirando os de fora da unidade quando não é Master
		String grupoUsuarioLogado = "";
		List<Perfil> listaPerfis = perfilService.buscarPorOperadorEUnidade(usuarioService.pegarOperadorLogado(), usuarioService.pegarUnidadeLogada());
		if(!listaPerfis.isEmpty()) {
			grupoUsuarioLogado = listaPerfis.get(0).getIdGrupoUsuarioFk().getNome();
		}
		
		if(!grupoUsuarioLogado.equalsIgnoreCase("MASTER")) {
			
			List<PessoaOperadores> listaA = new ArrayList<>();
			
			List <Perfil> listaPerfisNaUnidade = perfilService.buscarPorUnidade( usuarioService.pegarUnidadeLogada());
			for(Perfil p: listaPerfisNaUnidade) {
				if(!listaA.contains(p.getIdOperadorFk())) {listaA.add(p.getIdOperadorFk());}
			}
			
			model.addAttribute("pessoaOperadores", listaA);
		}else {
			model.addAttribute("pessoaOperadores", lista);
		}
		
		
		return "/operador/listaCancelados";	
	}

	
	//Fim da paginação
	
	
	
	
	
	@PostMapping("/salvar")
	public String salvar(PessoaOperadores operadores, RedirectAttributes attr) {		
		boolean acaoValida = true;
		
		if(operadores.getUsername().length()<3 || operadores.getPassword().length()<3) {
			return "redirect:/operadores/mensagem/de/dados/incompletos";
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		operadores.setPassword(encoder.encode(operadores.getPassword()));
		operadores.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		operadores.setDtCadastro(new Date());
		if(operadores.getEnabled()==null) {operadores.setEnabled(true);}
		
		
		//Olhando se já existe este operador
		if(operadores.getId()==null) {
			if(service.pessoaCadastrada(operadores.getIdPessoaFk())==true) {
				return "redirect:/operadores/mensagem/de/ja/cadastrado/pessoa";
			}
			if(service.loginCadastrado(operadores.getUsername())==true) {
				return "redirect:/operadores/mensagem/de/ja/cadastrado/login";
			}
			
		}
		
		if(acaoValida==true) {
			PessoaOperadores operadorSalvo = service.salvar(operadores);
			//Encaminhando para perfil
			return "redirect:/perfil/cadastrar/"+operadorSalvo.getId();
		}
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/operadores/cadastrar";
	}
	
	@GetMapping("/editarSenha/{id}")
	public String preEditarSenha(@PathVariable("id") Long id, ModelMap model, RedirectAttributes attr) {
		attr.addFlashAttribute("fail", "Operador já cadastrado. Talvez você deseje editar.");
		model.addAttribute("pessoaOperadores", service.buscarPorId(id));
		return "/operador/cadastroSenha";
	}
	
	@GetMapping("/editarUsuario/{id}")
	public String preEditarUsuario(@PathVariable("id") Long id, ModelMap model, RedirectAttributes attr) {
		attr.addFlashAttribute("fail", "Operador já cadastrado. Talvez você deseje editar.");
		model.addAttribute("pessoaOperadores", service.buscarPorId(id));
		return "/operador/cadastroUsuario";
	}
	
	@PostMapping("/editarSenha")
	public String editarSenha(PessoaOperadores operadores, RedirectAttributes attr) {
		boolean acaoValida = true;
		
		if(operadores.getUsername().length()<3 || operadores.getPassword().length()<3) {
			return "redirect:/operadores/mensagem/de/dados/incompletos";
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		operadores.setPassword(encoder.encode(operadores.getPassword()));
		operadores.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		operadores.setDtCadastro(new Date());
		if(operadores.getEnabled()==null) {operadores.setEnabled(true);}
		
		if(acaoValida==true){
			service.editar(operadores);
		}
		
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/operadores/listar";
	}
	
	@PostMapping("/editarUsuario")
	public String editarUsuario(PessoaOperadores operadores, RedirectAttributes attr) {
		boolean acaoValida = true;
		
		if(operadores.getUsername().length()<3 || operadores.getPassword().length()<3) {
			return "redirect:/operadores/mensagem/de/dados/incompletos";
		}
		
		if(service.loginCadastrado(operadores.getUsername(), operadores.getIdPessoaFk())) {
			return "redirect:/operadores/mensagem/de/ja/cadastrado/login";
		}
		
		operadores.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		operadores.setDtCadastro(new Date());
		if(operadores.getEnabled()==null) {operadores.setEnabled(true);}
		
		if(acaoValida==true){
			service.editar(operadores);
		}
		
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/operadores/listar";
	}
	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		
		PessoaOperadores pessoaOperadores = service.buscarPorId(id);
		pessoaOperadores.setIdOperadorCancelamentoFk(usuarioService.pegarOperadorLogado());
		pessoaOperadores.setDtCancelamento(new Date());
		
		service.editar(pessoaOperadores);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	
	@GetMapping("/restaurar/{id}")
	public String restaurae(@PathVariable("id") Long id, ModelMap model) {
		
		PessoaOperadores pessoaOperadores = service.buscarPorId(id);
		perfilService.deletarPorPessoa(pessoaOperadores);
		
		pessoaOperadores.setDtCancelamento(null);
		pessoaOperadores.setIdOperadorCancelamentoFk(null);
		pessoaOperadores.setDtCadastro(new Date());
		pessoaOperadores.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		pessoaOperadores.setEnabled(true);
		
		service.editar(pessoaOperadores);  
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/perfil/cadastrar/"+pessoaOperadores.getId();
	}
	
	
	@GetMapping("/mensagem/de/ja/cadastrado/pessoa")
	public String mensagemDePerfilJaCadastradoPessoa(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "JÁ Cadastrada");
		model.addAttribute("mensagem", "Esta Pessoa já existe como operador. Avalie se ela não está na lista dos operadores cancelados.");
		
		return "/alertas/jaTemPerfilNaUnidade";
	}
	
	@GetMapping("/mensagem/de/ja/cadastrado/login")
	public String mensagemDePerfilJaCadastradoLogin(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "JÁ Cadastrado");
		model.addAttribute("mensagem", "Este Login já está sendo usado. Tente outro.");
		
		return "/alertas/jaTemPerfilNaUnidade";
	}
	
	
	@GetMapping("/mensagem/de/ja/cadastrado")
	public String mensagemDePerfilJaCadastrado(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "JÁ Cadastrado");
		model.addAttribute("mensagem", "Este Operador já está cadastrado.");
		
		return "/alertas/jaTemPerfilNaUnidade";
	}
	
	@GetMapping("/mensagem/de/dados/incompletos")
	public String mensagemDeNaoEscolha(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "Dados Inconsistentes");
		model.addAttribute("mensagem", "Tanto Usuário quanto Senha devem conter pelo menos três caracteres.");
		
		return "/choqueescala/usuarioESenha";
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
