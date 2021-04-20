package com.folha.boot.Reposytory;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.FuncionariosFeriasPeriodos;
import com.folha.boot.domain.FuncionariosLicencas;

@Repository
public interface FuncionariosLicencasReposytory extends JpaRepository<FuncionariosLicencas , Long>{

	public List<FuncionariosLicencas> findAllByOrderByDtInicialAsc();

	public List<FuncionariosLicencas> findByDtInicialContainingOrderByDtInicialAsc(String dtInicial);
	
	public List<FuncionariosLicencas> findByDtInicialLessThanEqualAndDtFinalGreaterThanEqualAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkCpfAsc (Date dataFinal, Date dataInicial);
}
