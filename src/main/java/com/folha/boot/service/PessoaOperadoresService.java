package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PessoaOperadoresReposytory;
import com.folha.boot.domain.PessoaOperadores;

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
		return reposytory.findAll();
	}

	
	public List<PessoaOperadores> buscarPorMotivoCancelamento(String motivoCancelamento) {
		// TODO Auto-generated method stub
		return reposytory.findByMotivoCancelamentoContainingOrderByMotivoCancelamentoAsc(motivoCancelamento);
	}

}
