package com.folha.boot.domain;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

import java.util.List;

/**
 * The persistent class for the funcionarios_capacitacoes database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "funcionarios_capacitacoes")

public class FuncionariosCapacitacoes extends AbstractEntity<Long> {

	@Column(name = "nome_habilitacao_categoria", nullable = false, length = 30)
	private String nomeHabilitacaoCategoria;

	@Column(name = "descricao_habilitacao_categoria", length = 300)
	private String descricaoHabilitacaoCategoria;

	@OneToMany(mappedBy = "idHabilitacaoCategoriasFk")
	private List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoList;

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

	public List<PessoaDocumentosHabilitacao> getPessoaDocumentosHabilitacaoList() {
		return pessoaDocumentosHabilitacaoList;
	}

	public void setPessoaDocumentosHabilitacaoList(List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoList) {
		this.pessoaDocumentosHabilitacaoList = pessoaDocumentosHabilitacaoList;
	}

}