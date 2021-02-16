package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.UfReposytory;
import com.folha.boot.domain.Uf;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class UfServiceImpl implements UfService{

	@Autowired
	private UfReposytory reposytory;
	
	@Override
	public void salvar(Uf uf) {
		// TODO Auto-generated method stub
		reposytory.save(uf);	
	}

	@Override
	public void editar(Uf uf) {
		// TODO Auto-generated method stub
		reposytory.save(uf);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Uf buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Uf> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeUfAsc();
	}
	
	@Override
	public List<Uf> buscarPorNome(String nomeUf) {
		return reposytory.findByNomeUfContainingOrderByNomeUfAsc(nomeUf);
	}
	
	@Override
	public Uf converteEmMaiusculo(Uf uf) {
		uf.setSiglaUf(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(uf.getSiglaUf()));
		uf.setNomeUf(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(uf.getNomeUf()));
	return uf;
	}

}
