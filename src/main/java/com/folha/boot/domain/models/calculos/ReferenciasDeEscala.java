package com.folha.boot.domain.models.calculos;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.UnidadesRegime;
import com.folha.boot.domain.Vinculos;
import com.folha.boot.service.util.UtilidadesDeTexto;

public class ReferenciasDeEscala {
	
	AnoMes anoMes;
	TiposDeFolha tiposDeFolha;
	RegimesDeTrabalho regimesDeTrabalho;
	Vinculos vinculos;
	Unidades unidades;
	UnidadesRegime unidadesRegime;
	
	String nome;
	String cpf;
	String matricula;
	
	int diasFerias;
	int horasFeriasDescontadas;
	int diasLicenca;
	int horasLicencaDescontadas;
	
	String obsReferencias;
	
	public ReferenciasDeEscala() {
		super();
	}

	public TiposDeFolha getTiposDeFolha() {
		return tiposDeFolha;
	}

	public void setTiposDeFolha(TiposDeFolha tiposDeFolha) {
		this.tiposDeFolha = tiposDeFolha;
	}

	public RegimesDeTrabalho getRegimesDeTrabalho() {
		return regimesDeTrabalho;
	}

	public void setRegimesDeTrabalho(RegimesDeTrabalho regimesDeTrabalho) {
		this.regimesDeTrabalho = regimesDeTrabalho;
	}

	
	public Vinculos getVinculos() {
		return vinculos;
	}

	public void setVinculos(Vinculos vinculos) {
		this.vinculos = vinculos;
	}

	public Unidades getUnidades() {
		return unidades;
	}

	public void setUnidades(Unidades unidades) {
		this.unidades = unidades;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getDiasFerias() {
		return diasFerias;
	}

	public void setDiasFerias(int diasFerias) {
		this.diasFerias = diasFerias;
	}

	public int getDiasLicenca() {
		return diasLicenca;
	}

	public void setDiasLicenca(int diasLicenca) {
		this.diasLicenca = diasLicenca;
	}

	public String getObsReferencias() {
		return obsReferencias;
	}

	public void setObsReferencias(String obsReferencias) {
		this.obsReferencias = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(obsReferencias);
	}

	public AnoMes getAnoMes() {
		return anoMes;
	}

	public void setAnoMes(AnoMes anoMes) {
		this.anoMes = anoMes;
	}

	public UnidadesRegime getUnidadesRegime() {
		return unidadesRegime;
	}

	public void setUnidadesRegime(UnidadesRegime unidadesRegime) {
		this.unidadesRegime = unidadesRegime;
	}

	public int getHorasFeriasDescontadas() {
		return horasFeriasDescontadas;
	}

	public void setHorasFeriasDescontadas(int horasFeriasDescontadas) {
		this.horasFeriasDescontadas = horasFeriasDescontadas;
	}

	public int getHorasLicencaDescontadas() {
		return horasLicencaDescontadas;
	}

	public void setHorasLicencaDescontadas(int horasLicencaDescontadas) {
		this.horasLicencaDescontadas = horasLicencaDescontadas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nome);
	}

	
	
	
}
