package com.folha.boot.domain.seguranca;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.domain.AbstractEntity;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.Unidades;

@SuppressWarnings("serial")
@Entity
@Table(name = "perfil")
public class Perfil extends AbstractEntity<Long> { 

	@JoinColumn(name = "id_grupo_usuario_fk", referencedColumnName = "id")
    @ManyToOne
    private GrupoUsuario idGrupoUsuarioFk;
    @JoinColumn(name = "id_operador_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorFk;
    @JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeFk;
	public GrupoUsuario getIdGrupoUsuarioFk() {
		return idGrupoUsuarioFk;
	}
	public void setIdGrupoUsuarioFk(GrupoUsuario idGrupoUsuarioFk) {
		this.idGrupoUsuarioFk = idGrupoUsuarioFk;
	}
	public PessoaOperadores getIdOperadorFk() {
		return idOperadorFk;
	}
	public void setIdOperadorFk(PessoaOperadores idOperadorFk) {
		this.idOperadorFk = idOperadorFk;
	}
	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}
	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
	}
    
    
    
}
