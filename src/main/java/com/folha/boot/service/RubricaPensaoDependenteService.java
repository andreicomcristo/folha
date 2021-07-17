package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.RubricaPensaoDependenteReposytory;
import com.folha.boot.domain.RubricaPensao;
import com.folha.boot.domain.RubricaPensaoDependente;

@Service
@Transactional(readOnly = false)
public class RubricaPensaoDependenteService {
	
	@Autowired
	private  RubricaPensaoDependenteReposytory reposytory;

	public RubricaPensaoDependente salvar(RubricaPensaoDependente dependente) {
		return reposytory.save(dependente);
	}

	public void editar(RubricaPensaoDependente dependente) {
		reposytory.save(dependente);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public RubricaPensaoDependente buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<RubricaPensaoDependente> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<RubricaPensaoDependente> buscarPensao(RubricaPensao pensao){
		// TODO Auto-generated method stub
		return reposytory.findByIdRubricaPensaoFk(pensao);
	}

}
