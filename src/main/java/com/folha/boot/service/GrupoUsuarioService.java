package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.BancosReposytory;
import com.folha.boot.Reposytory.GrupoUsuarioReposytory;
import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.GrupoUsuario;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class GrupoUsuarioService {	
	@Autowired
	private GrupoUsuarioReposytory reposytory;

	//@Override
	public void salvar(GrupoUsuario grupoUsuario) {
		reposytory.save(grupoUsuario);
	}

	//@Override
	public void editar(GrupoUsuario grupoUsuario) {
		reposytory.save(grupoUsuario);

	}

	//@Override
	public void excluir(Long id) {
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	//@Override
	public GrupoUsuario buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	//@Override
	public List<GrupoUsuario> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeAsc();
	}
	
	//@Override
	public List<GrupoUsuario> buscarPorNome(String nome) {
		return reposytory.findByNomeContainingOrderByNomeAsc(nome.toUpperCase().trim());
	}
	
	
}
