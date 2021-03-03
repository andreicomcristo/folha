package com.folha.boot.service;

import java.util.List;
import com.folha.boot.domain.Unidades;

public interface UnidadesService {
	
	void salvar(Unidades unidades);

	void editar(Unidades unidades);

	void excluir(Long id);

	Unidades buscarPorId(Long id);

	List<Unidades> buscarTodos();

	List<Unidades> buscarPorNome(String nomeFantasia);


}
