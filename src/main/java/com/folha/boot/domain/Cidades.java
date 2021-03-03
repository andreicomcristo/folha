package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "cidades")
public class Cidades extends AbstractEntity<Long> {

	@Column(name="nome_cidade")
	private String nomeCidade;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="id_pais_fk", insertable = false, updatable = false)
	private Paises pais;

	//bi-directional many-to-one association to Uf
	@ManyToOne
	@JoinColumn(name = "id_uf_fk", referencedColumnName = "id")
	private Uf idUfFk;;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="cidade")
	private List<Enderecos> enderecos;

	//bi-directional many-to-one association to Pessoa
	@OneToMany(mappedBy="cidade")
	private List<Pessoa> pessoas;

	//bi-directional many-to-one association to PessoaDocumentosTitulo
	@OneToMany(mappedBy="cidade")
	private List<PessoaDocumentosTitulo> pessoaDocumentosTitulos;

	//bi-directional many-to-one association to Unidade
	@OneToMany(mappedBy="cidade")
	private List<Unidades> unidades;

	public Cidades() {
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public Paises getPais() {
		return pais;
	}

	public void setPais(Paises pais) {
		this.pais = pais;
	}


	public Uf getIdUfFk() {
		return idUfFk;
	}

	public void setIdUfFk(Uf idUfFk) {
		this.idUfFk = idUfFk;
	}

	public List<Enderecos> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Enderecos> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<PessoaDocumentosTitulo> getPessoaDocumentosTitulos() {
		return pessoaDocumentosTitulos;
	}

	public void setPessoaDocumentosTitulos(List<PessoaDocumentosTitulo> pessoaDocumentosTitulos) {
		this.pessoaDocumentosTitulos = pessoaDocumentosTitulos;
	}

	public List<Unidades> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidades> unidades) {
		this.unidades = unidades;
	}

	public Enderecos addEndereco(Enderecos endereco) {
		getEnderecos().add(endereco);
		endereco.setCidade(this);

		return endereco;
	}

	public Enderecos removeEndereco(Enderecos endereco) {
		getEnderecos().remove(endereco);
		endereco.setCidade(null);

		return endereco;
	}

	public Pessoa addPessoa(Pessoa pessoa) {
		getPessoas().add(pessoa);
		pessoa.setCidade(this);

		return pessoa;
	}

	public Pessoa removePessoa(Pessoa pessoa) {
		getPessoas().remove(pessoa);
		pessoa.setCidade(null);

		return pessoa;
	}

	public PessoaDocumentosTitulo addPessoaDocumentosTitulo(PessoaDocumentosTitulo pessoaDocumentosTitulo) {
		getPessoaDocumentosTitulos().add(pessoaDocumentosTitulo);
		pessoaDocumentosTitulo.setCidade(this);

		return pessoaDocumentosTitulo;
	}

	public PessoaDocumentosTitulo removePessoaDocumentosTitulo(PessoaDocumentosTitulo pessoaDocumentosTitulo) {
		getPessoaDocumentosTitulos().remove(pessoaDocumentosTitulo);
		pessoaDocumentosTitulo.setCidade(null);

		return pessoaDocumentosTitulo;
	}

	public Unidades addUnidade(Unidades unidade) {
		getUnidades().add(unidade);
		unidade.setCidade(this);

		return unidade;
	}

	public Unidades removeUnidade(Unidades unidade) {
		getUnidades().remove(unidade);
		unidade.setCidade(null);

		return unidade;
	}

}
