package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.Conselhos;

public interface ConselhosServices {

	void salvar(Conselhos cconselhos);

	void editar(Conselhos cconselhos);

	void excluir(Long id);

	Conselhos buscarPorId(Long id);

	List<Conselhos> buscarTodos();
	
	List<Conselhos> buscarPorDescricao(String descricaoConselho);
	
	Conselhos converteEmMaiusculo(Conselhos conselhos);
}
