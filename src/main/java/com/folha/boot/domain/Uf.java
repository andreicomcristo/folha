package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "uf")
public class Uf extends AbstractEntity<Long> {

	@Column(name = "sigla_uf", nullable = false, length = 300)
	private String siglaUf;

	@Basic(optional = false)
	@Column(name = "nome_uf", nullable = false, length = 300)
	private String nomeUf;

	@OneToMany(mappedBy = "idUfFk")
	private List<PessoaDocumentosConselho> pessoaDocumentosConselhoList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUfFk")
	private List<Cidades> cidadesList;

	@OneToMany(mappedBy = "idUfEmissao")
	private List<PessoaDocumentosRg> pessoaDocumentosRgList;

	public String getSiglaUf() {
		return siglaUf;
	}

	public void setSiglaUf(String siglaUf) {
		this.siglaUf = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaUf);
	}

	public String getNomeUf() {
		return nomeUf;
	}

	public void setNomeUf(String nomeUf) {
		this.nomeUf = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeUf);
	}

	public List<PessoaDocumentosConselho> getPessoaDocumentosConselhoList() {
		return pessoaDocumentosConselhoList;
	}

	public void setPessoaDocumentosConselhoList(List<PessoaDocumentosConselho> pessoaDocumentosConselhoList) {
		this.pessoaDocumentosConselhoList = pessoaDocumentosConselhoList;
	}

	public List<Cidades> getCidadesList() {
		return cidadesList;
	}

	public void setCidadesList(List<Cidades> cidadesList) {
		this.cidadesList = cidadesList;
	}

	public List<PessoaDocumentosRg> getPessoaDocumentosRgList() {
		return pessoaDocumentosRgList;
	}

	public void setPessoaDocumentosRgList(List<PessoaDocumentosRg> pessoaDocumentosRgList) {
		this.pessoaDocumentosRgList = pessoaDocumentosRgList;
	}

}
