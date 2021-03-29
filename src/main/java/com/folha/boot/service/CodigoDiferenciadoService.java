package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.CodigoDiferenciadoReposytory;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.Unidades;

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
	public List<CodigoDiferenciado> buscarTodos(Unidades unidade) {
		// TODO Auto-generated method stub
		return reposytory.findByIdUnidadeFkOrderByNomeCodigoDiferenciadoAsc(unidade);
	}
	
	@Transactional(readOnly = true)
	public List<CodigoDiferenciado> buscarPorNome(Unidades unidade, String nome) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeCodigoDiferenciadoContainingAndIdUnidadeFkOrderByNomeCodigoDiferenciadoAsc( nome, unidade);
	}

	
}
