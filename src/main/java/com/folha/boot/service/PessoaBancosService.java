package com.folha.boot.service;

import java.util.List;
import com.folha.boot.domain.PessoaBancos;

public interface PessoaBancosService {
	
	void salvar(PessoaBancos pessoaBancos);

	void editar(PessoaBancos pessoaBancos);

	void excluir(Long id);

	PessoaBancos buscarPorId(Long id);

	List<PessoaBancos> buscarTodos();
	
	List<PessoaBancos> buscarPorNome(String prioritario);
}
