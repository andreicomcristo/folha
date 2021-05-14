package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasPrevidenciaNome;

@Repository
public interface FaixasPrevidenciaNomeReposytory extends JpaRepository<FaixasPrevidenciaNome, Long> {

	public List<FaixasPrevidenciaNome> findAllByOrderByNomeFaixaAsc();

	public List<FaixasPrevidenciaNome> findByNomeFaixaContainingOrderByNomeFaixaAsc(String nomeFaixa);
	
	
}
