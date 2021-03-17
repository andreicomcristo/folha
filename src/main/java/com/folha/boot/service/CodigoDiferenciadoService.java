package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.CodigoDiferenciadoReposytory;
import com.folha.boot.domain.CodigoDiferenciado;

@Service
@Transactional(readOnly = false)
public class CodigoDiferenciadoService {

	@Autowired
	private CodigoDiferenciadoReposytory reposytory;

	public void salvar(CodigoDiferenciado codigoDiferenciado) {
		// TODO Auto-generated method stub
		reposytory.save(codigoDiferenciado);
	}

	public void editar(CodigoDiferenciado codigoDiferenciado) {
		// TODO Auto-generated method stub
		reposytory.save(codigoDiferenciado);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public CodigoDiferenciado buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<CodigoDiferenciado> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeCodigoDiferenciadoAsc();
	}

	public List<CodigoDiferenciado> buscarPorNome(String nomeCodigoDiferenciado) {
		return reposytory.findByNomeCodigoDiferenciadoContainingOrderByNomeCodigoDiferenciadoAsc(nomeCodigoDiferenciado);
	}
	
}
