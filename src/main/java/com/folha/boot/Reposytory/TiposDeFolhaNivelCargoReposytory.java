package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.NiveisCargo;
import com.folha.boot.domain.TiposDeFolhaNivelCargo;

@Repository
public interface TiposDeFolhaNivelCargoReposytory extends JpaRepository<TiposDeFolhaNivelCargo, Long>{

	public List<TiposDeFolhaNivelCargo> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc();

	public List<TiposDeFolhaNivelCargo> findByIdTipoDeFolhaFkNomeTipoFolhaContainingOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(String nome);
	
	public List<TiposDeFolhaNivelCargo> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(AnoMes anoMes);
	
	public List<TiposDeFolhaNivelCargo> findByIdAnoMesFkAndIdNivelCargoFkOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(AnoMes anoMes, NiveisCargo nivel);
	
	public Page<TiposDeFolhaNivelCargo> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(final Pageable page);
	
	public Page<TiposDeFolhaNivelCargo> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(String nome, final Pageable page);
}
