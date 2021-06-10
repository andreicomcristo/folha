package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PessoaOperadoresReposytory;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class PessoaOperadoresService {

	@Autowired
	private PessoaOperadoresReposytory reposytory;
	
	public PessoaOperadores salvar(PessoaOperadores pessoaOperadores) {
		// TODO Auto-generated method stub
		return reposytory.save(pessoaOperadores);
	}

	
	public void editar(PessoaOperadores pessoaOperadores) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaOperadores);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public PessoaOperadores buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<PessoaOperadores> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc();
	}

	
	public List<PessoaOperadores> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return reposytory.findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(nome.toUpperCase().trim());
	}
	
	public PessoaOperadores buscarPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findFirstByIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(pessoa);
	}

	
	
	public boolean pessoaCadastrada(Pessoa pessoa) {
		boolean resposta = false;
		if(!buscarPorPessoa2(pessoa).isEmpty()) {resposta = true;}
		return resposta;
	}
	
	public List<PessoaOperadores> buscarPorPessoa2(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findFirstByIdPessoaFk( pessoa);
	}
	
	
	public boolean loginCadastrado(String username) {
		boolean resposta = false;
		if(!buscarPorUsuario2(username).isEmpty()) {resposta = true;}
		return resposta;
	}
	
	public boolean loginCadastrado(String username, Pessoa pessoa) {
		boolean resposta = false;
		if(!buscarPorUsuario3(username, pessoa).isEmpty()) {resposta = true;}
		return resposta;
	}
	
	public List<PessoaOperadores> buscarPorUsuario2(String username) {
		// TODO Auto-generated method stub
		return reposytory.findFirstByUsername( username);
	}
	
	public List<PessoaOperadores> buscarPorUsuario3(String username, Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findFirstByUsernameAndIdPessoaFkNot( username, pessoa);
	}
	
	
	//Dados para listar Pessoas para editar local - unidade
	@Transactional(readOnly = true)
	public Page<PessoaOperadores> findPaginated( int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByEnabledAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc( true,  pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<PessoaOperadores> findPaginatedNome( String nome, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByEnabledAndIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc( true, nome.toUpperCase().trim(), pageable);
	}
	
	
	
	//Listar cancelados
	@Transactional(readOnly = true)
	public Page<PessoaOperadores> findPaginatedCancelados( int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByEnabledAndDtCancelamentoIsNotNullOrderByIdPessoaFkNomeAsc( true,  pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<PessoaOperadores> findPaginatedNomeCancelados( String nome, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByEnabledAndIdPessoaFkNomeContainingAndDtCancelamentoIsNotNullOrderByIdPessoaFkNomeAsc( true, nome.toUpperCase().trim(), pageable);
	}
	
}
