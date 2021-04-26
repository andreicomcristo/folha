package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.HistFuncionariosCargaHoraria;
import com.folha.boot.domain.HistFuncionariosCargos;
import com.folha.boot.domain.PessoaFuncionarios;

@Repository
public interface HistFuncionariosCargosReposytory extends JpaRepository<HistFuncionariosCargos, Long> {

	public List<HistFuncionariosCargos> findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
	
	public List<HistFuncionariosCargos> findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
}
