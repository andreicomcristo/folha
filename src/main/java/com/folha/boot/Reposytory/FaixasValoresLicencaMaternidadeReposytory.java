package com.folha.boot.Reposytory;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.FaixasValoresLicencaMaternidade;
import com.folha.boot.domain.PessoaFuncionarios;


@Repository
public interface FaixasValoresLicencaMaternidadeReposytory extends JpaRepository<FaixasValoresLicencaMaternidade, Long>{

	public List<FaixasValoresLicencaMaternidade> findByDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAscDtInicialAsc();
	
	public List<FaixasValoresLicencaMaternidade> findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAscDtInicialAsc(PessoaFuncionarios funcionario);
	
	public List<FaixasValoresLicencaMaternidade> findByIdFuncionarioFkIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAscDtInicialAsc(String nome);
	
	public List<FaixasValoresLicencaMaternidade> findByDtInicialLessThanEqualAndDtFinalGreaterThanEqualAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkCpfAsc (Date dataFinal, Date dataInicial);
	
	public Page<FaixasValoresLicencaMaternidade> findByDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAscDtInicialAsc(final Pageable page);
	
	public Page<FaixasValoresLicencaMaternidade> findByIdFuncionarioFkIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAscDtInicialAsc(String nome, final Pageable page);
}
