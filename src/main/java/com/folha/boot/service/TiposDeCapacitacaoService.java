package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.TiposDeCapacitacaoReposytory;
import com.folha.boot.domain.TiposDeCapacitacao;

@Service
@Transactional(readOnly = false)
public class TiposDeCapacitacaoService {

	@Autowired
	private  TiposDeCapacitacaoReposytory reposytory;

	public void salvar(TiposDeCapacitacao tiposDeCapacitacao) {
		reposytory.save(tiposDeCapacitacao);
	}

	public void editar(TiposDeCapacitacao tiposDeCapacitacao) {
		reposytory.save(tiposDeCapacitacao);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public TiposDeCapacitacao buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<TiposDeCapacitacao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
}
