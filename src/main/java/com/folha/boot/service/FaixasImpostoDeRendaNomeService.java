package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.FaixasImpostoDeRendaNomeReposytory;
import com.folha.boot.domain.FaixasImpostoDeRendaNome;

@Service
@Transactional(readOnly = false)
public class FaixasImpostoDeRendaNomeService {

	@Autowired
	private FaixasImpostoDeRendaNomeReposytory reposytory;

	public void salvar(FaixasImpostoDeRendaNome faixasImpostoDeRendaNome) {
		// TODO Auto-generated method stub
		reposytory.save(faixasImpostoDeRendaNome);
	}

	public void editar(FaixasImpostoDeRendaNome faixasImpostoDeRendaNome) {
		// TODO Auto-generated method stub
		reposytory.save(faixasImpostoDeRendaNome);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public FaixasImpostoDeRendaNome buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<FaixasImpostoDeRendaNome> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeFaixaAsc();
	}
	
	@Transactional(readOnly = true)
	public List<FaixasImpostoDeRendaNome> buscarNome(String nomeFaixa) {
		return reposytory.findByNomeFaixaContainingOrderByNomeFaixaAsc(nomeFaixa);
	}
}
