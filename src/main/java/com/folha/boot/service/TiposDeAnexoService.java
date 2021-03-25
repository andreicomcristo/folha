package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.TiposDeAnexoReposytory;
import com.folha.boot.domain.TiposDeAnexo;

@Service
@Transactional(readOnly = false)
public class TiposDeAnexoService {

	@Autowired
	private  TiposDeAnexoReposytory reposytory;

	public void salvar(TiposDeAnexo tiposDeAnexo) {
		reposytory.save(tiposDeAnexo);
	}

	public void editar(TiposDeAnexo tiposDeAnexo) {
		reposytory.save(tiposDeAnexo);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public TiposDeAnexo buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<TiposDeAnexo> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
}
