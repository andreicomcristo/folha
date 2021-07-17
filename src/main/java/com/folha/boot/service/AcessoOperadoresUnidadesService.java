package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.AcessoOperadoresUnidadesReposytory;
import com.folha.boot.domain.AcessoOperadoresUnidades;

@Service
@Transactional(readOnly = false)
public class AcessoOperadoresUnidadesService {

	@Autowired
	private  AcessoOperadoresUnidadesReposytory reposytory;

	public void salvar( AcessoOperadoresUnidades acessoOperadoresUnidades) {
		reposytory.save(acessoOperadoresUnidades);
	}

	public void editar( AcessoOperadoresUnidades acessoOperadoresUnidades) {
		reposytory.save(acessoOperadoresUnidades);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public  AcessoOperadoresUnidades buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List< AcessoOperadoresUnidades> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
}
