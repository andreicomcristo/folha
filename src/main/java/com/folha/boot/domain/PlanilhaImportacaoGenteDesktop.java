package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "planilha_importacao_gente_desktop")
public class PlanilhaImportacaoGenteDesktop extends AbstractEntity<Long>{

	@Column(name = "cpf")
    private String cpf;
    
	@Column(name = "matricula")
    private String matricula;
    
	@Column(name = "nome")
    private String nome;
    
	@Column(name = "nivel")
    private String nivel;
    
	@Column(name = "cargo")
    private String cargo;
    
	@Column(name = "regime_de_trabalho")
    private String regimeDeTrabalho;
    
	@Column(name = "mes_da_escala")
    private String mesDaEscala;
    
	@Column(name = "cnes_unidade")
    private String cnesUnidade;
    
	@Column(name = "nota")
    private String nota;
    
	@Column(name = "tipo_de_folha")
    private String tipoDeFolha;
    
	@Column(name = "horas_dia")
    private Integer horasDia;
    
	@Column(name = "horas_noite")
    private Integer horasNoite;
    
	@Column(name = "horas_semana")
    private Integer horasSemana;
    
	@Column(name = "horas_fim_de_semana")
    private Integer horasFimDeSemana;
    
	@Column(name = "horas_chdif")    
	private Integer horasChdif;
   
	@Column(name = "cod_diferenciado")    
    private String codDiferenciado;
    
    @Column(name = "incremento_de_risco")
    private String incrementoDeRisco;
    
    @Column(name = "nome_unidade")
    private String nomeUnidade;
    
    @Column(name = "ch_semanal")
    private Integer chSemanal;
	
    @Column(name = "dt_importacao")
    private Date dtImportacao;

    public Integer getChSemanal() {
		return chSemanal;
	}
	public void setChSemanal(Integer chSemanal) {
		this.chSemanal = chSemanal;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getRegimeDeTrabalho() {
		return regimeDeTrabalho;
	}
	public void setRegimeDeTrabalho(String regimeDeTrabalho) {
		this.regimeDeTrabalho = regimeDeTrabalho;
	}
	public String getMesDaEscala() {
		return mesDaEscala;
	}
	public void setMesDaEscala(String mesDaEscala) {
		this.mesDaEscala = mesDaEscala;
	}
	public String getCnesUnidade() {
		return cnesUnidade;
	}
	public void setCnesUnidade(String cnesUnidade) {
		this.cnesUnidade = cnesUnidade;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public String getTipoDeFolha() {
		return tipoDeFolha;
	}
	public void setTipoDeFolha(String tipoDeFolha) {
		this.tipoDeFolha = tipoDeFolha;
	}
	public Integer getHorasDia() {
		return horasDia;
	}
	public void setHorasDia(Integer horasDia) {
		this.horasDia = horasDia;
	}
	public Integer getHorasNoite() {
		return horasNoite;
	}
	public void setHorasNoite(Integer horasNoite) {
		this.horasNoite = horasNoite;
	}
	public Integer getHorasSemana() {
		return horasSemana;
	}
	public void setHorasSemana(Integer horasSemana) {
		this.horasSemana = horasSemana;
	}
	public Integer getHorasFimDeSemana() {
		return horasFimDeSemana;
	}
	public void setHorasFimDeSemana(Integer horasFimDeSemana) {
		this.horasFimDeSemana = horasFimDeSemana;
	}
	public Integer getHorasChdif() {
		return horasChdif;
	}
	public void setHorasChdif(Integer horasChdif) {
		this.horasChdif = horasChdif;
	}
	public String getCodDiferenciado() {
		return codDiferenciado;
	}
	public void setCodDiferenciado(String codDiferenciado) {
		this.codDiferenciado = codDiferenciado;
	}
	public String getIncrementoDeRisco() {
		return incrementoDeRisco;
	}
	public void setIncrementoDeRisco(String incrementoDeRisco) {
		this.incrementoDeRisco = incrementoDeRisco;
	}
	public String getNomeUnidade() {
		return nomeUnidade;
	}
	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}
    
    
}
