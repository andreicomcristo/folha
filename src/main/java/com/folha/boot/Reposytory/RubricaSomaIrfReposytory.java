package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.FaixasValoresSubsidio;
import com.folha.boot.domain.RubricaComplementoConstitucional;
import com.folha.boot.domain.RubricaComplementoConstitucionalCodigo;
import com.folha.boot.domain.RubricaGeralSoma;
import com.folha.boot.domain.RubricaGeralSomaCodigo;
import com.folha.boot.domain.RubricaInsalubridade;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.RubricaSomaIrf;
import com.folha.boot.domain.RubricaSomaIrfCodigo;
import com.folha.boot.domain.Unidades;

@Repository
public interface RubricaSomaIrfReposytory extends JpaRepository<RubricaSomaIrf, Long>{

	public List<RubricaSomaIrf> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<RubricaSomaIrf> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<RubricaSomaIrf> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public List<RubricaSomaIrf> findByIdCodigoFkAndIdAnoMesFk(RubricaSomaIrfCodigo rubricaSomaIrfCodigo, AnoMes anoMes);
	
	public Page<RubricaSomaIrf> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<RubricaSomaIrf> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
