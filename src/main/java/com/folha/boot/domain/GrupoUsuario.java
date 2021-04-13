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
    
    @JoinColumn(name = "id_tipo_grupo_usuario_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeGrupoUsuario idTipoGrupoUsuarioFk;
    
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
	public TiposDeGrupoUsuario getIdTipoGrupoUsuarioFk() {
		return idTipoGrupoUsuarioFk;
	}
	public void setIdTipoGrupoUsuarioFk(TiposDeGrupoUsuario idTipoGrupoUsuarioFk) {
		this.idTipoGrupoUsuarioFk = idTipoGrupoUsuarioFk;
	}

    
}
