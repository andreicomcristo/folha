package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresGpfMedicaDiferenciada;


@Repository
public interface FaixasValoresGpfMedicaDiferenciadaReposytory extends JpaRepository<FaixasValoresGpfMedicaDiferenciada, Long>{

	public List<FaixasValoresGpfMedicaDiferenciada> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<FaixasValoresGpfMedicaDiferenciada> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<FaixasValoresGpfMedicaDiferenciada> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public Page<FaixasValoresGpfMedicaDiferenciada> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<FaixasValoresGpfMedicaDiferenciada> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
