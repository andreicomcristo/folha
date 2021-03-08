package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "escolaridades")
public class Escolaridades extends AbstractEntity<Long> {

	@Column(name = "nome_escolaridade", nullable = false, length = 100)
	private String nomeEscolaridade;

	@Column(name = "descricao_escolaridade", length = 300)
	private String descricaoEscolaridade;

	@OneToMany(mappedBy = "idEscolaridadeFk")
	private List<Pessoa> pessoaList;
	
	public String getNomeEscolaridade() {
		return nomeEscolaridade;
	}

	public void setNomeEscolaridade(String nomeEscolaridade) {
		this.nomeEscolaridade = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeEscolaridade);
	}

	public String getDescricaoEscolaridade() {
		return descricaoEscolaridade;
	}

	public void setDescricaoEscolaridade(String descricaoEscolaridade) {
		this.descricaoEscolaridade = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoEscolaridade);
	}

	public List<Pessoa> getPessoaList() {
		return pessoaList;
	}

	public void setPessoaList(List<Pessoa> pessoaList) {
		this.pessoaList = pessoaList;
	}

}
