package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "privilegios")
public class Privilegios extends AbstractEntity<Long> {

	@Column(name="descricao_privilegio")
	private String descricaoPrivilegio;

	@Column(name="nome_privilegio")
	private String nomePrivilegio;

	//bi-directional many-to-one association to PessoaOperadore
	@OneToMany(mappedBy="privilegio")
	private List<PessoaOperadores> pessoaOperadores;

	public Privilegios() {
	}
	
	public String getDescricaoPrivilegio() {
		return this.descricaoPrivilegio;
	}

	public void setDescricaoPrivilegio(String descricaoPrivilegio) {
		this.descricaoPrivilegio = descricaoPrivilegio;
	}

	public String getNomePrivilegio() {
		return this.nomePrivilegio;
	}

	public void setNomePrivilegio(String nomePrivilegio) {
		this.nomePrivilegio = nomePrivilegio;
	}

	public List<PessoaOperadores> getPessoaOperadores() {
		return this.pessoaOperadores;
	}

	public void setPessoaOperadores(List<PessoaOperadores> pessoaOperadores) {
		this.pessoaOperadores = pessoaOperadores;
	}

	public PessoaOperadores addPessoaOperadore(PessoaOperadores pessoaOperadore) {
		getPessoaOperadores().add(pessoaOperadore);
		pessoaOperadore.setPrivilegio(this);

		return pessoaOperadore;
	}

	public PessoaOperadores removePessoaOperadore(PessoaOperadores pessoaOperadore) {
		getPessoaOperadores().remove(pessoaOperadore);
		pessoaOperadore.setPrivilegio(null);

		return pessoaOperadore;
	}

}
