package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.FuncionariosAnexosReposytory;
import com.folha.boot.domain.FuncionariosAnexos;


@Service
@Transactional(readOnly = false)
public class FuncionariosAnexosService {

	@Autowired
	private  FuncionariosAnexosReposytory reposytory;

	public void salvar(FuncionariosAnexos funcionariosAnexos) {
		reposytory.save(funcionariosAnexos);
	}

	public void editar(FuncionariosAnexos funcionariosAnexos) {
		reposytory.save(funcionariosAnexos);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public FuncionariosAnexos buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<FuncionariosAnexos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
}
