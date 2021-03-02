package com.folha.boot.domain;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipos_de_capacitacao database table.
 * 
 */
@Entity
@Table(name="tipos_de_capacitacao")

public class TiposDeCapacitacao extends AbstractEntity<Long>  {
	private static final long serialVersionUID = 1L;

	@Column(name="descricao_tipo_capacitacao")
	private String descricaoTipoCapacitacao;

	@Column(name="tipo_capacitacao")
	private String tipoCapacitacao;

	//bi-directional many-to-one association to FuncionariosCapacitacoe
	@OneToMany(mappedBy="tiposDeCapacitacao")
	private List<FuncionariosCapacitacoes> funcionariosCapacitacoes;

	public TiposDeCapacitacao() {
	}

	public String getDescricaoTipoCapacitacao() {
		return this.descricaoTipoCapacitacao;
	}

	public void setDescricaoTipoCapacitacao(String descricaoTipoCapacitacao) {
		this.descricaoTipoCapacitacao = descricaoTipoCapacitacao;
	}

	public String getTipoCapacitacao() {
		return this.tipoCapacitacao;
	}

	public void setTipoCapacitacao(String tipoCapacitacao) {
		this.tipoCapacitacao = tipoCapacitacao;
	}

	public List<FuncionariosCapacitacoes> getFuncionariosCapacitacoes() {
		return this.funcionariosCapacitacoes;
	}

	public void setFuncionariosCapacitacoes(List<FuncionariosCapacitacoes> funcionariosCapacitacoes) {
		this.funcionariosCapacitacoes = funcionariosCapacitacoes;
	}

	public FuncionariosCapacitacoes addFuncionariosCapacitacoe(FuncionariosCapacitacoes funcionariosCapacitacoe) {
		getFuncionariosCapacitacoes().add(funcionariosCapacitacoe);
		funcionariosCapacitacoe.setTiposDeCapacitacao(this);

		return funcionariosCapacitacoe;
	}

	public FuncionariosCapacitacoes removeFuncionariosCapacitacoe(FuncionariosCapacitacoes funcionariosCapacitacoe) {
		getFuncionariosCapacitacoes().remove(funcionariosCapacitacoe);
		funcionariosCapacitacoe.setTiposDeCapacitacao(null);

		return funcionariosCapacitacoe;
	}

}