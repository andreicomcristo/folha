package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.RubricaVencimento;

@Repository
public interface RubricaVencimentoReposytory extends JpaRepository<RubricaVencimento, Long> {
	
	public List<RubricaVencimento> findByIdAnoMesFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAscSequenciaAscIdUnidadeFkNomeFantasiaAsc(AnoMes anoMes);

	public void deleteByIdAnoMesFk(AnoMes anoMes);
	
}
