package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "uf")
public class Uf extends AbstractEntity<Long> {

	@Column(name="nome_uf")
	private String nomeUf;

	@Column(name="sigla_uf")
	private String siglaUf;

	//bi-directional many-to-one association to Cidade
	@OneToMany(mappedBy="uf")
	private List<Cidades> cidades;

	//bi-directional many-to-one association to PessoaDocumentosConselho
	@OneToMany(mappedBy="uf")
	private List<PessoaDocumentosConselho> pessoaDocumentosConselhos;

	//bi-directional many-to-one association to PessoaDocumentosRg
	@OneToMany(mappedBy="uf")
	private List<PessoaDocumentosRg> pessoaDocumentosRgs;

	public Uf() {
	}

	public String getNomeUf() {
		return this.nomeUf;
	}

	public void setNomeUf(String nomeUf) {
		this.nomeUf = nomeUf;
	}

	public String getSiglaUf() {
		return this.siglaUf;
	}

	public void setSiglaUf(String siglaUf) {
		this.siglaUf = siglaUf;
	}

	public List<Cidades> getCidades() {
		return this.cidades;
	}

	public void setCidades(List<Cidades> cidades) {
		this.cidades = cidades;
	}

	public Cidades addCidade(Cidades cidade) {
		getCidades().add(cidade);
		cidade.setIdUfFk(this);

		return cidade;
	}

	public Cidades removeCidade(Cidades cidade) {
		getCidades().remove(cidade);
		cidade.setIdUfFk(null);

		return cidade;
	}

	public List<PessoaDocumentosConselho> getPessoaDocumentosConselhos() {
		return this.pessoaDocumentosConselhos;
	}

	public void setPessoaDocumentosConselhos(List<PessoaDocumentosConselho> pessoaDocumentosConselhos) {
		this.pessoaDocumentosConselhos = pessoaDocumentosConselhos;
	}

	public PessoaDocumentosConselho addPessoaDocumentosConselho(PessoaDocumentosConselho pessoaDocumentosConselho) {
		getPessoaDocumentosConselhos().add(pessoaDocumentosConselho);
		pessoaDocumentosConselho.setUf(this);

		return pessoaDocumentosConselho;
	}

	public PessoaDocumentosConselho removePessoaDocumentosConselho(PessoaDocumentosConselho pessoaDocumentosConselho) {
		getPessoaDocumentosConselhos().remove(pessoaDocumentosConselho);
		pessoaDocumentosConselho.setUf(null);

		return pessoaDocumentosConselho;
	}

	public List<PessoaDocumentosRg> getPessoaDocumentosRgs() {
		return this.pessoaDocumentosRgs;
	}

	public void setPessoaDocumentosRgs(List<PessoaDocumentosRg> pessoaDocumentosRgs) {
		this.pessoaDocumentosRgs = pessoaDocumentosRgs;
	}

	public PessoaDocumentosRg addPessoaDocumentosRg(PessoaDocumentosRg pessoaDocumentosRg) {
		getPessoaDocumentosRgs().add(pessoaDocumentosRg);
		pessoaDocumentosRg.setUf(this);

		return pessoaDocumentosRg;
	}

	public PessoaDocumentosRg removePessoaDocumentosRg(PessoaDocumentosRg pessoaDocumentosRg) {
		getPessoaDocumentosRgs().remove(pessoaDocumentosRg);
		pessoaDocumentosRg.setUf(null);

		return pessoaDocumentosRg;
	}
}
