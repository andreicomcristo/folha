package com.folha.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_documentos")
public class PessoaDocumentos extends AbstractEntity<Long> {

	@Column(name="numero_documento")
	private String numeroDocumento;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa_fk", insertable = false, updatable = false)
	private Pessoa pessoa1;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa_fk", insertable = false, updatable = false)
	private Pessoa pessoa2;

	//bi-directional many-to-one association to TiposDeDocumento
	@ManyToOne
	@JoinColumn(name="id_tipos_de_documento_fk" ,insertable = false, updatable = false)
	private TiposDeDocumento tiposDeDocumento;

	public PessoaDocumentos() {
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Pessoa getPessoa1() {
		return this.pessoa1;
	}

	public void setPessoa1(Pessoa pessoa1) {
		this.pessoa1 = pessoa1;
	}

	public Pessoa getPessoa2() {
		return this.pessoa2;
	}

	public void setPessoa2(Pessoa pessoa2) {
		this.pessoa2 = pessoa2;
	}

	public TiposDeDocumento getTiposDeDocumento() {
		return this.tiposDeDocumento;
	}

	public void setTiposDeDocumento(TiposDeDocumento tiposDeDocumento) {
		this.tiposDeDocumento = tiposDeDocumento;
	}

}
