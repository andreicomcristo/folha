package com.folha.boot.service;

import java.util.List;
import com.folha.boot.domain.PessoaFilhos;

public interface PessoaFilhosService {

	void salvar(PessoaFilhos pessoaFilhos);

	void editar(PessoaFilhos pessoaFilhos);

	void excluir(Long id);

	PessoaFilhos buscarPorId(Long id);

	List<PessoaFilhos> buscarTodos();
	
	List<PessoaFilhos> buscarPorNome(String nomeFilho);
}
