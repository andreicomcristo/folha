package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PessoaFilhosReposytory;
import com.folha.boot.domain.PessoaFilhos;

@Service
@Transactional(readOnly = false)
public class PessoaFilhosServiceImpl implements PessoaFilhosService{

	@Autowired
	private PessoaFilhosReposytory reposytory;
	@Override
	public void salvar(PessoaFilhos pessoaFilhos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaFilhos);
	}

	@Override
	public void editar(PessoaFilhos pessoaFilhos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaFilhos);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public PessoaFilhos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<PessoaFilhos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public List<PessoaFilhos> buscarPorNome(String nomeFilho) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeFilhoContainingOrderByNomeFilhoAsc(nomeFilho);
	}
}
