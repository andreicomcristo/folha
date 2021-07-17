package com.folha.boot.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the tipos_de_capacitacao database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="tipos_de_capacitacao")
  
public class TiposDeCapacitacao extends AbstractEntity<Long>  {

	@Column(name = "tipo_capacitacao")
    private String tipoCapacitacao;
    
	@Column(name = "descricao_tipo_capacitacao")
    private String descricaoTipoCapacitacao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTiposCapacitacaoFk")
    private List<FuncionariosCapacitacoes> funcionariosCapacitacoesList;
	
    public String getTipoCapacitacao() {
		return tipoCapacitacao;
	}
	public void setTipoCapacitacao(String tipoCapacitacao) {
		this.tipoCapacitacao = tipoCapacitacao;
	}
	public String getDescricaoTipoCapacitacao() {
		return descricaoTipoCapacitacao;
	}
	public void setDescricaoTipoCapacitacao(String descricaoTipoCapacitacao) {
		this.descricaoTipoCapacitacao = descricaoTipoCapacitacao;
	}
	public List<FuncionariosCapacitacoes> getFuncionariosCapacitacoesList() {
		return funcionariosCapacitacoesList;
	}
	public void setFuncionariosCapacitacoesList(List<FuncionariosCapacitacoes> funcionariosCapacitacoesList) {
		this.funcionariosCapacitacoesList = funcionariosCapacitacoesList;
	}

}