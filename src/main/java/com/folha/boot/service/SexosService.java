package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.SexosReposytory;
import com.folha.boot.domain.Sexos;

@Service
@Transactional(readOnly = false)
public class SexosService {
	
	@Autowired
	private SexosReposytory reposytory;

	
	public void salvar(Sexos sexos) {
		// TODO Auto-generated method stub
		reposytory.save(sexos);
	}

	
	public void editar(Sexos sexos) {
		// TODO Auto-generated method stub
		reposytory.save(sexos);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public Sexos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<Sexos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeSexoAsc();
	}
	
	
	public List<Sexos> buscarPorNome(String nomeSexo) {
		return reposytory.findByNomeSexoContainingOrderByNomeSexoAsc(nomeSexo);
	}
	
}
