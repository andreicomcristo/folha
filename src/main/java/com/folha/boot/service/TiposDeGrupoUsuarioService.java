package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.TiposDeGrupoUsuarioReposytory;
import com.folha.boot.Reposytory.TiposLogradouroReposytory;
import com.folha.boot.domain.TiposDeGrupoUsuario;
import com.folha.boot.domain.TiposLogradouro;

@Service
@Transactional(readOnly = false)
public class TiposDeGrupoUsuarioService {

	@Autowired
	private TiposDeGrupoUsuarioReposytory reposytory;
	
	
	public void salvar(TiposDeGrupoUsuario tiposDeGrupoUsuario) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeGrupoUsuario);
		
	}

	
	public void editar(TiposDeGrupoUsuario tiposDeGrupoUsuario) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeGrupoUsuario);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public TiposDeGrupoUsuario buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<TiposDeGrupoUsuario> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeAsc();
	}

	
	public List<TiposDeGrupoUsuario> buscarPorNome(String nome) {
		return reposytory.findByNomeContainingOrderByNomeAsc(nome);
	}
	
	public List<TiposDeGrupoUsuario> buscarPorNomeExato(String nome) {
		return reposytory.findByNomeOrderByNomeAsc(nome);
	}

}
