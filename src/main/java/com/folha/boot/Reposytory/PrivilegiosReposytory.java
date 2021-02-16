package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.Privilegios;

@Repository
public interface PrivilegiosReposytory extends JpaRepository<Privilegios, Long> {

	public List<Privilegios> findAllByOrderByNomePrivilegioAsc();
	
	public List<Privilegios> findByNomePrivilegioContainingOrderByNomePrivilegioAsc(String nomePrivilegio);
}
