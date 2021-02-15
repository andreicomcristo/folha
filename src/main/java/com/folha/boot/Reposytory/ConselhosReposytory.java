package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.Conselhos;

@Repository
public interface ConselhosReposytory extends JpaRepository<Conselhos, Long> {

	public List<Conselhos> findAllByOrderByDescricaoConselhoAsc();
	
	public List<Conselhos> findByDescricaoConselhoContainingOrderByDescricaoConselhoAsc(String descricaoConselho);
}
