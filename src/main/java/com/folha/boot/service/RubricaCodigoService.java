package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.RubricaCodigoReposytory;
import com.folha.boot.domain.RubricaCodigo;


@Service
@Transactional(readOnly = false)
public class RubricaCodigoService {

	@Autowired
	private  RubricaCodigoReposytory reposytory;

	public void salvar(RubricaCodigo rubricaGeralSomaCodigo) {
		reposytory.save(rubricaGeralSomaCodigo);
	}

	public void editar(RubricaCodigo rubricaGeralSomaCodigo) {
		reposytory.save(rubricaGeralSomaCodigo);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public RubricaCodigo buscarPorId(Long id) {
		return reposytory.findById(id).get();
	}
		
	public List<RubricaCodigo> buscarPorNome( String nome) {
		return reposytory.findByCodigoContainingOrderByCodigoAsc( nome.toUpperCase().trim());
	}
	
	public List<RubricaCodigo> buscarTodos( ) {
		return reposytory.findAllByOrderByCodigoAsc();
	}
	
	
	@Transactional(readOnly = true)
	public Page<RubricaCodigo> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAll(  pageable);
	}

	@Transactional(readOnly = true)
	public Page<RubricaCodigo> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByCodigoContainingOrderByCodigoAsc( nome.toUpperCase().trim(), pageable);
	}
	
	
	public boolean avaliarCadastrado( String nome) {
		boolean resposta = false;
		List<RubricaCodigo> lista = reposytory.findByCodigoOrderByCodigoAsc( nome.toUpperCase().trim()); 
		if(!lista.isEmpty()) {resposta = true;}
		return resposta;
	}
	
	
}
