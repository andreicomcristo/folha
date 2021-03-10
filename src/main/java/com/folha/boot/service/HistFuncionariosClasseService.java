package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistFuncionariosClasseReposytory;
import com.folha.boot.domain.HistFuncionariosClasse;

@Service
@Transactional(readOnly = false)
public class HistFuncionariosClasseService {

	@Autowired
	private HistFuncionariosClasseReposytory reposytory;
	
	public void salvar(HistFuncionariosClasse histFuncionariosClasse) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosClasse);
	}

	
	public void editar(HistFuncionariosClasse histFuncionariosClasse) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosClasse);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistFuncionariosClasse buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistFuncionariosClasse> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

}
