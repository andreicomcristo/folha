package com.folha.boot.web.controller;

import java.util.List;

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
import com.folha.boot.domain.Conselhos;
import com.folha.boot.domain.EnderecoCorreios;
import com.folha.boot.domain.Enderecos;
import com.folha.boot.domain.HabilitacaoCategorias;
import com.folha.boot.domain.PessoaDocumentosConselho;
import com.folha.boot.domain.PessoaDocumentosCtps;
import com.folha.boot.domain.PessoaDocumentosHabilitacao;
import com.folha.boot.domain.PessoaDocumentosReservista;
import com.folha.boot.domain.PessoaDocumentosRg;
import com.folha.boot.domain.PessoaDocumentosTitulo;
import com.folha.boot.domain.TiposLogradouro;
import com.folha.boot.domain.Uf;
import com.folha.boot.service.CidadesService;
import com.folha.boot.service.ConselhosServices;
import com.folha.boot.service.EnderecosServices;
import com.folha.boot.service.HabilitacaoCategoriasService;
import com.folha.boot.service.PessoaDocumentosConselhoService;
import com.folha.boot.service.PessoaDocumentosCtpsService;
import com.folha.boot.service.PessoaDocumentosHabilitacaoService;
import com.folha.boot.service.PessoaDocumentosReservistaService;
import com.folha.boot.service.PessoaDocumentosRgService;
import com.folha.boot.service.PessoaDocumentosTituloService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.TiposLogradouroService;
import com.folha.boot.service.UfService;


@Controller
@RequestMapping("/ctpsdocs")
public class PessoaDocumentosCtpsController {
	
	Long idPessoaAtual;
	Enderecos enderecos = new Enderecos();
	
	@Autowired
	private PessoaDocumentosCtpsService service;
	
	@Autowired
	private CidadesService cidadesService;
	
	@Autowired
	private EnderecosServices enderecosServices;
	
	@Autowired
	private TiposLogradouroService tiposLogradouroService;

	
	@Autowired
	private PessoaDocumentosHabilitacaoService pessoaDocumentosHabilitacaoService;
	
	@Autowired
	private PessoaDocumentosReservistaService pessoaDocumentosReservistaService;
	
	@Autowired
	private PessoaDocumentosConselhoService pessoaDocumentosConselhoService;
	
	@Autowired
	private PessoaDocumentosRgService pessoaDocumentosRgService;
	
	@Autowired
	private PessoaDocumentosTituloService pessoaDocumentosTituloService;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	HabilitacaoCategoriasService habilitacaoCategoriasService;
	
	@Autowired
	UfService ufService;
	
