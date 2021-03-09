package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PessoaDocumentosRgReposytory;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.PessoaDocumentosRg;

@Service
@Transactional(readOnly = false)
public class PessoaDocumentosRgServiceImpl implements PessoaDocumentosRgService{

	@Autowired
	private PessoaDocumentosRgReposytory reposytory;
	@Override
	public void salvar(PessoaDocumentosRg pessoaDocumentosRg) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosRg);
	}

	@Override
	public void editar(PessoaDocumentosRg pessoaDocumentosRg) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosRg);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public PessoaDocumentosRg buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<PessoaDocumentosRg> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public List<PessoaDocumentosRg> buscarPorNumero(String rgNumero) {
		// TODO Auto-generated method stub
		return reposytory.findByRgNumeroContainingOrderByRgNumeroAsc(rgNumero);
	}
	
	@Override
	public List<PessoaDocumentosRg> buscarPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findByIdPessoaFk(pessoa);
	}

}
