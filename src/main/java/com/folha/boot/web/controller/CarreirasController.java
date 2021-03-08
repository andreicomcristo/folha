package com.folha.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.Carreiras;
import com.folha.boot.domain.Doc;
import com.folha.boot.service.CarreirasService;
import com.folha.boot.service.DocStorageService;

@Controller
@RequestMapping("/carreiras")
public class CarreirasController {

	@Autowired 
	private DocStorageService docStorageService;
	@Autowired
	private CarreirasService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Carreiras carreira, ModelMap model) {
		List<Doc> docs = docStorageService.getFiles();
		model.addAttribute("docs", docs);
		return "/carreira/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("carreiras", service.buscarTodos());
		return "/carreira/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Carreiras carreira, RedirectAttributes attr) {				
		service.salvar(carreira);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/carreiras/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("carreiras", service.buscarPorId(id));
		return "/carreira/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Carreiras carreiras, RedirectAttributes attr) {
		service.editar(carreiras);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/carreiras/listar";
	}
	
	@GetMapping("/excluir/{id}") 
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id); 
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model); 
	}
	
	@GetMapping("/buscar/nome/carreira")
	public String getPorNome(@RequestParam("nomeCarreira") String nomeCarreira, ModelMap model) {		
		model.addAttribute("carreiras", service.buscarPorNome(nomeCarreira.toUpperCase().trim()));
		return "/carreira/lista";
	}
		
	@PostMapping("/uploadFiles")
	public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		for (MultipartFile file: files) {
			docStorageService.saveFile(file);
			
		}
		return "redirect:/carreiras/cadastrar";
	}

	@GetMapping("/downloadFile/{Id}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long Id){
		Doc doc = docStorageService.getFile(Id).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocName()+"\"")
				.body(new ByteArrayResource(doc.getData()));
	}
	
}
