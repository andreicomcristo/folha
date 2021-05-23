package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.TiposDeFolhaReposytory;
import com.folha.boot.domain.TiposDeFolha;

@Service
@Transactional(readOnly = false)
public class TiposDeFolhaService {

	@Autowired
	private TiposDeFolhaReposytory reposytory;
	
	public void salvar(TiposDeFolha tiposDeFolha) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeFolha);
	}
	
	public void editar(TiposDeFolha tiposDeFolha) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeFolha);
	}
	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public TiposDeFolha buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<TiposDeFolha> buscarNaoEfetivasEVariaveis() {
		// TODO Auto-generated method stub
		return reposytory.findByIdFolhaEfetivaSimNaoFkSiglaAndIdTipoRemuneracaoFkNomeTipoRemuneracaoOrderByNomeTipoFolhaAsc("N", "VARIAVEL");
	}
	
	@Transactional(readOnly = true)
	public List<TiposDeFolha> buscarNaoEfetivas() {
		// TODO Auto-generated method stub
		return reposytory.findByIdFolhaEfetivaSimNaoFkSiglaOrderByNomeTipoFolhaAsc("N");
	}
	
	@Transactional(readOnly = true)
	public List<TiposDeFolha> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeTipoFolhaAsc();
	}
	@Transactional(readOnly = true)
	public List<TiposDeFolha> buscarPorNome(String tiposDeFolha) {
		return reposytory.findByNomeTipoFolhaContainingOrderByNomeTipoFolhaAsc(tiposDeFolha);
	}
	
}
