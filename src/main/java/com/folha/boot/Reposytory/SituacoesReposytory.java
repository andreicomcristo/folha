package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Situacoes;

@Repository
public interface SituacoesReposytory extends JpaRepository<Situacoes, Long> {

	public List<Situacoes> findAllByOrderByNomeSituacaoAsc();
	
	public List<Situacoes> findByNomeSituacaoContainingOrderByNomeSituacaoAsc(String nomeSituacao);

}
