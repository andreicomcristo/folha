package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "perfil")
public class Perfil extends AbstractEntity<Long> {

	@Basic(optional = false)
    @Column(name = "nome_perfil")
    private String nomePerfil;
    
	@Basic(optional = false)
    @Column(name = "descricao_perfil")
    private String descricaoPerfil;
    
    @OneToMany(mappedBy = "idPrivilegioFk")
    private List<PessoaOperadores> pessoaOperadoresList;
	
    public String getNomePerfil() {
		return nomePerfil;
	}
	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}
	public String getDescricaoPerfil() {
		return descricaoPerfil;
	}
	public void setDescricaoPerfil(String descricaoPerfil) {
		this.descricaoPerfil = descricaoPerfil;
	}
	public List<PessoaOperadores> getPessoaOperadoresList() {
		return pessoaOperadoresList;
	}
	public void setPessoaOperadoresList(List<PessoaOperadores> pessoaOperadoresList) {
		this.pessoaOperadoresList = pessoaOperadoresList;
	}

    
}
