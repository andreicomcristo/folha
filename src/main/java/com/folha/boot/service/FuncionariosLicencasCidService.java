package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.FuncionariosLicencasCidReposytory;
import com.folha.boot.domain.FuncionariosLicencasCid;

@Service
@Transactional(readOnly = false)
public class FuncionariosLicencasCidService {

	@Autowired
	private  FuncionariosLicencasCidReposytory reposytory;

	public void salvar(FuncionariosLicencasCid funcionariosLicencasCid) {
		reposytory.save(funcionariosLicencasCid);
	}

	public void editar(FuncionariosLicencasCid funcionariosLicencasCid) {
		reposytory.save(funcionariosLicencasCid);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public FuncionariosLicencasCid buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<FuncionariosLicencasCid> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
}
