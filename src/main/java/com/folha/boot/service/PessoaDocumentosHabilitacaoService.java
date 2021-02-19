package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.PessoaDocumentosHabilitacao;
public interface PessoaDocumentosHabilitacaoService {

	void salvar(PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao);

	void editar(PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao);

	void excluir(Long id);

	PessoaDocumentosHabilitacao buscarPorId(Long id);

	List<PessoaDocumentosHabilitacao> buscarPorNome(String numeroRegistro);

	List<PessoaDocumentosHabilitacao> buscarTodos();
}
