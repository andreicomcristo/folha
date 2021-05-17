package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresGpfDiferenciada;


@Repository
public interface FaixasValoresGpfDiferenciadaReposytory extends JpaRepository<FaixasValoresGpfDiferenciada, Long>{

	public List<FaixasValoresGpfDiferenciada> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<FaixasValoresGpfDiferenciada> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<FaixasValoresGpfDiferenciada> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public Page<FaixasValoresGpfDiferenciada> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<FaixasValoresGpfDiferenciada> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
