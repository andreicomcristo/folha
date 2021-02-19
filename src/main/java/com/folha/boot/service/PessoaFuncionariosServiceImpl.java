package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PessoaFuncionariosReposytory;
import com.folha.boot.domain.PessoaFuncionarios;

@Service
@Transactional(readOnly = false)
public class PessoaFuncionariosServiceImpl implements PessoaFuncionariosService{

	@Autowired
	private PessoaFuncionariosReposytory reposytory;
	@Override
	public void salvar(PessoaFuncionarios pessoaFuncionarios) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaFuncionarios);
	}

	@Override
	public void editar(PessoaFuncionarios pessoaFuncionarios) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaFuncionarios);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public PessoaFuncionarios buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<PessoaFuncionarios> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public List<PessoaFuncionarios> buscarPorMatricula(String matricula) {
		// TODO Auto-generated method stub
		return reposytory.findByMatriculaContainingOrderByMatriculaAsc(matricula);
	}

}
