package com.folha.boot.service;

import java.util.List;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Uf;

public interface CidadesService {

	void salvar(Cidades cidades);

	void editar(Cidades cidades);

	void excluir(Long id);

	Cidades buscarPorId(Long id);
	
	List<Cidades> buscarPorNome(String nomeCidade);
	
	List<Cidades> buscarTodos();
	
	List<Cidades> buscarPorIdUf(Uf uf);
}
