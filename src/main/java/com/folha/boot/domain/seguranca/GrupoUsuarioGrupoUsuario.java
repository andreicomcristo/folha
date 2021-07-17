package com.folha.boot.domain.seguranca;



import javax.persistence.*;

import com.folha.boot.domain.AbstractEntity;


@SuppressWarnings("serial")
@Entity
@Table(name = "grupo_usuario_grupo_usuario")
public class GrupoUsuarioGrupoUsuario extends AbstractEntity<Long> { 

	@JoinColumn(name = "id_grupo_usuario_compativel_fk", referencedColumnName = "id")
    @ManyToOne
    private GrupoUsuario idGrupoUsuarioCompativelFk;
    @JoinColumn(name = "id_grupo_usuario_fk", referencedColumnName = "id")
    @ManyToOne
    private GrupoUsuario idGrupoUsuarioFk;

    public GrupoUsuarioGrupoUsuario() {
    }

	public GrupoUsuario getIdGrupoUsuarioCompativelFk() {
		return idGrupoUsuarioCompativelFk;
	}

	public void setIdGrupoUsuarioCompativelFk(GrupoUsuario idGrupoUsuarioCompativelFk) {
		this.idGrupoUsuarioCompativelFk = idGrupoUsuarioCompativelFk;
	}

	public GrupoUsuario getIdGrupoUsuarioFk() {
		return idGrupoUsuarioFk;
	}

	public void setIdGrupoUsuarioFk(GrupoUsuario idGrupoUsuarioFk) {
		this.idGrupoUsuarioFk = idGrupoUsuarioFk;
	}
    
    
    
}
