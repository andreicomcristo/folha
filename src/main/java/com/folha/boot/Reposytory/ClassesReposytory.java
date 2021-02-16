package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Classes;

@Repository
public interface ClassesReposytory extends JpaRepository<Classes, Long> {

	public List<Classes> findAllByOrderByNomeClasseAsc();
	
	public List<Classes> findByNomeClasseContainingOrderByNomeClasseAsc(String nomeClasse);	
	
}
