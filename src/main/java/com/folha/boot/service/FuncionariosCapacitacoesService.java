package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.FuncionariosCapacitacoesReposytory;
import com.folha.boot.domain.FuncionariosCapacitacoes;

@Service
@Transactional(readOnly = false)
public class FuncionariosCapacitacoesService {

	@Autowired
	private  FuncionariosCapacitacoesReposytory reposytory;

	public void salvar(FuncionariosCapacitacoes funcionariosCapacitacoes) {
		reposytory.save(funcionariosCapacitacoes);
	}

	public void editar(FuncionariosCapacitacoes funcionariosCapacitacoes) {
		reposytory.save(funcionariosCapacitacoes);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public FuncionariosCapacitacoes buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<FuncionariosCapacitacoes> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByDescricaoAsc();
	}
	
	public List<FuncionariosCapacitacoes> buscarPorDescricao(String descricao) {
		return reposytory.findByDescricaoContainingOrderByDescricaoAsc(descricao);
	}
}
