package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.UnidadesRegimeReposytory;
import com.folha.boot.domain.UnidadesRegime;

@Service
@Transactional(readOnly = false)
public class UnidadesRegimeService {

	@Autowired
	private UnidadesRegimeReposytory reposytory;
	
	
	public void salvar(UnidadesRegime unidadesRegime) {
		// TODO Auto-generated method stub
		reposytory.save(unidadesRegime);
	}

	
	public void editar(UnidadesRegime unidadesRegime) {
		// TODO Auto-generated method stub
		reposytory.save(unidadesRegime);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public UnidadesRegime buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<UnidadesRegime> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	
	public List<UnidadesRegime> buscarPorNome(String nomeRegimeUnidLotacao) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeRegimeUnidLotacaoContainingOrderByNomeRegimeUnidLotacaoAsc(nomeRegimeUnidLotacao);
	}
}
