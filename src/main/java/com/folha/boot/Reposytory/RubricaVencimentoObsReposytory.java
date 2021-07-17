package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RubricaVencimentoObs;

@Repository
public interface RubricaVencimentoObsReposytory extends JpaRepository<RubricaVencimentoObs, Long> {
	
	public List<RubricaVencimentoObs> findByIdAnoMesFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAsc(AnoMes anoMes);
	
	public List<RubricaVencimentoObs> findByIdAnoMesFkAndIdFuncionarioFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAsc(AnoMes anoMes, PessoaFuncionarios funcionario);
	
	public List<RubricaVencimentoObs> findByIdAnoMesFkAndIdFuncionarioFkIdPessoaFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAsc(AnoMes anoMes, Pessoa pessoa);

	public void deleteByIdAnoMesFk(AnoMes anoMes);
	
}
