package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PessoaBancosReposytory;
import com.folha.boot.domain.PessoaBancos;

@Service
@Transactional(readOnly = false)
public class PessoaBancosServiceImpl implements PessoaBancosService {

	@Autowired
	private PessoaBancosReposytory reposytory;
	@Override
	public void salvar(PessoaBancos pessoaBancos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaBancos);
	}

	@Override
	public void editar(PessoaBancos pessoaBancos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaBancos);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public PessoaBancos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<PessoaBancos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public List<PessoaBancos> buscarPorNome(String prioritario) {
		// TODO Auto-generated method stub
		return reposytory.findByPrioritarioContainingOrderByPrioritarioAsc(prioritario);
	}
	
}
