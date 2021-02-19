package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Privilegios;

public interface PrivilegiosService {

	void salvar(Privilegios privilegios);

	void editar(Privilegios privilegios);

	void excluir(Long id);

	Privilegios buscarPorId(Long id);

	List<Privilegios> buscarTodos();
	
	List<Privilegios> buscarPorNome(String nomePrivilegio);
	
}
