package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.FaixasValoresParametrosCalculoFolhasExtrasReposytory;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;

@Service
@Transactional(readOnly = false)
public class FaixasValoresParametrosCalculoFolhasExtrasService {

	@Autowired
	private FaixasValoresParametrosCalculoFolhasExtrasReposytory reposytory;

	public void salvar(FaixasValoresParametrosCalculoFolhasExtras faixasValoresParametrosCalculoFolhasExtras) {
		// TODO Auto-generated method stub
		reposytory.save(faixasValoresParametrosCalculoFolhasExtras);
	}

	public void editar(FaixasValoresParametrosCalculoFolhasExtras faixasValoresParametrosCalculoFolhasExtras) {
		// TODO Auto-generated method stub
		reposytory.save(faixasValoresParametrosCalculoFolhasExtras);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public FaixasValoresParametrosCalculoFolhasExtras buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<FaixasValoresParametrosCalculoFolhasExtras> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByCnesUnidadeAsc();
	}
	@Transactional(readOnly = true)
	public List<FaixasValoresParametrosCalculoFolhasExtras> buscarPorCnes(String cnesUnidade) {
		return reposytory.findByCnesUnidadeContainingOrderByCnesUnidadeAsc(cnesUnidade);
	}
}
