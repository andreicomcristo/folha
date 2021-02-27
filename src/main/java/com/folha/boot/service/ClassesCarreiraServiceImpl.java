package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.ClassesReposytory;
import com.folha.boot.domain.ClassesCarreira;

@Service
@Transactional(readOnly = false)
public class ClassesCarreiraServiceImpl implements ClassesCarreiraService{

	@Autowired
	private ClassesReposytory reposytory;
	
	@Override
	public void salvar(ClassesCarreira classesCarreira) {
		// TODO Auto-generated method stub
		reposytory.save(classesCarreira);
	}

	@Override
	public void editar(ClassesCarreira classesCarreira) {
		// TODO Auto-generated method stub
		reposytory.save(classesCarreira);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public ClassesCarreira buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<ClassesCarreira> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeClasseAsc();
	}

	@Override
	public List<ClassesCarreira> buscarPorNome(String nomeClasse) {
		return reposytory.findByNomeClasseContainingOrderByNomeClasseAsc(nomeClasse);
	}
	
}
