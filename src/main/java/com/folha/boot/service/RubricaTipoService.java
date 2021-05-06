package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.RubricaTipoReposytory;
import com.folha.boot.domain.RubricaTipo;


@Service
@Transactional(readOnly = false)
public class RubricaTipoService {

	@Autowired
	private  RubricaTipoReposytory reposytory;

	public void salvar(RubricaTipo rubricaTipo) {
		reposytory.save(rubricaTipo);
	}

	public void editar(RubricaTipo rubricaTipo) {
		reposytory.save(rubricaTipo);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public RubricaTipo buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	public List<RubricaTipo> buscarTodos() {
		return reposytory.findAllByOrderBySequenciaAsc();
	}
	
	public List<RubricaTipo> buscarPorNome( String nome) {
		return reposytory.findByNomeContainingOrderBySequenciaAsc( nome.toUpperCase().trim());
	}
	
	
	@Transactional(readOnly = true)
	public Page<RubricaTipo> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderBySequenciaAsc(  pageable);
	}

	@Transactional(readOnly = true)
	public Page<RubricaTipo> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByNomeContainingOrderBySequenciaAsc(  nome.toUpperCase().trim(), pageable);
	}
	
	
}
