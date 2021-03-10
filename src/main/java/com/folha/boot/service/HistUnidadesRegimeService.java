package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistUnidadesRegimeReposytory;
import com.folha.boot.domain.HistUnidadesRegime;

@Service
@Transactional(readOnly = false)
public class HistUnidadesRegimeService{

	@Autowired
	private HistUnidadesRegimeReposytory reposytory;
	
	public void salvar(HistUnidadesRegime histUnidadesRegime) {
		// TODO Auto-generated method stub
		reposytory.save(histUnidadesRegime);
	}

	
	public void editar(HistUnidadesRegime histUnidadesRegime) {
		// TODO Auto-generated method stub
		reposytory.save(histUnidadesRegime);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistUnidadesRegime buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistUnidadesRegime> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

}
