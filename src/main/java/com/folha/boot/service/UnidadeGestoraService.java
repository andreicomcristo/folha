package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.UnidadeGestoraReposytory;
import com.folha.boot.Reposytory.UnidadesReposytory;
import com.folha.boot.domain.UnidadeGestora;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class UnidadeGestoraService {

	@Autowired
	private UnidadeGestoraReposytory reposytory;
		
	public void salvar(UnidadeGestora unidades) {
		// TODO Auto-generated method stub
		reposytory.save(unidades);
	}
	
	public void editar(UnidadeGestora unidades) {
		// TODO Auto-generated method stub
		reposytory.save(unidades);
	}
	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public UnidadeGestora buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<UnidadeGestora> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	public List<UnidadeGestora> buscarPorNome(String nomeFantasia) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeFantasiaContainingOrderByNomeFantasiaAsc(nomeFantasia);
	}

}
