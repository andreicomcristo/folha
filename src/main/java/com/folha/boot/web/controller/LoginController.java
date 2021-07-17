package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.folha.boot.domain.Unidades;
import com.folha.boot.service.UnidadesService;

@Controller
public class LoginController {
 
	@Autowired
	UnidadesService unidadesService;
	
	@GetMapping
	@RequestMapping("/login")  
	public String login(@AuthenticationPrincipal User user, Unidades unidades , ModelMap model) {
		
		if(user!=null) {
			return "redirect:/home";
		}
		
		model.addAttribute("unidades", unidadesService.buscarPorNome(""));
		return "login";
	}
	
	
	@GetMapping
	@RequestMapping("/logout")  
	public String logout() {
		return "logout";
	}
	
	
	
	@RequestMapping("/acesso-negado")
	public String acessoNegado(ModelMap model) {
		
		model.addAttribute("atencao", "");
		model.addAttribute("choque", "ACESSO NÃO PERMITIDO");
		model.addAttribute("mensagem", "Desculpe, você não está autorizado a acessar a página que solicitou. Se você acha que isso é um engano, entre em contato conosco.");
		return "/acessoNegado/acessoNegado";
	}
	
	
	
	
}
