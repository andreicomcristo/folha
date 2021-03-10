package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistFuncionariosVinculosReposytory;
import com.folha.boot.domain.HistFuncionariosVinculos;

@Service
@Transactional(readOnly = false)
public class HistFuncionariosVinculosService {

	@Autowired
	private HistFuncionariosVinculosReposytory reposytory;
	
	public void salvar(HistFuncionariosVinculos histFuncionariosVinculos) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosVinculos);
	}

	
	public void editar(HistFuncionariosVinculos histFuncionariosVinculos) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosVinculos);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistFuncionariosVinculos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistFuncionariosVinculos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

}
