package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;


@SuppressWarnings("serial")
@Entity
@Table(name = "hist_unidades_regime")
public class HistUnidadesRegime extends AbstractEntity<Long> {
	@Column(name = "dt_cadastro", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtCadastro;

	@Column(name = "motivo_cadastro", length = 300)
	private String motivoCadastro;

	@Column(name = "dt_cancelamento")
	@Temporal(TemporalType.DATE)
	private Date dtCancelamento;

	@Column(name = "motivo_cancelamento", length = 300)
	private String motivoCancelamento;

	@JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private PessoaOperadores idOperadorCadastroFk;

	@JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
	@ManyToOne
	private PessoaOperadores idOperadorCancelamentoFk;

	@JoinColumn(name = "id_unidade_de_saude_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Unidades idUnidadeDeSaudeFk;

	@JoinColumn(name = "id_unidade_regime_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private UnidadesRegime idUnidadeRegimeFk;

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

	public Unidades getIdUnidadeDeSaudeFk() {
		return idUnidadeDeSaudeFk;
	}

	public void setIdUnidadeDeSaudeFk(Unidades idUnidadeDeSaudeFk) {
		this.idUnidadeDeSaudeFk = idUnidadeDeSaudeFk;
	}

	public UnidadesRegime getIdUnidadeRegimeFk() {
		return idUnidadeRegimeFk;
	}

	public void setIdUnidadeRegimeFk(UnidadesRegime idUnidadeRegimeFk) {
		this.idUnidadeRegimeFk = idUnidadeRegimeFk;
	}

}
