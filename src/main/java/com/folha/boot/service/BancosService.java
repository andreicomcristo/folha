package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Bancos;

public interface BancosService {

	void salvar(Bancos bancos);

	void editar(Bancos bancos);

	void excluir(Long id);

	Bancos buscarPorId(Long id);

	List<Bancos> buscarTodos();
	
	List<Bancos> buscarPorNome(String nomeBanco);

}
