package com.folha.boot.domain;



import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_pensao")
public class RubricaPensao extends AbstractEntity<Long> {

	@Column(name = "valor")
    private Double valor;
    @Column(name = "percentagem")
    private Double percentagem;
    @Column(name = "nome_beneficiario")
    private String nomeBeneficiario;
    @Column(name = "cpf_beneficiario")
    private String cpfBeneficiario;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "dv_agencia")
    private String dvAgencia;
    @Column(name = "conta")
    private String conta;
    @Column(name = "dv_conta")
    private String dvConta;
    @Column(name = "operacao_variacao")
    private String operacaoVariacao;
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_banco_fk", referencedColumnName = "id")
    @ManyToOne
    private Bancos idBancoFk;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
    @ManyToOne
    private Pessoa idPessoaFk;

    public RubricaPensao() {
    }

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getPercentagem() {
		return percentagem;
	}

	public void setPercentagem(Double percentagem) {
		this.percentagem = percentagem;
	}

	
	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}

	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeBeneficiario);
	}

	public String getCpfBeneficiario() {
		return cpfBeneficiario;
	}

	public void setCpfBeneficiario(String cpfBeneficiario) {
		this.cpfBeneficiario = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cpfBeneficiario);
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(agencia);
	}

	public String getDvAgencia() {
		return dvAgencia;
	}

	public void setDvAgencia(String dvAgencia) {
		this.dvAgencia = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(dvAgencia);
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(conta);
	}

	public String getDvConta() {
		return dvConta;
	}

	public void setDvConta(String dvConta) {
		this.dvConta = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(dvConta);
	}

	public String getOperacaoVariacao() {
		return operacaoVariacao;
	}

	public void setOperacaoVariacao(String operacaoVariacao) {
		this.operacaoVariacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(operacaoVariacao);
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(observacao);
	}

	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}

	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}

	public Bancos getIdBancoFk() {
		return idBancoFk;
	}

	public void setIdBancoFk(Bancos idBancoFk) {
		this.idBancoFk = idBancoFk;
	}

	public Pessoa getIdPessoaFk() {
		return idPessoaFk;
	}

	public void setIdPessoaFk(Pessoa idPessoaFk) {
		this.idPessoaFk = idPessoaFk;
	}

    

}
