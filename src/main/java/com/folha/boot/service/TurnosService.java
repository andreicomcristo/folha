package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.TurnosReposytory;
import com.folha.boot.domain.Turnos;

@Service
@Transactional(readOnly = false)
public class TurnosService {

	@Autowired
	private  TurnosReposytory reposytory;

	public void salvar(Turnos turnos) {
		reposytory.save(turnos);
	}

	public void editar(Turnos turnos) {
		reposytory.save(turnos);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public Turnos buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<Turnos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
}
