package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistFuncionariosUnidadeAtuacaoReposytory;
import com.folha.boot.domain.HistFuncionariosUnidadeAtuacao;

@Service
@Transactional(readOnly = false)
public class HistFuncionariosUnidadeAtuacaoService {

	@Autowired
	private HistFuncionariosUnidadeAtuacaoReposytory reposytory;
	
	
	public void salvar(HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacao) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosUnidadeAtuacao);
	}

	
	public void editar(HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacao) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosUnidadeAtuacao);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistFuncionariosUnidadeAtuacao buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistFuncionariosUnidadeAtuacao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

}
