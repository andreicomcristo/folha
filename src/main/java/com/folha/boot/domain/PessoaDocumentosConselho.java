package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_documentos_conselho")
public class PessoaDocumentosConselho extends AbstractEntity<Long> {
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_emissao")
	private Date dtEmissao;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_validade")
	private Date dtValidade;

	@Column(name="numero_conselho")
	private String numeroConselho;

	//bi-directional many-to-one association to Conselho
	@ManyToOne
	@JoinColumn(name="id_conselhos_fk", insertable = false, updatable = false)
	private Conselhos conselho;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa_fk", insertable = false, updatable = false)
	private Pessoa pessoa;

	//bi-directional many-to-one association to Uf
	@ManyToOne
	@JoinColumn(name="id_uf_fk", insertable = false, updatable = false)
	private Uf uf;

	public PessoaDocumentosConselho() {
	}


	public Date getDtEmissao() {
		return this.dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public Date getDtValidade() {
		return this.dtValidade;
	}

	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}

	public String getNumeroConselho() {
		return this.numeroConselho;
	}

	public void setNumeroConselho(String numeroConselho) {
		this.numeroConselho = numeroConselho;
	}

	public Conselhos getConselho() {
		return this.conselho;
	}

	public void setConselho(Conselhos conselho) {
		this.conselho = conselho;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Uf getUf() {
		return this.uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

}
