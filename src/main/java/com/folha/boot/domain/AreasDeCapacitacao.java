package com.folha.boot.domain;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "areas_de_capacitacao")
public class AreasDeCapacitacao extends AbstractEntity<Long> {

	@Column(name = "area_de_capacitacao")
    private String areaDeCapacitacao;
   
	@OneToMany(mappedBy = "idAreaDeCapacitacaoFk")
    private List<FuncionariosCapacitacoes> funcionariosCapacitacoesList;

	public String getAreaDeCapacitacao() {
		return areaDeCapacitacao;
	}

	public void setAreaDeCapacitacao(String areaDeCapacitacao) {
		this.areaDeCapacitacao = areaDeCapacitacao;
	}

	public List<FuncionariosCapacitacoes> getFuncionariosCapacitacoesList() {
		return funcionariosCapacitacoesList;
	}

	public void setFuncionariosCapacitacoesList(List<FuncionariosCapacitacoes> funcionariosCapacitacoesList) {
		this.funcionariosCapacitacoesList = funcionariosCapacitacoesList;
	}
	
}