package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.PessoaFuncionarios;

public interface PessoaFuncionariosService {

	void salvar(PessoaFuncionarios pessoaFuncionarios);

	void editar(PessoaFuncionarios pessoaFuncionarios);

	void excluir(Long id);

	PessoaFuncionarios buscarPorId(Long id);

	List<PessoaFuncionarios> buscarTodos();
	
	List<PessoaFuncionarios> buscarPorMatricula(String matricula);
}
