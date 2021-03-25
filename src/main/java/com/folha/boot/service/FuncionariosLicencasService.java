package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.FuncionariosLicencasReposytory;
import com.folha.boot.domain.FuncionariosLicencas;

@Service
@Transactional(readOnly = false)
public class FuncionariosLicencasService {

	@Autowired
	private  FuncionariosLicencasReposytory reposytory;

	public void salvar(FuncionariosLicencas funcionariosLicencas) {
		reposytory.save(funcionariosLicencas);
	}

	public void editar(FuncionariosLicencas funcionariosLicencas) {
		reposytory.save(funcionariosLicencas);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public FuncionariosLicencas buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<FuncionariosLicencas> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
}
