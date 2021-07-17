package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.FuncionariosCapacitacoes;
import com.folha.boot.domain.Unidades;

@Repository
public interface FuncionariosCapacitacoesReposytory extends JpaRepository<FuncionariosCapacitacoes, Long>{

	public List<FuncionariosCapacitacoes> findByDtCancelamentoIsNullOrderByDescricaoAsc();
	
	public List<FuncionariosCapacitacoes> findByDescricaoContainingAndDtCancelamentoIsNullOrderByDescricaoAsc(String descricao);
	
	
	public Page<FuncionariosCapacitacoes> findByIdFuncionarioFkIdUnidadeAtuacaoAtualFkAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAscIdFuncionarioFkIdPessoaFkCpfAsc(Unidades unidades, final Pageable page);
	
	public Page<FuncionariosCapacitacoes> findByIdFuncionarioFkIdUnidadeAtuacaoAtualFkAndIdFuncionarioFkIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAscIdFuncionarioFkIdPessoaFkCpfAsc(Unidades unidades, String nome, final Pageable page);
	
}
