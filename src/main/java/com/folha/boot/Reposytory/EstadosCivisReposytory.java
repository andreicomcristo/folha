package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.EstadosCivis;

@Repository
public interface EstadosCivisReposytory extends JpaRepository<EstadosCivis, Long> {

	public List<EstadosCivis> findAllByOrderByNomeEstadoCivilAsc();
	
	public List<EstadosCivis> findByNomeEstadoCivilContainingOrderByNomeEstadoCivilAsc(String estadosCivis);
}
