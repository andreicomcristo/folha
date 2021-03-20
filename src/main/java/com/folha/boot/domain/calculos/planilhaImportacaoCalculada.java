package com.folha.boot.domain.calculos;

import java.util.Date;


public class planilhaImportacaoCalculada {

	Long id;
	
    private String cpf;
    
    private String matricula;
    
    private String nome;
    
    private String nivel;
    
    private String cargo;
    
    private String regimeDeTrabalho;
    
    private String mesDaEscala;
    
    private String cnesUnidade;
    
    private String nota;
    
    private String tipoDeFolha;
    
    private Integer horasDia;
    
    private Integer horasNoite;
    
    private Integer horasSemana;
    
    private Integer horasFimDeSemana;
    
	private Integer horasChdif;
    
    private String codDiferenciado;
    
    private String incrementoDeRisco;
    
    private String nomeUnidade;
    
    private Integer chSemanal;
	
    private Date dtImportacao;
    
    private Double valorBrutoHorasTotais;
    
    private Double valorBrutoHorasDia;
    
    private Double valorBrutoHorasNoite;
    
    private Double valorBrutoHorasSemana;
    
    private Double valorBrutoHorasFinalDeSemana;
    
    private Double valorPrevidencia;
    
    private Double valorPensao;
    
    private Double valorIR;
    
    private Double valorLiquido;
    
    private Double valorPatronal;
    

    
    
	public planilhaImportacaoCalculada() {
		super();
		// TODO Auto-generated constructor stub
	}



	


	public planilhaImportacaoCalculada(Long id, String cpf, String matricula, String nome, String nivel, String cargo,
			String regimeDeTrabalho, String mesDaEscala, String cnesUnidade, String nota, String tipoDeFolha,
			Integer horasDia, Integer horasNoite, Integer horasSemana, Integer horasFimDeSemana, Integer horasChdif,
			String codDiferenciado, String incrementoDeRisco, String nomeUnidade, Integer chSemanal, Date dtImportacao,
			Double valorBrutoHorasTotais, Double valorBrutoHorasDia, Double valorBrutoHorasNoite,
			Double valorBrutoHorasSemana, Double valorBrutoHorasFinalDeSemana, Double valorPrevidencia,
			Double valorPensao, Double valorIR, Double valorLiquido, Double valorPatronal) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.matricula = matricula;
		this.nome = nome;
		this.nivel = nivel;
		this.cargo = cargo;
		this.regimeDeTrabalho = regimeDeTrabalho;
		this.mesDaEscala = mesDaEscala;
		this.cnesUnidade = cnesUnidade;
		this.nota = nota;
		this.tipoDeFolha = tipoDeFolha;
		this.horasDia = horasDia;
		this.horasNoite = horasNoite;
		this.horasSemana = horasSemana;
		this.horasFimDeSemana = horasFimDeSemana;
		this.horasChdif = horasChdif;
		this.codDiferenciado = codDiferenciado;
		this.incrementoDeRisco = incrementoDeRisco;
		this.nomeUnidade = nomeUnidade;
		this.chSemanal = chSemanal;
		this.dtImportacao = dtImportacao;
		this.valorBrutoHorasTotais = valorBrutoHorasTotais;
		this.valorBrutoHorasDia = valorBrutoHorasDia;
		this.valorBrutoHorasNoite = valorBrutoHorasNoite;
		this.valorBrutoHorasSemana = valorBrutoHorasSemana;
		this.valorBrutoHorasFinalDeSemana = valorBrutoHorasFinalDeSemana;
		this.valorPrevidencia = valorPrevidencia;
		this.valorPensao = valorPensao;
		this.valorIR = valorIR;
		this.valorLiquido = valorLiquido;
		this.valorPatronal = valorPatronal;
	}






	public Double getValorBrutoHorasTotais() {
		return valorBrutoHorasTotais;
	}






	public void setValorBrutoHorasTotais(Double valorBrutoHorasTotais) {
		this.valorBrutoHorasTotais = valorBrutoHorasTotais;
	}






	public Double getValorBrutoHorasDia() {
		return valorBrutoHorasDia;
	}






	public void setValorBrutoHorasDia(Double valorBrutoHorasDia) {
		this.valorBrutoHorasDia = valorBrutoHorasDia;
	}






	public Double getValorBrutoHorasNoite() {
		return valorBrutoHorasNoite;
	}






	public void setValorBrutoHorasNoite(Double valorBrutoHorasNoite) {
		this.valorBrutoHorasNoite = valorBrutoHorasNoite;
	}






	public Double getValorBrutoHorasSemana() {
		return valorBrutoHorasSemana;
	}






	public void setValorBrutoHorasSemana(Double valorBrutoHorasSemana) {
		this.valorBrutoHorasSemana = valorBrutoHorasSemana;
	}






	public Double getValorBrutoHorasFinalDeSemana() {
		return valorBrutoHorasFinalDeSemana;
	}






	public void setValorBrutoHorasFinalDeSemana(Double valorBrutoHorasFinalDeSemana) {
		this.valorBrutoHorasFinalDeSemana = valorBrutoHorasFinalDeSemana;
	}






	public Double getValorPrevidencia() {
		return valorPrevidencia;
	}






	public void setValorPrevidencia(Double valorPrevidencia) {
		this.valorPrevidencia = valorPrevidencia;
	}






	public Double getValorPensao() {
		return valorPensao;
	}






	public void setValorPensao(Double valorPensao) {
		this.valorPensao = valorPensao;
	}






	public Double getValorIR() {
		return valorIR;
	}






	public void setValorIR(Double valorIR) {
		this.valorIR = valorIR;
	}






	public Double getValorLiquido() {
		return valorLiquido;
	}






	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}






	public Double getValorPatronal() {
		return valorPatronal;
	}






	public void setValorPatronal(Double valorPatronal) {
		this.valorPatronal = valorPatronal;
	}






	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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



	public Integer getChSemanal() {
		return chSemanal;
	}



	public void setChSemanal(Integer chSemanal) {
		this.chSemanal = chSemanal;
	}



	public Date getDtImportacao() {
		return dtImportacao;
	}



	public void setDtImportacao(Date dtImportacao) {
		this.dtImportacao = dtImportacao;
	}
	
    
    
    
}
