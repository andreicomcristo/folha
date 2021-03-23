package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PrivilegiosReposytory;
import com.folha.boot.domain.Perfil;

@Service
@Transactional(readOnly = false)
public class PrivilegiosService  {

	@Autowired
	private PrivilegiosReposytory reposytory;
	
	public void salvar(Perfil privilegios) {
		// TODO Auto-generated method stub
		reposytory.save(privilegios);
	}

	
	public void editar(Perfil privilegios) {
		// TODO Auto-generated method stub
		reposytory.save(privilegios);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public Perfil buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<Perfil> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomePrivilegioAsc();
	}
	
	
	public List<Perfil> buscarPorNome(String nomePrivilegio) {
		return reposytory.findByNomePrivilegioContainingOrderByNomePrivilegioAsc(nomePrivilegio);
	}
	
}
