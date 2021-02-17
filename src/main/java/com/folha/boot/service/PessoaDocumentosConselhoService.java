package com.folha.boot.service;

import java.util.List;
import com.folha.boot.domain.PessoaDocumentosConselho;

public interface PessoaDocumentosConselhoService {

	void salvar(PessoaDocumentosConselho pessoaDocumentosConselho);

	void editar(PessoaDocumentosConselho pessoaDocumentosConselho);

	void excluir(Long id);

	PessoaDocumentosConselho buscarPorId(Long id);

	PessoaDocumentosConselho converteEmMaiusculo(PessoaDocumentosConselho pessoaDocumentosConselho);

	List<PessoaDocumentosConselho> buscarPorNome(String numeroConselho);

	List<PessoaDocumentosConselho> buscarTodos();

}
