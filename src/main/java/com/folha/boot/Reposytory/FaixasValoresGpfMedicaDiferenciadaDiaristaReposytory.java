package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresGpfMedicaDiferenciadaDiarista;


@Repository
public interface FaixasValoresGpfMedicaDiferenciadaDiaristaReposytory extends JpaRepository<FaixasValoresGpfMedicaDiferenciadaDiarista, Long>{

	public List<FaixasValoresGpfMedicaDiferenciadaDiarista> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<FaixasValoresGpfMedicaDiferenciadaDiarista> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<FaixasValoresGpfMedicaDiferenciadaDiarista> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public Page<FaixasValoresGpfMedicaDiferenciadaDiarista> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<FaixasValoresGpfMedicaDiferenciadaDiarista> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
