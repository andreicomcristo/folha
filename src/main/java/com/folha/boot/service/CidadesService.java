package com.folha.boot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Uf;

public interface CidadesService {

	void salvar(Cidades cidades);

	void editar(Cidades cidades);

	void excluir(Long id);

	Cidades buscarPorId(Long id);
	
	List<Cidades> buscarTodos();
 
	List<Cidades> buscarDuzentos();
	
	List<Cidades> buscarDuzentos(Uf uf);
	
	List<Cidades> buscarPorIdUf(Uf uf);
	
	List<Cidades> buscarDuzentos(String nomeCidade);
	
	List<Cidades> buscarPorNome(String nomeCidade);

	Page<Cidades> findPaginated(int pageNo, int pageSize); 
	
	Page<Cidades> findPaginatedNome(int pageNo, int pageSize, String nomeCidade);
	
	Page<Cidades> findPaginatedEstado(int pageNo, int pageSize, Uf uf);
		
}
