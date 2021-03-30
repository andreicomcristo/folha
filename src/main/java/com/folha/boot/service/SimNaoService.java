package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.SimNaoReposytory;
import com.folha.boot.Reposytory.TurnosReposytory;
import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.Turnos;

@Service
@Transactional(readOnly = false)
public class SimNaoService {

	@Autowired
	private  SimNaoReposytory reposytory;

	public void salvar(SimNao simNao) {
		reposytory.save(simNao);
	}

	public void editar(SimNao simNao) {
		reposytory.save(simNao);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public SimNao buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<SimNao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<SimNao> buscarPorSigla(String sigla) {
		// TODO Auto-generated method stub
		return reposytory.findBySigla(sigla);
	}
}
