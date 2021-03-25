package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.LocalidadeEscalaReposytory;
import com.folha.boot.domain.LocalidadeEscala;

@Service
@Transactional(readOnly = false)
public class LocalidadeEscalaService {

	@Autowired
	private  LocalidadeEscalaReposytory reposytory;

	public void salvar(LocalidadeEscala localidadeEscala) {
		reposytory.save(localidadeEscala);
	}

	public void editar(LocalidadeEscala localidadeEscala) {
		reposytory.save(localidadeEscala);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public LocalidadeEscala buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<LocalidadeEscala> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
}
