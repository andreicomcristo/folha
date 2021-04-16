package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.FuncionariosFeriasPeriodosReposytory;
import com.folha.boot.domain.FuncionariosFerias;
import com.folha.boot.domain.FuncionariosFeriasPeriodos;
import com.folha.boot.domain.PessoaFuncionarios;

@Service
@Transactional(readOnly = false)
public class FuncionariosFeriasPeriodosService {

	@Autowired
	private  FuncionariosFeriasPeriodosReposytory reposytory;

	public FuncionariosFeriasPeriodos salvar(FuncionariosFeriasPeriodos funcionariosFeriasPeriodos) {
		return reposytory.save(funcionariosFeriasPeriodos);
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
	
	@Transactional(readOnly = true)
	public List<FuncionariosFeriasPeriodos> buscarFerias(FuncionariosFerias ferias){
		// TODO Auto-generated method stub
		return reposytory.findByIdFeriasFk(ferias);
	}
}
