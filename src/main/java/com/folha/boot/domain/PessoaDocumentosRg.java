package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_documentos_rg")
public class PessoaDocumentosRg extends AbstractEntity<Long> {

	@Column(name = "rg_numero", nullable = false, length = 100)
	private String rgNumero;

	@Column(name = "rg_orgao_emissor", length = 100)
	private String rgOrgaoEmissor;

	@Column(name = "dt_emissao")
	@Temporal(TemporalType.DATE)
	private Date dtEmissao;

	@Column(name = "id_pessoa_fk", nullable = false)
	private long idPessoaFk;

	@JoinColumn(name = "id_uf_emissao", referencedColumnName = "id")
	@ManyToOne
	private Uf idUfEmissao;

	public String getRgNumero() {
		return rgNumero;
	}

	public void setRgNumero(String rgNumero) {
		this.rgNumero = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(rgNumero);
	}

	public String getRgOrgaoEmissor() {
		return rgOrgaoEmissor;
	}

	public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
		this.rgOrgaoEmissor = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(rgOrgaoEmissor);
	}

	public Date getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public long getIdPessoaFk() {
		return idPessoaFk;
	}

	public void setIdPessoaFk(long idPessoaFk) {
		this.idPessoaFk = idPessoaFk;
	}

	public Uf getIdUfEmissao() {
		return idUfEmissao;
	}

	public void setIdUfEmissao(Uf idUfEmissao) {
		this.idUfEmissao = idUfEmissao;
	}
	

}
