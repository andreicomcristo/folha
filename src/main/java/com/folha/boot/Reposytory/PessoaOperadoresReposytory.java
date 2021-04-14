package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.Unidades;

@Repository
public interface PessoaOperadoresReposytory extends JpaRepository<PessoaOperadores, Long> {

	public List<PessoaOperadores> findAllByOrderByIdPessoaFkNomeAsc();

	public List<PessoaOperadores> findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(String nome);
	
	public PessoaOperadores findFirstByIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(Pessoa pessoa);
	
	public Page<PessoaOperadores> findByEnabledOrderByIdPessoaFkNomeAsc(boolean enabled, final Pageable page);
	
	public Page<PessoaOperadores> findByEnabledAndIdPessoaFkNomeContainingOrderByIdPessoaFkNomeAsc(boolean enabled, String nome,final Pageable page);
	
	
}
