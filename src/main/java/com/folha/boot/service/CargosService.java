package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.CargosReposytory;
import com.folha.boot.domain.Cargos;

@Service
@Transactional(readOnly = false)
public class CargosService{
	
	@Autowired
	private CargosReposytory reposytory;
	
	public Cargos salvar(Cargos cargos) {
		// TODO Auto-generated method stub
		return reposytory.save(cargos);
		
	}

	public void editar(Cargos cargos) {
		// TODO Auto-generated method stub
		reposytory.save(cargos);
		
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Cargos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<Cargos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeCargoAsc();
	}

	public List<Cargos> buscarPorNome(String nomeCargo) {
		// TODO Auto-generated method stub		
		return reposytory.findByNomeCargoContainingOrderByNomeCargoAsc(nomeCargo);
	};
	
}
