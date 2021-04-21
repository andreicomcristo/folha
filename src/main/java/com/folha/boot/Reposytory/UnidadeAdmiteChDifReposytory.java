package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.UnidadeAdmiteChDif;
import com.folha.boot.domain.UnidadeAdmiteIncrementoDeRisco;
import com.folha.boot.domain.Unidades;

@Repository
public interface UnidadeAdmiteChDifReposytory extends JpaRepository<UnidadeAdmiteChDif, Long>{

	public List<UnidadeAdmiteChDif> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc();

	public List<UnidadeAdmiteChDif> findByIdUnidadeFkNomeFantasiaContainingOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(String nome);
	
	public List<UnidadeAdmiteChDif> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes);
	
	public Page<UnidadeAdmiteChDif> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(final Pageable page);
	
	public Page<UnidadeAdmiteChDif> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(String nome, final Pageable page);
	
}
