package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistFuncionariosAutorizacaoReposytory;
import com.folha.boot.domain.HistFuncionariosAutorizacao;

@Service
@Transactional(readOnly = false)
public class HistFuncionariosAutorizacaoService {

	@Autowired
	private HistFuncionariosAutorizacaoReposytory reposytory;
	
	
	public void salvar(HistFuncionariosAutorizacao histFuncionariosAutorizacao) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosAutorizacao);
	}

	
	public void editar(HistFuncionariosAutorizacao histFuncionariosAutorizacao) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosAutorizacao);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistFuncionariosAutorizacao buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistFuncionariosAutorizacao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

}
