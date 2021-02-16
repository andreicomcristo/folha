package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.NiveisCargoReposytory;
import com.folha.boot.domain.NiveisCargo;
import com.folha.boot.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class NiveisCargoServiceImpl implements NiveisCargoService{

	UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
	
	@Autowired
	private NiveisCargoReposytory reposytory;
	
	@Override
	public void salvar(NiveisCargo niveisCargo) {
		// TODO Auto-generated method stub
		reposytory.save(niveisCargo);
	}

	@Override
	public void editar(NiveisCargo niveisCargo) {
		// TODO Auto-generated method stub
		reposytory.save(niveisCargo);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public NiveisCargo buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<NiveisCargo> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeNivelCargoAsc();
	}
	
	@Override
	public List<NiveisCargo> buscarPorNome(String nomeNivelCargo) {
		return reposytory.findByNomeNivelCargoContainingOrderByNomeNivelCargoAsc(nomeNivelCargo);
	}
	
	@Override
	public NiveisCargo converteEmMaiusculo(NiveisCargo niveisCargo) {
		niveisCargo.setSiglaNivelCargo( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(niveisCargo.getSiglaNivelCargo()));
		niveisCargo.setNomeNivelCargo( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(niveisCargo.getNomeNivelCargo()));
		niveisCargo.setDescricaoNivelCargo( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(niveisCargo.getDescricaoNivelCargo()));
		
		return niveisCargo;
	}

}
