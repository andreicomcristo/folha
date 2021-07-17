package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.HistFuncionariosCargaHoraria;
import com.folha.boot.domain.PessoaFuncionarios;

@Repository
public interface HistFuncionariosCargaHorariaReposytory extends JpaRepository<HistFuncionariosCargaHoraria, Long> {

	public List<HistFuncionariosCargaHoraria> findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
	
	public List<HistFuncionariosCargaHoraria> findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
}
