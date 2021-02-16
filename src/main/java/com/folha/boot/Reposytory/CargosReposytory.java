package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Cargos;

@Repository
public interface CargosReposytory extends JpaRepository<Cargos, Long> {
	
	public List<Cargos> findAllByOrderByNomeCargoAsc();
	
	public List<Cargos> findByNomeCargoContainingOrderByNomeCargoAsc(String nomeCargo); 
}
