package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.CoordenacaoEscalaReposytory;
import com.folha.boot.domain.CoordenacaoEscala;

@Service
@Transactional(readOnly = false)
public class CoordenacaoEscalaService {

	@Autowired
	private  CoordenacaoEscalaReposytory reposytory;

	public void salvar(CoordenacaoEscala coordenacaoEscala) {
		reposytory.save(coordenacaoEscala);
	}

	public void editar(CoordenacaoEscala coordenacaoEscala) {
		reposytory.save(coordenacaoEscala);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public CoordenacaoEscala buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<CoordenacaoEscala> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
}
