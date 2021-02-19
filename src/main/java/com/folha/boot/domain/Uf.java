package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

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
	private List<PessoaDocumentosConselho> pessoaDocumentosConselhoCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUfFk")
	private List<Cidades> cidadesCollection;

	@OneToMany(mappedBy = "idUfEmissao")
	private List<PessoaDocumentosRg> pessoaDocumentosRgCollection;

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

	public List<PessoaDocumentosConselho> getPessoaDocumentosConselhoCollection() {
		return pessoaDocumentosConselhoCollection;
	}

	public void setPessoaDocumentosConselhoCollection(List<PessoaDocumentosConselho> pessoaDocumentosConselhoCollection) {
		this.pessoaDocumentosConselhoCollection = pessoaDocumentosConselhoCollection;
	}

	public List<Cidades> getCidadesCollection() {
		return cidadesCollection;
	}

	public void setCidadesCollection(List<Cidades> cidadesCollection) {
		this.cidadesCollection = cidadesCollection;
	}

	public List<PessoaDocumentosRg> getPessoaDocumentosRgCollection() {
		return pessoaDocumentosRgCollection;
	}

	public void setPessoaDocumentosRgCollection(List<PessoaDocumentosRg> pessoaDocumentosRgCollection) {
		this.pessoaDocumentosRgCollection = pessoaDocumentosRgCollection;
	}

}
