package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "regimes_de_trabalho")
public class RegimesDeTrabalho extends AbstractEntity<Long> {

    @Column(name = "nome_regime_de_trabalho")
    private String nomeRegimeDeTrabalho;
    @Column(name = "descricao_regime_de_trabalho")
    private String descricaoRegimeDeTrabalho;
    @OneToMany(mappedBy = "idRegimeFk")
    private List<Escala> escalaList;
    @OneToMany(mappedBy = "idRegimeFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList;
    @OneToMany(mappedBy = "idRegimeDeTrabalhoFk")
    private List<FaixasValoresParametrosCalculoFolhasExtras> faixasValoresParametrosCalculoFolhasExtrasList;
    @OneToMany(mappedBy = "idRegimeFk")
    private List<EscalaAlteracoes> escalaAlteracoesList;
    @OneToMany(mappedBy = "idRegimeDeTrabalhoFk")
    private List<FaixasValoresParametrosCalculoFolhasExtrasIndividual> faixasValoresParametrosCalculoFolhasExtrasIndividualList;
    @OneToMany(mappedBy = "idRegimeDeTrabalhoFk")
    private List<RegimeDeTrabalhoTurno> regimeDeTrabalhoTurnoList;
    @OneToMany(mappedBy = "idRegimeFk")
    private List<EscalaHorasPagas> escalaHorasPagasList;

	public String getNomeRegimeDeTrabalho() {
		return nomeRegimeDeTrabalho;
	}

	public void setNomeRegimeDeTrabalho(String nomeRegimeDeTrabalho) {
		this.nomeRegimeDeTrabalho = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeRegimeDeTrabalho);
	}

	public String getDescricaoRegimeDeTrabalho() {
		return descricaoRegimeDeTrabalho;
	}

	public void setDescricaoRegimeDeTrabalho(String descricaoRegimeDeTrabalho) {
		this.descricaoRegimeDeTrabalho = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoRegimeDeTrabalho);
	}

	public List<FaixasValoresParametrosCalculoFolhasExtras> getFaixasValoresParametrosCalculoFolhasExtrasList() {
		return faixasValoresParametrosCalculoFolhasExtrasList;
	}

	public void setFaixasValoresParametrosCalculoFolhasExtrasList(
			List<FaixasValoresParametrosCalculoFolhasExtras> faixasValoresParametrosCalculoFolhasExtrasList) {
		this.faixasValoresParametrosCalculoFolhasExtrasList = faixasValoresParametrosCalculoFolhasExtrasList;
	}

	public List<Escala> getEscalaList() {
		return escalaList;
	}

	public void setEscalaList(List<Escala> escalaList) {
		this.escalaList = escalaList;
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

	public List<FaixasValoresParametrosCalculoFolhasExtrasIndividual> getFaixasValoresParametrosCalculoFolhasExtrasIndividualList() {
		return faixasValoresParametrosCalculoFolhasExtrasIndividualList;
	}

	public void setFaixasValoresParametrosCalculoFolhasExtrasIndividualList(
			List<FaixasValoresParametrosCalculoFolhasExtrasIndividual> faixasValoresParametrosCalculoFolhasExtrasIndividualList) {
		this.faixasValoresParametrosCalculoFolhasExtrasIndividualList = faixasValoresParametrosCalculoFolhasExtrasIndividualList;
	}

	public List<RegimeDeTrabalhoTurno> getRegimeDeTrabalhoTurnoList() {
		return regimeDeTrabalhoTurnoList;
	}

	public void setRegimeDeTrabalhoTurnoList(List<RegimeDeTrabalhoTurno> regimeDeTrabalhoTurnoList) {
		this.regimeDeTrabalhoTurnoList = regimeDeTrabalhoTurnoList;
	}

	public List<EscalaHorasPagas> getEscalaHorasPagasList() {
		return escalaHorasPagasList;
	}

	public void setEscalaHorasPagasList(List<EscalaHorasPagas> escalaHorasPagasList) {
		this.escalaHorasPagasList = escalaHorasPagasList;
	}
	
	
	
}
