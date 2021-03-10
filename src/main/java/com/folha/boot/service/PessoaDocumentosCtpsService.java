package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PessoaDocumentosCtpsReposytory;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.PessoaDocumentosCtps;


@Service
@Transactional(readOnly = false)
public class PessoaDocumentosCtpsService {

	@Autowired
	private PessoaDocumentosCtpsReposytory reposytory;
	
	
	public void salvar(PessoaDocumentosCtps pessoaDocumentosCtps) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosCtps);
	}

	
	public void editar(PessoaDocumentosCtps pessoaDocumentosCtps) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosCtps);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public PessoaDocumentosCtps buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<PessoaDocumentosCtps> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	
	public List<PessoaDocumentosCtps> buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return reposytory.findByNumeroContainingOrderByNumeroAsc(numero);
	}
	
	
	public List<PessoaDocumentosCtps> buscarPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findByIdPessoaFk(pessoa);
	}

}
