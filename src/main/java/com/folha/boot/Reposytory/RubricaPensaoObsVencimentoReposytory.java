package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.RubricaPensaoObsVencimento;

@Repository
public interface RubricaPensaoObsVencimentoReposytory extends JpaRepository<RubricaPensaoObsVencimento, Long> {
	
	public List<RubricaPensaoObsVencimento> findByIdAnoMesFkOrderByIdAnoMesFkAscIdRubricaPensaoObsFkIdRubricaPensaoFkIdPessoaFkCpfAsc(AnoMes anoMes);
	
	public void deleteByIdAnoMesFk(AnoMes anoMes);
	
}
