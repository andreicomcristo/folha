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
import com.folha.boot.domain.RubricaInsalubridade;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.RubricaInsalubridadeFuncionario;
import com.folha.boot.domain.Unidades;

@Repository
public interface RubricaGeralSomaPercentagemFuncionarioReposytory extends JpaRepository<RubricaGeralSomaPercentagemFuncionario, Long>{

	public List<RubricaGeralSomaPercentagemFuncionario> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<RubricaGeralSomaPercentagemFuncionario> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<RubricaGeralSomaPercentagemFuncionario> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public List<RubricaGeralSomaPercentagemFuncionario> findByIdCodigoFkAndIdAnoMesFkAndIdFuncionarioFk(RubricaGeralSomaPercentagemCodigo rubricaGeralSomaPercentagemCodigo, AnoMes anoMes, PessoaFuncionarios pessoaFuncionarios);
	
	public Page<RubricaGeralSomaPercentagemFuncionario> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<RubricaGeralSomaPercentagemFuncionario> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
