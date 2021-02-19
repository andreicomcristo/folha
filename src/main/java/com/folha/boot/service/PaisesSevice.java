package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Paises;

public interface PaisesSevice {

	void salvar(Paises paises);

	void editar(Paises paises);

	void excluir(Long id);

	Paises buscarPorId(Long id);

	List<Paises> buscarTodos();
	
	List<Paises> buscarPorNome(String nomePais);
	
}
