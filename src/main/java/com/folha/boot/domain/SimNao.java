package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "sim_nao")
public class SimNao extends AbstractEntity<Long> {

	@Column(name = "sigla")
    private String sigla;
    @Column(name = "descricao")
    private String descricao;
    
    @OneToMany(mappedBy = "idChDifSimNaoFk")
    private List<Escala> escalaList;
    @OneToMany(mappedBy = "idIncrementoDeRiscoSimNaoFk")
    private List<Escala> escalaList1;
    @OneToMany(mappedBy = "idAvaliacaoAssiduidadeFk")
    private List<Escala> escalaList2;
    @OneToMany(mappedBy = "idAvaliacaoAtividadesBurocraticasFk")
    private List<Escala> escalaList3;
    @OneToMany(mappedBy = "idAvaliacaoFormalizacaoPontoFk")
    private List<Escala> escalaList4;
    @OneToMany(mappedBy = "idAvaliacaoPermanenciaFk")
    private List<Escala> escalaList5;
    @OneToMany(mappedBy = "idAvaliacaoPermanenciaFk")
    private List<Escala> escalaList6;
    @OneToMany(mappedBy = "idLiberacaoDobraInvertidaSimNaoFk")
    private List<Escala> escalaList7;
    
    @OneToMany(mappedBy = "idAvaliacaoAssiduidadeFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList;
    @OneToMany(mappedBy = "idChDifSimNaoFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList1;
    @OneToMany(mappedBy = "idLiberacaoDobraInvertidaSimNaoFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList2;
    @OneToMany(mappedBy = "idAvaliacaoAtividadesBurocraticasFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList3;
    @OneToMany(mappedBy = "idAvaliacaoFormalizacaoPontoFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList4;
    @OneToMany(mappedBy = "idIncrementoDeRiscoSimNaoFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList5;
    @OneToMany(mappedBy = "idAvaliacaoPermanenciaFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList6;
    @OneToMany(mappedBy = "idPresencialSimNaoFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList7;
    
    @OneToMany(mappedBy = "idCorteFolhaEfetivaSimNaoFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
    @OneToMany(mappedBy = "idCorteFolhaExtraSimNaoFk")
    private List<FuncionariosLicencas> funcionariosLicencasList1;
    @OneToMany(mappedBy = "idPendenciaExameComprobatorioSimNaoFk")
    private List<FuncionariosLicencas> funcionariosLicencasList2;
    @OneToMany(mappedBy = "idCorteAdicionalNoturnoSimNaoFk")
    private List<FuncionariosLicencas> funcionariosLicencasList3;
    @OneToMany(mappedBy = "idEscalaBloqueadaFk")
    private List<AnoMes> anoMesList;
    @OneToMany(mappedBy = "idTransparenciaEnviadaFk")
    private List<AnoMes> anoMesList1;
    
    @OneToMany(mappedBy = "idChDifSimNaoFk")
    private List<EscalaAlteracoes> escalaAlteracoesList;
    @OneToMany(mappedBy = "idLiberacaoDobraInvertidaSimNaoFk")
    private List<EscalaAlteracoes> escalaAlteracoesList1;
    @OneToMany(mappedBy = "idIncrementoDeRiscoSimNaoFk")
    private List<EscalaAlteracoes> escalaAlteracoesList2;
    @OneToMany(mappedBy = "idAvaliacaoAssiduidadeFk")
    private List<EscalaAlteracoes> escalaAlteracoesList3;
    @OneToMany(mappedBy = "idAvaliacaoAtividadesBurocraticasFk")
    private List<EscalaAlteracoes> escalaAlteracoesList4;
    @OneToMany(mappedBy = "idAvaliacaoFormalizacaoPontoFk")
    private List<EscalaAlteracoes> escalaAlteracoesList5;
    @OneToMany(mappedBy = "idAvaliacaoPermanenciaFk")
    private List<EscalaAlteracoes> escalaAlteracoesList6;
    @OneToMany(mappedBy = "idPresencialSimNaoFk")
    private List<EscalaAlteracoes> escalaAlteracoesList7;
    
    @OneToMany(mappedBy = "idPrioritarioFk")
    private List<PessoaBancos> pessoaBancosList;
    
    @OneToMany(mappedBy = "idFolhaEfetivaSimNaoFk")
    private List<TiposDeFolha> tiposDeFolhaList;
    
    @OneToMany(mappedBy = "idNecessitaAtribuicaoRhFk")
    private List<CodigoDiferenciado> codigoDiferenciadoList;
    @OneToMany(mappedBy = "idNecessitaAtribuicaoSedeFk")
    private List<CodigoDiferenciado> codigoDiferenciadoList1;
    @OneToMany(mappedBy = "idConfirmacaoSedeSimNaoFk")
    private List<PessoaCodDiferenciado> pessoaCodDiferenciadoList;
    
    @OneToMany(mappedBy = "idAvaliacaoSedeSimNaoFk")
    private List<PessoaLimiteHoras> pessoaLimiteHorasList;
    
    @OneToMany(mappedBy = "idComplementoPlantaoSimNaoFk")
    private List<Escala> escalaList8;
    
    @OneToMany(mappedBy = "idComplementoPlantaoSimNaoFk")
    private List<EscalaAlteracoes> escalaAlteracoesList8;
    
    @OneToMany(mappedBy = "idComplementoPlantaoSimNaoFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList8;
    
    public SimNao() {
    }


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<Escala> getEscalaList() {
		return escalaList;
	}


	public void setEscalaList(List<Escala> escalaList) {
		this.escalaList = escalaList;
	}


	public List<Escala> getEscalaList1() {
		return escalaList1;
	}


	public void setEscalaList1(List<Escala> escalaList1) {
		this.escalaList1 = escalaList1;
	}


	public List<Escala> getEscalaList2() {
		return escalaList2;
	}


	public void setEscalaList2(List<Escala> escalaList2) {
		this.escalaList2 = escalaList2;
	}


	public List<Escala> getEscalaList3() {
		return escalaList3;
	}


	public void setEscalaList3(List<Escala> escalaList3) {
		this.escalaList3 = escalaList3;
	}


	public List<Escala> getEscalaList4() {
		return escalaList4;
	}


	public void setEscalaList4(List<Escala> escalaList4) {
		this.escalaList4 = escalaList4;
	}


	public List<Escala> getEscalaList5() {
		return escalaList5;
	}


	public void setEscalaList5(List<Escala> escalaList5) {
		this.escalaList5 = escalaList5;
	}


	public List<Escala> getEscalaList6() {
		return escalaList6;
	}


	public void setEscalaList6(List<Escala> escalaList6) {
		this.escalaList6 = escalaList6;
	}


	public List<Escala> getEscalaList7() {
		return escalaList7;
	}


	public void setEscalaList7(List<Escala> escalaList7) {
		this.escalaList7 = escalaList7;
	}


	public List<FuncionariosLicencas> getFuncionariosLicencasList() {
		return funcionariosLicencasList;
	}


	public void setFuncionariosLicencasList(List<FuncionariosLicencas> funcionariosLicencasList) {
		this.funcionariosLicencasList = funcionariosLicencasList;
	}


	public List<FuncionariosLicencas> getFuncionariosLicencasList1() {
		return funcionariosLicencasList1;
	}


	public void setFuncionariosLicencasList1(List<FuncionariosLicencas> funcionariosLicencasList1) {
		this.funcionariosLicencasList1 = funcionariosLicencasList1;
	}


	public List<FuncionariosLicencas> getFuncionariosLicencasList2() {
		return funcionariosLicencasList2;
	}


	public void setFuncionariosLicencasList2(List<FuncionariosLicencas> funcionariosLicencasList2) {
		this.funcionariosLicencasList2 = funcionariosLicencasList2;
	}


	public List<AnoMes> getAnoMesList() {
		return anoMesList;
	}


	public void setAnoMesList(List<AnoMes> anoMesList) {
		this.anoMesList = anoMesList;
	}


	public List<AnoMes> getAnoMesList1() {
		return anoMesList1;
	}


	public void setAnoMesList1(List<AnoMes> anoMesList1) {
		this.anoMesList1 = anoMesList1;
	}


	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList() {
		return escalaPosTransparenciaList;
	}


	public void setEscalaPosTransparenciaList(List<EscalaPosTransparencia> escalaPosTransparenciaList) {
		this.escalaPosTransparenciaList = escalaPosTransparenciaList;
	}


	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList1() {
		return escalaPosTransparenciaList1;
	}


	public void setEscalaPosTransparenciaList1(List<EscalaPosTransparencia> escalaPosTransparenciaList1) {
		this.escalaPosTransparenciaList1 = escalaPosTransparenciaList1;
	}


	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList2() {
		return escalaPosTransparenciaList2;
	}


	public void setEscalaPosTransparenciaList2(List<EscalaPosTransparencia> escalaPosTransparenciaList2) {
		this.escalaPosTransparenciaList2 = escalaPosTransparenciaList2;
	}


	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList3() {
		return escalaPosTransparenciaList3;
	}


	public void setEscalaPosTransparenciaList3(List<EscalaPosTransparencia> escalaPosTransparenciaList3) {
		this.escalaPosTransparenciaList3 = escalaPosTransparenciaList3;
	}


	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList4() {
		return escalaPosTransparenciaList4;
	}


	public void setEscalaPosTransparenciaList4(List<EscalaPosTransparencia> escalaPosTransparenciaList4) {
		this.escalaPosTransparenciaList4 = escalaPosTransparenciaList4;
	}


	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList5() {
		return escalaPosTransparenciaList5;
	}


	public void setEscalaPosTransparenciaList5(List<EscalaPosTransparencia> escalaPosTransparenciaList5) {
		this.escalaPosTransparenciaList5 = escalaPosTransparenciaList5;
	}


	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList6() {
		return escalaPosTransparenciaList6;
	}


	public void setEscalaPosTransparenciaList6(List<EscalaPosTransparencia> escalaPosTransparenciaList6) {
		this.escalaPosTransparenciaList6 = escalaPosTransparenciaList6;
	}


	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList7() {
		return escalaPosTransparenciaList7;
	}


	public void setEscalaPosTransparenciaList7(List<EscalaPosTransparencia> escalaPosTransparenciaList7) {
		this.escalaPosTransparenciaList7 = escalaPosTransparenciaList7;
	}


	public List<EscalaAlteracoes> getEscalaAlteracoesList() {
		return escalaAlteracoesList;
	}


	public void setEscalaAlteracoesList(List<EscalaAlteracoes> escalaAlteracoesList) {
		this.escalaAlteracoesList = escalaAlteracoesList;
	}


	public List<EscalaAlteracoes> getEscalaAlteracoesList1() {
		return escalaAlteracoesList1;
	}


	public void setEscalaAlteracoesList1(List<EscalaAlteracoes> escalaAlteracoesList1) {
		this.escalaAlteracoesList1 = escalaAlteracoesList1;
	}


	public List<EscalaAlteracoes> getEscalaAlteracoesList2() {
		return escalaAlteracoesList2;
	}


	public void setEscalaAlteracoesList2(List<EscalaAlteracoes> escalaAlteracoesList2) {
		this.escalaAlteracoesList2 = escalaAlteracoesList2;
	}


	public List<EscalaAlteracoes> getEscalaAlteracoesList3() {
		return escalaAlteracoesList3;
	}


	public void setEscalaAlteracoesList3(List<EscalaAlteracoes> escalaAlteracoesList3) {
		this.escalaAlteracoesList3 = escalaAlteracoesList3;
	}


	public List<EscalaAlteracoes> getEscalaAlteracoesList4() {
		return escalaAlteracoesList4;
	}


	public void setEscalaAlteracoesList4(List<EscalaAlteracoes> escalaAlteracoesList4) {
		this.escalaAlteracoesList4 = escalaAlteracoesList4;
	}


	public List<EscalaAlteracoes> getEscalaAlteracoesList5() {
		return escalaAlteracoesList5;
	}


	public void setEscalaAlteracoesList5(List<EscalaAlteracoes> escalaAlteracoesList5) {
		this.escalaAlteracoesList5 = escalaAlteracoesList5;
	}


	public List<EscalaAlteracoes> getEscalaAlteracoesList6() {
		return escalaAlteracoesList6;
	}


	public void setEscalaAlteracoesList6(List<EscalaAlteracoes> escalaAlteracoesList6) {
		this.escalaAlteracoesList6 = escalaAlteracoesList6;
	}


	public List<EscalaAlteracoes> getEscalaAlteracoesList7() {
		return escalaAlteracoesList7;
	}


	public void setEscalaAlteracoesList7(List<EscalaAlteracoes> escalaAlteracoesList7) {
		this.escalaAlteracoesList7 = escalaAlteracoesList7;
	}


	public List<PessoaBancos> getPessoaBancosList() {
		return pessoaBancosList;
	}


	public void setPessoaBancosList(List<PessoaBancos> pessoaBancosList) {
		this.pessoaBancosList = pessoaBancosList;
	}


	public List<TiposDeFolha> getTiposDeFolhaList() {
		return tiposDeFolhaList;
	}


	public void setTiposDeFolhaList(List<TiposDeFolha> tiposDeFolhaList) {
		this.tiposDeFolhaList = tiposDeFolhaList;
	}


	public List<CodigoDiferenciado> getCodigoDiferenciadoList() {
		return codigoDiferenciadoList;
	}


	public void setCodigoDiferenciadoList(List<CodigoDiferenciado> codigoDiferenciadoList) {
		this.codigoDiferenciadoList = codigoDiferenciadoList;
	}


	public List<CodigoDiferenciado> getCodigoDiferenciadoList1() {
		return codigoDiferenciadoList1;
	}


	public void setCodigoDiferenciadoList1(List<CodigoDiferenciado> codigoDiferenciadoList1) {
		this.codigoDiferenciadoList1 = codigoDiferenciadoList1;
	}


	public List<PessoaCodDiferenciado> getPessoaCodDiferenciadoList() {
		return pessoaCodDiferenciadoList;
	}


	public void setPessoaCodDiferenciadoList(List<PessoaCodDiferenciado> pessoaCodDiferenciadoList) {
		this.pessoaCodDiferenciadoList = pessoaCodDiferenciadoList;
	}


	public List<PessoaLimiteHoras> getPessoaLimiteHorasList() {
		return pessoaLimiteHorasList;
	}


	public void setPessoaLimiteHorasList(List<PessoaLimiteHoras> pessoaLimiteHorasList) {
		this.pessoaLimiteHorasList = pessoaLimiteHorasList;
	}


	public List<FuncionariosLicencas> getFuncionariosLicencasList3() {
		return funcionariosLicencasList3;
	}


	public void setFuncionariosLicencasList3(List<FuncionariosLicencas> funcionariosLicencasList3) {
		this.funcionariosLicencasList3 = funcionariosLicencasList3;
	}


	public List<Escala> getEscalaList8() {
		return escalaList8;
	}


	public void setEscalaList8(List<Escala> escalaList8) {
		this.escalaList8 = escalaList8;
	}


	public List<EscalaAlteracoes> getEscalaAlteracoesList8() {
		return escalaAlteracoesList8;
	}


	public void setEscalaAlteracoesList8(List<EscalaAlteracoes> escalaAlteracoesList8) {
		this.escalaAlteracoesList8 = escalaAlteracoesList8;
	}


	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList8() {
		return escalaPosTransparenciaList8;
	}


	public void setEscalaPosTransparenciaList8(List<EscalaPosTransparencia> escalaPosTransparenciaList8) {
		this.escalaPosTransparenciaList8 = escalaPosTransparenciaList8;
	}

	

	
	
	
    
	
	
}
