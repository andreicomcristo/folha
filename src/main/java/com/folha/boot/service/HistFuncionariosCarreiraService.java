package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistFuncionariosCarreiraReposytory;
import com.folha.boot.domain.HistFuncionariosCarreira;

@Service
@Transactional(readOnly = false)
public class HistFuncionariosCarreiraService {

	@Autowired
	private HistFuncionariosCarreiraReposytory reposytory;
	
	public void salvar(HistFuncionariosCarreira histFuncionariosCarreira) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosCarreira);
	}

	
	public void editar(HistFuncionariosCarreira histFuncionariosCarreira) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosCarreira);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistFuncionariosCarreira buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistFuncionariosCarreira> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

}
