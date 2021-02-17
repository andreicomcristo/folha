package com.folha.boot.service;

import java.util.List;
import com.folha.boot.domain.Cidades;

public interface CidadesService {

	void salvar(Cidades cidades);

	void editar(Cidades cidades);

	void excluir(Long id);

	Cidades buscarPorId(Long id);

	Cidades converteEmMaiusculo(Cidades cidades);
	
	List<Cidades> buscarPorNome(String nomeCidade);
	
	List<Cidades> buscarTodos();
}
