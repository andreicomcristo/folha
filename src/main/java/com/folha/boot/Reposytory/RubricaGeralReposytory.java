package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.RubricaGeral;
import com.folha.boot.domain.RubricaGeralCodigo;


@Repository
public interface RubricaGeralReposytory extends JpaRepository<RubricaGeral, Long>{

	public List<RubricaGeral> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<RubricaGeral> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<RubricaGeral> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public List<RubricaGeral> findByIdCodigoFkAndIdAnoMesFk(RubricaGeralCodigo rubricaGeralSomaCodigo, AnoMes anoMes);
	
	public Page<RubricaGeral> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<RubricaGeral> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
