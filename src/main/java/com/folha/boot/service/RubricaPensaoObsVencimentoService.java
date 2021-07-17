package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.RubricaPensaoObsVencimentoReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.RubricaPensaoObsVencimento;



@Service
@Transactional(readOnly = false)
public class RubricaPensaoObsVencimentoService {	
	@Autowired
	private RubricaPensaoObsVencimentoReposytory reposytory;

	//@Override
	public void salvar(RubricaPensaoObsVencimento rubricaPensaoObsVencimento) {
		reposytory.save(rubricaPensaoObsVencimento);
	}
	
	
	//@Override
	public void editar(RubricaPensaoObsVencimento rubricaPensaoObsVencimento) {
		reposytory.save(rubricaPensaoObsVencimento);
	}

	//@Override
	public void excluir(Long id) {
		reposytory.deleteById(id);
	}
	
	public void excluirPorMes(AnoMes anoMes) {
		reposytory.deleteByIdAnoMesFk(anoMes);
	}

	@Transactional(readOnly = true)
	//@Override
	public RubricaPensaoObsVencimento buscarPorId(Long id) {
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	//@Override
	public List<RubricaPensaoObsVencimento> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	//@Override
	public List<RubricaPensaoObsVencimento> buscarPorMes(AnoMes anoMes) {
		return reposytory.findByIdAnoMesFkOrderByIdAnoMesFkAscIdRubricaPensaoObsFkIdRubricaPensaoFkIdPessoaFkCpfAsc(anoMes);
	}
	
	
	
	
}
