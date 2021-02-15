package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.NiveisCargo;

public interface NiveisCargoService {

	void salvar(NiveisCargo niveisCargo);

	void editar(NiveisCargo niveisCargo);

	void excluir(Long id);

	NiveisCargo buscarPorId(Long id);

	List<NiveisCargo> buscarTodos();
	
	List<NiveisCargo> buscarPorNome(String nomeNivelCargo);
	
}
