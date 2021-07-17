package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.AreasDeCapacitacaoReposytory;
import com.folha.boot.domain.AreasDeCapacitacao;

@Service
@Transactional(readOnly = false)
public class AreasDeCapacitacaoService {
	@Autowired
	private  AreasDeCapacitacaoReposytory reposytory;

	public void salvar(AreasDeCapacitacao areasDeCapacitacao) {
		reposytory.save(areasDeCapacitacao);
	}

	public void editar(AreasDeCapacitacao areasDeCapacitacao) {
		reposytory.save(areasDeCapacitacao);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public AreasDeCapacitacao buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<AreasDeCapacitacao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByAreaDeCapacitacaoAsc();
	}
	
	public List<AreasDeCapacitacao> buscarPorNome(String areaDeCapacitacao) {
		return reposytory.findByAreaDeCapacitacaoContainingOrderByAreaDeCapacitacaoAsc(areaDeCapacitacao);
	}
}
