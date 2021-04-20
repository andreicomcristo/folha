package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Vinculos;

@Repository
public interface VinculosReposytory extends JpaRepository<Vinculos, Long> {

	public List<Vinculos> findAllByOrderByNomeVinculoAsc();
	
	public List<Vinculos> findByNomeVinculoContainingOrderByNomeVinculoAsc(String nomeVinculo);	
	
	public List<Vinculos> findFirstByNomeVinculoOrderByNomeVinculoAsc(String nomeVinculo);	
}
