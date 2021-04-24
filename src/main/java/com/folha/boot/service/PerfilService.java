package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PerfilReposytory;
import com.folha.boot.domain.seguranca.Perfil;

@Service
@Transactional(readOnly = false)
public class PerfilService {

	@Autowired
	private  PerfilReposytory reposytory;

	public void salvar(Perfil perfil) {
		reposytory.save(perfil);
	}

	public void editar(Perfil perfil) {
		reposytory.save(perfil);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public Perfil buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<Perfil> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
}
