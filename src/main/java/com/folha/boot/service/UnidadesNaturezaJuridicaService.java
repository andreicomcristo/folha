package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.UnidadesNaturezaJuridicaReposytory;
import com.folha.boot.domain.UnidadesNaturezaJuridica;

@Service
@Transactional(readOnly = false)
public class UnidadesNaturezaJuridicaService {

	@Autowired
	private UnidadesNaturezaJuridicaReposytory reposytory;
	
	
	public void salvar(UnidadesNaturezaJuridica unidadesNaturezaJuridica) {
		// TODO Auto-generated method stub
		reposytory.save(unidadesNaturezaJuridica);
	}

	
	public void editar(UnidadesNaturezaJuridica unidadesNaturezaJuridica) {
		// TODO Auto-generated method stub
		reposytory.save(unidadesNaturezaJuridica);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public UnidadesNaturezaJuridica buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<UnidadesNaturezaJuridica> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeNaturezaJuridicaAsc();
	}

	
	public List<UnidadesNaturezaJuridica> buscarPorNome(String nomeNaturezaJuridica) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeNaturezaJuridicaContainingOrderByNomeNaturezaJuridicaAsc(nomeNaturezaJuridica);
	}

	@Transactional(readOnly = true)
	public Page<UnidadesNaturezaJuridica> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByNomeNaturezaJuridicaAsc(  pageable);
	}

	@Transactional(readOnly = true)
	public Page<UnidadesNaturezaJuridica> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByNomeNaturezaJuridicaContainingOrderByNomeNaturezaJuridicaAsc(  nome.toUpperCase().trim(), pageable);
	}
	
}
