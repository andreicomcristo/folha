package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "sexos")
public class Sexos extends AbstractEntity<Long> {

	@Column(name="descricao_sexo")
	private String descricaoSexo;

	@Column(name="nome_sexo")
	private String nomeSexo;

	//bi-directional many-to-one association to Pessoa
	@OneToMany(mappedBy="sexo1")
	private List<Pessoa> pessoas1;

	//bi-directional many-to-one association to Pessoa
	@OneToMany(mappedBy="sexo2")
	private List<Pessoa> pessoas2;

	public Sexos() {
	}

	public String getDescricaoSexo() {
		return this.descricaoSexo;
	}

	public void setDescricaoSexo(String descricaoSexo) {
		this.descricaoSexo = descricaoSexo;
	}

	public String getNomeSexo() {
		return this.nomeSexo;
	}

	public void setNomeSexo(String nomeSexo) {
		this.nomeSexo = nomeSexo;
	}

	public List<Pessoa> getPessoas1() {
		return this.pessoas1;
	}

	public void setPessoas1(List<Pessoa> pessoas1) {
		this.pessoas1 = pessoas1;
	}

	public Pessoa addPessoas1(Pessoa pessoas1) {
		getPessoas1().add(pessoas1);
		pessoas1.setSexo1(this);

		return pessoas1;
	}

	public Pessoa removePessoas1(Pessoa pessoas1) {
		getPessoas1().remove(pessoas1);
		pessoas1.setSexo1(null);

		return pessoas1;
	}

	public List<Pessoa> getPessoas2() {
		return this.pessoas2;
	}

	public void setPessoas2(List<Pessoa> pessoas2) {
		this.pessoas2 = pessoas2;
	}

	public Pessoa addPessoas2(Pessoa pessoas2) {
		getPessoas2().add(pessoas2);
		pessoas2.setSexo2(this);

		return pessoas2;
	}

	public Pessoa removePessoas2(Pessoa pessoas2) {
		getPessoas2().remove(pessoas2);
		pessoas2.setSexo2(null);

		return pessoas2;
	}

}
