package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.HistFuncionariosUnidadeLotacao;
import com.folha.boot.domain.PessoaFuncionarios;

@Repository
public interface HistFuncionariosUnidadeLotacaoReposytory extends JpaRepository<HistFuncionariosUnidadeLotacao, Long> {

	public List<HistFuncionariosUnidadeLotacao> findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
	
	public List<HistFuncionariosUnidadeLotacao> findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
}
