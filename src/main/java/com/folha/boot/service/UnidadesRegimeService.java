package com.folha.boot.service;

import java.util.List;
import com.folha.boot.domain.UnidadesRegime;

public interface UnidadesRegimeService {
	
	void salvar(UnidadesRegime unidadesRegime);

	void editar(UnidadesRegime unidadesRegime);

	void excluir(Long id);

	UnidadesRegime buscarPorId(Long id);

	List<UnidadesRegime> buscarTodos();
	
	List<UnidadesRegime> buscarPorNome(String nomeRegimeUnidLotacao);

}
