package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.NiveisCarreiraReposytory;
import com.folha.boot.domain.NiveisCarreira;

@Service
@Transactional(readOnly = false)
public class NiveisCarreiraService{

	@Autowired
	private NiveisCarreiraReposytory reposytory;
	
	
	public void salvar(NiveisCarreira niveisCarreira) {
		// TODO Auto-generated method stub
		reposytory.save(niveisCarreira);
	}

	
	public void editar(NiveisCarreira niveisCarreira) {
		// TODO Auto-generated method stub
		reposytory.save(niveisCarreira);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public NiveisCarreira buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<NiveisCarreira> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeNivelCarreiraAsc();
	}

	
	public List<NiveisCarreira> buscarPorNome(String nomeNivelCarreira) {
		return reposytory.findByNomeNivelCarreiraContainingOrderByNomeNivelCarreiraAsc(nomeNivelCarreira);
	}
	
}
