package com.folha.boot.web.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



@Controller
public class HomeController {

	
	/*
	@GetMapping("/")
	public String home(ModelMap model, HttpServletRequest request) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		model.addAttribute("usuario", username);
		model.addAttribute("unidadeLogada", request.getSession().getAttribute("unidade"));
		
		return "/home";
	}
	*/
	@GetMapping("/home")
	public String homeSpringSecurity(ModelMap model, HttpServletRequest request) {
		
		model.addAttribute("nomeOperadorLogado", request.getSession().getAttribute("operador"));
		model.addAttribute("nomeUnidadeLogada", request.getSession().getAttribute("unidade").toString());
		
		return "/home";
	}
	
	@GetMapping("/")
	public String home(ModelMap model, HttpServletRequest request) {
		
		model.addAttribute("nomeOperadorLogado", request.getSession().getAttribute("operador"));
		model.addAttribute("nomeUnidadeLogada", request.getSession().getAttribute("unidade").toString());
		
		return "/home";
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
