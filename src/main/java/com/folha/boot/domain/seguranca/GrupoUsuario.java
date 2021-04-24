package com.folha.boot.domain.seguranca;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.domain.AbstractEntity;
import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "grupo_usuario")
public class GrupoUsuario extends AbstractEntity<Long> { 

	@Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idGrupoUsuarioFk")
    private List<Perfil> perfilList;
    
    @OneToMany(mappedBy = "idGrupoUsuarioFk")
    private List<GrupoUsuarioPermissao> grupoUsuarioPermissaoList;
    
    
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
	public List<GrupoUsuarioPermissao> getGrupoUsuarioPermissaoList() {
		return grupoUsuarioPermissaoList;
	}
	public void setGrupoUsuarioPermissaoList(List<GrupoUsuarioPermissao> grupoUsuarioPermissaoList) {
		this.grupoUsuarioPermissaoList = grupoUsuarioPermissaoList;
	}
	

    
}
