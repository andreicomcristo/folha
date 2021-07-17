package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.HistFuncionariosVinculos;
import com.folha.boot.domain.PessoaFuncionarios;

@Repository
public interface HistFuncionariosVinculosReposytory extends JpaRepository<HistFuncionariosVinculos, Long> {

	public List<HistFuncionariosVinculos> findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
	
	public List<HistFuncionariosVinculos> findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
}
