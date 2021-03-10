package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.TiposDeFiliacaoReposytory;
import com.folha.boot.domain.TiposDeFiliacao;

@Service
@Transactional(readOnly = false)
public class TiposDeFiliacaoService {

	@Autowired
	private TiposDeFiliacaoReposytory reposytory;
	
	
	public void salvar(TiposDeFiliacao tiposDeFiliacao) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeFiliacao);
	}

	
	public void editar(TiposDeFiliacao tiposDeFiliacao) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeFiliacao);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public TiposDeFiliacao buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<TiposDeFiliacao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeTipoFiliacaoAsc();
	}
	
	
	public List<TiposDeFiliacao> buscarPorNome(String nomeTipoFiliacao) {
		return reposytory.findByNomeTipoFiliacaoContainingOrderByNomeTipoFiliacaoAsc(nomeTipoFiliacao);
	}

}
