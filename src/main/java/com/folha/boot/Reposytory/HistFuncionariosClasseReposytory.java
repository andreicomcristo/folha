package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.HistFuncionariosCargos;
import com.folha.boot.domain.HistFuncionariosCarreira;
import com.folha.boot.domain.HistFuncionariosClasse;
import com.folha.boot.domain.PessoaFuncionarios;

@Repository
public interface HistFuncionariosClasseReposytory extends JpaRepository<HistFuncionariosClasse, Long> {

	public List<HistFuncionariosClasse> findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
	
	public List<HistFuncionariosClasse> findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
}
