package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.EstadosCivisReposytory;
import com.folha.boot.domain.EstadosCivis;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class EstadosCivisServiceImpl implements EstadosCivisService {

	@Autowired
	private EstadosCivisReposytory reposytory;
	
	@Override
	public void salvar(EstadosCivis estadosCivis) {
		// TODO Auto-generated method stub
		reposytory.save(estadosCivis);
	}

	@Override
	public void editar(EstadosCivis estadosCivis) {
		// TODO Auto-generated method stub
		reposytory.save(estadosCivis);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public EstadosCivis buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<EstadosCivis> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeEstadoCivilAsc();
	}

	@Override
	public List<EstadosCivis> buscarPorNome(String nomeEstadoCivil) {
		return reposytory.findByNomeEstadoCivilContainingOrderByNomeEstadoCivilAsc(nomeEstadoCivil);
	}

}
