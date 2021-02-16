package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.TiposDeFiliacao;

public interface TiposDeFiliacaoService {
	
	void salvar(TiposDeFiliacao tiposDeFiliacao);

	void editar(TiposDeFiliacao tiposDeFiliacao);

	void excluir(Long id);

	TiposDeFiliacao buscarPorId(Long id);

	List<TiposDeFiliacao> buscarTodos();

	List<TiposDeFiliacao> buscarPorNome(String nomeTipoFiliacao);
	
	TiposDeFiliacao converteEmMaiusculo(TiposDeFiliacao tiposDeFiliacao);
}
