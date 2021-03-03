package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_filhos")
public class PessoaFilhos extends AbstractEntity<Long> {

	@Column(name = "nome_filho", nullable = false, length = 300)
	private String nomeFilho;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dtNascimento;

	@Column(name = "cpf_filho", length = 20)
	private String cpfFilho;

	@Column(name = "rg_filho", length = 30)
	private String rgFilho;

	@Column(name = "rg_dt_emissao_filho")
	@Temporal(TemporalType.DATE)
	private Date rgDtEmissaoFilho;

	@Column(name = "rg_orgao_expedidor", length = 150)
	private String rgOrgaoExpedidor;

	@Column(name = "numero_certidao_nascimento", length = 150)
	private String numeroCertidaoNascimento;

	@Column(name = "dt_certidado_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dtCertidadoNascimento;

	@Column(name = "cartorio_certidado_nascimento", length = 150)
	private String cartorioCertidadoNascimento;

	@Column(name = "livro_certidao_nascimento", length = 150)
	private String livroCertidaoNascimento;

	@Column(name = "folha_certidao_nascimento", length = 150)
	private String folhaCertidaoNascimento;

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

	@JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Pessoa idPessoaFk;

	@JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
	@ManyToOne
	private PessoaOperadores idOperadorCadastroFk;

	@JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
	@ManyToOne
	private PessoaOperadores idOperadorCancelamentoFk;

	@JoinColumn(name = "id_tipo_filiacao_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private TiposDeFiliacao idTipoFiliacaoFk;

	public String getNomeFilho() {
		return nomeFilho;
	}

	public void setNomeFilho(String nomeFilho) {
		this.nomeFilho = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeFilho);
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getCpfFilho() {
		return cpfFilho;
	}

	public void setCpfFilho(String cpfFilho) {
		this.cpfFilho = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cpfFilho);
	}

	public String getRgFilho() {
		return rgFilho;
	}

	public void setRgFilho(String rgFilho) {
		this.rgFilho = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(rgFilho);
	}

	public Date getRgDtEmissaoFilho() {
		return rgDtEmissaoFilho;
	}

	public void setRgDtEmissaoFilho(Date rgDtEmissaoFilho) {
		this.rgDtEmissaoFilho = rgDtEmissaoFilho;
	}

	public String getRgOrgaoExpedidor() {
		return rgOrgaoExpedidor;
	}

	public void setRgOrgaoExpedidor(String rgOrgaoExpedidor) {
		this.rgOrgaoExpedidor = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(rgOrgaoExpedidor);
	}

	public String getNumeroCertidaoNascimento() {
		return numeroCertidaoNascimento;
	}

	public void setNumeroCertidaoNascimento(String numeroCertidaoNascimento) {
		this.numeroCertidaoNascimento = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(numeroCertidaoNascimento);
	}

	public Date getDtCertidadoNascimento() {
		return dtCertidadoNascimento;
	}

	public void setDtCertidadoNascimento(Date dtCertidadoNascimento) {
		this.dtCertidadoNascimento = dtCertidadoNascimento;
	}

	public String getCartorioCertidadoNascimento() {
		return cartorioCertidadoNascimento;
	}

	public void setCartorioCertidadoNascimento(String cartorioCertidadoNascimento) {
		this.cartorioCertidadoNascimento = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cartorioCertidadoNascimento);
	}

	public String getLivroCertidaoNascimento() {
		return livroCertidaoNascimento;
	}

	public void setLivroCertidaoNascimento(String livroCertidaoNascimento) {
		this.livroCertidaoNascimento = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(livroCertidaoNascimento);
	}

	public String getFolhaCertidaoNascimento() {
		return folhaCertidaoNascimento;
	}

	public void setFolhaCertidaoNascimento(String folhaCertidaoNascimento) {
		this.folhaCertidaoNascimento = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(folhaCertidaoNascimento);
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
		this.motivoCadastro = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(motivoCadastro);
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
		this.motivoCancelamento = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(motivoCancelamento);
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

	public TiposDeFiliacao getIdTipoFiliacaoFk() {
		return idTipoFiliacaoFk;
	}

	public void setIdTipoFiliacaoFk(TiposDeFiliacao idTipoFiliacaoFk) {
		this.idTipoFiliacaoFk = idTipoFiliacaoFk;
	}


}
