package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.RubricaNaturezaReposytory;
import com.folha.boot.domain.RubricaNatureza;

@Service
@Transactional(readOnly = false)
public class RubricaNaturezaService {

	@Autowired
	private  RubricaNaturezaReposytory reposytory;

	public void salvar(RubricaNatureza rubricaNatureza) {
		reposytory.save(rubricaNatureza);
	}

	public void editar(RubricaNatureza rubricaNatureza) {
		reposytory.save(rubricaNatureza);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public RubricaNatureza buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<RubricaNatureza> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<RubricaNatureza> buscarPorSigla(String sigla) {
		// TODO Auto-generated method stub
		return reposytory.findBySigla(sigla);
	}
}
