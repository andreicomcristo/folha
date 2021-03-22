package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "faixas_imposto_de_renda_nome")
public class FaixasImpostoDeRendaNome extends AbstractEntity<Long> {

	@Column(name = "nome_faixa")
	private String nomeFaixa;
	
	@OneToMany(mappedBy = "idFaixasImpostoDeRendaNomeFk")
	private List<FaixasImpostoDeRenda> faixasImpostoDeRendaList;

	public String getNomeFaixa() {
		return nomeFaixa;
	}

	public void setNomeFaixa(String nomeFaixa) {
		this.nomeFaixa = nomeFaixa;
	}

	public List<FaixasImpostoDeRenda> getFaixasImpostoDeRendaList() {
		return faixasImpostoDeRendaList;
	}

	public void setFaixasImpostoDeRendaList(List<FaixasImpostoDeRenda> faixasImpostoDeRendaList) {
		this.faixasImpostoDeRendaList = faixasImpostoDeRendaList;
	}

}
