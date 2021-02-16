package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.CargosReposytory;
import com.folha.boot.domain.Cargos;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class CargosServiceImpl implements CargosService{
	
	@Autowired
	private CargosReposytory reposytory;
	
	@Override
	public void salvar(Cargos cargos) {
		// TODO Auto-generated method stub
		reposytory.save(cargos);
		
	}

	@Override
	public void editar(Cargos cargos) {
		// TODO Auto-generated method stub
		reposytory.save(cargos);
		
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Cargos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	@Override 
	public List<Cargos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override 
	public Cargos converteEmMaiusculo(Cargos cargos) {	
		cargos.setNomeCargo(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cargos.getNomeCargo()));
		cargos.setDescricaoCargo(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cargos.getDescricaoCargo()));
		
		return cargos;
	}

	@Override
	public List<Cargos> buscarPorNome(String nomeCargo) {
		// TODO Auto-generated method stub		
		return reposytory.findByNomeCargoContainingOrderByNomeCargoAsc(nomeCargo);
	};
	
}
