package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.CargosEspecialidadeReposytory;
import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class CargosEspecialidadeServiceImpl implements CargosEspecialidadeService{

	@Autowired
	private CargosEspecialidadeReposytory reposytory;
	
	@Override
	public void salvar(CargosEspecialidade cargosEspecialidade) {
		// TODO Auto-generated method stub
		reposytory.save(cargosEspecialidade);
		
	}

	@Override
	public void editar(CargosEspecialidade cargosEspecialidade) {
		// TODO Auto-generated method stub
		reposytory.save(cargosEspecialidade);
		
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
		
	}

	@Transactional(readOnly = true)
	@Override
	public CargosEspecialidade buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<CargosEspecialidade> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public CargosEspecialidade converteEmMaiusculo(CargosEspecialidade cargosEspecialidade) {
			
		cargosEspecialidade.setNomeEspecialidadeCargo(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cargosEspecialidade.getNomeEspecialidadeCargo()));
		cargosEspecialidade.setDescricaoEspecialidadeCargo(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cargosEspecialidade.getDescricaoEspecialidadeCargo()));
		return cargosEspecialidade;
	}

}
