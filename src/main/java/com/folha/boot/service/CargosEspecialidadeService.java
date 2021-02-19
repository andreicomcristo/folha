package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.CargosEspecialidade;

public interface CargosEspecialidadeService {

	void salvar(CargosEspecialidade cargosEspecialidade);

	void editar(CargosEspecialidade cargosEspecialidade);

	void excluir(Long id);

	CargosEspecialidade buscarPorId(Long id); 

	List<CargosEspecialidade> buscarPorNome(String nomeEspecialidadeCargo);
	
	List<CargosEspecialidade> buscarTodos();
	
}
