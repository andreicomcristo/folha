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
import com.folha.boot.domain.RubricaGeralSubtracaoPercentagem;
import com.folha.boot.domain.RubricaGeralSubtracaoPercentagemCodigo;
import com.folha.boot.domain.RubricaInsalubridade;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.Unidades;

@Repository
public interface RubricaGeralSubtracaoPercentagemReposytory extends JpaRepository<RubricaGeralSubtracaoPercentagem, Long>{

	public List<RubricaGeralSubtracaoPercentagem> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<RubricaGeralSubtracaoPercentagem> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<RubricaGeralSubtracaoPercentagem> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public List<RubricaGeralSubtracaoPercentagem> findByIdCodigoFkAndIdAnoMesFk(RubricaGeralSubtracaoPercentagemCodigo rubricaGeralSubtracaoPercentagemCodigo, AnoMes anoMes);
	
	public Page<RubricaGeralSubtracaoPercentagem> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<RubricaGeralSubtracaoPercentagem> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
