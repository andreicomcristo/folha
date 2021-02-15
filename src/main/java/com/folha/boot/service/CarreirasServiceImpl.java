package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.CarreirasReposytory;
import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.Carreiras;

@Service
@Transactional(readOnly = false)
public class CarreirasServiceImpl implements CarreirasService{

	@Autowired
	private CarreirasReposytory reposytory;
	
	@Override
	public void salvar(Carreiras carreiras) {
		// TODO Auto-generated method stub
		reposytory.save(carreiras);
	}

	@Override
	public void editar(Carreiras carreiras) {
		// TODO Auto-generated method stub
		reposytory.save(carreiras);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Carreiras buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Carreiras> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeCarreiraAsc();
	}

	@Override
	public List<Carreiras> buscarPorNome(String nomeCarreira) {
		
		return reposytory.findByNomeCarreiraContainingOrderByNomeCarreiraAsc(nomeCarreira);
	}
	
}
