package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_soma_irf_funcionario")
public class RubricaSomaIrfFuncionario extends AbstractEntity<Long> {

	@Column(name = "obs")
    private String obs;
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaFuncionarios idFuncionarioFk;
    @JoinColumn(name = "id_codigo_fk", referencedColumnName = "id")
    @ManyToOne
    private RubricaSomaIrfCodigo idCodigoFk;
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}
	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}
	public PessoaFuncionarios getIdFuncionarioFk() {
		return idFuncionarioFk;
	}
	public void setIdFuncionarioFk(PessoaFuncionarios idFuncionarioFk) {
		this.idFuncionarioFk = idFuncionarioFk;
	}
	public RubricaSomaIrfCodigo getIdCodigoFk() {
		return idCodigoFk;
	}
	public void setIdCodigoFk(RubricaSomaIrfCodigo idCodigoFk) {
		this.idCodigoFk = idCodigoFk;
	}
    
    
	
}
