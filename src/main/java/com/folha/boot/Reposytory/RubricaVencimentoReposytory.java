package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Fonte;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RubricaVencimento;
import com.folha.boot.domain.Unidades;

@Repository
public interface RubricaVencimentoReposytory extends JpaRepository<RubricaVencimento, Long> {
	
	public List<RubricaVencimento> findByIdAnoMesFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAscSequenciaAscIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes);
	
	public List<RubricaVencimento> findByIdAnoMesFkAndIdNaturezaFkSiglaOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAscSequenciaAscIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes, String nome);
	
	public List<RubricaVencimento> findByIdAnoMesFkAndIdFonteFkAndIdNaturezaFkSiglaOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAscSequenciaAscIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes, Fonte fonte, String nome);
	
	public List<RubricaVencimento> findByIdAnoMesFkAndIdFonteFkAndIdUnidadeFkAndIdNaturezaFkSiglaOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAscSequenciaAscIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes, Fonte fonte, Unidades unidade, String nome);
	
	public List<RubricaVencimento> findByIdAnoMesFkAndIdUnidadeFkAndIdNaturezaFkSiglaOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAscSequenciaAscIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes, Unidades unidade, String nome);
	
	
	public List<RubricaVencimento> findByIdAnoMesFkAndIdNaturezaFkSiglaAndIdFuncionarioFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAscSequenciaAscIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes, String nome, PessoaFuncionarios funcionario);
	
	public List<RubricaVencimento> findByIdAnoMesFkAndIdNaturezaFkSiglaAndIdFuncionarioFkIdPessoaFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAscSequenciaAscIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes, String nome, Pessoa pessoa);
	
	public List<RubricaVencimento> findByIdAnoMesFkAndIdFuncionarioFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAscIdNaturezaFkSiglaDescSequenciaAscIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes, PessoaFuncionarios funcionario);
	
	public List<RubricaVencimento> findByIdAnoMesFkAndIdFuncionarioFkIdPessoaFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAscIdNaturezaFkSiglaDescSequenciaAscIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes, Pessoa pessoa);

	public void deleteByIdAnoMesFk(AnoMes anoMes);
	
}
