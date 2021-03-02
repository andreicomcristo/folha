package com.folha.boot.domain;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_documentos_reservista")
public class PessoaDocumentosReservista extends AbstractEntity<Long> {

	private String numero;

	private String serie;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa_fk", insertable = false, updatable = false)
	private Pessoa pessoa;

	public PessoaDocumentosReservista() {
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


}
