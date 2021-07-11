package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_pensao_obs")
public class RubricaPensaoObs extends AbstractEntity<Long> {

	@Column(name = "valor_descontado")
    private Double valorDescontado;
	@Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_rubrica_pensao_fk", referencedColumnName = "id")
    @ManyToOne
    private RubricaPensao idRubricaPensaoFk;
    @OneToMany(mappedBy = "idRubricaPensaoObsFk")
    private List<RubricaPensaoObsVencimento> rubricaPensaoObsVencimentoList;

    public RubricaPensaoObs() {
    }

	public Double getValorDescontado() {
		return valorDescontado;
	}

	public void setValorDescontado(Double valorDescontado) {
		this.valorDescontado = valorDescontado;
	}

	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}

	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}

	public RubricaPensao getIdRubricaPensaoFk() {
		return idRubricaPensaoFk;
	}

	public void setIdRubricaPensaoFk(RubricaPensao idRubricaPensaoFk) {
		this.idRubricaPensaoFk = idRubricaPensaoFk;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(observacao);
	}

	public List<RubricaPensaoObsVencimento> getRubricaPensaoObsVencimentoList() {
		return rubricaPensaoObsVencimentoList;
	}

	public void setRubricaPensaoObsVencimentoList(List<RubricaPensaoObsVencimento> rubricaPensaoObsVencimentoList) {
		this.rubricaPensaoObsVencimentoList = rubricaPensaoObsVencimentoList;
	}
    
    
	
	
}