	@Autowired
	ConselhosServices conselhosServices;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaDocumentosCtps ctps) {		
		return "/docctps/cadastro";
	}
	
	@GetMapping("/cadastrar/{id}")
	public String cadastrarComPessoa(@PathVariable("id") Long id, ModelMap model, PessoaDocumentosCtps pessoaDocumentos, PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao, PessoaDocumentosReservista pessoaDocumentosReservista, PessoaDocumentosConselho pessoaDocumentosConselho, PessoaDocumentosRg pessoaDocumentosRg, PessoaDocumentosTitulo pessoaDocumentosTitulo, Enderecos enderecos) {	
		idPessoaAtual = id;
		
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("enderecos", this.enderecos);
		model.addAttribute("pessoaDocumentosLista1", service.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("pessoaDocumentosLista2", pessoaDocumentosHabilitacaoService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("pessoaDocumentosLista3", pessoaDocumentosReservistaService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("pessoaDocumentosLista4", pessoaDocumentosConselhoService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("pessoaDocumentosLista5", pessoaDocumentosRgService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("pessoaDocumentosLista6", pessoaDocumentosTituloService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("pessoaDocumentosLista7", enderecosServices.buscarPorPessoa(pessoaService.buscarPorId(id)));
		
		return "/docctps/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaDocumentosCtps", service.buscarTodos());
		return "/docctps/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaDocumentosCtps documento, RedirectAttributes attr) {
		
		documento.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		service.salvar(documento);
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@PostMapping("/salvar/habilitacao")
	public String salvarHabilitacao(PessoaDocumentosHabilitacao habilitacao, RedirectAttributes attr) {
		
		habilitacao.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		pessoaDocumentosHabilitacaoService.salvar(habilitacao);
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@PostMapping("/salvar/reservista")
	public String salvarReservista(PessoaDocumentosReservista reservista, RedirectAttributes attr) {
		
		reservista.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		pessoaDocumentosReservistaService.salvar(reservista);
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@PostMapping("/salvar/rg")
	public String salvarReservista(PessoaDocumentosRg rg, RedirectAttributes attr) {
		
		rg.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		pessoaDocumentosRgService.salvar(rg);
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@PostMapping("/salvar/titulo")
	public String salvarReservista(PessoaDocumentosTitulo titulo, RedirectAttributes attr) {
		
		titulo.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		pessoaDocumentosTituloService.salvar(titulo);
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@PostMapping("/salvar/conselho")
	public String salvarConselho(PessoaDocumentosConselho conselho, RedirectAttributes attr) {
		
		conselho.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		pessoaDocumentosConselhoService.salvar(conselho);
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
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
		return  "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
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
		this.enderecos.setIdTipoLogradouroFk(tiposLogradouroService.buscarPorNome("RUA").get(0));
	
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/avancar")
	public String avancar() {
		return "redirect:/enderecos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/retroceder")
	public String retroceder() {
		return "redirect:/documentos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaDocumentosCtps", service.buscarPorId(id));
		return "/docctps/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaDocumentosCtps ctps, RedirectAttributes attr) {
		service.editar(ctps);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/ctpsdocs/listar";
	}
	
	@GetMapping("/excluir/ctps/{id}")
	public String excluirCtps(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista1", service.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/excluir/reservista/{id}")
	public String excluirReservista(@PathVariable("id") Long id, ModelMap model) {
		pessoaDocumentosReservistaService.excluir(id);  
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista3", pessoaDocumentosReservistaService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/excluir/habilitacao/{id}")
	public String excluirHabilitacao(@PathVariable("id") Long id, ModelMap model) {
		pessoaDocumentosHabilitacaoService.excluir(id);  
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista2", pessoaDocumentosHabilitacaoService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/excluir/conselho/{id}")
	public String excluirConselho(@PathVariable("id") Long id, ModelMap model) {
		pessoaDocumentosConselhoService.excluir(id);  
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista4", pessoaDocumentosConselhoService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/excluir/rg/{id}")
	public String excluirRg(@PathVariable("id") Long id, ModelMap model) {
		pessoaDocumentosRgService.excluir(id);  
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista5", pessoaDocumentosRgService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}

	@GetMapping("/excluir/titulo/{id}")
	public String excluirTitulo(@PathVariable("id") Long id, ModelMap model) {
		pessoaDocumentosTituloService.excluir(id);  
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista6", pessoaDocumentosTituloService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/excluir/endereco/{id}")
	public String excluirEndereco(@PathVariable("id") Long id, ModelMap model) {
		enderecosServices.excluir(id);  
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista7", enderecosServices.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/buscar/numero/documento/ctps")
	public String getPorNome(@RequestParam("numero") String numero, ModelMap model) {		
		model.addAttribute("pessoaDocumentosCtps", service.buscarPorNumero(numero.toUpperCase().trim()));
		return "/docctps/lista";
	}
	
	@ModelAttribute("idHabilitacaoCategoriasFk")
	public List<HabilitacaoCategorias> getHabilitacaoCategorias() {
		return habilitacaoCategoriasService.buscarTodos();
	}
	
	@ModelAttribute("idUfFk")
	public List<Uf> getUfs() {
		return ufService.buscarTodos();
	}
	
	@ModelAttribute("idUfEmissao")
	public List<Uf> getUfsEmissao() {
		return ufService.buscarTodos();
	}
	
	@ModelAttribute("idConselhosFk")
	public List<Conselhos> getConselhos() {
		return conselhosServices.buscarTodos();
	}
	
	@ModelAttribute("idCidadeFk")
	public List<Cidades> getCidades() {
		return cidadesService.buscarTodos();
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
	
	
}
