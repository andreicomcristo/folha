package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.HistFuncionariosCargos;
import com.folha.boot.domain.HistFuncionariosClasse;
import com.folha.boot.domain.HistFuncionariosNiveisCarreira;
import com.folha.boot.domain.PessoaFuncionarios;

@Repository
public interface HistFuncionariosNiveisCarreiraReposytory extends JpaRepository<HistFuncionariosNiveisCarreira, Long>{

	public List<HistFuncionariosNiveisCarreira> findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
	
	public List<HistFuncionariosNiveisCarreira> findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(PessoaFuncionarios pessoaFuncionarios);
}
