package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.AtividadeEscalaReposytory;
import com.folha.boot.Reposytory.RubricaComplementoConstitucionalCodigoReposytory;
import com.folha.boot.Reposytory.RubricaGeralSomaCodigoReposytory;
import com.folha.boot.Reposytory.RubricaGeralSomaPercentagemCodigoReposytory;
import com.folha.boot.Reposytory.RubricaInsalubridadeCodigoReposytory;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.LocalidadeEscala;
import com.folha.boot.domain.RubricaComplementoConstitucionalCodigo;
import com.folha.boot.domain.RubricaGeralSomaCodigo;
import com.folha.boot.domain.RubricaGeralSomaPercentagemCodigo;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class RubricaGeralSomaPercentagemCodigoService {

	@Autowired
	private  RubricaGeralSomaPercentagemCodigoReposytory reposytory;

	public void salvar(RubricaGeralSomaPercentagemCodigo rubricaGeralSomaPercentagemCodigo) {
		reposytory.save(rubricaGeralSomaPercentagemCodigo);
	}

	public void editar(RubricaGeralSomaPercentagemCodigo rubricaGeralSomaPercentagemCodigo) {
		reposytory.save(rubricaGeralSomaPercentagemCodigo);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public RubricaGeralSomaPercentagemCodigo buscarPorId(Long id) {
		return reposytory.findById(id).get();
	}
		
	public List<RubricaGeralSomaPercentagemCodigo> buscarPorNome( String nome) {
		return reposytory.findByCodigoContainingOrderByCodigoAsc( nome.toUpperCase().trim());
	}
	
	public List<RubricaGeralSomaPercentagemCodigo> buscarTodos( ) {
		return reposytory.findAllByOrderByCodigoAsc();
	}
	
	
	@Transactional(readOnly = true)
	public Page<RubricaGeralSomaPercentagemCodigo> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAll(  pageable);
	}

	@Transactional(readOnly = true)
	public Page<RubricaGeralSomaPercentagemCodigo> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByCodigoContainingOrderByCodigoAsc( nome.toUpperCase().trim(), pageable);
	}
	
	
	public boolean avaliarCadastrado( String nome) {
		boolean resposta = false;
		List<RubricaGeralSomaPercentagemCodigo> lista = reposytory.findByCodigoOrderByCodigoAsc( nome.toUpperCase().trim()); 
		if(!lista.isEmpty()) {resposta = true;}
		return resposta;
	}
	
	
}
