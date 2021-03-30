package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.FuncionariosCapacitacoes;

@Repository
public interface FuncionariosCapacitacoesReposytory extends JpaRepository<FuncionariosCapacitacoes, Long>{

	public List<FuncionariosCapacitacoes> findAllByOrderByDescricaoAsc();
	
	public List<FuncionariosCapacitacoes> findByDescricaoContainingOrderByDescricaoAsc(String descricao);
}
