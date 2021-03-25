package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.FuncionariosFeriasPeriodosReposytory;
import com.folha.boot.domain.FuncionariosFeriasPeriodos;

@Service
@Transactional(readOnly = false)
public class FuncionariosFeriasPeriodosService {

	@Autowired
	private  FuncionariosFeriasPeriodosReposytory reposytory;

	public void salvar(FuncionariosFeriasPeriodos funcionariosFeriasPeriodos) {
		reposytory.save(funcionariosFeriasPeriodos);
	}

	public void editar(FuncionariosFeriasPeriodos funcionariosFeriasPeriodos) {
		reposytory.save(funcionariosFeriasPeriodos);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public FuncionariosFeriasPeriodos buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<FuncionariosFeriasPeriodos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
}
