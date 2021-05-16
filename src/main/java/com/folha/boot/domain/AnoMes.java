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
    private List<UnidadeAdmiteComplementoPlantao> unidadeAdmiteComplementoPlantaoList;
    
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<FatorPatronal> fatorChDifList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<TiposDeFolhaNivelCargo> tiposDeFolhaNivelCargoList;
    
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaPensaoObs> rubricaPensaoObsList;
    
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<PessoaIncrementoDeRisco> pessoaIncrementoDeRiscoList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<PessoaChDif> pessoaChDifList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaVencimentoObs> rubricaVencimentoObsList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<HorasFaltasFolhasVariaveis> horasFaltasFolhasVariaveisList;
    @OneToMany(mappedBy = "idAnoMesLancamentoFk")
    private List<HorasFaltasFolhasVariaveis> horasFaltasFolhasVariaveisList1;
    
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaPensao> rubricaPensaoList;
    
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<NaoDescontaInss> naoDescontaInssList;
    
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<VencimentosFuncionario> rubricaFuncionarioList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<FaixasValoresSubsidio> faixasValoresSubsidioList;
    
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<Rubrica> rubricaList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> limiteHorasAcrescimoPorUnidadeEEspecialidadeList;
    
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<FaixasValoresGpf> faixasValoresGpfList;
    
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaVencimento> rubricaVencimentoList;
    
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
	public List<FatorPatronal> getFatorChDifList() {
		return fatorChDifList;
	}
	public void setFatorChDifList(List<FatorPatronal> fatorChDifList) {
		this.fatorChDifList = fatorChDifList;
	}
	public List<TiposDeFolhaNivelCargo> getTiposDeFolhaNivelCargoList() {
		return tiposDeFolhaNivelCargoList;
	}
	public void setTiposDeFolhaNivelCargoList(List<TiposDeFolhaNivelCargo> tiposDeFolhaNivelCargoList) {
		this.tiposDeFolhaNivelCargoList = tiposDeFolhaNivelCargoList;
	}
	public List<PessoaIncrementoDeRisco> getPessoaIncrementoDeRiscoList() {
		return pessoaIncrementoDeRiscoList;
	}
	public void setPessoaIncrementoDeRiscoList(List<PessoaIncrementoDeRisco> pessoaIncrementoDeRiscoList) {
		this.pessoaIncrementoDeRiscoList = pessoaIncrementoDeRiscoList;
	}
	public List<PessoaChDif> getPessoaChDifList() {
		return pessoaChDifList;
	}
	
	public List<FaixasValoresSubsidio> getFaixasValoresSubsidioList() {
		return faixasValoresSubsidioList;
	}
	public void setFaixasValoresSubsidioList(List<FaixasValoresSubsidio> faixasValoresSubsidioList) {
		this.faixasValoresSubsidioList = faixasValoresSubsidioList;
	}
	
	
	
	public List<VencimentosFuncionario> getRubricaFuncionarioList() {
		return rubricaFuncionarioList;
	}
	public void setRubricaFuncionarioList(List<VencimentosFuncionario> rubricaFuncionarioList) {
		this.rubricaFuncionarioList = rubricaFuncionarioList;
	}
	public List<Rubrica> getRubricaList() {
		return rubricaList;
	}
	public void setRubricaList(List<Rubrica> rubricaList) {
		this.rubricaList = rubricaList;
	}
	public List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> getLimiteHorasAcrescimoPorUnidadeEEspecialidadeList() {
		return limiteHorasAcrescimoPorUnidadeEEspecialidadeList;
	}
	public void setLimiteHorasAcrescimoPorUnidadeEEspecialidadeList(
			List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> limiteHorasAcrescimoPorUnidadeEEspecialidadeList) {
		this.limiteHorasAcrescimoPorUnidadeEEspecialidadeList = limiteHorasAcrescimoPorUnidadeEEspecialidadeList;
	}
	public void setPessoaChDifList(List<PessoaChDif> pessoaChDifList) {
		this.pessoaChDifList = pessoaChDifList;
	}
	public List<UnidadeAdmiteComplementoPlantao> getUnidadeAdmiteComplementoPlantaoList() {
		return unidadeAdmiteComplementoPlantaoList;
	}
	public void setUnidadeAdmiteComplementoPlantaoList(
			List<UnidadeAdmiteComplementoPlantao> unidadeAdmiteComplementoPlantaoList) {
		this.unidadeAdmiteComplementoPlantaoList = unidadeAdmiteComplementoPlantaoList;
	}
	public List<RubricaVencimento> getRubricaVencimentoList() {
		return rubricaVencimentoList;
	}
	public void setRubricaVencimentoList(List<RubricaVencimento> rubricaVencimentoList) {
		this.rubricaVencimentoList = rubricaVencimentoList;
	}
	public List<FaixasValoresGpf> getFaixasValoresGpfList() {
		return faixasValoresGpfList;
	}
	public void setFaixasValoresGpfList(List<FaixasValoresGpf> faixasValoresGpfList) {
		this.faixasValoresGpfList = faixasValoresGpfList;
	}
	public List<NaoDescontaInss> getNaoDescontaInssList() {
		return naoDescontaInssList;
	}
	public void setNaoDescontaInssList(List<NaoDescontaInss> naoDescontaInssList) {
		this.naoDescontaInssList = naoDescontaInssList;
	}
	public List<HorasFaltasFolhasVariaveis> getHorasFaltasFolhasVariaveisList() {
		return horasFaltasFolhasVariaveisList;
	}
	public void setHorasFaltasFolhasVariaveisList(List<HorasFaltasFolhasVariaveis> horasFaltasFolhasVariaveisList) {
		this.horasFaltasFolhasVariaveisList = horasFaltasFolhasVariaveisList;
	}
	public List<HorasFaltasFolhasVariaveis> getHorasFaltasFolhasVariaveisList1() {
		return horasFaltasFolhasVariaveisList1;
	}
	public void setHorasFaltasFolhasVariaveisList1(List<HorasFaltasFolhasVariaveis> horasFaltasFolhasVariaveisList1) {
		this.horasFaltasFolhasVariaveisList1 = horasFaltasFolhasVariaveisList1;
	}
	public List<RubricaVencimentoObs> getRubricaVencimentoObsList() {
		return rubricaVencimentoObsList;
	}
	public void setRubricaVencimentoObsList(List<RubricaVencimentoObs> rubricaVencimentoObsList) {
		this.rubricaVencimentoObsList = rubricaVencimentoObsList;
	}
	public List<RubricaPensao> getRubricaPensaoList() {
		return rubricaPensaoList;
	}
	public void setRubricaPensaoList(List<RubricaPensao> rubricaPensaoList) {
		this.rubricaPensaoList = rubricaPensaoList;
	}
	public List<RubricaPensaoObs> getRubricaPensaoObsList() {
		return rubricaPensaoObsList;
	}
	public void setRubricaPensaoObsList(List<RubricaPensaoObs> rubricaPensaoObsList) {
		this.rubricaPensaoObsList = rubricaPensaoObsList;
	}
		
	
	
	
}
