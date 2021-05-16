package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.RubricaPensaoObs;

@Repository
public interface RubricaPensaoObsReposytory extends JpaRepository<RubricaPensaoObs, Long> {
	
	public List<RubricaPensaoObs> findByIdAnoMesFkOrderByIdAnoMesFkAscIdRubricaPensaoFkIdPessoaFkCpfAsc(AnoMes anoMes);
	
	public List<RubricaPensaoObs> findByIdAnoMesFkAndIdRubricaPensaoFkIdPessoaFkOrderByIdAnoMesFkAsc(AnoMes anoMes, Pessoa pessoa);

	public void deleteByIdAnoMesFk(AnoMes anoMes);
	
}
