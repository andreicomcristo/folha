package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.UfReposytory;
import com.folha.boot.domain.Uf;

@Service
@Transactional(readOnly = false)
public class UfService {

	@Autowired
	private UfReposytory reposytory;
	
	
	public void salvar(Uf uf) {
		// TODO Auto-generated method stub
		reposytory.save(uf);	
	}

	
	public void editar(Uf uf) {
		// TODO Auto-generated method stub
		reposytory.save(uf);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public Uf buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<Uf> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeUfAsc();
	}
	
	
	public List<Uf> buscarPorNome(String nomeUf) {
		return reposytory.findByNomeUfContainingOrderByNomeUfAsc(nomeUf);
	}
	
}
