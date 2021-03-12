package com.folha.boot.domain;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "funcionarios_anexos")

public class FuncionariosAnexos extends AbstractEntity<Long> {

	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dtCadastro;
	@Column(name = "dt_cancelamento")
	@Temporal(TemporalType.DATE)
	private Date dtCancelamento;
	@Column(name = "motivo_cancelamento")
	private String motivoCancelamento;
	@Lob
	@Column(name = "pdf_anexo")
	private byte[] pdfAnexo;
	@JoinColumn(name = "id_pessoa_funcionario_fk", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private PessoaFuncionarios idPessoaFuncionarioFk;
	@JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
	@ManyToOne
	private PessoaOperadores idOperadorCadastroFk;
	@JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
	@ManyToOne
	private PessoaOperadores idOperadorCancelamentoFk;
	@JoinColumn(name = "id_tipo_de_anexo_fk", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private TiposDeAnexo idTipoDeAnexoFk;

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
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

	public byte[] getPdfAnexo() {
		return pdfAnexo;
	}

	public void setPdfAnexo(byte[] pdfAnexo) {
		this.pdfAnexo = pdfAnexo;
	}

	public PessoaFuncionarios getIdPessoaFuncionarioFk() {
		return idPessoaFuncionarioFk;
	}

	public void setIdPessoaFuncionarioFk(PessoaFuncionarios idPessoaFuncionarioFk) {
		this.idPessoaFuncionarioFk = idPessoaFuncionarioFk;
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

	public TiposDeAnexo getIdTipoDeAnexoFk() {
		return idTipoDeAnexoFk;
	}

	public void setIdTipoDeAnexoFk(TiposDeAnexo idTipoDeAnexoFk) {
		this.idTipoDeAnexoFk = idTipoDeAnexoFk;
	}

}