package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.CategoriaDeLicenca;

@Repository
public interface CategoriaDeLicencaReposytory extends JpaRepository<CategoriaDeLicenca, Long> {
	
	public List<CategoriaDeLicenca> findAllByOrderByNomeAsc();
	
	public List<CategoriaDeLicenca> findByNomeContainingOrderByNomeAsc(String nomeBanco);	
}
