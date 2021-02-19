package com.folha.boot.service;

import java.util.List;
import com.folha.boot.domain.Pessoa;

public interface PessoaService {

	void salvar(Pessoa pessoa);

	void editar(Pessoa pessoa);

	void excluir(Long id);

	Pessoa buscarPorId(Long id);

	List<Pessoa> buscarPorNome(String nome);

	List<Pessoa> buscarTodos();
}
