package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresIncentivoDeRisco;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.FaixasValoresSubsidio;
import com.folha.boot.domain.Unidades;

@Repository
public interface FaixasValoresIncentivoDeRiscoReposytory extends JpaRepository<FaixasValoresIncentivoDeRisco, Long>{

	public List<FaixasValoresIncentivoDeRisco> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<FaixasValoresIncentivoDeRisco> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<FaixasValoresIncentivoDeRisco> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public Page<FaixasValoresIncentivoDeRisco> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<FaixasValoresIncentivoDeRisco> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
