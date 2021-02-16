package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.TiposDeDocumento;

public interface TiposDeDocumentoService {
	
	void salvar(TiposDeDocumento tiposDeDocumento);

	void editar(TiposDeDocumento tiposDeDocumento);

	void excluir(Long id);

	TiposDeDocumento buscarPorId(Long id);

	List<TiposDeDocumento> buscarTodos();

	List<TiposDeDocumento> buscarPorNome(String siglaDocumento);
	
	TiposDeDocumento converteEmMaiusculo(TiposDeDocumento tiposDeDocumento);
}
