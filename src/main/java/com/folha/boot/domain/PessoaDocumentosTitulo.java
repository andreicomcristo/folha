package com.folha.boot.domain;

import javax.persistence.*;
@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_documentos_titulo")
public class PessoaDocumentosTitulo extends AbstractEntity<Long> {

	@Column(name="numero_titulo")
	private String numeroTitulo;

	private String secao;

	private String zona;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="id_cidade_fk", insertable = false, updatable = false)
	private Cidades cidade;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa_fk", insertable = false, updatable = false)
	private Pessoa pessoa;

	public PessoaDocumentosTitulo() {
	}

	public String getNumeroTitulo() {
		return this.numeroTitulo;
	}

	public void setNumeroTitulo(String numeroTitulo) {
		this.numeroTitulo = numeroTitulo;
	}

	public String getSecao() {
		return this.secao;
	}

	public void setSecao(String secao) {
		this.secao = secao;
	}

	public String getZona() {
		return this.zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public Cidades getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidades cidade) {
		this.cidade = cidade;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
