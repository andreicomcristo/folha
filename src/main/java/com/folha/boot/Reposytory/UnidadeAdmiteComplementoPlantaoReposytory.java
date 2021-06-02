package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.UnidadeAdmiteComplementoPlantao;
import com.folha.boot.domain.Unidades;

@Repository
public interface UnidadeAdmiteComplementoPlantaoReposytory extends JpaRepository<UnidadeAdmiteComplementoPlantao, Long>{

	public List<UnidadeAdmiteComplementoPlantao> findByIdUnidadeFkOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(Unidades unidades);
	
	public List<UnidadeAdmiteComplementoPlantao> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc();

	public List<UnidadeAdmiteComplementoPlantao> findByIdUnidadeFkNomeFantasiaContainingOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(String nome);
	
	public List<UnidadeAdmiteComplementoPlantao> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes);
	
	public List<UnidadeAdmiteComplementoPlantao> findByIdAnoMesFkAndIdUnidadeFkOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes, Unidades unidade);
	
	public Page<UnidadeAdmiteComplementoPlantao> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(final Pageable page);
	
	public Page<UnidadeAdmiteComplementoPlantao> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(String nome, final Pageable page);
	
	
}
