package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.ConversaoFontePorFolha;
import com.folha.boot.domain.TiposDeFolha;



@Repository
public interface ConversaoFontePorFolhaReposytory extends JpaRepository<ConversaoFontePorFolha, Long>{

	public List<ConversaoFontePorFolha> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdFolhaFkNomeTipoFolhaAsc();

	public List<ConversaoFontePorFolha> findByIdFolhaFkNomeTipoFolhaContainingOrderByIdAnoMesFkNomeAnoMesDescIdFolhaFkNomeTipoFolhaAsc(String nome);
	
	public List<ConversaoFontePorFolha> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdFolhaFkNomeTipoFolhaAsc(AnoMes anoMes);
	
	public List<ConversaoFontePorFolha> findByIdAnoMesFkAndIdFolhaFkOrderByIdAnoMesFkNomeAnoMesDescIdFolhaFkNomeTipoFolhaAsc(AnoMes anoMes, TiposDeFolha folha);
	
	public Page<ConversaoFontePorFolha> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdFolhaFkNomeTipoFolhaAsc(final Pageable page);
	
	public Page<ConversaoFontePorFolha> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdFolhaFkNomeTipoFolhaAsc(String nome, final Pageable page);
}
