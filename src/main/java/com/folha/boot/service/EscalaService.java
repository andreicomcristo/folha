package com.folha.boot.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.EscalaReposytoty;
import com.folha.boot.Reposytory.PessoaDocumentosReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;
import com.folha.boot.service.util.UtilidadesMatematicas;

@Service
@Transactional(readOnly = false)
public class EscalaService {

	@Autowired
	private EscalaReposytoty reposytory;
	
	
	public Escala salvar(Escala escala) {
		// TODO Auto-generated method stub
		Escala escala1 = reposytory.save(escala);
		return escala1;
	}
	
	public void editar(Escala escala) {
		// TODO Auto-generated method stub
		reposytory.save(escala);
	}

	public void cancelar(Escala escala) {
		// TODO Auto-generated method stub
		escala.setDtCancelamento(new Date());
		reposytory.save(escala);
	}
	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public Escala buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<Escala> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	
	public List<Escala> buscarPorCoordenacaoEAnoMes(CoordenacaoEscala coordenacaoEscala, AnoMes anoMes) {
		// TODO Auto-generated method stub
		return reposytory.buscarPorCoordenacaoEAnoMes(coordenacaoEscala, anoMes);
	}
	
	
	
	
	
}
