package com.folha.boot.Reposytory;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.seguranca.GrupoUsuario;
import com.folha.boot.domain.seguranca.GrupoUsuarioGrupoUsuario;

@Repository
public interface GrupoUsuarioGrupoUsuarioReposytory extends JpaRepository<GrupoUsuarioGrupoUsuario, Long> {
	
	public List<GrupoUsuarioGrupoUsuario> findAllByOrderByIdGrupoUsuarioFkNomeAscIdGrupoUsuarioCompativelFkNomeAsc( );
	
	public List<GrupoUsuarioGrupoUsuario> findByIdGrupoUsuarioFkNomeContainingOrderByIdGrupoUsuarioFkNomeAscIdGrupoUsuarioCompativelFkNomeAsc(String nome);
	
	public List<GrupoUsuarioGrupoUsuario> findByIdGrupoUsuarioFkOrderByIdGrupoUsuarioFkNomeAscIdGrupoUsuarioCompativelFkNomeAsc(GrupoUsuario grupoUsuario);
	
	public List<GrupoUsuarioGrupoUsuario> findByIdGrupoUsuarioFkAndIdGrupoUsuarioCompativelFkOrderByIdGrupoUsuarioFkNomeAscIdGrupoUsuarioCompativelFkNomeAsc(GrupoUsuario grupoUsuario, GrupoUsuario grupoUsuarioCompativel);
	
	
	public Page<GrupoUsuarioGrupoUsuario> findAllByOrderByIdGrupoUsuarioFkNomeAscIdGrupoUsuarioCompativelFkNomeAsc( final Pageable pageable);
	
	public Page<GrupoUsuarioGrupoUsuario> findByIdGrupoUsuarioFkNomeContainingOrderByIdGrupoUsuarioFkNomeAscIdGrupoUsuarioCompativelFkNomeAsc(String nome, final Pageable pageable);
	
	
}
