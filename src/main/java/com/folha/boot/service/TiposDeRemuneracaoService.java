package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.TiposDeFolhaReposytory;
import com.folha.boot.Reposytory.TiposDeRemuneracaoReposytory;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.TiposDeRemuneracao;

@Service
@Transactional(readOnly = false)
public class TiposDeRemuneracaoService {

	@Autowired
	private TiposDeRemuneracaoReposytory reposytory;
	
	public void salvar(TiposDeRemuneracao tipo) {
		// TODO Auto-generated method stub
		reposytory.save(tipo);
	}
	
	public void editar(TiposDeRemuneracao tipo) {
		// TODO Auto-generated method stub
		reposytory.save(tipo);
	}
	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public TiposDeRemuneracao buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<TiposDeRemuneracao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeTipoRemuneracaoAsc();
	}
	@Transactional(readOnly = true)
	public List<TiposDeRemuneracao> buscarPorNome(String nome) {
		return reposytory.findByNomeTipoRemuneracaoContainingOrderByNomeTipoRemuneracaoAsc(nome);
	}
	
}
