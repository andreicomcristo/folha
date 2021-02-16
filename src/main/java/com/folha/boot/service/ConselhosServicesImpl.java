package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.ConselhosReposytory;
import com.folha.boot.domain.Conselhos;
import com.folha.boot.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class ConselhosServicesImpl implements ConselhosServices{

	UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
	
	@Autowired
	private ConselhosReposytory reposytory;

	@Override
	public void salvar(Conselhos conselhos) {
		// TODO Auto-generated method stub
		reposytory.save(conselhos);
	}

	@Override
	public void editar(Conselhos conselhos) {
		// TODO Auto-generated method stub
		reposytory.save(conselhos);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Conselhos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Conselhos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	@Override
	public List<Conselhos> buscarPorDescricao(String descricaoConselho) {
		return reposytory.findByDescricaoConselhoContainingOrderByDescricaoConselhoAsc(descricaoConselho);
	}
	
	@Override
	public Conselhos converteEmMaiusculo(Conselhos conselhos) {
		conselhos.setNomeConselho( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(conselhos.getNomeConselho()));
		conselhos.setDescricaoConselho( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(conselhos.getDescricaoConselho()));
		
	return conselhos;
	}

}
