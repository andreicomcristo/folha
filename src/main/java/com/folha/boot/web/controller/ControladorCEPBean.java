package com.folha.boot.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Enderecos;
import com.folha.boot.domain.endereco.Endereco;
import com.folha.boot.service.CidadesService;
import com.folha.boot.service.endereco.EnderecoService;
import com.folha.boot.service.util.UtilidadesDeTexto;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;


@Controller
@ManagedBean(value ="CEPBean")
@SessionScope
public class ControladorCEPBean implements Serializable {


	private static final long serialVersionUID = -4818919924660193639L;
	
	private List<Endereco> listagem = new ArrayList<Endereco>();
	
	private Endereco endereco;
	
	private String cep;

	private EnderecoService servico = new EnderecoService();
	
	public Endereco carregarEndereco() {
		endereco = new Endereco();
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

	public List<Endereco> getListagem() {
		return listagem;
	}

	public void setListagem(List<Endereco> listagem) {
		this.listagem = listagem;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void limpar() {
		this.endereco = new Endereco();
	}

}
