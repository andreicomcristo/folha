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
import com.folha.boot.Reposytory.RubricaGeralSubtracaoPercentagemCodigoReposytory;
import com.folha.boot.Reposytory.RubricaInsalubridadeCodigoReposytory;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.LocalidadeEscala;
import com.folha.boot.domain.RubricaComplementoConstitucionalCodigo;
import com.folha.boot.domain.RubricaGeralSomaCodigo;
import com.folha.boot.domain.RubricaGeralSubtracaoCodigo;
import com.folha.boot.domain.RubricaGeralSubtracaoPercentagemCodigo;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class RubricaGeralSubtracaoPercentagemCodigoService {

	@Autowired
	private  RubricaGeralSubtracaoPercentagemCodigoReposytory reposytory;

	public void salvar(RubricaGeralSubtracaoPercentagemCodigo rubricaGeralSubtracaoPercentagemCodigo) {
		reposytory.save(rubricaGeralSubtracaoPercentagemCodigo);
	}

	public void editar(RubricaGeralSubtracaoPercentagemCodigo rubricaGeralSubtracaoPercentagemCodigo) {
		reposytory.save(rubricaGeralSubtracaoPercentagemCodigo);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public RubricaGeralSubtracaoPercentagemCodigo buscarPorId(Long id) {
		return reposytory.findById(id).get();
	}
		
	public List<RubricaGeralSubtracaoPercentagemCodigo> buscarPorNome( String nome) {
		return reposytory.findByCodigoContainingOrderByCodigoAsc( nome.toUpperCase().trim());
	}
	
	public List<RubricaGeralSubtracaoPercentagemCodigo> buscarTodos( ) {
		return reposytory.findAllByOrderByCodigoAsc();
	}
	
	
	@Transactional(readOnly = true)
	public Page<RubricaGeralSubtracaoPercentagemCodigo> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAll(  pageable);
	}

	@Transactional(readOnly = true)
	public Page<RubricaGeralSubtracaoPercentagemCodigo> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByCodigoContainingOrderByCodigoAsc( nome.toUpperCase().trim(), pageable);
	}
	
	
	public boolean avaliarCadastrado( String nome) {
		boolean resposta = false;
		List<RubricaGeralSubtracaoPercentagemCodigo> lista = reposytory.findByCodigoOrderByCodigoAsc( nome.toUpperCase().trim()); 
		if(!lista.isEmpty()) {resposta = true;}
		return resposta;
	}
	
	
}
