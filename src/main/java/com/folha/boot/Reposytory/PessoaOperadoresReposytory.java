package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.PessoaOperadores;

@Repository
public interface PessoaOperadoresReposytory extends JpaRepository<PessoaOperadores, Long> {

	public List<PessoaOperadores> findAllByOrderByMotivoCancelamentoAsc();

	public List<PessoaOperadores> findByMotivoCancelamentoContainingOrderByMotivoCancelamentoAsc(String motivoCancelamento);
	
}
