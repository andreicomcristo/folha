package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.SituacaoVariacaoReposytory;
import com.folha.boot.domain.SituacaoVariacao;

@Service
@Transactional(readOnly = false)
public class SituacaoVariacaoService {
	
	@Autowired
	private SituacaoVariacaoReposytory reposytory;
	
	public void salvar(SituacaoVariacao situacaoVariacao) {
		// TODO Auto-generated method stub
		reposytory.save(situacaoVariacao);
	}

	
	public void editar(SituacaoVariacao situacaoVariacao) {
		// TODO Auto-generated method stub
		reposytory.save(situacaoVariacao);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public SituacaoVariacao buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<SituacaoVariacao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeAsc();
	}
	
	
	public List<SituacaoVariacao> buscarPorNome(String nome) {
		return reposytory.findByNomeContainingOrderByNomeAsc(nome.toUpperCase().trim());
	}

}
