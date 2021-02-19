package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.HabilitacaoCategorias;

public interface HabilitacaoCategoriasService {

	void salvar(HabilitacaoCategorias habilitacaoCategorias);

	void editar(HabilitacaoCategorias habilitacaoCategorias);

	void excluir(Long id);

	HabilitacaoCategorias  buscarPorId(Long id);

	List<HabilitacaoCategorias > buscarTodos();
	
	List<HabilitacaoCategorias> buscarPorNome(String nomeHabilitacaoCategorias);
	
}
