package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_bancos")
public class PessoaBancos extends AbstractEntity<Long> {
	
	@Column(name = "operacao_variacao", length = 20)
	private String operacaoVariacao;

	@Column(name = "agencia_numero", nullable = false, length = 20)
	private String agenciaNumero;

	@Column(name = "agencia_dv", length = 5)
	private String agenciaDv;

	@Column(name = "conta_numero", nullable = false, length = 20)
	private String contaNumero;

	@Column(name = "conta_dv", nullable = false, length = 5)
	private String contaDv;

	@Column(name = "agencia_nome", length = 300)
	private String agenciaNome;

	@Column(name = "prioritario", length = 2147483647)
	private String prioritario;

	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dtCadastro;

	@Column(name = "motivo_cadastro", length = 300)
	private String motivoCadastro;

	@Column(name = "dt_cancelamento")
	@Temporal(TemporalType.DATE)
	private Date dtCancelamento;

	@Column(name = "motivo_cancelamento", length = 300)
	private String motivoCancelamento;

	@JoinColumn(name = "id_banco_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Bancos idBancoFk;

	@JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Pessoa idPessoaFk;

	@JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
	@ManyToOne
	private PessoaOperadores idOperadorCadastroFk;

	@JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
	@ManyToOne
	private PessoaOperadores idOperadorCancelamentoFk;

	public String getOperacaoVariacao() {
		return operacaoVariacao;
	}

	public void setOperacaoVariacao(String operacaoVariacao) {
		this.operacaoVariacao = operacaoVariacao;
	}

	public String getAgenciaNumero() {
		return agenciaNumero;
	}

	public void setAgenciaNumero(String agenciaNumero) {
		this.agenciaNumero = agenciaNumero;
	}

	public String getAgenciaDv() {
		return agenciaDv;
	}

	public void setAgenciaDv(String agenciaDv) {
		this.agenciaDv = agenciaDv;
	}

	public String getContaNumero() {
		return contaNumero;
	}

	public void setContaNumero(String contaNumero) {
		this.contaNumero = contaNumero;
	}

	public String getContaDv() {
		return contaDv;
	}

	public void setContaDv(String contaDv) {
		this.contaDv = contaDv;
	}

	public String getAgenciaNome() {
		return agenciaNome;
	}

	public void setAgenciaNome(String agenciaNome) {
		this.agenciaNome = agenciaNome;
	}

	public String getPrioritario() {
		return prioritario;
	}

	public void setPrioritario(String prioritario) {
		this.prioritario = prioritario;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public String getMotivoCadastro() {
		return motivoCadastro;
	}

	public void setMotivoCadastro(String motivoCadastro) {
		this.motivoCadastro = motivoCadastro;
	}

	public Date getDtCancelamento() {
		return dtCancelamento;
	}

	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
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

	public PessoaOperadores getIdOperadorCadastroFk() {
		return idOperadorCadastroFk;
	}

	public void setIdOperadorCadastroFk(PessoaOperadores idOperadorCadastroFk) {
		this.idOperadorCadastroFk = idOperadorCadastroFk;
	}

	public PessoaOperadores getIdOperadorCancelamentoFk() {
		return idOperadorCancelamentoFk;
	}

	public void setIdOperadorCancelamentoFk(PessoaOperadores idOperadorCancelamentoFk) {
		this.idOperadorCancelamentoFk = idOperadorCancelamentoFk;
	}

}
