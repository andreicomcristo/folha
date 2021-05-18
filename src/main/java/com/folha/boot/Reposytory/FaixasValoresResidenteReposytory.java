package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresResidente;


@Repository
public interface FaixasValoresResidenteReposytory extends JpaRepository<FaixasValoresResidente, Long>{

	public List<FaixasValoresResidente> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<FaixasValoresResidente> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<FaixasValoresResidente> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public Page<FaixasValoresResidente> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<FaixasValoresResidente> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
