package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipos_de_documento")
public class TiposDeDocumento extends AbstractEntity<Long> {

	@Column(name = "sigla_documento", length = 300)
	private String siglaDocumento;

	@Column(name = "nome_documento", length = 300)
	private String nomeDocumento;

	@OneToMany(mappedBy = "idTiposDeDocumentoFk")
	private List<PessoaDocumentos> pessoaDocumentosList;

	public String getSiglaDocumento() {
		return siglaDocumento;
	}

	public void setSiglaDocumento(String siglaDocumento) {
		this.siglaDocumento = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaDocumento);
	}

	public String getNomeDocumento() {
		return nomeDocumento;
	}

	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeDocumento);
	}

	public List<PessoaDocumentos> getPessoaDocumentosList() {
		return pessoaDocumentosList;
	}

	public void setPessoaDocumentosList(List<PessoaDocumentos> pessoaDocumentosList) {
		this.pessoaDocumentosList = pessoaDocumentosList;
	}

}
