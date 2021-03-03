package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_documentos_conselho")
public class PessoaDocumentosConselho extends AbstractEntity<Long> {

	@Basic(optional = false)
	@Column(name = "numero_conselho")
	private String numeroConselho;
	@Column(name = "dt_emissao")
	@Temporal(TemporalType.DATE)
	private Date dtEmissao;
	@Column(name = "dt_validade")
	@Temporal(TemporalType.DATE)
	private Date dtValidade;
	@JoinColumn(name = "id_conselhos_fk")
	@ManyToOne
	private Conselhos idConselhosFk;
	@JoinColumn(name = "id_pessoa_fk")
	@ManyToOne(optional = false)
	private Pessoa idPessoaFk;
	@JoinColumn(name = "id_uf_fk")
	@ManyToOne
	private Uf idUfFk;

	public PessoaDocumentosConselho() {
		super();
	}

	public PessoaDocumentosConselho(String numeroConselho, Date dtEmissao, Date dtValidade, Conselhos idConselhosFk,
			Pessoa idPessoaFk, Uf idUfFk) {
		super();
		this.numeroConselho = numeroConselho;
		this.dtEmissao = dtEmissao;
		this.dtValidade = dtValidade;
		this.idConselhosFk = idConselhosFk;
		this.idPessoaFk = idPessoaFk;
		this.idUfFk = idUfFk;
	}

	public String getNumeroConselho() {
		return numeroConselho;
	}

	public void setNumeroConselho(String numeroConselho) {
		this.numeroConselho = numeroConselho;
	}

	public Date getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public Date getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}

	public Conselhos getIdConselhosFk() {
		return idConselhosFk;
	}

	public void setIdConselhosFk(Conselhos idConselhosFk) {
		this.idConselhosFk = idConselhosFk;
	}

	public Pessoa getIdPessoaFk() {
		return idPessoaFk;
	}

	public void setIdPessoaFk(Pessoa idPessoaFk) {
		this.idPessoaFk = idPessoaFk;
	}

	public Uf getIdUfFk() {
		return idUfFk;
	}

	public void setIdUfFk(Uf idUfFk) {
		this.idUfFk = idUfFk;
	}

}
