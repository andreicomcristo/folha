package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.EscolaridadesReposytory;
import com.folha.boot.domain.Escolaridades;

@Service
@Transactional(readOnly = false)
public class EscolaridadesService {
	
	@Autowired
	private EscolaridadesReposytory reposytory;
	
	public void salvar(Escolaridades escolaridades) {
		// TODO Auto-generated method stub
		reposytory.save(escolaridades);
	}

	public void editar(Escolaridades escolaridades) {
		// TODO Auto-generated method stub
		reposytory.save(escolaridades);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Escolaridades buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<Escolaridades> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	public List<Escolaridades> buscarPorNome(String nomeEscolaridade) {
		return reposytory.findByNomeEscolaridadeContainingOrderByNomeEscolaridadeAsc(nomeEscolaridade);
	}
	
}
