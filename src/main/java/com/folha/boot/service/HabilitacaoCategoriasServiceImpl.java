package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HabilitacaoCategoriasReposytory;
import com.folha.boot.domain.HabilitacaoCategorias;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class HabilitacaoCategoriasServiceImpl implements HabilitacaoCategoriasService{

	@Autowired
	private HabilitacaoCategoriasReposytory reposytory;

	@Override
	public void salvar(HabilitacaoCategorias habilitacaoCategorias) {
		// TODO Auto-generated method stub
		reposytory.save(habilitacaoCategorias);
	}

	@Override
	public void editar(HabilitacaoCategorias habilitacaoCategorias) {
		// TODO Auto-generated method stub
		reposytory.save(habilitacaoCategorias);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public HabilitacaoCategorias buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<HabilitacaoCategorias> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeHabilitacaoCategoriaAsc();
	}

	@Override
	public List<HabilitacaoCategorias> buscarPorNome(String nomeHabilitacaoCategoria) {
		return reposytory.findByNomeHabilitacaoCategoriaContainingOrderByNomeHabilitacaoCategoriaAsc(nomeHabilitacaoCategoria);
	}
	
	@Override
	public HabilitacaoCategorias converteEmMaiusculo(HabilitacaoCategorias habilitacaoCategorias) {
		habilitacaoCategorias.setNomeHabilitacaoCategoria(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(habilitacaoCategorias.getNomeHabilitacaoCategoria()));
		habilitacaoCategorias.setDescricaoHabilitacaoCategoria(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(habilitacaoCategorias.getDescricaoHabilitacaoCategoria()));
		return habilitacaoCategorias;
	}
	
}
