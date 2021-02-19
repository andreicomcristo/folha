package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PrivilegiosReposytory;
import com.folha.boot.domain.Privilegios;

@Service
@Transactional(readOnly = false)
public class PrivilegiosServiceImpl implements PrivilegiosService {

	@Autowired
	private PrivilegiosReposytory reposytory;
	@Override
	public void salvar(Privilegios privilegios) {
		// TODO Auto-generated method stub
		reposytory.save(privilegios);
	}

	@Override
	public void editar(Privilegios privilegios) {
		// TODO Auto-generated method stub
		reposytory.save(privilegios);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Privilegios buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Privilegios> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomePrivilegioAsc();
	}
	
	@Override
	public List<Privilegios> buscarPorNome(String nomePrivilegio) {
		return reposytory.findByNomePrivilegioContainingOrderByNomePrivilegioAsc(nomePrivilegio);
	}
	
}
