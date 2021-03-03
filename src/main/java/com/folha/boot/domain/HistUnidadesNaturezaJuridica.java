package com.folha.boot.domain;

import java.util.Date;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "hist_unidades_natureza_juridica")
public class HistUnidadesNaturezaJuridica extends AbstractEntity<Long> {

	@Column(name = "id_natureza_juridica_fk", nullable = false)
	private long idNaturezaJuridicaFk;

	@Basic(optional = false)
	@Column(name = "dt_cadastro", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtCadastro;

	@Column(name = "motivo_cadastro", length = 150)
	private String motivoCadastro;

	@Column(name = "dt_cancelamento")
	@Temporal(TemporalType.DATE)
	private Date dtCancelamento;

	@Column(name = "motivo_cancelamento", length = 150)
	private String motivoCancelamento;

	@JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private PessoaOperadores idOperadorCadastroFk;

	@JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
	@ManyToOne
	private PessoaOperadores idOperadorCancelamentoFk;

	@JoinColumn(name = "id_unidade_de_saude_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private UnidadesNaturezaJuridica idUnidadeDeSaudeFk;

	public long getIdNaturezaJuridicaFk() {
		return idNaturezaJuridicaFk;
	}

	public void setIdNaturezaJuridicaFk(long idNaturezaJuridicaFk) {
		this.idNaturezaJuridicaFk = idNaturezaJuridicaFk;
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

	public UnidadesNaturezaJuridica getIdUnidadeDeSaudeFk() {
		return idUnidadeDeSaudeFk;
	}

	public void setIdUnidadeDeSaudeFk(UnidadesNaturezaJuridica idUnidadeDeSaudeFk) {
		this.idUnidadeDeSaudeFk = idUnidadeDeSaudeFk;
	}

}
