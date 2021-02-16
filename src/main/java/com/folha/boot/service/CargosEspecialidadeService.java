package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.CargosEspecialidade;

public interface CargosEspecialidadeService {

	void salvar(CargosEspecialidade cargosEspecialidade);

	void editar(CargosEspecialidade cargosEspecialidade);

	void excluir(Long id);

	CargosEspecialidade buscarPorId(Long id);

	CargosEspecialidade converteEmMaiusculo(CargosEspecialidade cargosEspecialidade);

	List<CargosEspecialidade> buscarTodos();
	
}
