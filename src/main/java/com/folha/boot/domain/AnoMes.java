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
    
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<FaixasImpostoDeRenda> faixasImpostoDeRendaList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<FaixasPrevidencia> faixasPrevidenciaList;
    
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<FaixasValoresParametrosCalculoFolhasExtras> faixasValoresParametrosCalculoFolhasExtrasList;
    
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<UnidadeAdmiteChDif> unidadeAdmiteChDifList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<UnidadeAdmiteIncrementoDeRisco> unidadeAdmiteIncrementoDeRiscoList;
    
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<FatorChDif> fatorChDifList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<TiposDeFolhaNivelCargo> tiposDeFolhaNivelCargoList;
    
    
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
	public List<FaixasValoresParametrosCalculoFolhasExtras> getFaixasValoresParametrosCalculoFolhasExtrasList() {
		return faixasValoresParametrosCalculoFolhasExtrasList;
	}
	public void setFaixasValoresParametrosCalculoFolhasExtrasList(
			List<FaixasValoresParametrosCalculoFolhasExtras> faixasValoresParametrosCalculoFolhasExtrasList) {
		this.faixasValoresParametrosCalculoFolhasExtrasList = faixasValoresParametrosCalculoFolhasExtrasList;
	}
	public List<FaixasImpostoDeRenda> getFaixasImpostoDeRendaList() {
		return faixasImpostoDeRendaList;
	}
	public void setFaixasImpostoDeRendaList(List<FaixasImpostoDeRenda> faixasImpostoDeRendaList) {
		this.faixasImpostoDeRendaList = faixasImpostoDeRendaList;
	}
	public List<FaixasPrevidencia> getFaixasPrevidenciaList() {
		return faixasPrevidenciaList;
	}
	public void setFaixasPrevidenciaList(List<FaixasPrevidencia> faixasPrevidenciaList) {
		this.faixasPrevidenciaList = faixasPrevidenciaList;
	}
	public List<UnidadeAdmiteChDif> getUnidadeAdmiteChDifList() {
		return unidadeAdmiteChDifList;
	}
	public void setUnidadeAdmiteChDifList(List<UnidadeAdmiteChDif> unidadeAdmiteChDifList) {
		this.unidadeAdmiteChDifList = unidadeAdmiteChDifList;
	}
	public List<UnidadeAdmiteIncrementoDeRisco> getUnidadeAdmiteIncrementoDeRiscoList() {
		return unidadeAdmiteIncrementoDeRiscoList;
	}
	public void setUnidadeAdmiteIncrementoDeRiscoList(
			List<UnidadeAdmiteIncrementoDeRisco> unidadeAdmiteIncrementoDeRiscoList) {
		this.unidadeAdmiteIncrementoDeRiscoList = unidadeAdmiteIncrementoDeRiscoList;
	}
	public List<FatorChDif> getFatorChDifList() {
		return fatorChDifList;
	}
	public void setFatorChDifList(List<FatorChDif> fatorChDifList) {
		this.fatorChDifList = fatorChDifList;
	}
	public List<TiposDeFolhaNivelCargo> getTiposDeFolhaNivelCargoList() {
		return tiposDeFolhaNivelCargoList;
	}
	public void setTiposDeFolhaNivelCargoList(List<TiposDeFolhaNivelCargo> tiposDeFolhaNivelCargoList) {
		this.tiposDeFolhaNivelCargoList = tiposDeFolhaNivelCargoList;
	}
	
	
	
	
}
