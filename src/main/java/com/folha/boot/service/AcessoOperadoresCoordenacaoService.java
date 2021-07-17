package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.AcessoOperadoresCoordenacaoReposytory;
import com.folha.boot.domain. AcessoOperadoresCoordenacao;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class AcessoOperadoresCoordenacaoService {

	@Autowired
	private  AcessoOperadoresCoordenacaoReposytory reposytory;

	public void salvar(AcessoOperadoresCoordenacao acessoOperadoresCoordenacao) {
		reposytory.save(acessoOperadoresCoordenacao);
	}

	public void editar(AcessoOperadoresCoordenacao acessoOperadoresCoordenacao) {
		reposytory.save(acessoOperadoresCoordenacao);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public  AcessoOperadoresCoordenacao buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List< AcessoOperadoresCoordenacao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	@Transactional(readOnly = true)
	public List< AcessoOperadoresCoordenacao> buscarPorOperador(PessoaOperadores pessoaOperadores) {
		// TODO Auto-generated method stub
		return reposytory.findByIdOperadorFk(pessoaOperadores);
	}
	
	@Transactional(readOnly = true)
	public List< AcessoOperadoresCoordenacao> buscarPorOperadorEUnidade(PessoaOperadores pessoaOperadores, Unidades unidades) {
		// TODO Auto-generated method stub
		return reposytory.findByIdOperadorFkAndIdCoordenacaoFkIdLocalidadeFkIdUnidadeFk(pessoaOperadores, unidades);
	}
	
	
	
	
}
