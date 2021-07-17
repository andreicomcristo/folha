package com.folha.boot.domain.seguranca;



import javax.persistence.*;

import com.folha.boot.domain.AbstractEntity;


@SuppressWarnings("serial")
@Entity
@Table(name = "grupo_usuario_permissao")
public class GrupoUsuarioPermissao extends AbstractEntity<Long> { 

	@JoinColumn(name = "id_grupo_usuario_fk", referencedColumnName = "id")
    @ManyToOne
    private GrupoUsuario idGrupoUsuarioFk;
    @JoinColumn(name = "id_permissao_fk", referencedColumnName = "id")
    @ManyToOne
    private Permissao idPermissaoFk;
	public GrupoUsuario getIdGrupoUsuarioFk() {
		return idGrupoUsuarioFk;
	}
	public void setIdGrupoUsuarioFk(GrupoUsuario idGrupoUsuarioFk) {
		this.idGrupoUsuarioFk = idGrupoUsuarioFk;
	}
	public Permissao getIdPermissaoFk() {
		return idPermissaoFk;
	}
	public void setIdPermissaoFk(Permissao idPermissaoFk) {
		this.idPermissaoFk = idPermissaoFk;
	}

    
}
