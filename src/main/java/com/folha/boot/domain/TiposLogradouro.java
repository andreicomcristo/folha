package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipos_logradouro")
public class TiposLogradouro extends AbstractEntity<Long> {

	@Column(name="descricao_tipo_logradouro")
	private String descricaoTipoLogradouro;

	@Column(name="nome_tipo_logradouro")
	private String nomeTipoLogradouro;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="tiposLogradouro")
	private List<Enderecos> enderecos;

	//bi-directional many-to-one association to Unidade
	@OneToMany(mappedBy="tiposLogradouro")
	private List<Unidades> unidades;

	public TiposLogradouro() {
	}

	public String getDescricaoTipoLogradouro() {
		return this.descricaoTipoLogradouro;
	}

	public void setDescricaoTipoLogradouro(String descricaoTipoLogradouro) {
		this.descricaoTipoLogradouro = descricaoTipoLogradouro;
	}

	public String getNomeTipoLogradouro() {
		return this.nomeTipoLogradouro;
	}

	public void setNomeTipoLogradouro(String nomeTipoLogradouro) {
		this.nomeTipoLogradouro = nomeTipoLogradouro;
	}

	public List<Enderecos> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Enderecos> enderecos) {
		this.enderecos = enderecos;
	}

	public Enderecos addEndereco(Enderecos endereco) {
		getEnderecos().add(endereco);
		endereco.setTiposLogradouro(this);

		return endereco;
	}

	public Enderecos removeEndereco(Enderecos endereco) {
		getEnderecos().remove(endereco);
		endereco.setTiposLogradouro(null);

		return endereco;
	}

	public List<Unidades> getUnidades() {
		return this.unidades;
	}

	public void setUnidades(List<Unidades> unidades) {
		this.unidades = unidades;
	}

	public Unidades addUnidade(Unidades unidade) {
		getUnidades().add(unidade);
		unidade.setTiposLogradouro(this);

		return unidade;
	}

	public Unidades removeUnidade(Unidades unidade) {
		getUnidades().remove(unidade);
		unidade.setTiposLogradouro(null);

		return unidade;
	}


}
