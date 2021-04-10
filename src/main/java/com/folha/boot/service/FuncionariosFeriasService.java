package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.FuncionariosFeriasReposytory;
import com.folha.boot.domain.FuncionariosFerias;

@Service
@Transactional(readOnly = false)
public class FuncionariosFeriasService {

	@Autowired
	private  FuncionariosFeriasReposytory reposytory;

	public FuncionariosFerias salvar(FuncionariosFerias funcionariosFerias) {
		return reposytory.save(funcionariosFerias);
	}

	public void editar(FuncionariosFerias funcionariosFerias) {
		reposytory.save(funcionariosFerias);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public FuncionariosFerias buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<FuncionariosFerias> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByAnoReferenciaAsc();
	}
	
	public List<FuncionariosFerias> buscarPorAnoReferencia(String anoReferencia) {
		return reposytory.findByAnoReferenciaContainingOrderByAnoReferenciaAsc(anoReferencia);
	}
}
