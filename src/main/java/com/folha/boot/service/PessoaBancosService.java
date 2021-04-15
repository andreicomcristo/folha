package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PessoaBancosReposytory;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaBancos;
import com.folha.boot.domain.PessoaDocumentos;

@Service
@Transactional(readOnly = false)
public class PessoaBancosService {

	@Autowired
	private PessoaBancosReposytory reposytory;
	
	public void salvar(PessoaBancos pessoaBancos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaBancos);
	}

	
	public void editar(PessoaBancos pessoaBancos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaBancos);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public PessoaBancos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<PessoaBancos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	
	public List<PessoaBancos> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return reposytory.findByIdBancoFkNomeBancoContainingOrderByIdPrioritarioFkSiglaAsc(nome);
	}
	
	public List<PessoaBancos> buscarPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findByIdPessoaFk(pessoa);
	}
	
}
