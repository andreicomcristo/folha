package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.EscolaridadesReposytory;
import com.folha.boot.domain.Escolaridades;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class EscolaridadesServiceImpl implements EscolaridadesService{
	
	@Autowired
	private EscolaridadesReposytory reposytory;
	
	@Override
	public void salvar(Escolaridades escolaridades) {
		// TODO Auto-generated method stub
		reposytory.save(escolaridades);
	}

	@Override
	public void editar(Escolaridades escolaridades) {
		// TODO Auto-generated method stub
		reposytory.save(escolaridades);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Escolaridades buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Escolaridades> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public List<Escolaridades> buscarPorNome(String nomeEscolaridade) {
		return reposytory.findByNomeEscolaridadeContainingOrderByNomeEscolaridadeAsc(nomeEscolaridade);
	}
	
	@Override
	public Escolaridades converteEmMaiusculo(Escolaridades escolaridades) {
		escolaridades.setNomeEscolaridade(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(escolaridades.getNomeEscolaridade()));
		escolaridades.setDescricaoEscolaridade(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(escolaridades.getDescricaoEscolaridade()));
		return escolaridades;
	}
}
