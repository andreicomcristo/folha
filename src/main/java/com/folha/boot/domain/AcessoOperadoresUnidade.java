package com.folha.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="acesso_operadores_unidades")

public class AcessoOperadoresUnidade extends AbstractEntity <Long>{

	@ManyToOne
	@JoinColumn(name="id_operador_fk")
	private PessoaOperadores pessoaOperadores;

	//bi-directional many-to-one association to Unidade
	@ManyToOne
	@JoinColumn(name="id_unidade_fk")
	private Unidades unidades;

	public AcessoOperadoresUnidade() {
	}
	
	public AcessoOperadoresUnidade(PessoaOperadores pessoaOperadores, Unidades unidades) {
		super();
		this.pessoaOperadores = pessoaOperadores;
		this.unidades = unidades;
	}

	public PessoaOperadores getPessoaOperadores() {
		return pessoaOperadores;
	}

	public void setPessoaOperadores(PessoaOperadores pessoaOperadores) {
		this.pessoaOperadores = pessoaOperadores;
	}

	public Unidades getUnidades() {
		return unidades;
	}

	public void setUnidades(Unidades unidades) {
		this.unidades = unidades;
	}

}