package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_documentos_habilitacao")
public class PessoaDocumentosHabilitacao extends AbstractEntity<Long> {

	@Temporal(TemporalType.DATE)
	@Column(name="dt_emissao")
	private Date dtEmissao;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_primeira_habilitacao")
	private Date dtPrimeiraHabilitacao;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_validade")
	private Date dtValidade;

	@Column(name="numero_registro")
	private String numeroRegistro;

	//bi-directional many-to-one association to HabilitacaoCategoria
	@ManyToOne
	@JoinColumn(name="id_habilitacao_categorias_fk", insertable = false, updatable = false)
	private HabilitacaoCategorias habilitacaoCategoria;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa_fk", insertable = false, updatable = false)
	private Pessoa pessoa;

	public PessoaDocumentosHabilitacao() {
	}

	public Date getDtEmissao() {
		return this.dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public Date getDtPrimeiraHabilitacao() {
		return this.dtPrimeiraHabilitacao;
	}

	public void setDtPrimeiraHabilitacao(Date dtPrimeiraHabilitacao) {
		this.dtPrimeiraHabilitacao = dtPrimeiraHabilitacao;
	}

	public Date getDtValidade() {
		return this.dtValidade;
	}

	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}

	public String getNumeroRegistro() {
		return this.numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public HabilitacaoCategorias getHabilitacaoCategoria() {
		return this.habilitacaoCategoria;
	}

	public void setHabilitacaoCategoria(HabilitacaoCategorias habilitacaoCategoria) {
		this.habilitacaoCategoria = habilitacaoCategoria;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
