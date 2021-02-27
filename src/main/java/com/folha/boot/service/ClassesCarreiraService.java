package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.ClassesCarreira;

public interface ClassesCarreiraService {

	void salvar(ClassesCarreira classesCarreira);

	void editar(ClassesCarreira classesCarreira);

	void excluir(Long id);

	ClassesCarreira buscarPorId(Long id);

	List<ClassesCarreira> buscarTodos();
	
	List<ClassesCarreira> buscarPorNome(String nomeClasse);
	
}
