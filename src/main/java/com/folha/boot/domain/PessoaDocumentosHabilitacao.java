package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_documentos_habilitacao")
public class PessoaDocumentosHabilitacao extends AbstractEntity<Long> {

	@Column(name = "numero_registro", nullable = false, length = 100)
	private String numeroRegistro;

	@Column(name = "dt_emissao")
	@Temporal(TemporalType.DATE)
	private Date dtEmissao;

	@Column(name = "dt_validade")
	@Temporal(TemporalType.DATE)
	private Date dtValidade;

	@Column(name = "dt_primeira_habilitacao")
	@Temporal(TemporalType.DATE)
	private Date dtPrimeiraHabilitacao;

	@JoinColumn(name = "id_habilitacao_categorias_fk", referencedColumnName = "id")
	@ManyToOne
	private HabilitacaoCategorias idHabilitacaoCategoriasFk;

	@JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
	@ManyToOne
	private Pessoa idPessoaFk;

	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(numeroRegistro);
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

	public Date getDtPrimeiraHabilitacao() {
		return dtPrimeiraHabilitacao;
	}

	public void setDtPrimeiraHabilitacao(Date dtPrimeiraHabilitacao) {
		this.dtPrimeiraHabilitacao = dtPrimeiraHabilitacao;
	}

	public HabilitacaoCategorias getIdHabilitacaoCategoriasFk() {
		return idHabilitacaoCategoriasFk;
	}

	public void setIdHabilitacaoCategoriasFk(HabilitacaoCategorias idHabilitacaoCategoriasFk) {
		this.idHabilitacaoCategoriasFk = idHabilitacaoCategoriasFk;
	}

	public Pessoa getIdPessoaFk() {
		return idPessoaFk;
	}

	public void setIdPessoaFk(Pessoa idPessoaFk) {
		this.idPessoaFk = idPessoaFk;
	}

}
