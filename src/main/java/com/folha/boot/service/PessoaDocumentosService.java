package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PessoaDocumentosReposytory;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;

@Service
@Transactional(readOnly = false)
public class PessoaDocumentosService {

	@Autowired
	private PessoaDocumentosReposytory reposytory;
	
	
	public void salvar(PessoaDocumentos pessoaDocumentos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentos);
	}

	
	public void editar(PessoaDocumentos pessoaDocumentos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentos);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public PessoaDocumentos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<PessoaDocumentos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	
	public List<PessoaDocumentos> buscarPorNome(String pessoaDocumentos) {
		// TODO Auto-generated method stub
		return reposytory.findByNumeroDocumentoContainingOrderByNumeroDocumentoAsc(pessoaDocumentos);
	}
	
	
	public List<PessoaDocumentos> buscarPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findByIdPessoaFk(pessoa);
	}

}
