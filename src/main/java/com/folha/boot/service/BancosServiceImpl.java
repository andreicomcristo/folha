package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.BancosReposytory;
import com.folha.boot.domain.Bancos;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class BancosServiceImpl implements BancosService {

	UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();
	
	@Autowired
	private BancosReposytory reposytory;

	@Override
	public void salvar(Bancos bancos) {
		reposytory.save(bancos);
	}

	@Override
	public void editar(Bancos bancos) {
		reposytory.save(bancos);

	}

	@Override
	public void excluir(Long id) {
		reposytory.deleteById(id);

	}

	@Transactional(readOnly = true)
	@Override
	public Bancos buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Bancos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeBancoAsc();
	}
	
	@Override
	public List<Bancos> buscarPorNome(String nomeBanco) {
		return reposytory.findByNomeBancoContainingOrderByNomeBancoAsc(nomeBanco);
	}
	
	@Override
	public Bancos converteEmMaiusculo(Bancos bancos) {
		bancos.setCodigoBanco( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(bancos.getCodigoBanco()));
		bancos.setNomeBanco( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(bancos.getNomeBanco()));
		bancos.setSiglaBanco( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(bancos.getSiglaBanco()));
	return bancos;
	}

}
