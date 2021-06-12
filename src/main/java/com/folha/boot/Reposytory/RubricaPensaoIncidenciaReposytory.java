package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.RubricaPensaoIncidencia;


@Repository
public interface RubricaPensaoIncidenciaReposytory extends JpaRepository<RubricaPensaoIncidencia, Long>{

	public List<RubricaPensaoIncidencia> findAllByOrderByNomeAsc();

	public List<RubricaPensaoIncidencia> findByNomeContainingOrderByNomeAsc(String nome);
	
	
	public Page<RubricaPensaoIncidencia> findAllByOrderByNomeAsc( final Pageable page);
	
	public Page<RubricaPensaoIncidencia> findByNomeContainingOrderByNomeAsc( String nome, final Pageable page);
	
}
