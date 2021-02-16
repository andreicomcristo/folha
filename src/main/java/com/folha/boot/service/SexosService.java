package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Sexos;

public interface SexosService {

	void salvar(Sexos sexos);

	void editar(Sexos sexos);

	void excluir(Long id);

	Sexos buscarPorId(Long id);

	List<Sexos> buscarTodos();
	
	List<Sexos> buscarPorNome(String nomeSexo);
	
	Sexos converteEmMaiusculo(Sexos sexos);
}
