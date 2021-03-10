package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.ClassesCarreiraReposytory;
import com.folha.boot.domain.ClassesCarreira;

@Service
@Transactional(readOnly = false)
public class ClassesCarreiraService {

	@Autowired
	private ClassesCarreiraReposytory reposytory;

	public void salvar(ClassesCarreira classesCarreira) {
		// TODO Auto-generated method stub
		reposytory.save(classesCarreira);
	}

	public void editar(ClassesCarreira classesCarreira) {
		// TODO Auto-generated method stub
		reposytory.save(classesCarreira);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public ClassesCarreira buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<ClassesCarreira> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeClasseAsc();
	}

	public List<ClassesCarreira> buscarPorNome(String nomeClasse) {
		return reposytory.findByNomeClasseContainingOrderByNomeClasseAsc(nomeClasse);
	}
	
}
