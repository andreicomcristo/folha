package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.CidsReposytory;
import com.folha.boot.domain.Cids;

@Service
@Transactional(readOnly = false)
public class CidsService {

	@Autowired
	private CidsReposytory reposytory;
	
	public void salvar(Cids cids) {
		// TODO Auto-generated method stub
		reposytory.save(cids);
	}

	public void editar(Cids cids) {
		// TODO Auto-generated method stub
		reposytory.save(cids);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Cids buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<Cids> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByCodCidAsc();
	}

	public List<Cids> buscarPorNome(String codCid) {
		
		return reposytory.findByCodCidContainingOrderByCodCidAsc(codCid);
	}	
}
