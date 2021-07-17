package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
		return reposytory.findAllByOrderByNomeRegimeUnidLotacaoAsc();
	}

	
	public List<UnidadesRegime> buscarPorNome(String nomeRegimeUnidLotacao) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeRegimeUnidLotacaoContainingOrderByNomeRegimeUnidLotacaoAsc(nomeRegimeUnidLotacao);
	}
	
	@Transactional(readOnly = true)
	public Page<UnidadesRegime> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByNomeRegimeUnidLotacaoAsc(  pageable);
	}

	@Transactional(readOnly = true)
	public Page<UnidadesRegime> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByNomeRegimeUnidLotacaoContainingOrderByNomeRegimeUnidLotacaoAsc(  nome.toUpperCase().trim(), pageable);
	}
	
	
}
