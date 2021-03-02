package com.folha.boot.domain;

import javax.persistence.*;
import java.util.List;


@SuppressWarnings("serial")
@Entity
@Table(name="areas_de_capacitacao")
public class AreasDeCapacitacao extends AbstractEntity<Long>  {
	
	@Column(name="area_de_capacitacao")
	private String areaDeCapacitacao;

	//bi-directional many-to-one association to FuncionariosCapacitacoe
	@OneToMany(mappedBy="areasDeCapacitacao")
	private List<FuncionariosCapacitacoes> funcionariosCapacitacoes;

	public AreasDeCapacitacao() {
	}

	public String getAreaDeCapacitacao() {
		return this.areaDeCapacitacao;
	}

	public void setAreaDeCapacitacao(String areaDeCapacitacao) {
		this.areaDeCapacitacao = areaDeCapacitacao;
	}

	public List<FuncionariosCapacitacoes> getFuncionariosCapacitacoes() {
		return this.funcionariosCapacitacoes;
	}

	public void setFuncionariosCapacitacoes(List<FuncionariosCapacitacoes> funcionariosCapacitacoes) {
		this.funcionariosCapacitacoes = funcionariosCapacitacoes;
	}

	public FuncionariosCapacitacoes addFuncionariosCapacitacoe(FuncionariosCapacitacoes funcionariosCapacitacoe) {
		getFuncionariosCapacitacoes().add(funcionariosCapacitacoe);
		funcionariosCapacitacoe.setAreasDeCapacitacao(this);

		return funcionariosCapacitacoe;
	}

	public FuncionariosCapacitacoes removeFuncionariosCapacitacoe(FuncionariosCapacitacoes funcionariosCapacitacoe) {
		getFuncionariosCapacitacoes().remove(funcionariosCapacitacoe);
		funcionariosCapacitacoe.setAreasDeCapacitacao(null);

		return funcionariosCapacitacoe;
	}

}