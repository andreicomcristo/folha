package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "grupo_usuario")
public class GrupoUsuario extends AbstractEntity<Long> { 

	@Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idGrupoUsuarioFk")
    private List<Perfil> perfilList;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nome);
	}
	public List<Perfil> getPerfilList() {
		return perfilList;
	}
	public void setPerfilList(List<Perfil> perfilList) {
		this.perfilList = perfilList;
	}

    
}
