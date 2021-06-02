package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.AnoMesReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.service.util.Extenso;

@Service
@Transactional(readOnly = false)
public class AnoMesService {

	
	@Autowired
	private  AnoMesReposytory reposytory;

	public void salvar(AnoMes anoMes) {
		reposytory.save(anoMes);
	}

	public void editar(AnoMes anoMes) {
		reposytory.save(anoMes);
	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public AnoMes buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<AnoMes> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeAnoMesDesc();
	}
	
	public AnoMes buscarPorEscalaLiberadaAtual() {
		return reposytory.findFirstByIdEscalaBloqueadaFkSiglaOrderByNomeAnoMesAsc("N");
	}
	
	
	public List<AnoMes> buscarPorNome(String nomeAnoMes) {
		return reposytory.findByNomeAnoMesOrderByNomeAnoMesDesc(nomeAnoMes);
	}
	
	public boolean escalaBloqueada (String nomeAnoMes) {
		boolean resposta = true;
		List<AnoMes> lista = buscarPorNome(nomeAnoMes);
		if(!lista.isEmpty()) {
			if(lista.get(0).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("N")) {
				resposta = false;
			}
		}
		return resposta;
	}
	
	
}
