package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.VinculosReposytory;
import com.folha.boot.domain.Vinculos;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class VinculosServiceImpl implements VinculosService{

	@Autowired
	private UtilidadesDeTexto utilidadesDeTexto;
	
	@Autowired
	private VinculosReposytory reposytory;
	
	@Override
	public void salvar(Vinculos vinculos) {
		// TODO Auto-generated method stub
		reposytory.save(vinculos);
	}

	@Override
	public void editar(Vinculos vinculos) {
		// TODO Auto-generated method stub
		reposytory.save(vinculos);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Vinculos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Vinculos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeVinculoAsc();
	}

	@Override
	public List<Vinculos> buscarPorNome(String nomeVinculo) {
		return reposytory.findByNomeVinculoContainingOrderByNomeVinculoAsc(nomeVinculo);
	}
	
	@Override
	public Vinculos converteEmMaiusculo(Vinculos vinculos) {
		vinculos.setNomeVinculo( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(vinculos.getNomeVinculo()));
		vinculos.setDescricaoVinculo( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(vinculos.getDescricaoVinculo()));
	return vinculos;
	}
}
