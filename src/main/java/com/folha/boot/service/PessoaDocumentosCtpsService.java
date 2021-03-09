package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.PessoaDocumentosCtps;

public interface PessoaDocumentosCtpsService {

	void salvar(PessoaDocumentosCtps pessoaDocumentosCtps);

	void editar(PessoaDocumentosCtps pessoaDocumentosCtps);

	void excluir(Long id);

	PessoaDocumentosCtps buscarPorId(Long id);

	List<PessoaDocumentosCtps> buscarPorNumero(String numero);

	List<PessoaDocumentosCtps> buscarTodos();
	
	List<PessoaDocumentosCtps> buscarPorPessoa(Pessoa pessoa);
}

