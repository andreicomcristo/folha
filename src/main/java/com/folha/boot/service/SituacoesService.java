package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Situacoes;

public interface SituacoesService {

	void salvar(Situacoes situacoes);

	void editar(Situacoes situacoes);

	void excluir(Long id);

	Situacoes buscarPorId(Long id);

	List<Situacoes> buscarTodos();
	
	List<Situacoes> buscarPorNome(String nomeSituacao);
	
	Situacoes converteEmMaiusculo(Situacoes situacoes);
}
