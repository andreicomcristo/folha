package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PessoaFotosReposytory;
import com.folha.boot.domain.PessoaFotos;

@Service
@Transactional(readOnly = false)
public class PessoaFotosService {

	@Autowired
	private PessoaFotosReposytory reposytory;
	
	public void salvar(PessoaFotos pessoaFotos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaFotos);
	}

	
	public void editar(PessoaFotos pessoaFotos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaFotos);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public PessoaFotos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<PessoaFotos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	
	

}
