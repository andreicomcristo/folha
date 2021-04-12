package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.HistFuncionariosCargos;
import com.folha.boot.domain.HistFuncionariosUnidadeAtuacao;
import com.folha.boot.domain.PessoaFuncionarios;

@Repository
public interface HistFuncionariosUnidadeAtuacaoReposytory extends JpaRepository<HistFuncionariosUnidadeAtuacao, Long> {

	public List<HistFuncionariosUnidadeAtuacao> findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
	
	public List<HistFuncionariosUnidadeAtuacao> findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
}
