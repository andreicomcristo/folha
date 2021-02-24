package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.CidadesReposytory;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Uf;

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
	
	@Transactional(readOnly = true)
	@Override
	public List<Cidades> buscarDuzentos() {
		// TODO Auto-generated method stub
		List<Cidades> lista = reposytory.findAllByOrderByNomeCidadeAsc();
		if (lista.size() > 300) {
			for (int i = lista.size() - 1; i > 200; i--) {
				lista.remove(i);
			}			
		}
		return lista;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Cidades> buscarPorNome(String nomeCidade) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeCidadeContainingOrderByNomeCidadeAsc(nomeCidade);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Cidades> buscarPorIdUf(Uf uf) {
		// TODO Auto-generated method stub
		return reposytory.findByIdUfFk(uf);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Cidades> buscarDuzentos(Uf uf) {
		// TODO Auto-generated method stub
		List<Cidades> lista = reposytory.findByIdUfFk(uf);
		if (lista.size() > 300) {
			for (int i = lista.size() - 1; i > 200; i--) {
				lista.remove(i);
			}			
		}
		return lista;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Cidades> buscarDuzentos(String nomeCidade) {
		// TODO Auto-generated method stub
		List<Cidades> lista = reposytory.findByNomeCidadeContainingOrderByNomeCidadeAsc(nomeCidade.toUpperCase().trim());
		if (lista.size() > 300) {
			for (int i = lista.size() - 1; i > 200; i--) {
				lista.remove(i);
			}			
		}
		return lista;
	}
}
