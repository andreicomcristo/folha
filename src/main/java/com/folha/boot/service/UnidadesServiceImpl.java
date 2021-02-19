package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.UnidadesReposytory;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class UnidadesServiceImpl implements UnidadesService{

	@Autowired
	private UnidadesReposytory reposytory;
	
	@Override
	public void salvar(Unidades unidades) {
		// TODO Auto-generated method stub
		reposytory.save(unidades);
	}

	@Override
	public void editar(Unidades unidades) {
		// TODO Auto-generated method stub
		reposytory.save(unidades);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Unidades buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Unidades> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public List<Unidades> buscarPorNome(String nomeFantasia) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeFantasiaContainingOrderByNomeFantasiaAsc(nomeFantasia);
	}

}
