package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Vinculos;

public interface VinculosService {
	
	void salvar(Vinculos vinculos);

	void editar(Vinculos vinculos);

	void excluir(Long id);

	Vinculos buscarPorId(Long id);

	List<Vinculos> buscarTodos();

	List<Vinculos> buscarPorNome(String nomeViculo);
	
}
