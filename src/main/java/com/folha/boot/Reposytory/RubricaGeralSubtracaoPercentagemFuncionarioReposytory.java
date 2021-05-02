package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.FaixasValoresSubsidio;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RubricaComplementoConstitucional;
import com.folha.boot.domain.RubricaComplementoConstitucionalCodigo;
import com.folha.boot.domain.RubricaComplementoConstitucionalFuncionario;
import com.folha.boot.domain.RubricaGeralSomaCodigo;
import com.folha.boot.domain.RubricaGeralSomaFuncionario;
import com.folha.boot.domain.RubricaGeralSomaPercentagemCodigo;
import com.folha.boot.domain.RubricaGeralSomaPercentagemFuncionario;
import com.folha.boot.domain.RubricaGeralSubtracaoPercentagemCodigo;
import com.folha.boot.domain.RubricaGeralSubtracaoPercentagemFuncionario;
import com.folha.boot.domain.RubricaInsalubridade;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.RubricaInsalubridadeFuncionario;
import com.folha.boot.domain.Unidades;

@Repository
public interface RubricaGeralSubtracaoPercentagemFuncionarioReposytory extends JpaRepository<RubricaGeralSubtracaoPercentagemFuncionario, Long>{

	public List<RubricaGeralSubtracaoPercentagemFuncionario> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<RubricaGeralSubtracaoPercentagemFuncionario> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<RubricaGeralSubtracaoPercentagemFuncionario> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public List<RubricaGeralSubtracaoPercentagemFuncionario> findByIdCodigoFkAndIdAnoMesFkAndIdFuncionarioFk(RubricaGeralSubtracaoPercentagemCodigo rubricaGeralSubtracaoPercentagemCodigo, AnoMes anoMes, PessoaFuncionarios pessoaFuncionarios);
	
	public Page<RubricaGeralSubtracaoPercentagemFuncionario> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<RubricaGeralSubtracaoPercentagemFuncionario> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
