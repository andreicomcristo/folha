package com.folha.boot.service;

import java.util.List;

import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.CargaHorariaSemanal;
import com.folha.boot.domain.Carreiras;

public interface CargaHorariaSemanalService {

	void salvar(CargaHorariaSemanal cargaHorariaSemanal);

	void editar(CargaHorariaSemanal cargaHorariaSemanal);

	void excluir(Long id);

	CargaHorariaSemanal buscarPorId(Long id);

	List<CargaHorariaSemanal> buscarTodos();
	
	List<CargaHorariaSemanal> buscarPorCargaHorariaSemanal(int cargaHoraria);
	
	CargaHorariaSemanal converteEmMaiusculo(CargaHorariaSemanal cargaHorariaSemanal);

}
