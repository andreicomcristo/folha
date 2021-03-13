package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PessoaDocumentosReservistaReposytory;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentosReservista;

@Service
@Transactional(readOnly = false)
public class PessoaDocumentosReservistaService {

	@Autowired
	private PessoaDocumentosReservistaReposytory reposytory;
	
	
	public void salvar(PessoaDocumentosReservista pessoaDocumentosReservista) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosReservista);
	}

	
	public void editar(PessoaDocumentosReservista pessoaDocumentosReservista) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosReservista);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public PessoaDocumentosReservista buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<PessoaDocumentosReservista> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	
	public List<PessoaDocumentosReservista> buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return reposytory.findByNumeroContainingOrderByNumeroAsc(numero);
	}

	
	public List<PessoaDocumentosReservista> buscarPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findByIdPessoaFk(pessoa);
	}
	
}
