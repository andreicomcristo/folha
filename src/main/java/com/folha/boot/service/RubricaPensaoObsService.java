package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.RubricaPensaoObsReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.RubricaPensaoObs;



@Service
@Transactional(readOnly = false)
public class RubricaPensaoObsService {	
	@Autowired
	private RubricaPensaoObsReposytory reposytory;

	//@Override
	public void salvar(RubricaPensaoObs rubricaPensaoObs) {
		reposytory.save(rubricaPensaoObs);
	}
	
	
	//@Override
	public void editar(RubricaPensaoObs rubricaPensaoObs) {
		reposytory.save(rubricaPensaoObs);
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
	public RubricaPensaoObs buscarPorId(Long id) {
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	//@Override
	public List<RubricaPensaoObs> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	//@Override
	public List<RubricaPensaoObs> buscarPorMes(AnoMes anoMes) {
		return reposytory.findByIdAnoMesFkOrderByIdAnoMesFkAscIdRubricaPensaoFkIdPessoaFkCpfAsc(anoMes);
	}
	
	//@Override
	public List<RubricaPensaoObs> buscarPorMesEPessoa(AnoMes anoMes, Pessoa pessoa) {
		return reposytory.findByIdAnoMesFkAndIdRubricaPensaoFkIdPessoaFkOrderByIdAnoMesFkAsc(anoMes, pessoa);
	}
	
	
}
