package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.SexosReposytory;
import com.folha.boot.domain.Sexos;

@Service
@Transactional(readOnly = false)
public class SexosServiceImpl implements SexosService {

	@Autowired
	private SexosReposytory reposytory;

	@Override
	public void salvar(Sexos sexos) {
		// TODO Auto-generated method stub
		reposytory.save(sexos);
	}

	@Override
	public void editar(Sexos sexos) {
		// TODO Auto-generated method stub
		reposytory.save(sexos);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Sexos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Sexos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
}
