package com.folha.boot.service;

import java.util.List;
import com.folha.boot.domain.Escolaridades;

public interface EscolaridadesService {
	
	void salvar(Escolaridades escolaridades);

	void editar(Escolaridades escolaridades);

	void excluir(Long id);

	Escolaridades buscarPorId(Long id);

	List<Escolaridades> buscarTodos();

	List<Escolaridades> buscarPorNome(String nomeEscolaridade);
	
}
