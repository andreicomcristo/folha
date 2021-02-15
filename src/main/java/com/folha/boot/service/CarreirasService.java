package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Carreiras;

public interface CarreirasService {
	
	void salvar(Carreiras carreiras);

	void editar(Carreiras carreiras);

	void excluir(Long id);

	Carreiras buscarPorId(Long id);

	List<Carreiras> buscarTodos();
	
	List<Carreiras> buscarPorNome(String nomeCarreira);
	
	Carreiras converteEmMaiusculo(Carreiras carreiras);

}
