package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Perfil;

@Repository
public interface PrivilegiosReposytory extends JpaRepository<Perfil, Long> {

	public List<Perfil> findAllByOrderByNomePrivilegioAsc();
	
	public List<Perfil> findByNomePrivilegioContainingOrderByNomePrivilegioAsc(String nomePrivilegio);
}
