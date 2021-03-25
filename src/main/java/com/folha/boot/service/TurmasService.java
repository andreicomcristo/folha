package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.TurmasReposytory;
import com.folha.boot.domain.Turmas;

@Service
@Transactional(readOnly = false)
public class TurmasService {

	@Autowired
	private  TurmasReposytory reposytory;

	public void salvar(Turmas turmas) {
		reposytory.save(turmas);
	}

	public void editar(Turmas turmas) {
		reposytory.save(turmas);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public Turmas buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<Turmas> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
}
