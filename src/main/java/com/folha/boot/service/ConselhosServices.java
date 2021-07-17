package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.ConselhosReposytory;
import com.folha.boot.domain.Conselhos;

@Service
@Transactional(readOnly = false)
public class ConselhosServices {
	
	@Autowired
	private ConselhosReposytory reposytory;

	public void salvar(Conselhos conselhos) {
		// TODO Auto-generated method stub
		reposytory.save(conselhos);
	}

	public void editar(Conselhos conselhos) {
		// TODO Auto-generated method stub
		reposytory.save(conselhos);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
		
	}

	@Transactional(readOnly = true)
	public Conselhos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<Conselhos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	public List<Conselhos> buscarPorNome(String nomeConselho) {
		return reposytory.findByNomeConselhoContainingOrderByNomeConselhoAsc(nomeConselho);
	}
	
}
