package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.EscalaHorasPagas;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;

@Repository
public interface EscalaHorasPagasReposytory extends JpaRepository<EscalaHorasPagas, Long> {
	
	public List<EscalaHorasPagas> findByIdAnoMesFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAsc(AnoMes anoMes);
	
	public List<EscalaHorasPagas> findByIdAnoMesFkAndIdFuncionarioFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAsc(AnoMes anoMes, PessoaFuncionarios funcionario);
	
	public List<EscalaHorasPagas> findByIdAnoMesFkAndIdFuncionarioFkIdPessoaFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAsc(AnoMes anoMes, Pessoa pessoa);

	public void deleteByIdAnoMesFk(AnoMes anoMes);
	
}
