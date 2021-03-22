package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.CargosEspecialidadeReposytory;
import com.folha.boot.domain.CargosEspecialidade;

@Service
@Transactional(readOnly = false)
public class CargosEspecialidadeService {

	@Autowired
	private CargosEspecialidadeReposytory reposytory;

	public void salvar(CargosEspecialidade cargosEspecialidade) {
		// TODO Auto-generated method stub
		reposytory.save(cargosEspecialidade);
		
	}

	public void editar(CargosEspecialidade cargosEspecialidade) {
		// TODO Auto-generated method stub
		reposytory.save(cargosEspecialidade);
		
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
		
	}

	@Transactional(readOnly = true)
	public CargosEspecialidade buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<CargosEspecialidade> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdCargoFkNomeCargoAscNomeEspecialidadeCargoAsc();
	}

	public List<CargosEspecialidade> buscarPorNome(String nomeEspecialidadeCargo) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeEspecialidadeCargoContainingOrderByNomeEspecialidadeCargoAsc(nomeEspecialidadeCargo);
	}

	@Transactional(readOnly = true)
	public List<CargosEspecialidade> buscarTodosOrdemDeCargo() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdCargoFkNomeCargoAscNomeEspecialidadeCargoAsc();
	}
	
}
