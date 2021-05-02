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
import com.folha.boot.domain.RubricaGeralSubtracaoCodigo;
import com.folha.boot.domain.RubricaGeralSubtracaoFuncionario;
import com.folha.boot.domain.RubricaInsalubridade;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.RubricaInsalubridadeFuncionario;
import com.folha.boot.domain.Unidades;

@Repository
public interface RubricaGeralSubtracaoFuncionarioReposytory extends JpaRepository<RubricaGeralSubtracaoFuncionario, Long>{

	public List<RubricaGeralSubtracaoFuncionario> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<RubricaGeralSubtracaoFuncionario> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<RubricaGeralSubtracaoFuncionario> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public List<RubricaGeralSubtracaoFuncionario> findByIdCodigoFkAndIdAnoMesFkAndIdFuncionarioFk(RubricaGeralSubtracaoCodigo rubricaGeralSubtracaoCodigo, AnoMes anoMes, PessoaFuncionarios pessoaFuncionarios);
	
	public Page<RubricaGeralSubtracaoFuncionario> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<RubricaGeralSubtracaoFuncionario> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
