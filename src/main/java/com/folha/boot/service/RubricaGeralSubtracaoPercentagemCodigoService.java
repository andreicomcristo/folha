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
import com.folha.boot.Reposytory.RubricaGeralSubtracaoCodigoReposytory;
import com.folha.boot.Reposytory.RubricaInsalubridadeCodigoReposytory;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.LocalidadeEscala;
import com.folha.boot.domain.RubricaComplementoConstitucionalCodigo;
import com.folha.boot.domain.RubricaGeralSomaCodigo;
import com.folha.boot.domain.RubricaGeralSubtracaoCodigo;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class RubricaGeralSubtracaoPercentagemCodigoService {

	@Autowired
	private  RubricaGeralSubtracaoCodigoReposytory reposytory;

	public void salvar(RubricaGeralSubtracaoCodigo rubricaGeralSubtracaoCodigo) {
		reposytory.save(rubricaGeralSubtracaoCodigo);
	}

	public void editar(RubricaGeralSubtracaoCodigo rubricaGeralSubtracaoCodigo) {
		reposytory.save(rubricaGeralSubtracaoCodigo);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public RubricaGeralSubtracaoCodigo buscarPorId(Long id) {
		return reposytory.findById(id).get();
	}
		
	public List<RubricaGeralSubtracaoCodigo> buscarPorNome( String nome) {
		return reposytory.findByCodigoContainingOrderByCodigoAsc( nome.toUpperCase().trim());
	}
	
	public List<RubricaGeralSubtracaoCodigo> buscarTodos( ) {
		return reposytory.findAllByOrderByCodigoAsc();
	}
	
	
	@Transactional(readOnly = true)
	public Page<RubricaGeralSubtracaoCodigo> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAll(  pageable);
	}

	@Transactional(readOnly = true)
	public Page<RubricaGeralSubtracaoCodigo> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByCodigoContainingOrderByCodigoAsc( nome.toUpperCase().trim(), pageable);
	}
	
	
	public boolean avaliarCadastrado( String nome) {
		boolean resposta = false;
		List<RubricaGeralSubtracaoCodigo> lista = reposytory.findByCodigoOrderByCodigoAsc( nome.toUpperCase().trim()); 
		if(!lista.isEmpty()) {resposta = true;}
		return resposta;
	}
	
	
}
