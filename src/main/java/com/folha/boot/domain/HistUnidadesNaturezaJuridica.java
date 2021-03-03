package com.folha.boot.domain;

import java.util.Date;
import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "hist_unidades_natureza_juridica")
public class HistUnidadesNaturezaJuridica extends AbstractEntity<Long> {

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cancelamento")
	private Date dtCancelamento;

	@Column(name="id_natureza_juridica_fk", insertable = false, updatable = false)
	private Long idNaturezaJuridicaFk;

	@Column(name="motivo_cadastro")
	private String motivoCadastro;

	@Column(name="motivo_cancelamento")
	private String motivoCancelamento;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk", insertable = false, updatable = false)
	private PessoaOperadores pessoaOperadore1;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk", insertable = false, updatable = false)
	private PessoaOperadores pessoaOperadore2;

	//bi-directional many-to-one association to UnidadesNaturezaJuridica
	@ManyToOne
	@JoinColumn(name="id_unidade_de_saude_fk", insertable = false, updatable = false)
	private UnidadesNaturezaJuridica unidadesNaturezaJuridica;

	public HistUnidadesNaturezaJuridica() {
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

	public Long getIdNaturezaJuridicaFk() {
		return this.idNaturezaJuridicaFk;
	}

	public void setIdNaturezaJuridicaFk(Long idNaturezaJuridicaFk) {
		this.idNaturezaJuridicaFk = idNaturezaJuridicaFk;
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

	public UnidadesNaturezaJuridica getUnidadesNaturezaJuridica() {
		return this.unidadesNaturezaJuridica;
	}

	public void setUnidadesNaturezaJuridica(UnidadesNaturezaJuridica unidadesNaturezaJuridica) {
		this.unidadesNaturezaJuridica = unidadesNaturezaJuridica;
	}

}
