package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.CidadesReposytory;
import com.folha.boot.Reposytory.UfReposytory;
import com.folha.boot.domain.Cidades;

@Service
@Transactional(readOnly = false)
public class CidadesServiceImpl implements CidadesService{

	@Autowired
	private CidadesReposytory reposytory;
	
	@Override
	public void salvar(Cidades cidades) {
		// TODO Auto-generated method stub
		reposytory.save(cidades);
	}

	@Override
	public void editar(Cidades cidades) {
		// TODO Auto-generated method stub
		reposytory.save(cidades);
		
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Cidades buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cidades> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeCidadeAsc();
	}

	@Override
	public List<Cidades> buscarPorNome(String nomeCidade) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeCidadeContainingOrderByNomeCidadeAsc(nomeCidade);
	}
	
	@Override
	public List<Cidades> buscarPorIdUf(Long idUf) {
		// TODO Auto-generated method stub
		return reposytory.findByIdUfFk(idUf);
	}
	
}
