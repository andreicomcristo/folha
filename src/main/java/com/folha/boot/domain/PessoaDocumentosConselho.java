package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_documentos_conselho")
public class PessoaDocumentosConselho extends AbstractEntity<Long> {
	@Column(name = "numero_conselho", nullable = false, length = 100)
    private String numeroConselho;
    
	@Column(name = "dt_emissao")
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dtEmissao;
	
    @Column(name = "dt_validade")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dtValidade;
    @JoinColumn(name = "id_conselhos_fk", referencedColumnName = "id")
    @ManyToOne
    private Conselhos idConselhosFk;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa idPessoaFk;
    @JoinColumn(name = "id_uf_fk", referencedColumnName = "id")
    @ManyToOne
    private Uf idUfFk;
    
	public String getNumeroConselho() {
		return numeroConselho;
	}
	public void setNumeroConselho(String numeroConselho) {
		this.numeroConselho = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(numeroConselho);
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
