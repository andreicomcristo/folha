package com.folha.boot.domain;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;
@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_documentos_titulo")
public class PessoaDocumentosTitulo extends AbstractEntity<Long> {

	@Column(name = "numero_titulo", nullable = false, length = 100)
    private String numeroTitulo;
    
	@Column(name = "zona", length = 100)
    private String zona;
    
	@Column(name = "secao", length = 100)
    private String secao;
    
	@JoinColumn(name = "id_cidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Cidades idCidadeFk;
    
	@JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa idPessoaFk;

	public String getNumeroTitulo() {
		return numeroTitulo;
	}

	public void setNumeroTitulo(String numeroTitulo) {
		this.numeroTitulo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(numeroTitulo);
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(zona);
	}

	public String getSecao() {
		return secao;
	}

	public void setSecao(String secao) {
		this.secao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(secao);
	}

	public Cidades getIdCidadeFk() {
		return idCidadeFk;
	}

	public void setIdCidadeFk(Cidades idCidadeFk) {
		this.idCidadeFk = idCidadeFk;
	}

	public Pessoa getIdPessoaFk() {
		return idPessoaFk;
	}

	public void setIdPessoaFk(Pessoa idPessoaFk) {
		this.idPessoaFk = idPessoaFk;
	}
	
    
}
