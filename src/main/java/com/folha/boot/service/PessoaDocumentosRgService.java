package com.folha.boot.service;

import java.util.List;
import com.folha.boot.domain.PessoaDocumentosRg;

public interface PessoaDocumentosRgService {

	void salvar(PessoaDocumentosRg pessoaDocumentosRg);

	void editar(PessoaDocumentosRg pessoaDocumentosRg);

	void excluir(Long id);

	PessoaDocumentosRg buscarPorId(Long id);

	List<PessoaDocumentosRg> buscarPorNumero(String rgNumero);

	List<PessoaDocumentosRg> buscarTodos();
}
