package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.CarreirasReposytory;
import com.folha.boot.domain.Carreiras;

@Service
@Transactional(readOnly = false)
public class CarreirasService {
	
	@Autowired
	private CarreirasReposytory reposytory;
	
	public void salvar(Carreiras carreiras) {
		// TODO Auto-generated method stub
		reposytory.save(carreiras);
	}

	public void editar(Carreiras carreiras) {
		// TODO Auto-generated method stub
		reposytory.save(carreiras);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Carreiras buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<Carreiras> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeCarreiraAsc();
	}

	public List<Carreiras> buscarPorNome(String nomeCarreira) {
		
		return reposytory.findByNomeCarreiraContainingOrderByNomeCarreiraAsc(nomeCarreira);
	}	
}
