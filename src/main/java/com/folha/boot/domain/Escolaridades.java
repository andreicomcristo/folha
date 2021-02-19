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

	@OneToMany(mappedBy = "seqEscolaridade")
	private List<Pessoa> pessoaCollection;

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

	public List<Pessoa> getPessoaCollection() {
		return pessoaCollection;
	}

	public void setPessoaCollection(List<Pessoa> pessoaCollection) {
		this.pessoaCollection = pessoaCollection;
	}
	
}
