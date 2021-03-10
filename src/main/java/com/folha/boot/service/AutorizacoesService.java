package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.AutorizacoesReposytory;
import com.folha.boot.domain.Autorizacoes;

@Service
@Transactional(readOnly = false)
public class AutorizacoesService {
	
	@Autowired
	private AutorizacoesReposytory reposytory;

	public void salvar(Autorizacoes autorizacoes) {

		reposytory.save(autorizacoes);
	}

	public void editar(Autorizacoes autorizacoes) {

		reposytory.save(autorizacoes);

	}

	public void excluir(Long id) {
		
		reposytory.deleteById(id);
		
	}

	@Transactional(readOnly = true)
	public Autorizacoes buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<Autorizacoes> buscarTodos() {
			
		return reposytory.findAll();
	}

}
