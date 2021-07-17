package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.RubricaPensaoIncidenciaReposytory;
import com.folha.boot.domain.RubricaPensaoIncidencia;

@Service
@Transactional(readOnly = false)
public class RubricaPensaoIncidenciaService {

	@Autowired
	private  RubricaPensaoIncidenciaReposytory reposytory;

	public void salvar(RubricaPensaoIncidencia rubricaPensaoIncidencia) {
		reposytory.save(rubricaPensaoIncidencia);
	}

	public void editar(RubricaPensaoIncidencia rubricaPensaoIncidencia) {
		reposytory.save(rubricaPensaoIncidencia);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public RubricaPensaoIncidencia buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	public List<RubricaPensaoIncidencia> buscarTodos() {
		return reposytory.findAllByOrderByNomeAsc();
	}
	
	public List<RubricaPensaoIncidencia> buscarNaUnidadePorNome( String nome) {
		return reposytory.findByNomeContainingOrderByNomeAsc( nome.toUpperCase().trim());
	}
	
	
	@Transactional(readOnly = true)
	public Page<RubricaPensaoIncidencia> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByNomeAsc(  pageable);
	}

	@Transactional(readOnly = true)
	public Page<RubricaPensaoIncidencia> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByNomeContainingOrderByNomeAsc( nome.toUpperCase().trim(), pageable);
	}
	
	
}
