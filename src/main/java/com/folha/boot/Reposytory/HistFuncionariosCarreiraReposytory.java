package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.HistFuncionariosCargos;
import com.folha.boot.domain.HistFuncionariosCarreira;
import com.folha.boot.domain.PessoaFuncionarios;

@Repository
public interface HistFuncionariosCarreiraReposytory extends JpaRepository<HistFuncionariosCarreira, Long> {

	public List<HistFuncionariosCarreira> findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
	
	public List<HistFuncionariosCarreira> findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
}
