package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.FatorChDif;
import com.folha.boot.domain.UnidadeAdmiteIncrementoDeRisco;
import com.folha.boot.domain.Unidades;

@Repository
public interface UnidadeAdmiteIncrementoDeRiscoReposytory extends JpaRepository<UnidadeAdmiteIncrementoDeRisco, Long>{

	public List<UnidadeAdmiteIncrementoDeRisco> findByIdUnidadeFkOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(Unidades unidades);
	
	public List<UnidadeAdmiteIncrementoDeRisco> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc();

	public List<UnidadeAdmiteIncrementoDeRisco> findByIdUnidadeFkNomeFantasiaContainingOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(String nome);
	
	public List<UnidadeAdmiteIncrementoDeRisco> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes);
	
	public Page<UnidadeAdmiteIncrementoDeRisco> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(final Pageable page);
	
	public Page<UnidadeAdmiteIncrementoDeRisco> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(String nome, final Pageable page);
	
	
}
