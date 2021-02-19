package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.UnidadesNaturezaJuridica;

public interface UnidadesNaturezaJuridicaService {
	
	void salvar(UnidadesNaturezaJuridica unidadesNaturezaJuridica);

	void editar(UnidadesNaturezaJuridica unidadesNaturezaJuridica);

	void excluir(Long id);

	UnidadesNaturezaJuridica buscarPorId(Long id);

	List<UnidadesNaturezaJuridica> buscarTodos();
	
	List<UnidadesNaturezaJuridica> buscarPorNome(String nomeNaturezaJuridica);

}
