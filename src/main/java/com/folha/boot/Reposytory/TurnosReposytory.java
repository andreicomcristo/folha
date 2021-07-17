package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Turnos;

@Repository
public interface TurnosReposytory extends JpaRepository<Turnos, Long>{

	public List<Turnos> findAllByOrderByNomeTurnoAsc();
	public Turnos findFirstByNomeTurnoOrderByNomeTurnoAsc(String nome);
	
	
	public Page<Turnos> findAllByOrderByNomeTurnoAsc( final Pageable page);
	
	public Page<Turnos> findByDescricaoTurnoContainingOrderByNomeTurnoAsc( String nome, final Pageable page);
	
	
}
