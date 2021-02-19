package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.PessoaDocumentosTitulo;

public interface PessoaDocumentosTituloService {

	void salvar(PessoaDocumentosTitulo pessoaDocumentosTitulo);

	void editar(PessoaDocumentosTitulo pessoaDocumentosTitulo);

	void excluir(Long id);

	PessoaDocumentosTitulo buscarPorId(Long id);

	List<PessoaDocumentosTitulo> buscarPorNumero(String numeroTitulo);

	List<PessoaDocumentosTitulo> buscarTodos();
}
