package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipos_de_grupo_usuario")
public class TiposDeGrupoUsuario extends AbstractEntity<Long> {

	@Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idTipoGrupoUsuarioFk")
    private List<GrupoUsuario> grupoUsuarioList;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nome);
	}
	public List<GrupoUsuario> getGrupoUsuarioList() {
		return grupoUsuarioList;
	}
	public void setGrupoUsuarioList(List<GrupoUsuario> grupoUsuarioList) {
		this.grupoUsuarioList = grupoUsuarioList;
	}
    
    
}
