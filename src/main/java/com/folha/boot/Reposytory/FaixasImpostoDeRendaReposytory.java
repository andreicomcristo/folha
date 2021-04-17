package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.FaixasImpostoDeRenda;
import com.folha.boot.domain.Unidades;

@Repository
public interface FaixasImpostoDeRendaReposytory extends JpaRepository<FaixasImpostoDeRenda , Long> {
     
	public List<FaixasImpostoDeRenda> findAllByOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc();
	
	public List<FaixasImpostoDeRenda> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc(String anoMes);
	
	public List<FaixasImpostoDeRenda> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc(AnoMes anoMes);

	
	
	public Page<FaixasImpostoDeRenda> findAllByOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc( final Pageable page);
	
	public Page<FaixasImpostoDeRenda> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc( String nome, final Pageable page);
	
	
	
}
