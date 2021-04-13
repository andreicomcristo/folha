package com.folha.boot.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.UnidadesService;

@Controller
@RequestMapping("/operadores")
public class PessoaOperadoresController {
	
	Long idUnidadeLogada = 1l;
	Long idOperadorLogado = 1l;
	
	@Autowired
	private PessoaOperadoresService service;
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private UnidadesService unidadesService;

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
		return "redirect:/operadores/editar/"+operador.getId();
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(PessoaOperadores operadores) {		
		return "/operador/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaOperadores", service.buscarTodos());
		return "/operador/lista"; 
	}
		
	@PostMapping("/salvar")
	public String salvar(PessoaOperadores operadores, RedirectAttributes attr) {		
		boolean acaoValida = true;
		
		if(operadores.getUsername().length()<3 || operadores.getPassword().length()<3) {
			return "redirect:/operadores/mensagem/de/dados/incompletos";
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		operadores.setPassword(encoder.encode(operadores.getPassword()));
		operadores.setIdOperadorCadastroFk(service.buscarPorId(idOperadorLogado));
		operadores.setDtCadastro(new Date());
		if(operadores.getEnabled()==null) {operadores.setEnabled(true);}
		
		if(acaoValida==true) {
			service.salvar(operadores);
		}
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/operadores/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model, RedirectAttributes attr) {
		attr.addFlashAttribute("fail", "Operador já cadastrado. Talvez você deseje editar.");
		model.addAttribute("pessoaOperadores", service.buscarPorId(id));
		return "/operador/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaOperadores operadores, RedirectAttributes attr) {
		service.editar(operadores);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/operadores/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/mensagem/de/dados/incompletos")
	public String mensagemDeNaoEscolha(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "Dados Inconsistentes");
		model.addAttribute("mensagem", "Tanto Usuário quanto Senha devem conter pelo menos três caracteres.");
		
		return "/choqueescala/usuarioESenha";
	}

}
