package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_filhos")
public class PessoaFilhos extends AbstractEntity<Long> {

	@Column(name="cartorio_certidado_nascimento")
	private String cartorioCertidadoNascimento;

	@Column(name="cpf_filho")
	private String cpfFilho;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cancelamento")
	private Date dtCancelamento;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_certidado_nascimento")
	private Date dtCertidadoNascimento;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Date dtNascimento;

	@Column(name="folha_certidao_nascimento")
	private String folhaCertidaoNascimento;

	@Column(name="livro_certidao_nascimento")
	private String livroCertidaoNascimento;

	@Column(name="motivo_cadastro")
	private String motivoCadastro;

	@Column(name="motivo_cancelamento")
	private String motivoCancelamento;

	@Column(name="nome_filho")
	private String nomeFilho;

	@Column(name="numero_certidao_nascimento")
	private String numeroCertidaoNascimento;

	@Temporal(TemporalType.DATE)
	@Column(name="rg_dt_emissao_filho")
	private Date rgDtEmissaoFilho;

	@Column(name="rg_filho")
	private String rgFilho;

	@Column(name="rg_orgao_expedidor")
	private String rgOrgaoExpedidor;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa_fk", insertable = false, updatable = false)
	private Pessoa pessoa;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk", insertable = false, updatable = false)
	private PessoaOperadores pessoaOperadore1;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk", insertable = false, updatable = false)
	private PessoaOperadores pessoaOperadore2;

	//bi-directional many-to-one association to TiposDeFiliacao
	@ManyToOne
	@JoinColumn(name="id_tipo_filiacao_fk", insertable = false, updatable = false)
	private TiposDeFiliacao tiposDeFiliacao;

	public PessoaFilhos() {
	}

	public String getCartorioCertidadoNascimento() {
		return this.cartorioCertidadoNascimento;
	}

	public void setCartorioCertidadoNascimento(String cartorioCertidadoNascimento) {
		this.cartorioCertidadoNascimento = cartorioCertidadoNascimento;
	}

	public String getCpfFilho() {
		return this.cpfFilho;
	}

	public void setCpfFilho(String cpfFilho) {
		this.cpfFilho = cpfFilho;
	}

	public Date getDtCadastro() {
		return this.dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtCancelamento() {
		return this.dtCancelamento;
	}

	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}

	public Date getDtCertidadoNascimento() {
		return this.dtCertidadoNascimento;
	}

	public void setDtCertidadoNascimento(Date dtCertidadoNascimento) {
		this.dtCertidadoNascimento = dtCertidadoNascimento;
	}

	public Date getDtNascimento() {
		return this.dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getFolhaCertidaoNascimento() {
		return this.folhaCertidaoNascimento;
	}

	public void setFolhaCertidaoNascimento(String folhaCertidaoNascimento) {
		this.folhaCertidaoNascimento = folhaCertidaoNascimento;
	}

	public String getLivroCertidaoNascimento() {
		return this.livroCertidaoNascimento;
	}

	public void setLivroCertidaoNascimento(String livroCertidaoNascimento) {
		this.livroCertidaoNascimento = livroCertidaoNascimento;
	}

	public String getMotivoCadastro() {
		return this.motivoCadastro;
	}

	public void setMotivoCadastro(String motivoCadastro) {
		this.motivoCadastro = motivoCadastro;
	}

	public String getMotivoCancelamento() {
		return this.motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public String getNomeFilho() {
		return this.nomeFilho;
	}

	public void setNomeFilho(String nomeFilho) {
		this.nomeFilho = nomeFilho;
	}

	public String getNumeroCertidaoNascimento() {
		return this.numeroCertidaoNascimento;
	}

	public void setNumeroCertidaoNascimento(String numeroCertidaoNascimento) {
		this.numeroCertidaoNascimento = numeroCertidaoNascimento;
	}

	public Date getRgDtEmissaoFilho() {
		return this.rgDtEmissaoFilho;
	}

	public void setRgDtEmissaoFilho(Date rgDtEmissaoFilho) {
		this.rgDtEmissaoFilho = rgDtEmissaoFilho;
	}

	public String getRgFilho() {
		return this.rgFilho;
	}

	public void setRgFilho(String rgFilho) {
		this.rgFilho = rgFilho;
	}

	public String getRgOrgaoExpedidor() {
		return this.rgOrgaoExpedidor;
	}

	public void setRgOrgaoExpedidor(String rgOrgaoExpedidor) {
		this.rgOrgaoExpedidor = rgOrgaoExpedidor;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaOperadores getPessoaOperadore1() {
		return this.pessoaOperadore1;
	}

	public void setPessoaOperadore1(PessoaOperadores pessoaOperadore1) {
		this.pessoaOperadore1 = pessoaOperadore1;
	}

	public PessoaOperadores getPessoaOperadore2() {
		return this.pessoaOperadore2;
	}

	public void setPessoaOperadore2(PessoaOperadores pessoaOperadore2) {
		this.pessoaOperadore2 = pessoaOperadore2;
	}

	public TiposDeFiliacao getTiposDeFiliacao() {
		return this.tiposDeFiliacao;
	}

	public void setTiposDeFiliacao(TiposDeFiliacao tiposDeFiliacao) {
		this.tiposDeFiliacao = tiposDeFiliacao;
	}
}
