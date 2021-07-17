package com.folha.boot.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.annotation.SessionScope;

import com.folha.boot.domain.EnderecoCorreios;
import com.folha.boot.service.EnderecoCorreiosService;
import com.folha.boot.service.util.UtilidadesDeTexto;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;


@Controller
@ManagedBean(value ="CEPBean")
@SessionScope
public class ControladorCEPBean implements Serializable {


	private static final long serialVersionUID = -4818919924660193639L;
	
	private List<EnderecoCorreios> listagem = new ArrayList<EnderecoCorreios>();
	
	private EnderecoCorreios endereco;
	
	private String cep;

	private EnderecoCorreiosService servico = new EnderecoCorreiosService();
	
	public EnderecoCorreios carregarEndereco() {
		endereco = new EnderecoCorreios();
		Client c = Client.create();
		WebResource wr = c.resource("http://viacep.com.br/ws/" + this.getCep() + "/json/");
		System.out.println("CHAMOU O URI....");
		this.endereco = servico.buscarEnderecoPor(wr.get(String.class));
		String JSON = wr.get(String.class);
		
		if(this.getEndereco().getBairro()!=null){ this.getEndereco().setBairro(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(this.getEndereco().getBairro()));  }
		if(this.getEndereco().getLocalidade()!=null){ this.getEndereco().setLocalidade(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(this.getEndereco().getLocalidade()));}
		if(this.getEndereco().getLogradouro()!=null){ this.getEndereco().setLogradouro(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(this.getEndereco().getLogradouro()));}
		if(this.getEndereco().getComplemento()!=null){ this.getEndereco().setComplemento(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(this.getEndereco().getComplemento()));}
		if(this.getEndereco().getGia()!=null){ this.getEndereco().setGia(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(this.getEndereco().getGia()));}
		if(this.getEndereco().getIbge()!=null){ this.getEndereco().setIbge(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(this.getEndereco().getIbge()));}
		if(this.getEndereco().getNumero()!=null){ this.getEndereco().setNumero(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(this.getEndereco().getNumero()));}
		if(this.getEndereco().getUf()!=null){ this.getEndereco().setUf(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(this.getEndereco().getUf()));}
		if(this.getEndereco().getUnidade()!=null){ this.getEndereco().setUnidade(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(this.getEndereco().getUnidade()));}
		if(this.getEndereco().getTipoLogradouro()!=null){ this.getEndereco().setTipoLogradouro(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(this.getEndereco().getTipoLogradouro()));}
		
		if(this.getEndereco().getLogradouro()!=null) {
			if((this.getEndereco().getLogradouro().length()>0)) {
				for(int i=0;i<this.getEndereco().getLogradouro().length();i++){
					if(this.getEndereco().getLogradouro().substring(i, (i+1)).equalsIgnoreCase(" ")) {
						this.getEndereco().setTipoLogradouro(this.getEndereco().getLogradouro().substring(0, (i)));
						this.getEndereco().setLogradouro(this.getEndereco().getLogradouro().substring((i+1), this.getEndereco().getLogradouro().length()  ));
						break;
					}
				}
			}
		}
		return this.getEndereco();
	}

	public List<EnderecoCorreios> getListagem() {
		return listagem;
	}

	public void setListagem(List<EnderecoCorreios> listagem) {
		this.listagem = listagem;
	}

	public EnderecoCorreios getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoCorreios endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void limpar() {
		this.endereco = new EnderecoCorreios();
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
