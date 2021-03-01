package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String login(Unidades unidades , ModelMap model) {
		model.addAttribute("unidades", unidadesService.buscarPorNome(""));
		return "login";
	}
}
