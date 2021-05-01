package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_geral_subtracao_percentagem")
public class RubricaGeralSubtracaoPercentagem extends AbstractEntity<Long> {

	@Column(name = "valor")
    private Double valor;
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_codigo_fk", referencedColumnName = "id")
    @ManyToOne
    private RubricaGeralSubtracaoPercentagemCodigo idCodigoFk;
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}
	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}
	public RubricaGeralSubtracaoPercentagemCodigo getIdCodigoFk() {
		return idCodigoFk;
	}
	public void setIdCodigoFk(RubricaGeralSubtracaoPercentagemCodigo idCodigoFk) {
		this.idCodigoFk = idCodigoFk;
	}
    
	
}
