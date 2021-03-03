package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "enderecos")
public class Enderecos extends AbstractEntity<Long> {

	@Column(name="endereco_bairro")
	private String enderecoBairro;

	@Column(name="endereco_cep")
	private String enderecoCep;

	@Column(name="endereco_complemento")
	private String enderecoComplemento;

	@Column(name="endereco_logradouro")
	private String enderecoLogradouro;

	@Column(name="endereco_numero")
	private String enderecoNumero;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="id_endereco_cidade_fk", insertable = false, updatable = false)
	private Cidades cidade;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa_fk" , insertable = false, updatable = false)
	private Pessoa pessoa;

	//bi-directional many-to-one association to TiposLogradouro
	@ManyToOne
	@JoinColumn(name="id_tipo_logradouro_fk" , insertable = false, updatable = false)
	private TiposLogradouro tiposLogradouro;

	//bi-directional many-to-one association to Pessoa
	@OneToMany(mappedBy="endereco")
	private List<Pessoa> pessoas;

	public Enderecos() {
	}
	
	public String getEnderecoBairro() {
		return enderecoBairro;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}

	public String getEnderecoCep() {
		return enderecoCep;
	}

	public void setEnderecoCep(String enderecoCep) {
		this.enderecoCep = enderecoCep;
	}

	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}

	public String getEnderecoLogradouro() {
		return enderecoLogradouro;
	}

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = enderecoLogradouro;
	}

	public String getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public Cidades getCidade() {
		return cidade;
	}

	public void setCidade(Cidades cidade) {
		this.cidade = cidade;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TiposLogradouro getTiposLogradouro() {
		return tiposLogradouro;
	}

	public void setTiposLogradouro(TiposLogradouro tiposLogradouro) {
		this.tiposLogradouro = tiposLogradouro;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa addPessoa(Pessoa pessoa) {
		getPessoas().add(pessoa);
		pessoa.setEndereco(this);

		return pessoa;
	}

	public Pessoa removePessoa(Pessoa pessoa) {
		getPessoas().remove(pessoa);
		pessoa.setEndereco(null);

		return pessoa;
	}

}
