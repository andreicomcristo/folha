package com.folha.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

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
	@Type(type="org.hibernate.type.BinaryType")
	@Column(name = "fotografia")
	private byte[] fotografia;
	//private String fotografia;
	
	
	
	public PessoaFotos() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
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
