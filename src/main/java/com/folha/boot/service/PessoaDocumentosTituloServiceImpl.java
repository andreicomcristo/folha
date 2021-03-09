package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PessoaDocumentosTituloReposytory;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.PessoaDocumentosTitulo;

@Service
@Transactional(readOnly = false)
public class PessoaDocumentosTituloServiceImpl implements PessoaDocumentosTituloService{

	@Autowired
	private PessoaDocumentosTituloReposytory reposytory;
	@Override
	public void salvar(PessoaDocumentosTitulo pessoaDocumentosTitulo) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosTitulo);
	}

	@Override
	public void editar(PessoaDocumentosTitulo pessoaDocumentosTitulo) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosTitulo);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public PessoaDocumentosTitulo buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<PessoaDocumentosTitulo> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public List<PessoaDocumentosTitulo> buscarPorNumero(String numeroTitulo) {
		// TODO Auto-generated method stub
		return reposytory.findByNumeroTituloContainingOrderByNumeroTituloAsc(numeroTitulo);
	}
	
	@Override
	public List<PessoaDocumentosTitulo> buscarPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findByIdPessoaFk(pessoa);
	}

}
