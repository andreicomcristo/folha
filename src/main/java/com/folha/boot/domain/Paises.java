package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "paises")
public class Paises extends AbstractEntity<Long> {

	@Column(name="nome_pais")
	private String nomePais;

	//bi-directional many-to-one association to Cidade
	@OneToMany(mappedBy="pais")
	private List<Cidades> cidades;

	public Paises() {
	}

	public String getNomePais() {
		return this.nomePais;
	}

	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}

	public List<Cidades> getCidades() {
		return this.cidades;
	}

	public void setCidades(List<Cidades> cidades) {
		this.cidades = cidades;
	}

	public Cidades addCidade(Cidades cidade) {
		getCidades().add(cidade);
		cidade.setPais(this);

		return cidade;
	}

	public Cidades removeCidade(Cidades cidade) {
		getCidades().remove(cidade);
		cidade.setPais(null);

		return cidade;
	}
}
