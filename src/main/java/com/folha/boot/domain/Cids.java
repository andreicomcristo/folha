package com.folha.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "cids")
public class Cids extends AbstractEntity<Long> {

	@Column(name = "id")
	private Long id;
	@Basic(optional = false)
	@Column(name = "cod_cid")
	private String codCid;
	@Column(name = "descricao_cid")
	
	private String descricaoCid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodCid() {
		return codCid;
	}
	public void setCodCid(String codCid) {
		this.codCid = codCid;
	}
	public String getDescricaoCid() {
		return descricaoCid;
	}
	public void setDescricaoCid(String descricaoCid) {
		this.descricaoCid = descricaoCid;
	}
	
}
