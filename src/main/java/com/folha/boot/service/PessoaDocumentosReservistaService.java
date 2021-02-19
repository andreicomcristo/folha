package com.folha.boot.service;

import java.util.List;
import com.folha.boot.domain.PessoaDocumentosReservista;

public interface PessoaDocumentosReservistaService {

	void salvar(PessoaDocumentosReservista pessoaDocumentosReservista);

	void editar(PessoaDocumentosReservista pessoaDocumentosReservista);

	void excluir(Long id);

	PessoaDocumentosReservista buscarPorId(Long id);

	List<PessoaDocumentosReservista> buscarPorNumero(String numero);

	List<PessoaDocumentosReservista> buscarTodos();
}
