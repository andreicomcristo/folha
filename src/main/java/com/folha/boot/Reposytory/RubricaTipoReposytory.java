package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.RubricaTipo;

@Repository
public interface RubricaTipoReposytory extends JpaRepository<RubricaTipo, Long>{

	
	public List<RubricaTipo> findAllByOrderBySequenciaAsc();
	
	public List<RubricaTipo> findByNomeContainingOrderBySequenciaAsc(String nome);
	
	
	
	public Page<RubricaTipo> findAllByOrderBySequenciaAsc( final Pageable page);
	
	public Page<RubricaTipo> findByNomeContainingOrderBySequenciaAsc( String nome, final Pageable page);
	
}
