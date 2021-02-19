package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.ClassesReposytory;
import com.folha.boot.domain.Classes;

@Service
@Transactional(readOnly = false)
public class ClassesServiceImpl implements ClassesService{

	@Autowired
	private ClassesReposytory reposytory;
	
	@Override
	public void salvar(Classes classes) {
		// TODO Auto-generated method stub
		reposytory.save(classes);
	}

	@Override
	public void editar(Classes classes) {
		// TODO Auto-generated method stub
		reposytory.save(classes);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Classes buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Classes> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeClasseAsc();
	}

	@Override
	public List<Classes> buscarPorNome(String nomeClasse) {
		return reposytory.findByNomeClasseContainingOrderByNomeClasseAsc(nomeClasse);
	}
	
}
