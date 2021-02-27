package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.ClassesCarreira;

@Repository
public interface ClassesReposytory extends JpaRepository<ClassesCarreira, Long> {

	public List<ClassesCarreira> findAllByOrderByNomeClasseAsc();
	
	public List<ClassesCarreira> findByNomeClasseContainingOrderByNomeClasseAsc(String nomeClasse);	
	
}
