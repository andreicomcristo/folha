package com.folha.boot.domain.testeIlo;


import java.util.List;

import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Cids;
import com.folha.boot.domain.seguranca.GrupoUsuario;

public class ObjetoPrincipal {
	
	List<Cids> listaCids;
	List<Cidades> listaCidades;
	List<GrupoUsuario> listaGrupoUsuario;
	
	public List<Cids> getListaCids() {
		return listaCids;
	}
	public void setListaCids(List<Cids> listaCids) {
		this.listaCids = listaCids;
	}
	public List<Cidades> getListaCidades() {
		return listaCidades;
	}
	public void setListaCidades(List<Cidades> listaCidades) {
		this.listaCidades = listaCidades;
	}
	public List<GrupoUsuario> getListaGrupoUsuario() {
		return listaGrupoUsuario;
	}
	public void setListaGrupoUsuario(List<GrupoUsuario> listaGrupoUsuario) {
		this.listaGrupoUsuario = listaGrupoUsuario;
	}
	
	
}
