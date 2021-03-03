package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;
@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_documentos_rg")
public class PessoaDocumentosRg extends AbstractEntity<Long> {

	@Temporal(TemporalType.DATE)
	@Column(name="dt_emissao")
	private Date dtEmissao;

	@Column(name="id_pessoa_fk", insertable = false, updatable = false)
	private Long idPessoaFk;

	@Column(name="rg_numero")
	private String rgNumero;

	@Column(name="rg_orgao_emissor")
	private String rgOrgaoEmissor;

	//bi-directional many-to-one association to Uf
	@ManyToOne
	@JoinColumn(name="id_uf_emissao")
	private Uf uf;

	public PessoaDocumentosRg() {
	}

	public Date getDtEmissao() {
		return this.dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public Long getIdPessoaFk() {
		return this.idPessoaFk;
	}

	public void setIdPessoaFk(Long idPessoaFk) {
		this.idPessoaFk = idPessoaFk;
	}

	public String getRgNumero() {
		return this.rgNumero;
	}

	public void setRgNumero(String rgNumero) {
		this.rgNumero = rgNumero;
	}

	public String getRgOrgaoEmissor() {
		return this.rgOrgaoEmissor;
	}

	public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
		this.rgOrgaoEmissor = rgOrgaoEmissor;
	}

	public Uf getUf() {
		return this.uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

}
