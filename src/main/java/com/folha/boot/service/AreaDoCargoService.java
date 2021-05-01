package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.AnoMesReposytory;
import com.folha.boot.Reposytory.AreaDoCargoReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.AreaDoCargo;

@Service
@Transactional(readOnly = false)
public class AreaDoCargoService {

	@Autowired
	private  AreaDoCargoReposytory reposytory;

	public void salvar(AreaDoCargo areaDoCargo) {
		reposytory.save(areaDoCargo);
	}

	public void editar(AreaDoCargo areaDoCargo) {
		reposytory.save(areaDoCargo);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public AreaDoCargo buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<AreaDoCargo> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeAsc();
	}
	
	public List<AreaDoCargo> buscarPorNome(String nome) {
		return reposytory.findByNomeOrderByNomeAsc(nome);
	}
	
	
	
}
