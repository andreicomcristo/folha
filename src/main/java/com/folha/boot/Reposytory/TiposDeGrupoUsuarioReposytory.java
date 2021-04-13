package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.TiposDeGrupoUsuario;
import com.folha.boot.domain.TiposLogradouro;

@Repository
public interface TiposDeGrupoUsuarioReposytory extends JpaRepository<TiposDeGrupoUsuario, Long> {

	public List<TiposDeGrupoUsuario> findAllByOrderByNomeAsc();

	public List<TiposDeGrupoUsuario> findByNomeContainingOrderByNomeAsc(String nome);
	
	public List<TiposDeGrupoUsuario> findByNomeOrderByNomeAsc(String nomeTipoLogradouro);

}
