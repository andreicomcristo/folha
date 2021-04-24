package com.folha.boot.domain.seguranca;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.folha.boot.domain.AbstractEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "permissao")
public class Permissao extends AbstractEntity<Long> {

	@Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idPermissaoFk")
    private List<GrupoUsuarioPermissao> grupoUsuarioPermissaoList;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<GrupoUsuarioPermissao> getGrupoUsuarioPermissaoList() {
		return grupoUsuarioPermissaoList;
	}
	public void setGrupoUsuarioPermissaoList(List<GrupoUsuarioPermissao> grupoUsuarioPermissaoList) {
		this.grupoUsuarioPermissaoList = grupoUsuarioPermissaoList;
	}
   
	
	
	
}
