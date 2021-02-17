package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PessoaDocumentosHabilitacaoReposytory;
import com.folha.boot.domain.PessoaDocumentosHabilitacao;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class PessoaDocumentosHabilitacaoServiceImpl implements PessoaDocumentosHabilitacaoService{

	@Autowired
	private PessoaDocumentosHabilitacaoReposytory reposytory;
	
	@Override
	public void salvar(PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosHabilitacao);
	}

	@Override
	public void editar(PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosHabilitacao);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public PessoaDocumentosHabilitacao buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<PessoaDocumentosHabilitacao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public PessoaDocumentosHabilitacao converteEmMaiusculo(PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao) {
		// TODO Auto-generated method stub
		pessoaDocumentosHabilitacao.setNumeroRegistro(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoaDocumentosHabilitacao.getNumeroRegistro()));
		return pessoaDocumentosHabilitacao;
	}

	@Override
	public List<PessoaDocumentosHabilitacao> buscarPorNome(String numeroRegistro) {
		// TODO Auto-generated method stub
		return reposytory.findByNumeroRegistroContainingOrderByNumeroRegistroAsc(numeroRegistro);
	}

}
