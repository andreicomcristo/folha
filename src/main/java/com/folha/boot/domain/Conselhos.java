package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "conselhos")
public class Conselhos extends AbstractEntity<Long> {

	@Column(name="descricao_conselho")
	private String descricaoConselho;

	@Column(name="nome_conselho")
	private String nomeConselho;

	//bi-directional many-to-one association to PessoaDocumentosConselho
	@OneToMany(mappedBy="conselho")
	private List<PessoaDocumentosConselho> pessoaDocumentosConselhos;

	public Conselhos() {
	}

	public String getDescricaoConselho() {
		return this.descricaoConselho;
	}

	public void setDescricaoConselho(String descricaoConselho) {
		this.descricaoConselho = descricaoConselho;
	}

	public String getNomeConselho() {
		return this.nomeConselho;
	}

	public void setNomeConselho(String nomeConselho) {
		this.nomeConselho = nomeConselho;
	}

	public List<PessoaDocumentosConselho> getPessoaDocumentosConselhos() {
		return this.pessoaDocumentosConselhos;
	}

	public void setPessoaDocumentosConselhos(List<PessoaDocumentosConselho> pessoaDocumentosConselhos) {
		this.pessoaDocumentosConselhos = pessoaDocumentosConselhos;
	}

	public PessoaDocumentosConselho addPessoaDocumentosConselho(PessoaDocumentosConselho pessoaDocumentosConselho) {
		getPessoaDocumentosConselhos().add(pessoaDocumentosConselho);
		pessoaDocumentosConselho.setConselho(this);

		return pessoaDocumentosConselho;
	}

	public PessoaDocumentosConselho removePessoaDocumentosConselho(PessoaDocumentosConselho pessoaDocumentosConselho) {
		getPessoaDocumentosConselhos().remove(pessoaDocumentosConselho);
		pessoaDocumentosConselho.setConselho(null);

		return pessoaDocumentosConselho;
	}

}
