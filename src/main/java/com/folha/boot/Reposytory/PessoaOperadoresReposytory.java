package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaOperadores;

@Repository
public interface PessoaOperadoresReposytory extends JpaRepository<PessoaOperadores, Long> {

	public List<PessoaOperadores> findAllByOrderByIdPessoaFkNomeAsc();

	public List<PessoaOperadores> findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(String nome);
	
	public PessoaOperadores findFirstByIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(Pessoa pessoa);
	
}
