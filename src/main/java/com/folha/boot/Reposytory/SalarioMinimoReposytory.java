package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.SalarioMinimo;


@Repository
public interface SalarioMinimoReposytory extends JpaRepository<SalarioMinimo, Long>{

	public List<SalarioMinimo> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();

	public List<SalarioMinimo> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public List<SalarioMinimo> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public Page<SalarioMinimo> findAllByOrderByIdAnoMesFkNomeAnoMesDesc( final Pageable page);
	
	public Page<SalarioMinimo> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc( String nome, final Pageable page);
	
}
