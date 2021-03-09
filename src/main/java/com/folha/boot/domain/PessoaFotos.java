package com.folha.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_fotos")
public class PessoaFotos extends AbstractEntity<Long> {

	public PessoaFotos(Pessoa pessoa, byte[] data) {
		super();
		this.idPessoaFk = pessoa;
		this.fotografia = data;
	}
	
	
	@Lob
	@Column(name = "fotografia")
	private byte[] fotografia;

	@JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Pessoa idPessoaFk;

	public byte[] getFotografia() {
		return fotografia;
	}

	public void setFotografia(byte[] fotografia) {
		this.fotografia = fotografia;
	}

	public Pessoa getIdPessoaFk() {
		return idPessoaFk;
	}

	public void setIdPessoaFk(Pessoa idPessoaFk) {
		this.idPessoaFk = idPessoaFk;
	}


}
