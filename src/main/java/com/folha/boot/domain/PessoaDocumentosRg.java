package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dtEmissao;

	@JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Pessoa idPessoaFk;

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

	
	public Uf getIdUfEmissao() {
		return idUfEmissao;
	}

	public void setIdUfEmissao(Uf idUfEmissao) {
		this.idUfEmissao = idUfEmissao;
	}
	
	public Pessoa getIdPessoaFk() {
		return idPessoaFk;
	}

	public void setIdPessoaFk(Pessoa idPessoaFk) {
		this.idPessoaFk = idPessoaFk;
	}

}
