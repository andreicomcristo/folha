package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	
}
