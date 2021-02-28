package com.folha.boot.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(ModelMap model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("usuario", username);
		return "/home";
	}
}
