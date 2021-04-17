package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasImpostoDeRenda;
import com.folha.boot.domain.FaixasPrevidencia;

@Repository
public interface FaixasPrevidenciaReposytory extends JpaRepository<FaixasPrevidencia, Long> {

	public List<FaixasPrevidencia> findAllByOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc();

	public List<FaixasPrevidencia> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc(String anoMes);
	
	public List<FaixasPrevidencia> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc(AnoMes anoMes);

	
	
	
	public Page<FaixasPrevidencia> findAllByOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc( final Pageable page);
	
	public Page<FaixasPrevidencia> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc( String nome, final Pageable page);
	
	
}
