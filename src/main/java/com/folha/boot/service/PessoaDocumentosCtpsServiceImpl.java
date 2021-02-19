package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PessoaDocumentosCtpsReposytory;
import com.folha.boot.domain.PessoaDocumentosCtps;


@Service
@Transactional(readOnly = false)
public class PessoaDocumentosCtpsServiceImpl implements PessoaDocumentosCtpsService{

	@Autowired
	private PessoaDocumentosCtpsReposytory reposytory;
	
	@Override
	public void salvar(PessoaDocumentosCtps pessoaDocumentosCtps) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosCtps);
	}

	@Override
	public void editar(PessoaDocumentosCtps pessoaDocumentosCtps) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosCtps);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public PessoaDocumentosCtps buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<PessoaDocumentosCtps> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public List<PessoaDocumentosCtps> buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return reposytory.findByNumeroContainingOrderByNumeroAsc(numero);
	}

}
