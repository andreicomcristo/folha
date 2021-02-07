package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.PessoaDocumentos;

public interface PessoaDocumentosService {

	void salvar(PessoaDocumentos pessoaDocumentos);

	void editar(PessoaDocumentos pessoaDocumentos);

	void excluir(Long id);

	PessoaDocumentos buscarPorId(Long id);

	List<PessoaDocumentos> buscarTodos();
}
