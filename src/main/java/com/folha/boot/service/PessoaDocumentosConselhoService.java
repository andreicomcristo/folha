package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PessoaDocumentosConselhoReposytory;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentosConselho;

@Service
@Transactional(readOnly = false)
public class PessoaDocumentosConselhoService {

	@Autowired
	private PessoaDocumentosConselhoReposytory reposytory;
	
	
	public void salvar(PessoaDocumentosConselho pessoaDocumentosConselho) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosConselho);
	}

	
	public void editar(PessoaDocumentosConselho pessoaDocumentosConselho) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosConselho);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public PessoaDocumentosConselho buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<PessoaDocumentosConselho> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	
	public List<PessoaDocumentosConselho> buscarPorNome(String numeroConselho) {
		// TODO Auto-generated method stub
		return reposytory.findByNumeroConselhoContainingOrderByNumeroConselhoAsc(numeroConselho);
	}
	
	
	public List<PessoaDocumentosConselho> buscarPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findByIdPessoaFk(pessoa);
	}
	
	public List<PessoaDocumentosConselho> buscarPorPessoaOrdemDataValidade(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findByIdPessoaFkOrderByDtValidadeDesc(pessoa);
	}
	
	

}
