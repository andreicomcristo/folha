package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistFuncionariosSituacoesReposytory;
import com.folha.boot.domain.HistFuncionariosSituacoes;

@Service
@Transactional(readOnly = false)
public class HistFuncionariosSituacoesService {
	

	@Autowired
	private HistFuncionariosSituacoesReposytory reposytory;
	
	
	public void salvar(HistFuncionariosSituacoes histFuncionariosSituacoes) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosSituacoes);
	}

	
	public void editar(HistFuncionariosSituacoes histFuncionariosSituacoes) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosSituacoes);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistFuncionariosSituacoes buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistFuncionariosSituacoes> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

}
