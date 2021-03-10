package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.TiposLogradouroReposytory;
import com.folha.boot.domain.TiposLogradouro;

@Service
@Transactional(readOnly = false)
public class TiposLogradouroService {

	@Autowired
	private TiposLogradouroReposytory reposytory;
	
	
	public void salvar(TiposLogradouro tiposLogradouro) {
		// TODO Auto-generated method stub
		reposytory.save(tiposLogradouro);
		
	}

	
	public void editar(TiposLogradouro tiposLogradouro) {
		// TODO Auto-generated method stub
		reposytory.save(tiposLogradouro);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public TiposLogradouro buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<TiposLogradouro> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeTipoLogradouroAsc();
	}

	
	public List<TiposLogradouro> buscarPorNome(String nomeTipoLogradouro) {
		return reposytory.findByNomeTipoLogradouroContainingOrderByNomeTipoLogradouroAsc(nomeTipoLogradouro);
	}

}
