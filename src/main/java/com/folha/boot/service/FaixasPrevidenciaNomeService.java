package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.FaixasPrevidenciaNomeReposytory;
import com.folha.boot.domain.FaixasPrevidenciaNome;

@Service
@Transactional(readOnly = false)
public class FaixasPrevidenciaNomeService {

	@Autowired
	private FaixasPrevidenciaNomeReposytory reposytory;

	public void salvar(FaixasPrevidenciaNome faixasPrevidenciaNome) {
		// TODO Auto-generated method stub
		reposytory.save(faixasPrevidenciaNome);
	}

	public void editar(FaixasPrevidenciaNome faixasPrevidenciaNome) {
		// TODO Auto-generated method stub
		reposytory.save(faixasPrevidenciaNome);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public FaixasPrevidenciaNome buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<FaixasPrevidenciaNome> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeFaixaAsc();
	}
	
	@Transactional(readOnly = true)
	public List<FaixasPrevidenciaNome> buscarNome(String nomeFaixa) {
		return reposytory.findByNomeFaixaContainingOrderByNomeFaixaAsc(nomeFaixa);
	}
	
	
	
}
