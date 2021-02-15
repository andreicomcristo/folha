package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.Carreiras;

public interface BancosService {

	void salvar(Bancos bancos);

	void editar(Bancos bancos);

	void excluir(Long id);

	Bancos buscarPorId(Long id);

	List<Bancos> buscarTodos();
	
	List<Bancos> buscarPorNome(String nomeBanco);
	
	Bancos converteEmMaiusculo(Bancos bancos);

}
