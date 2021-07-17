package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.AtividadeEscalaReposytory;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class AtividadeEscalaService {

	@Autowired
	private  AtividadeEscalaReposytory reposytory;

	public void salvar(AtividadeEscala atividadeEscala) {
		reposytory.save(atividadeEscala);
	}

	public void editar(AtividadeEscala atividadeEscala) {
		reposytory.save(atividadeEscala);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public AtividadeEscala buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	/*
	@Transactional(readOnly = true)
	public List<AtividadeEscala> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findByDtCancelamentoIsNullOrderByNomeAtividadeAsc();
	}
	
	public List<AtividadeEscala> buscarPorNome(String nomeAtividade) {
		return reposytory.findByNomeAtividadeContainingAndDtCancelamentoIsNullOrderByNomeAtividadeAsc(nomeAtividade.toUpperCase().trim());
	}
	*/
	public List<AtividadeEscala> buscarNaUnidade(Unidades unidades) {
		return reposytory.findByIdUnidadeFkAndDtCancelamentoIsNullOrderByNomeAtividadeAsc(unidades);
	}
	
	public List<AtividadeEscala> buscarNaUnidadePorNome(Unidades unidades, String nome) {
		return reposytory.findByIdUnidadeFkAndNomeAtividadeContainingAndDtCancelamentoIsNullOrderByNomeAtividadeAsc(unidades, nome.toUpperCase().trim());
	}
	
	
	@Transactional(readOnly = true)
	public Page<AtividadeEscala> findPaginated(Unidades unidades ,int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeFkAndDtCancelamentoIsNullOrderByNomeAtividadeAsc(unidades,  pageable);
	}

	@Transactional(readOnly = true)
	public Page<AtividadeEscala> findPaginatedNome(Unidades unidades ,String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeFkAndNomeAtividadeContainingAndDtCancelamentoIsNullOrderByNomeAtividadeAsc( unidades, nome.toUpperCase().trim(), pageable);
	}
	
	
}
