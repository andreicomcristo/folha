package com.folha.boot.domain.models.calculos;


import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.Fonte;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaBancos;
import com.folha.boot.service.util.UtilidadesDeTexto;

public class TxtFinanceiro {
	
	String juncao;
	AnoMes anoMes;
	Fonte fonte;
	Pessoa pessoa;
	PessoaBancos banco;
	Double valor;
	
	String cpf;
	String nome;
	String codigoBanco;
	String agencia;
	String conta;
	String valorString;
	String nomeBanco;
	
	String obs;
	
	public TxtFinanceiro() {
	}

	public String getJuncao() {
		return juncao;
	}

	public void setJuncao(String juncao) {
		this.juncao = juncao;
	}

	public AnoMes getAnoMes() {
		return anoMes;
	}

	public void setAnoMes(AnoMes anoMes) {
		this.anoMes = anoMes;
	}

	public Fonte getFonte() {
		return fonte;
	}

	public void setFonte(Fonte fonte) {
		this.fonte = fonte;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public PessoaBancos getBanco() {
		return banco;
	}

	public void setBanco(PessoaBancos banco) {
		this.banco = banco;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getValorString() {
		return valorString;
	}

	public void setValorString(String valorString) {
		this.valorString = valorString;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(obs);
	}
	
	
		
}
