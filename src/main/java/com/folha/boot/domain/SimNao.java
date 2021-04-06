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
    
    @OneToMany(mappedBy = "idCorteFolhaEfetivaSimNaoFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
    @OneToMany(mappedBy = "idCorteFolhaExtraSimNaoFk")
    private List<FuncionariosLicencas> funcionariosLicencasList1;
    @OneToMany(mappedBy = "idPendenciaExameComprobatorioSimNaoFk")
    private List<FuncionariosLicencas> funcionariosLicencasList2;
    @OneToMany(mappedBy = "idEscalaBloqueadaFk")
    private List<AnoMes> anoMesList;
    
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

    
	
	
}
