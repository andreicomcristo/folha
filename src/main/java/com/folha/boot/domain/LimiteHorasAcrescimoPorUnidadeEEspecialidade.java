package com.folha.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "limite_horas_acrescimo_por_unidade_e_especialidade")
public class LimiteHorasAcrescimoPorUnidadeEEspecialidade extends AbstractEntity<Long> {

	@Column(name = "horas")
    private Integer horas;
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_especialidade_fk", referencedColumnName = "id")
    @ManyToOne
    private CargosEspecialidade idEspecialidadeFk;
    @JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeFk;
    @Column(name = "motivo")
    private String motivo;
    
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}
	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}
	public CargosEspecialidade getIdEspecialidadeFk() {
		return idEspecialidadeFk;
	}
	public void setIdEspecialidadeFk(CargosEspecialidade idEspecialidadeFk) {
		this.idEspecialidadeFk = idEspecialidadeFk;
	}
	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}
	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(motivo);
	}
    
    
	
}
