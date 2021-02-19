package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PessoaDocumentosReposytory;
import com.folha.boot.domain.PessoaDocumentos;

@Service
@Transactional(readOnly = false)
public class PessoaDocumentosServiceImpl implements PessoaDocumentosService{

	@Autowired
	private PessoaDocumentosReposytory reposytory;
	
	@Override
	public void salvar(PessoaDocumentos pessoaDocumentos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentos);
	}

	@Override
	public void editar(PessoaDocumentos pessoaDocumentos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentos);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public PessoaDocumentos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<PessoaDocumentos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public List<PessoaDocumentos> buscarPorNome(String pessoaDocumentos) {
		// TODO Auto-generated method stub
		return reposytory.findByNumeroDocumentoContainingOrderByNumeroDocumentoAsc(pessoaDocumentos);
	}

}
