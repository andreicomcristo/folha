package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Paises;

@Repository
public interface PaisesReposytoty extends JpaRepository<Paises, Long> {

	public List<Paises> findAllByOrderByNomePaisAsc();
	
	public List<Paises> findByNomePaisContainingOrderByNomePaisAsc(String nomePais);
}
