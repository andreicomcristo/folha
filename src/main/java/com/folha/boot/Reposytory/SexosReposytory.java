package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.Sexos;

@Repository
public interface SexosReposytory extends JpaRepository<Sexos, Long> {

	public List<Sexos> findAllByOrderByNomeSexoAsc();
	
	public List<Sexos> findByNomeSexoContainingOrderByNomeSexoAsc(String nomeSexo);
}
