package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.AtividadeEscalaReposytory;
import com.folha.boot.domain.AtividadeEscala;

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
	
	@Transactional(readOnly = true)
	public List<AtividadeEscala> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeAtividadeAsc();
	}
	
	public List<AtividadeEscala> buscarPorNome(String nomeAtividade) {
		return reposytory.findByNomeAtividadeContainingOrderByNomeAtividadeAsc(nomeAtividade);
	}
}
