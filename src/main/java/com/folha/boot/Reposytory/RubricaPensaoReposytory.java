package com.folha.boot.Reposytory;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.RubricaPensao;


@Repository
public interface RubricaPensaoReposytory extends JpaRepository<RubricaPensao, Long>{

	public List<RubricaPensao> findAllByDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc();
	
	public RubricaPensao findFirstByIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(Pessoa pessoa);
	
	public List<RubricaPensao> findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(String nome);
		
	public List<RubricaPensao> findByIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(Pessoa pessoa);
	
	public List<RubricaPensao> findByDtInicialLessThanEqualAndDtFinalGreaterThanEqualAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(Date dtFinal, Date dtInicial, Pessoa pessoa);
	
	public List<RubricaPensao> findByDtInicialLessThanEqualAndDtFinalIsNullAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(Date dtFinal,  Pessoa pessoa);
	
	
	public Page<RubricaPensao> findAllByDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(final Pageable page);
	
	public Page<RubricaPensao> findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(String nome, final Pageable page);
	
	
}
