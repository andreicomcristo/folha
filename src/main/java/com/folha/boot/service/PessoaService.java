package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PessoaReposytory;
import com.folha.boot.domain.Pessoa;

@Service
@Transactional(readOnly = false)
public class PessoaService {

	@Autowired
	private PessoaReposytory reposytory;
	
	
	public Pessoa salvar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.save(pessoa);
	}

	
	public void editar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		reposytory.save(pessoa);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public Pessoa buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<Pessoa> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findByDtCancelamentoIsNullOrderByNomeAsc();
	}

	
	public List<Pessoa> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeContainingAndDtCancelamentoIsNullOrderByNomeAsc(nome);
	}
	
	
	public List<Pessoa> buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return reposytory.findByCpfAndDtCancelamentoIsNullOrderByNomeAsc(cpf);
	}
	
}
