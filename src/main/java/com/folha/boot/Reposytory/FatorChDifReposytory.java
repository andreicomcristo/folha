package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.FatorChDif;
import com.folha.boot.domain.Unidades;

@Repository
public interface FatorChDifReposytory extends JpaRepository<FatorChDif, Long>{

	public List<FatorChDif> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc();

	public List<FatorChDif> findByIdUnidadeFkNomeFantasiaContainingOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(String nome);
	
	public List<FatorChDif> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes);
	
	public Page<FatorChDif> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(final Pageable page);
	
	public Page<FatorChDif> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(String nome, final Pageable page);
}
