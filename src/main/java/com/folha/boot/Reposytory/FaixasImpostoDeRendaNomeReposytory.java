package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.FaixasImpostoDeRendaNome;

@Repository
public interface FaixasImpostoDeRendaNomeReposytory extends JpaRepository<FaixasImpostoDeRendaNome, Long> {

	public List<FaixasImpostoDeRendaNome> findAllByOrderByNomeFaixaAsc();

	public List<FaixasImpostoDeRendaNome> findByNomeFaixaContainingOrderByNomeFaixaAsc(String nomeFaixa);
	
}
