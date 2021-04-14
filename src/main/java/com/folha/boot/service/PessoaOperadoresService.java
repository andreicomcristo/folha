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
	
	public void salvar(PessoaOperadores pessoaOperadores) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaOperadores);
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
		return reposytory.findAllByOrderByIdPessoaFkNomeAsc();
	}

	
	public List<PessoaOperadores> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return reposytory.findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(nome.toUpperCase().trim());
	}
	
	public PessoaOperadores buscarPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findFirstByIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(pessoa);
	}

	
	//Dados para listar Pessoas para editar local - unidade
	@Transactional(readOnly = true)
	public Page<PessoaOperadores> findPaginated( int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByEnabledOrderByIdPessoaFkNomeAsc( true,  pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<PessoaOperadores> findPaginatedNome( String nome, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByEnabledAndIdPessoaFkNomeContainingOrderByIdPessoaFkNomeAsc( true, nome.toUpperCase().trim(), pageable);
	}
	
}
