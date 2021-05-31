package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.TiposDeFolhaVinculo;
import com.folha.boot.domain.Vinculos;


@Repository
public interface TiposDeFolhaVinculoReposytory extends JpaRepository<TiposDeFolhaVinculo, Long>{

	public List<TiposDeFolhaVinculo> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc();

	public List<TiposDeFolhaVinculo> findByIdTipoDeFolhaFkNomeTipoFolhaContainingOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(String nome);
	
	public List<TiposDeFolhaVinculo> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(AnoMes anoMes);
	
	public List<TiposDeFolhaVinculo> findByIdAnoMesFkAndIdVinculoFkOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(AnoMes anoMes, Vinculos vinculo);
	
	public Page<TiposDeFolhaVinculo> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(final Pageable page);
	
	public Page<TiposDeFolhaVinculo> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(String nome, final Pageable page);
}
