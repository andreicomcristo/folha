package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Carreiras;

@Repository
public interface CarreirasReposytory extends JpaRepository<Carreiras, Long> {

	public List<Carreiras> findAllByOrderByNomeCarreiraAsc();
	
	public List<Carreiras> findByNomeCarreiraContainingOrderByNomeCarreiraAsc(String nomeCarreira);
	
}
