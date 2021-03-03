package com.folha.boot.domain;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_documentos")
public class PessoaDocumentos extends AbstractEntity<Long> {
	@Column(name = "numero_documento", length = 100)
	private String numeroDocumento;

	@JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
	@ManyToOne
	private Pessoa idPessoaFk;

	@JoinColumn(name = "id_tipos_de_documento_fk", referencedColumnName = "id")
	@ManyToOne
	private TiposDeDocumento idTiposDeDocumentoFk;

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(numeroDocumento);
	}

	public Pessoa getIdPessoaFk() {
		return idPessoaFk;
	}

	public void setIdPessoaFk(Pessoa idPessoaFk) {
		this.idPessoaFk = idPessoaFk;
	}

	public TiposDeDocumento getIdTiposDeDocumentoFk() {
		return idTiposDeDocumentoFk;
	}

	public void setIdTiposDeDocumentoFk(TiposDeDocumento idTiposDeDocumentoFk) {
		this.idTiposDeDocumentoFk = idTiposDeDocumentoFk;
	}
	
}
