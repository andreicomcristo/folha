package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PessoaFilhosReposytory;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFilhos;

@Service
@Transactional(readOnly = false)
public class PessoaFilhosService {

	@Autowired
	private PessoaFilhosReposytory reposytory;
	
	public void salvar(PessoaFilhos pessoaFilhos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaFilhos);
	}

	
	public void editar(PessoaFilhos pessoaFilhos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaFilhos);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public PessoaFilhos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<PessoaFilhos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	
	public List<PessoaFilhos> buscarPorNome(String nomeFilho) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeFilhoContainingOrderByNomeFilhoAsc(nomeFilho);
	}
	
	public List<PessoaFilhos> buscarPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findByIdPessoaFkOrderByNomeFilhoAsc(pessoa);
	}
}
