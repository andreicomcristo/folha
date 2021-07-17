package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.NiveisCarreira;

@Repository
public interface NiveisCarreiraReposytory extends JpaRepository<NiveisCarreira, Long> {
	
	public List<NiveisCarreira> findAllByOrderByNomeNivelCarreiraAsc();
	
	public List<NiveisCarreira> findByNomeNivelCarreiraContainingOrderByNomeNivelCarreiraAsc(String nomeNivelCarreira);
	
}
