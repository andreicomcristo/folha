package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.CategoriaDeLicencaReposytory;
import com.folha.boot.domain.CategoriaDeLicenca;

@Service
@Transactional(readOnly = false)
public class CategoriaDeLicencaService {	
	@Autowired
	private CategoriaDeLicencaReposytory reposytory;

	//@Override
	public void salvar(CategoriaDeLicenca categoriaDeLicenca) {
		reposytory.save(categoriaDeLicenca);
	}

	//@Override
	public void editar(CategoriaDeLicenca categoriaDeLicenca) {
		reposytory.save(categoriaDeLicenca);

	}

	//@Override
	public void excluir(Long id) {
		reposytory.deleteById(id);

	}

	@Transactional(readOnly = true)
	//@Override
	public CategoriaDeLicenca buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	//@Override
	public List<CategoriaDeLicenca> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeAsc();
	}
	
	//@Override
	public List<CategoriaDeLicenca> buscarPorNome(String nome) {
		return reposytory.findByNomeContainingOrderByNomeAsc(nome.toUpperCase().trim());
	}
	
}
