package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.TiposDeFiliacaoReposytory;
import com.folha.boot.domain.TiposDeFiliacao;
import com.folha.boot.service.util.*;

@Service
@Transactional(readOnly = false)
public class TiposDeFiliacaoServiceImpl implements TiposDeFiliacaoService {

	@Autowired
	private UtilidadesDeTexto utilidadesDeTexto;
	
	@Autowired
	private TiposDeFiliacaoReposytory reposytory;
	
	@Override
	public void salvar(TiposDeFiliacao tiposDeFiliacao) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeFiliacao);
	}

	@Override
	public void editar(TiposDeFiliacao tiposDeFiliacao) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeFiliacao);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public TiposDeFiliacao buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<TiposDeFiliacao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeTipoFiliacaoAsc();
	}
	
	@Override
	public List<TiposDeFiliacao> buscarPorNome(String nomeTipoFiliacao) {
		return reposytory.findByNomeTipoFiliacaoContainingOrderByNomeTipoFiliacaoAsc(nomeTipoFiliacao);
	}
	
	@Override
	public TiposDeFiliacao converteEmMaiusculo(TiposDeFiliacao tiposDeFiliacao) {
		tiposDeFiliacao.setNomeTipoFiliacao( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(tiposDeFiliacao.getNomeTipoFiliacao()));
		tiposDeFiliacao.setDescricaoTipoFiliacao( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(tiposDeFiliacao.getDescricaoTipoFiliacao()));
	return tiposDeFiliacao;
	}

}
