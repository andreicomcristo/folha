package com.folha.boot.service;

import java.util.List;
import com.folha.boot.domain.PessoaOperadores;

public interface PessoaOperadoresService {

	void salvar(PessoaOperadores pessoaOperadores);

	void editar(PessoaOperadores pessoaOperadores);

	void excluir(Long id);

	PessoaOperadores buscarPorId(Long id);

	List<PessoaOperadores> buscarTodos();
	
	List<PessoaOperadores> buscarPorMotivoCancelamento(String motivoCancelamento);
}
