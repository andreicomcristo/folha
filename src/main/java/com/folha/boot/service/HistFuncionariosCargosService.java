package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistFuncionariosCargosReposytory;
import com.folha.boot.domain.HistFuncionariosCargos;

@Service
@Transactional(readOnly = false)
public class HistFuncionariosCargosService {

	@Autowired
	private HistFuncionariosCargosReposytory reposytory;

	
	public void salvar(HistFuncionariosCargos histFuncionariosCargos) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosCargos);
	}

	
	public void editar(HistFuncionariosCargos histFuncionariosCargos) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosCargos);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistFuncionariosCargos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistFuncionariosCargos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	
}
