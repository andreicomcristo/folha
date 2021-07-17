package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.LiberacaoIndividualEscalaReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.LiberacaoIndividualEscala;
import com.folha.boot.domain.Unidades;


@Service
@Transactional(readOnly = false)
public class LiberacaoIndividualEscalaService {

	@Autowired
	private  LiberacaoIndividualEscalaReposytory reposytory;

	public void salvar(LiberacaoIndividualEscala liberacaoIndividualEscala) {
		reposytory.save(liberacaoIndividualEscala);
	}

	public void editar(LiberacaoIndividualEscala liberacaoIndividualEscala) {
		reposytory.save(liberacaoIndividualEscala);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public LiberacaoIndividualEscala buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	public boolean escalaLiberadaExcepcionalmente(AnoMes anoMes, Unidades unidade) {
		boolean resposta = false;
		List<LiberacaoIndividualEscala> lista = reposytory.findByIdAnoMesFkAndIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(anoMes, unidade);
		if(!lista.isEmpty()) {resposta = true;}
		return resposta;
	}
	
	public List<LiberacaoIndividualEscala> buscarTodos() {
		return reposytory.findByDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc();
	}
	
	
	
	@Transactional(readOnly = true)
	public Page<LiberacaoIndividualEscala> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(  pageable);
	}

	
}
