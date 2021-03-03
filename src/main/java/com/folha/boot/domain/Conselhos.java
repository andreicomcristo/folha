package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "conselhos")
public class Conselhos extends AbstractEntity<Long> {

	@Column(name = "nome_conselho", nullable = false, length = 100)
	private String nomeConselho;

	@Column(name = "descricao_conselho", length = 300)
	private String descricaoConselho;

	@OneToMany(mappedBy = "idConselhosFk")
	private List<PessoaDocumentosConselho> pessoaDocumentosConselhoList;

	public String getNomeConselho() {
		return nomeConselho;
	}

	public void setNomeConselho(String nomeConselho) {
		this.nomeConselho = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeConselho);
	}

	public String getDescricaoConselho() {
		return descricaoConselho;
	}

	public void setDescricaoConselho(String descricaoConselho) {
		this.descricaoConselho = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoConselho);
	}

	public List<PessoaDocumentosConselho> getPessoaDocumentosConselhoList() {
		return pessoaDocumentosConselhoList;
	}

	public void setPessoaDocumentosConselhoList(List<PessoaDocumentosConselho> pessoaDocumentosConselhoList) {
		this.pessoaDocumentosConselhoList = pessoaDocumentosConselhoList;
	}
	
}
