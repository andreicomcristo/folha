package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Classes;

public interface ClassesService {

	void salvar(Classes classes);

	void editar(Classes classes);

	void excluir(Long id);

	Classes buscarPorId(Long id);

	List<Classes> buscarTodos();
	
	List<Classes> buscarPorNome(String nomeClasse);
	
}
