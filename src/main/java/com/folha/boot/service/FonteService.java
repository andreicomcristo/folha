package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.FonteReposytory;
import com.folha.boot.domain.Fonte;

@Service
@Transactional(readOnly = false)
public class FonteService {

	@Autowired
	private  FonteReposytory reposytory;

	public void salvar(Fonte fonte) {
		reposytory.save(fonte);
	}

	public void editar(Fonte fonte) {
		reposytory.save(fonte);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public Fonte buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	public List<Fonte> buscarTodos() {
		return reposytory.findAllByOrderByNomeAsc();
	}
	
	public List<Fonte> buscarPorNome( String nome) {
		return reposytory.findByNomeContainingOrderByNomeAsc(nome.toUpperCase().trim());
	}
	
	
	@Transactional(readOnly = true)
	public Page<Fonte> findPaginated( int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByNomeAsc(  pageable);
	}

	@Transactional(readOnly = true)
	public Page<Fonte> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByNomeContainingOrderByNomeAsc(  nome.toUpperCase().trim(), pageable);
	}
	
	
}
