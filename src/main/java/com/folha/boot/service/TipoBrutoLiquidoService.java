package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.TipoBrutoLiquidoReposytory;
import com.folha.boot.domain.TipoBrutoLiquido;

@Service
@Transactional(readOnly = false)
public class TipoBrutoLiquidoService {

	@Autowired
	private  TipoBrutoLiquidoReposytory reposytory;

	public void salvar(TipoBrutoLiquido tipoBrutoLiquido) {
		reposytory.save(tipoBrutoLiquido);
	}

	public void editar(TipoBrutoLiquido tipoBrutoLiquido) {
		reposytory.save(tipoBrutoLiquido);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public TipoBrutoLiquido buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	public List<TipoBrutoLiquido> buscarTodos() {
		return reposytory.findAllByOrderByNomeAsc();
	}
	
	public List<TipoBrutoLiquido> buscarPorNome( String nome) {
		return reposytory.findByNomeContainingOrderByNomeAsc(nome.toUpperCase().trim());
	}
	
	
	@Transactional(readOnly = true)
	public Page<TipoBrutoLiquido> findPaginated( int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByNomeAsc(  pageable);
	}

	@Transactional(readOnly = true)
	public Page<TipoBrutoLiquido> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByNomeContainingOrderByNomeAsc(  nome.toUpperCase().trim(), pageable);
	}
	
	
}
