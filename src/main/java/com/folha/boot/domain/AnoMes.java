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
    
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<PessoaIncrementoDeRisco> pessoaIncrementoDeRiscoList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<PessoaChDif> pessoaChDifList;
    
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaComplementoConstitucional> rubricaComplementoConstitucionalList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaGeralSomaPercentagemFuncionario> rubricaGeralSomaPercentagemFuncionarioList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaGeralSomaFuncionario> rubricaGeralSomaFuncionarioList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaGeralSubtracao> rubricaGeralSubtracaoList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<FaixasValoresSubsidio> faixasValoresSubsidioList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaInsalubridadeFuncionario> rubricaInsalubridadeFuncionarioList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaGeralSubtracaoPercentagemFuncionario> rubricaGeralSubtracaoPercentagemFuncionarioList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaComplementoConstitucionalFuncionario> rubricaComplementoConstitucionalFuncionarioList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaGeralSoma> rubricaGeralSomaList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaGeralSomaPercentagem> rubricaGeralSomaPercentagemList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaGeralSubtracaoPercentagem> rubricaGeralSubtracaoPercentagemList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaDescontoPensaoFuncionario> rubricaDescontoPensaoFuncionarioList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaInsalubridade> rubricaInsalubridadeList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaGeralSubtracaoFuncionario> rubricaGeralSubtracaoFuncionarioList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaSomaIrf> rubricaSomaIrfList;
    @OneToMany(mappedBy = "idAnoMesFk")
    private List<RubricaSomaIrfFuncionario> rubricaSomaIrfFuncionarioList;
    
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
	public List<PessoaIncrementoDeRisco> getPessoaIncrementoDeRiscoList() {
		return pessoaIncrementoDeRiscoList;
	}
	public void setPessoaIncrementoDeRiscoList(List<PessoaIncrementoDeRisco> pessoaIncrementoDeRiscoList) {
		this.pessoaIncrementoDeRiscoList = pessoaIncrementoDeRiscoList;
	}
	public List<PessoaChDif> getPessoaChDifList() {
		return pessoaChDifList;
	}
	public void setPessoaChDifList(List<PessoaChDif> pessoaChDifList) {
		this.pessoaChDifList = pessoaChDifList;
	}
	public List<RubricaComplementoConstitucional> getRubricaComplementoConstitucionalList() {
		return rubricaComplementoConstitucionalList;
	}
	public void setRubricaComplementoConstitucionalList(
			List<RubricaComplementoConstitucional> rubricaComplementoConstitucionalList) {
		this.rubricaComplementoConstitucionalList = rubricaComplementoConstitucionalList;
	}
	public List<RubricaGeralSomaPercentagemFuncionario> getRubricaGeralSomaPercentagemFuncionarioList() {
		return rubricaGeralSomaPercentagemFuncionarioList;
	}
	public void setRubricaGeralSomaPercentagemFuncionarioList(
			List<RubricaGeralSomaPercentagemFuncionario> rubricaGeralSomaPercentagemFuncionarioList) {
		this.rubricaGeralSomaPercentagemFuncionarioList = rubricaGeralSomaPercentagemFuncionarioList;
	}
	public List<RubricaGeralSomaFuncionario> getRubricaGeralSomaFuncionarioList() {
		return rubricaGeralSomaFuncionarioList;
	}
	public void setRubricaGeralSomaFuncionarioList(List<RubricaGeralSomaFuncionario> rubricaGeralSomaFuncionarioList) {
		this.rubricaGeralSomaFuncionarioList = rubricaGeralSomaFuncionarioList;
	}
	public List<RubricaGeralSubtracao> getRubricaGeralSubtracaoList() {
		return rubricaGeralSubtracaoList;
	}
	public void setRubricaGeralSubtracaoList(List<RubricaGeralSubtracao> rubricaGeralSubtracaoList) {
		this.rubricaGeralSubtracaoList = rubricaGeralSubtracaoList;
	}
	public List<FaixasValoresSubsidio> getFaixasValoresSubsidioList() {
		return faixasValoresSubsidioList;
	}
	public void setFaixasValoresSubsidioList(List<FaixasValoresSubsidio> faixasValoresSubsidioList) {
		this.faixasValoresSubsidioList = faixasValoresSubsidioList;
	}
	public List<RubricaInsalubridadeFuncionario> getRubricaInsalubridadeFuncionarioList() {
		return rubricaInsalubridadeFuncionarioList;
	}
	public void setRubricaInsalubridadeFuncionarioList(
			List<RubricaInsalubridadeFuncionario> rubricaInsalubridadeFuncionarioList) {
		this.rubricaInsalubridadeFuncionarioList = rubricaInsalubridadeFuncionarioList;
	}
	public List<RubricaGeralSubtracaoPercentagemFuncionario> getRubricaGeralSubtracaoPercentagemFuncionarioList() {
		return rubricaGeralSubtracaoPercentagemFuncionarioList;
	}
	public void setRubricaGeralSubtracaoPercentagemFuncionarioList(
			List<RubricaGeralSubtracaoPercentagemFuncionario> rubricaGeralSubtracaoPercentagemFuncionarioList) {
		this.rubricaGeralSubtracaoPercentagemFuncionarioList = rubricaGeralSubtracaoPercentagemFuncionarioList;
	}
	public List<RubricaComplementoConstitucionalFuncionario> getRubricaComplementoConstitucionalFuncionarioList() {
		return rubricaComplementoConstitucionalFuncionarioList;
	}
	public void setRubricaComplementoConstitucionalFuncionarioList(
			List<RubricaComplementoConstitucionalFuncionario> rubricaComplementoConstitucionalFuncionarioList) {
		this.rubricaComplementoConstitucionalFuncionarioList = rubricaComplementoConstitucionalFuncionarioList;
	}
	public List<RubricaGeralSoma> getRubricaGeralSomaList() {
		return rubricaGeralSomaList;
	}
	public void setRubricaGeralSomaList(List<RubricaGeralSoma> rubricaGeralSomaList) {
		this.rubricaGeralSomaList = rubricaGeralSomaList;
	}
	public List<RubricaGeralSomaPercentagem> getRubricaGeralSomaPercentagemList() {
		return rubricaGeralSomaPercentagemList;
	}
	public void setRubricaGeralSomaPercentagemList(List<RubricaGeralSomaPercentagem> rubricaGeralSomaPercentagemList) {
		this.rubricaGeralSomaPercentagemList = rubricaGeralSomaPercentagemList;
	}
	public List<RubricaGeralSubtracaoPercentagem> getRubricaGeralSubtracaoPercentagemList() {
		return rubricaGeralSubtracaoPercentagemList;
	}
	public void setRubricaGeralSubtracaoPercentagemList(
			List<RubricaGeralSubtracaoPercentagem> rubricaGeralSubtracaoPercentagemList) {
		this.rubricaGeralSubtracaoPercentagemList = rubricaGeralSubtracaoPercentagemList;
	}
	public List<RubricaDescontoPensaoFuncionario> getRubricaDescontoPensaoFuncionarioList() {
		return rubricaDescontoPensaoFuncionarioList;
	}
	public void setRubricaDescontoPensaoFuncionarioList(
			List<RubricaDescontoPensaoFuncionario> rubricaDescontoPensaoFuncionarioList) {
		this.rubricaDescontoPensaoFuncionarioList = rubricaDescontoPensaoFuncionarioList;
	}
	public List<RubricaInsalubridade> getRubricaInsalubridadeList() {
		return rubricaInsalubridadeList;
	}
	public void setRubricaInsalubridadeList(List<RubricaInsalubridade> rubricaInsalubridadeList) {
		this.rubricaInsalubridadeList = rubricaInsalubridadeList;
	}
	public List<RubricaGeralSubtracaoFuncionario> getRubricaGeralSubtracaoFuncionarioList() {
		return rubricaGeralSubtracaoFuncionarioList;
	}
	public void setRubricaGeralSubtracaoFuncionarioList(
			List<RubricaGeralSubtracaoFuncionario> rubricaGeralSubtracaoFuncionarioList) {
		this.rubricaGeralSubtracaoFuncionarioList = rubricaGeralSubtracaoFuncionarioList;
	}
	public List<RubricaSomaIrf> getRubricaSomaIrfList() {
		return rubricaSomaIrfList;
	}
	public void setRubricaSomaIrfList(List<RubricaSomaIrf> rubricaSomaIrfList) {
		this.rubricaSomaIrfList = rubricaSomaIrfList;
	}
	public List<RubricaSomaIrfFuncionario> getRubricaSomaIrfFuncionarioList() {
		return rubricaSomaIrfFuncionarioList;
	}
	public void setRubricaSomaIrfFuncionarioList(List<RubricaSomaIrfFuncionario> rubricaSomaIrfFuncionarioList) {
		this.rubricaSomaIrfFuncionarioList = rubricaSomaIrfFuncionarioList;
	}
	
	
	
	
}
