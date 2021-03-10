package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistFuncionariosUnidadeLotacaoReposytory;
import com.folha.boot.domain.HistFuncionariosUnidadeLotacao;

public class HistFuncionariosUnidadeLotacaoService {

	@Autowired
	private HistFuncionariosUnidadeLotacaoReposytory reposytory;
	
	
	public void salvar(HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacao) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosUnidadeLotacao);
	}

	
	public void editar(HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacao) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosUnidadeLotacao);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistFuncionariosUnidadeLotacao buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistFuncionariosUnidadeLotacao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

}
