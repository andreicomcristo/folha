package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistUnidadesNaturezaJuridicaReposytory;
import com.folha.boot.domain.HistUnidadesNaturezaJuridica;

@Service
@Transactional(readOnly = false)
public class HistUnidadesNaturezaJuridicaService {

	@Autowired
	private HistUnidadesNaturezaJuridicaReposytory reposytory;
	
	public void salvar(HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridica) {
		// TODO Auto-generated method stub
		reposytory.save(histUnidadesNaturezaJuridica);
	}

	
	public void editar(HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridica) {
		// TODO Auto-generated method stub
		reposytory.save(histUnidadesNaturezaJuridica);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistUnidadesNaturezaJuridica buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistUnidadesNaturezaJuridica> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

}
