package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.seguranca.GrupoUsuario;

@Repository
public interface GrupoUsuarioReposytory extends JpaRepository<GrupoUsuario, Long> {
	
	public List<GrupoUsuario> findAllByOrderByNomeAsc();
	
	public Page<GrupoUsuario> findAllByOrderByNomeAsc(final Pageable page);
	
	public List<GrupoUsuario> findByNomeContainingOrderByNomeAsc(String nome);	
	
	
	@Query("select c from GrupoUsuario c " +
            "where cast(c.id as string) like %:pesquisa% or " +
            "c.nome like %:pesquisa%"
            )
	 List<GrupoUsuario> findAllTable(@Param("pesquisa")String pesquisa);

}
