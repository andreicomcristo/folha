package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PessoaReposytory;
import com.folha.boot.domain.Pessoa;

@Service
@Transactional(readOnly = false)
public class PessoaServiceImpl implements PessoaService{

	@Autowired
	private PessoaReposytory reposytory;
	
	@Override
	public void salvar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		reposytory.save(pessoa);
	}

	@Override
	public void editar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		reposytory.save(pessoa);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Pessoa buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Pessoa> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public List<Pessoa> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeContainingOrderByNomeAsc(nome);
	}
	
	@Override
	public List<Pessoa> buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return reposytory.findByCpfOrderByNomeAsc(cpf);
	}
	
}
