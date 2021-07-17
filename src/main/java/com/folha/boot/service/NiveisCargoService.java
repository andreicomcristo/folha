package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.NiveisCargoReposytory;
import com.folha.boot.domain.NiveisCargo;

@Service
@Transactional(readOnly = false)
public class NiveisCargoService {

	@Autowired
	private NiveisCargoReposytory reposytory;
	
	
	public void salvar(NiveisCargo niveisCargo) {
		// TODO Auto-generated method stub
		reposytory.save(niveisCargo);
	}

	
	public void editar(NiveisCargo niveisCargo) {
		// TODO Auto-generated method stub
		reposytory.save(niveisCargo);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public NiveisCargo buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<NiveisCargo> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeNivelCargoAsc();
	}
	
	
	public List<NiveisCargo> buscarPorNome(String nomeNivelCargo) {
		return reposytory.findByNomeNivelCargoContainingOrderByNomeNivelCargoAsc(nomeNivelCargo);
	}
	
}
