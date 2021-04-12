package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.HistFuncionariosCargos;
import com.folha.boot.domain.HistFuncionariosNiveisCarreira;
import com.folha.boot.domain.HistFuncionariosSituacoes;
import com.folha.boot.domain.PessoaFuncionarios;

@Repository
public interface HistFuncionariosSituacoesReposytory extends JpaRepository<HistFuncionariosSituacoes, Long> {

	public List<HistFuncionariosSituacoes> findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
	
	public List<HistFuncionariosSituacoes> findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
}
