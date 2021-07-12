package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.LiberacaoIndividualEscala;
import com.folha.boot.domain.Unidades;


@Repository
public interface LiberacaoIndividualEscalaReposytory extends JpaRepository<LiberacaoIndividualEscala, Long>{

	public List<LiberacaoIndividualEscala> findByIdAnoMesFkAndIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes, Unidades unidades);
	
	public List<LiberacaoIndividualEscala> findByDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc();
	
	public Page<LiberacaoIndividualEscala> findByDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc( final Pageable page);
	
	
	
}
