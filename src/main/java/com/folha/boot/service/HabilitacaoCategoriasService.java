package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HabilitacaoCategoriasReposytory;
import com.folha.boot.domain.HabilitacaoCategorias;

@Service
@Transactional(readOnly = false)
public class HabilitacaoCategoriasService {

	@Autowired
	private HabilitacaoCategoriasReposytory reposytory;

	public void salvar(HabilitacaoCategorias habilitacaoCategorias) {
		// TODO Auto-generated method stub
		reposytory.save(habilitacaoCategorias);
	}

	
	public void editar(HabilitacaoCategorias habilitacaoCategorias) {
		// TODO Auto-generated method stub
		reposytory.save(habilitacaoCategorias);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HabilitacaoCategorias buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HabilitacaoCategorias> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeHabilitacaoCategoriaAsc();
	}

	
	public List<HabilitacaoCategorias> buscarPorNome(String nomeHabilitacaoCategoria) {
		return reposytory.findByNomeHabilitacaoCategoriaContainingOrderByNomeHabilitacaoCategoriaAsc(nomeHabilitacaoCategoria);
	}
	
}
