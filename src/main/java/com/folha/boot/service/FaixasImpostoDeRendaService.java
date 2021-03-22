package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.FaixasImpostoDeRendaReposytory;
import com.folha.boot.domain.FaixasImpostoDeRenda;

@Service
@Transactional(readOnly = false)
public class FaixasImpostoDeRendaService {

	@Autowired
	private FaixasImpostoDeRendaReposytory reposytory;

	public void salvar(FaixasImpostoDeRenda faixasImpostoDeRenda) {
		// TODO Auto-generated method stub
		reposytory.save(faixasImpostoDeRenda);
	}

	public void editar(FaixasImpostoDeRenda faixasImpostoDeRenda) {
		// TODO Auto-generated method stub
		reposytory.save(faixasImpostoDeRenda);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public FaixasImpostoDeRenda buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<FaixasImpostoDeRenda> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByAnoMesAsc();
	}
	
	@Transactional(readOnly = true)
	public List<FaixasImpostoDeRenda> buscarPorAnoMes(String anoMes) {
		return reposytory.findByAnoMesContainingOrderByAnoMesAsc(anoMes);
	}
}
