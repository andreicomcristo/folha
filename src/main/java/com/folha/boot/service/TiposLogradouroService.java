package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.TiposLogradouro;

public interface TiposLogradouroService {

	void salvar(TiposLogradouro tiposLogradouro);

	void editar(TiposLogradouro tiposLogradouro);

	void excluir(Long id);

	TiposLogradouro buscarPorId(Long id);

	List<TiposLogradouro> buscarTodos();

	List<TiposLogradouro> buscarPorNome(String nomeTipoLogradouro);

}
