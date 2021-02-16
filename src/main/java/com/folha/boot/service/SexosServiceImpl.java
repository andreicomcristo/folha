package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.SexosReposytory;
import com.folha.boot.domain.Sexos;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class SexosServiceImpl implements SexosService {

	UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
	
	@Autowired
	private SexosReposytory reposytory;

	@Override
	public void salvar(Sexos sexos) {
		// TODO Auto-generated method stub
		reposytory.save(sexos);
	}

	@Override
	public void editar(Sexos sexos) {
		// TODO Auto-generated method stub
		reposytory.save(sexos);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Sexos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Sexos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeSexoAsc();
	}
	
	@Override
	public List<Sexos> buscarPorNome(String nomeSexo) {
		return reposytory.findByNomeSexoContainingOrderByNomeSexoAsc(nomeSexo);
	}
	
	@Override
	public Sexos converteEmMaiusculo(Sexos sexos) {
		sexos.setNomeSexo( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(sexos.getNomeSexo()));
		sexos.setDescricaoSexo( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(sexos.getDescricaoSexo()));
		
	return sexos;
	}
}
