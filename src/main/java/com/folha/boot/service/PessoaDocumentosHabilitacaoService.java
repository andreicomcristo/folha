package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PessoaDocumentosHabilitacaoReposytory;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.PessoaDocumentosHabilitacao;

@Service
@Transactional(readOnly = false)
public class PessoaDocumentosHabilitacaoService {

	@Autowired
	private PessoaDocumentosHabilitacaoReposytory reposytory;
	
	
	public void salvar(PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosHabilitacao);
	}

	
	public void editar(PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosHabilitacao);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public PessoaDocumentosHabilitacao buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<PessoaDocumentosHabilitacao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	
	public List<PessoaDocumentosHabilitacao> buscarPorNome(String numeroRegistro) {
		// TODO Auto-generated method stub
		return reposytory.findByNumeroRegistroContainingOrderByNumeroRegistroAsc(numeroRegistro);
	}

	
	public List<PessoaDocumentosHabilitacao> buscarPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findByIdPessoaFk(pessoa);
	}
	
}
