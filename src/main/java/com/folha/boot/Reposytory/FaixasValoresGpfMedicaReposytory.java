package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresGpfMedica;


@Repository
public interface FaixasValoresGpfMedicaReposytory extends JpaRepository<FaixasValoresGpfMedica, Long>{

	public List<FaixasValoresGpfMedica> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<FaixasValoresGpfMedica> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<FaixasValoresGpfMedica> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public Page<FaixasValoresGpfMedica> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<FaixasValoresGpfMedica> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
