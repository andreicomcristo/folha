package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipos_de_documento")
public class TiposDeDocumento extends AbstractEntity<Long> {

	@Column(name="nome_documento")
	private String nomeDocumento;

	@Column(name="sigla_documento")
	private String siglaDocumento;

	//bi-directional many-to-one association to PessoaDocumento
	@OneToMany(mappedBy="tiposDeDocumento")
	private List<PessoaDocumentos> pessoaDocumentos;

	public TiposDeDocumento() {
	}

	public String getNomeDocumento() {
		return this.nomeDocumento;
	}

	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

	public String getSiglaDocumento() {
		return this.siglaDocumento;
	}

	public void setSiglaDocumento(String siglaDocumento) {
		this.siglaDocumento = siglaDocumento;
	}

	public List<PessoaDocumentos> getPessoaDocumentos() {
		return this.pessoaDocumentos;
	}

	public void setPessoaDocumentos(List<PessoaDocumentos> pessoaDocumentos) {
		this.pessoaDocumentos = pessoaDocumentos;
	}

	public PessoaDocumentos addPessoaDocumento(PessoaDocumentos pessoaDocumento) {
		getPessoaDocumentos().add(pessoaDocumento);
		pessoaDocumento.setTiposDeDocumento(this);

		return pessoaDocumento;
	}

	public PessoaDocumentos removePessoaDocumento(PessoaDocumentos pessoaDocumento) {
		getPessoaDocumentos().remove(pessoaDocumento);
		pessoaDocumento.setTiposDeDocumento(null);

		return pessoaDocumento;
	}

}
