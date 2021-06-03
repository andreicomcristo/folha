package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Cargos;
import com.folha.boot.domain.IncrementoDeRiscoUnidadeCargo;
import com.folha.boot.domain.Unidades;


@Repository
public interface IncrementoDeRiscoUnidadeCargoReposytory extends JpaRepository<IncrementoDeRiscoUnidadeCargo, Long>{

	public List<IncrementoDeRiscoUnidadeCargo> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<IncrementoDeRiscoUnidadeCargo> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<IncrementoDeRiscoUnidadeCargo> findByIdAnoMesFkAndIdUnidadeFkAndIdCargoFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes, Unidades unidade, Cargos cargo);
	
	public List<IncrementoDeRiscoUnidadeCargo> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public Page<IncrementoDeRiscoUnidadeCargo> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<IncrementoDeRiscoUnidadeCargo> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
