package com.folha.boot.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.folha.boot.domain.EnderecoCorreios;
import com.folha.boot.domain.Enderecos;
import com.folha.boot.domain.TiposLogradouro;
import com.folha.boot.service.CidadesService;
import com.folha.boot.service.EnderecosServices;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.TiposLogradouroService;

@Controller
@RequestMapping("/enderecos")
public class EnderecosController {

	Long idPessoaAtual;
	Enderecos enderecos = new Enderecos();
	
	@Autowired
	private EnderecosServices enderecosServices;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private CidadesService cidadesService;
	
	@Autowired
	private TiposLogradouroService tiposLogradouroService;

	@GetMapping("/cadastrar")
	public String cadastrar(Enderecos endereco) {
		
		return "/endereco/cadastro";
	}
	
	@GetMapping("/cadastrar/{id}")
	public String cadastrarComPessoa(@PathVariable("id") Long id, ModelMap model, Enderecos enderecos) {	
		idPessoaAtual = id;
		
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("enderecos", this.enderecos);
		model.addAttribute("pessoaDocumentosLista7", enderecosServices.buscarPorPessoa(pessoaService.buscarPorId(id)));
		
		return "/endereco/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("enderecos", enderecosServices.buscarTodos());
		return "/endereco/lista"; 
	}
	
	@GetMapping("/listar/endereco/viacep")
	public String listarEnderecoViaCep(ModelMap model, Enderecos enderecos) {
		if(enderecos!=null) {
			if(enderecos.getEnderecoCep().length()==8) {
				enderecos = this.obterEndereco(enderecos.getEnderecoCep());
				this.enderecos = enderecos;
				enderecos.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
				model.addAttribute("enderecos", enderecos);
			}
		}
		return  "redirect:/enderecos/cadastrar/"+idPessoaAtual+"";
	}
	
	@PostMapping("/salvar/endereco")
	public String salvarConselho(Enderecos enderecos, RedirectAttributes attr) {
		enderecos.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		enderecos.setEnderecoCep(enderecos.getEnderecoCep().replace("-", ""));
		enderecosServices.salvar(enderecos);
		this.enderecos.setEnderecoBairro("");
		this.enderecos.setEnderecoCep("");
		this.enderecos.setEnderecoComplemento("");
		this.enderecos.setEnderecoLogradouro("");
		this.enderecos.setEnderecoNumero("");
		this.enderecos.setIdEnderecoCidadeFk(cidadesService.buscarPorNome("MACEIO").get(0));
		this.enderecos.setIdTipoLogradouroFk(tiposLogradouroService.buscarPorNomeExato("RUA").get(0));
	
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/enderecos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/avancar")
	public String avancar() {
		return "redirect:/filhos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/retroceder")
	public String retroceder() {
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@PostMapping("/salvar")
	public String salvar(Enderecos endereco, RedirectAttributes attr) {
		
		enderecosServices.salvar(endereco);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/enderecos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", pessoaService.buscarPorId(idPessoaAtual));
		model.addAttribute("enderecos", enderecosServices.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista7", enderecosServices.buscarPorPessoa(pessoaService.buscarPorId(idPessoaAtual)));
		return "/endereco/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Enderecos endereco, RedirectAttributes attr) {
		enderecosServices.editar(endereco);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/enderecos/listar";
	}
	
	@GetMapping("/excluir/endereco/{id}")
	public String excluirEndereco(@PathVariable("id") Long id, ModelMap model) {
		enderecosServices.excluir(id);  
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista7", enderecosServices.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/enderecos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		enderecosServices.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}

	@GetMapping("/buscar/endereco/logradouro")
	public String getPorNome(@RequestParam("enderecoLogradouro") String enderecoLogradouro, ModelMap model) {		
		model.addAttribute("enderecos", enderecosServices.buscarPorNome(enderecoLogradouro.toUpperCase().trim()));
		return "/endereco/lista";
	}

	
	@ModelAttribute("idEnderecoCidadeFk")
	public List<Cidades> getCidadesEndereco() {
		return cidadesService.buscarTodos();
	}
	
	@ModelAttribute("idTipoLogradouroFk")
	public List<TiposLogradouro> getTiposLogradouro() {
		return tiposLogradouroService.buscarTodos();
	}
	
	
	
	// buscando endereco por cep
	public Enderecos obterEndereco(String cepBusca) {
		ControladorCEPBean c = new ControladorCEPBean();
		c.setCep(cepBusca);
		Enderecos enderecos = new Enderecos();
		EnderecoCorreios endereco = c.carregarEndereco();
		
		List<Cidades> listaDeCidades =  cidadesService.buscarPorNome(endereco.getLocalidade());
		List<TiposLogradouro> listaTiposLogradouro =  tiposLogradouroService.buscarPorNomeExato(endereco.getTipoLogradouro());
		
		for(int i=0;i<listaDeCidades.size();i++) {
			if(listaDeCidades.get(i).getIdUfFk().getSiglaUf().equalsIgnoreCase(endereco.getUf())) {
				enderecos.setIdEnderecoCidadeFk(listaDeCidades.get(i));
			}			
		}
		
		if(!listaTiposLogradouro.isEmpty()){
			enderecos.setIdTipoLogradouroFk(listaTiposLogradouro.get(0));
		}
		
		enderecos.setEnderecoBairro(endereco.getBairro());
		enderecos.setEnderecoLogradouro(endereco.getLogradouro());
		enderecos.setEnderecoCep(endereco.getCep());
		enderecos.setEnderecoComplemento("");
		enderecos.setEnderecoNumero("");
	
		return enderecos;
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
