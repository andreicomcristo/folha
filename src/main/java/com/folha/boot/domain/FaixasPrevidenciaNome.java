package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "faixas_previdencia_nome")
public class FaixasPrevidenciaNome extends AbstractEntity<Long> {

	@Column(name = "nome_faixa")
	private String nomeFaixa;
	@OneToMany(mappedBy = "idFaixasPrevidenciaNomeFk")
	private List<FaixasPrevidencia> faixasPrevidenciaList;
	
	public String getNomeFaixa() {
		return nomeFaixa;
	}
	public void setNomeFaixa(String nomeFaixa) {
		this.nomeFaixa = nomeFaixa;
	}
	public List<FaixasPrevidencia> getFaixasPrevidenciaList() {
		return faixasPrevidenciaList;
	}
	public void setFaixasPrevidenciaList(List<FaixasPrevidencia> faixasPrevidenciaList) {
		this.faixasPrevidenciaList = faixasPrevidenciaList;
	}
	
}
