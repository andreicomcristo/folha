package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Enderecos;

public interface EnderecosServices {

	void salvar(Enderecos enderecos);

	void editar(Enderecos enderecos);

	void excluir(Long id);

	Enderecos buscarPorId(Long id);

	List<Enderecos> buscarPorNome(String enderecoLogradouro);

	List<Enderecos> buscarTodos();
}
