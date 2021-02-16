package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Cargos;

public interface CargosService {
	
	void salvar(Cargos cargos);

	void editar(Cargos cargos);

	void excluir(Long id);

	Cargos buscarPorId(Long id);

	List<Cargos> buscarTodos();
	
	List<Cargos> buscarPorNome(String nomeCargo);
	
	Cargos converteEmMaiusculo(Cargos cargo);

}
