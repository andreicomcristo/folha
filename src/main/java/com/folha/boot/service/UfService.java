package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Uf;

public interface UfService {
	
	void salvar(Uf uf);

	void editar(Uf uf);

	void excluir(Long id);

	Uf buscarPorId(Long id);

	List<Uf> buscarTodos();
	
	List<Uf> buscarPorNome(String nomeUF);
	
}
