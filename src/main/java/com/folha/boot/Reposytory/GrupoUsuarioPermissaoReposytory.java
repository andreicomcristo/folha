package com.folha.boot.Reposytory;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.seguranca.GrupoUsuario;
import com.folha.boot.domain.seguranca.GrupoUsuarioPermissao;

@Repository
public interface GrupoUsuarioPermissaoReposytory extends JpaRepository<GrupoUsuarioPermissao, Long> {
	
	public List<GrupoUsuarioPermissao> findAllByOrderByIdGrupoUsuarioFkNomeAscIdPermissaoFkNomeAsc( );
	
	public List<GrupoUsuarioPermissao> findByIdGrupoUsuarioFkNomeOrderByIdGrupoUsuarioFkNomeAscIdPermissaoFkNomeAsc(String nome);
	
	//Usado no ACL
	public List<GrupoUsuarioPermissao> findByIdGrupoUsuarioFkOrderByIdPermissaoFkAsc(GrupoUsuario grupoUsuario);
	
	
	public Page<GrupoUsuarioPermissao> findAllByOrderByIdGrupoUsuarioFkNomeAscIdPermissaoFkNomeAsc( final Pageable pageable);
	
	public Page<GrupoUsuarioPermissao> findByIdGrupoUsuarioFkNomeOrderByIdGrupoUsuarioFkNomeAscIdPermissaoFkNomeAsc(String nome, final Pageable pageable);
	
	
}
