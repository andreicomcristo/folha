package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.AutorizacoesReposytory;
import com.folha.boot.domain.Autorizacoes;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class AutorizacoesServiceImpl implements AutorizacoesService {

	
	
	@Autowired
	private AutorizacoesReposytory reposytory;

	@Override
	public void salvar(Autorizacoes autorizacoes) {

		reposytory.save(autorizacoes);
	}


	@Override
	public void editar(Autorizacoes autorizacoes) {

		reposytory.save(autorizacoes);

	}

	@Override
	public void excluir(Long id) {
		
		reposytory.deleteById(id);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Autorizacoes buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Autorizacoes> buscarTodos() {
			
		return reposytory.findAll();
	}

}
