package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.ClassesCarreira;
import com.folha.boot.domain.NiveisCarreira;

public interface NiveisCarreiraService {

	void salvar(NiveisCarreira niveisCarreira);

	void editar(NiveisCarreira niveisCarreira);

	void excluir(Long id);

	NiveisCarreira buscarPorId(Long id);

	List<NiveisCarreira> buscarTodos();
	
	List<NiveisCarreira> buscarPorNome(String nomeNivelCarreira);
	
}
