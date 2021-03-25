package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.HistFuncionariosNiveisCarreiraReposytory;
import com.folha.boot.domain.HistFuncionariosNiveisCarreira;

@Service
@Transactional(readOnly = false)
public class HistFuncionariosNiveisCarreiraService {

	@Autowired
	private  HistFuncionariosNiveisCarreiraReposytory reposytory;

	public void salvar(HistFuncionariosNiveisCarreira histFuncionariosNiveisCarreira) {
		reposytory.save(histFuncionariosNiveisCarreira);
	}

	public void editar(HistFuncionariosNiveisCarreira histFuncionariosNiveisCarreira) {
		reposytory.save(histFuncionariosNiveisCarreira);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public HistFuncionariosNiveisCarreira buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<HistFuncionariosNiveisCarreira> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
}
