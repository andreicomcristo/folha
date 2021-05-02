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
import com.folha.boot.domain.RubricaGeralSomaPercentagem;
import com.folha.boot.domain.RubricaGeralSomaPercentagemCodigo;
import com.folha.boot.domain.RubricaInsalubridade;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.Unidades;

@Repository
public interface RubricaGeralSomaPercentagemReposytory extends JpaRepository<RubricaGeralSomaPercentagem, Long>{

	public List<RubricaGeralSomaPercentagem> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<RubricaGeralSomaPercentagem> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<RubricaGeralSomaPercentagem> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public List<RubricaGeralSomaPercentagem> findByIdCodigoFkAndIdAnoMesFk(RubricaGeralSomaPercentagemCodigo rubricaGeralSomaPercentagemCodigo, AnoMes anoMes);
	
	public Page<RubricaGeralSomaPercentagem> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<RubricaGeralSomaPercentagem> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
