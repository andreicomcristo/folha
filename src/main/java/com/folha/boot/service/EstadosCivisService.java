package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.EstadosCivis;

public interface EstadosCivisService {

	void salvar(EstadosCivis estadosCivis);

	void editar(EstadosCivis estadosCivis);

	void excluir(Long id);

	EstadosCivis buscarPorId(Long id);

	List<EstadosCivis> buscarTodos();
	
	List<EstadosCivis> buscarPorNome(String nomeEstadosCivis);
	
	EstadosCivis converteEmMaiusculo(EstadosCivis estadosCivis);
}
