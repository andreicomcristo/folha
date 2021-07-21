package com.folha.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_pensao_obs_vencimento")
public class RubricaPensaoObsVencimento extends AbstractEntity<Long> {
	
	@Column(name = "valor_liquido")
    private Double valorLiqido;
	
	@Column(name = "valor_ir")
    private Double valorIr;
	
	@Column(name = "valor_descontado")
    private Double valorDescontado;
	
	@JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_rubrica_pensao_obs_fk", referencedColumnName = "id")
    @ManyToOne
    private RubricaPensaoObs idRubricaPensaoObsFk;
    @JoinColumn(name = "id_rubrica_vencimento_fk", referencedColumnName = "id")
    @ManyToOne
    private RubricaVencimento idRubricaVencimentoFk;

    public RubricaPensaoObsVencimento() {
    }

	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}

	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}

	public RubricaPensaoObs getIdRubricaPensaoObsFk() {
		return idRubricaPensaoObsFk;
	}

	public void setIdRubricaPensaoObsFk(RubricaPensaoObs idRubricaPensaoObsFk) {
		this.idRubricaPensaoObsFk = idRubricaPensaoObsFk;
	}

	public RubricaVencimento getIdRubricaVencimentoFk() {
		return idRubricaVencimentoFk;
	}

	public void setIdRubricaVencimentoFk(RubricaVencimento idRubricaVencimentoFk) {
		this.idRubricaVencimentoFk = idRubricaVencimentoFk;
	}

	public Double getValorDescontado() {
		return valorDescontado;
	}

	public void setValorDescontado(Double valorDescontado) {
		this.valorDescontado = valorDescontado;
	}

	public Double getValorLiqido() {
		return valorLiqido;
	}

	public void setValorLiqido(Double valorLiqido) {
		this.valorLiqido = valorLiqido;
	}

	public Double getValorIr() {
		return valorIr;
	}

	public void setValorIr(Double valorIr) {
		this.valorIr = valorIr;
	}
    
	
}
