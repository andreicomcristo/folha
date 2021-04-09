package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ano_mes")
public class AnoMes extends AbstractEntity<Long> {

	@Column(name = "nome_ano_mes")
    private String nomeAnoMes;
	@OneToMany(mappedBy = "idAnoMesFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList;
    @JoinColumn(name = "id_escala_bloqueada_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idEscalaBloqueadaFk;
    @JoinColumn(name = "id_transparencia_enviada_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idTransparenciaEnviadaFk;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<EscalaAlteracoes> escalaAlteracoesList;
    
	public String getNomeAnoMes() {
		return nomeAnoMes;
	}
	public void setNomeAnoMes(String nomeAnoMes) {
		this.nomeAnoMes = nomeAnoMes;
	}
	public SimNao getIdEscalaBloqueadaFk() {
		return idEscalaBloqueadaFk;
	}
	public void setIdEscalaBloqueadaFk(SimNao idEscalaBloqueadaFk) {
		this.idEscalaBloqueadaFk = idEscalaBloqueadaFk;
	}
	public SimNao getIdTransparenciaEnviadaFk() {
		return idTransparenciaEnviadaFk;
	}
	public void setIdTransparenciaEnviadaFk(SimNao idTransparenciaEnviadaFk) {
		this.idTransparenciaEnviadaFk = idTransparenciaEnviadaFk;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList() {
		return escalaPosTransparenciaList;
	}
	public void setEscalaPosTransparenciaList(List<EscalaPosTransparencia> escalaPosTransparenciaList) {
		this.escalaPosTransparenciaList = escalaPosTransparenciaList;
	}
	public List<EscalaAlteracoes> getEscalaAlteracoesList() {
		return escalaAlteracoesList;
	}
	public void setEscalaAlteracoesList(List<EscalaAlteracoes> escalaAlteracoesList) {
		this.escalaAlteracoesList = escalaAlteracoesList;
	}
	
	
	
	
}
