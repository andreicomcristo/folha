package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.Unidades;



@Repository
public interface PessoaOperadoresReposytory extends JpaRepository<PessoaOperadores, Long> {

	//@Query("select u from pessoa_operadores u where u.username = :login")
    //public PessoaOperadores findByLogin(@Param("login")String login);
	
	public List<PessoaOperadores> findFirstByUsername(String login);
	
	public List<PessoaOperadores> findFirstByIdPessoaFk(Pessoa pessoa);
	
	public List<PessoaOperadores> findFirstByUsernameAndIdPessoaFkNot(String login, Pessoa pessoa);
	
	
	
	public PessoaOperadores findFirstByUsernameAndDtCancelamentoIsNull(String login);
	
	public List<PessoaOperadores> findAllByDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc();

	public List<PessoaOperadores> findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(String nome);
	
	public PessoaOperadores findFirstByIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(Pessoa pessoa);
	
	public Page<PessoaOperadores> findByEnabledAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(boolean enabled, final Pageable page);
	
	public Page<PessoaOperadores> findByEnabledAndIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(boolean enabled, String nome,final Pageable page);
	
	
	//Cancelados
	public Page<PessoaOperadores> findByEnabledAndDtCancelamentoIsNotNullOrderByIdPessoaFkNomeAsc(boolean enabled, final Pageable page);
	
	public Page<PessoaOperadores> findByEnabledAndIdPessoaFkNomeContainingAndDtCancelamentoIsNotNullOrderByIdPessoaFkNomeAsc(boolean enabled, String nome,final Pageable page);
	
	
}
