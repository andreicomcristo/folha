package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "habilitacao_categorias")
public class HabilitacaoCategorias extends AbstractEntity<Long> {

	@Column(name = "nome_habilitacao_categoria", nullable = false, length = 30)
	private String nomeHabilitacaoCategoria;

	@Column(name = "descricao_habilitacao_categoria", length = 300)
	private String descricaoHabilitacaoCategoria;

	@OneToMany(mappedBy = "idHabilitacaoCategoriasFk")
	private List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoCollection;

	public String getNomeHabilitacaoCategoria() {
		return nomeHabilitacaoCategoria;
	}

	public void setNomeHabilitacaoCategoria(String nomeHabilitacaoCategoria) {
		this.nomeHabilitacaoCategoria = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeHabilitacaoCategoria);
	}

	public String getDescricaoHabilitacaoCategoria() {
		return descricaoHabilitacaoCategoria;
	}

	public void setDescricaoHabilitacaoCategoria(String descricaoHabilitacaoCategoria) {
		this.descricaoHabilitacaoCategoria = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoHabilitacaoCategoria);
	}

	public List<PessoaDocumentosHabilitacao> getPessoaDocumentosHabilitacaoCollection() {
		return pessoaDocumentosHabilitacaoCollection;
	}

	public void setPessoaDocumentosHabilitacaoCollection(
			List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoCollection) {
		this.pessoaDocumentosHabilitacaoCollection = pessoaDocumentosHabilitacaoCollection;
	}

}
