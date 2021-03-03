package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "habilitacao_categorias")
public class HabilitacaoCategorias extends AbstractEntity<Long> {
	
	@Column(name="descricao_habilitacao_categoria")
	private String descricaoHabilitacaoCategoria;

	@Column(name="nome_habilitacao_categoria")
	private String nomeHabilitacaoCategoria;

	//bi-directional many-to-one association to PessoaDocumentosHabilitacao
	@OneToMany(mappedBy="habilitacaoCategoria")
	private List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaos;

	public HabilitacaoCategorias() {
	}

	public String getDescricaoHabilitacaoCategoria() {
		return this.descricaoHabilitacaoCategoria;
	}

	public void setDescricaoHabilitacaoCategoria(String descricaoHabilitacaoCategoria) {
		this.descricaoHabilitacaoCategoria = descricaoHabilitacaoCategoria;
	}

	public String getNomeHabilitacaoCategoria() {
		return this.nomeHabilitacaoCategoria;
	}

	public void setNomeHabilitacaoCategoria(String nomeHabilitacaoCategoria) {
		this.nomeHabilitacaoCategoria = nomeHabilitacaoCategoria;
	}

	public List<PessoaDocumentosHabilitacao> getPessoaDocumentosHabilitacaos() {
		return this.pessoaDocumentosHabilitacaos;
	}

	public void setPessoaDocumentosHabilitacaos(List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaos) {
		this.pessoaDocumentosHabilitacaos = pessoaDocumentosHabilitacaos;
	}

	public PessoaDocumentosHabilitacao addPessoaDocumentosHabilitacao(PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao) {
		getPessoaDocumentosHabilitacaos().add(pessoaDocumentosHabilitacao);
		pessoaDocumentosHabilitacao.setHabilitacaoCategoria(this);

		return pessoaDocumentosHabilitacao;
	}

	public PessoaDocumentosHabilitacao removePessoaDocumentosHabilitacao(PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao) {
		getPessoaDocumentosHabilitacaos().remove(pessoaDocumentosHabilitacao);
		pessoaDocumentosHabilitacao.setHabilitacaoCategoria(null);

		return pessoaDocumentosHabilitacao;
	}

}
