package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.TempoCalculoReposytory;
import com.folha.boot.domain.TempoCalculo;

@Service
@Transactional(readOnly = false)
public class TempoCalculoService {

	@Autowired
	private TempoCalculoReposytory reposytory;
	
	
	public void salvar(TempoCalculo tempoCalculo) {
		// TODO Auto-generated method stub
		
		if(reposytory.findAll().size()>0 && tempoCalculo.getId()==null) {
			reposytory.deleteAll();
		}
		
		reposytory.save(tempoCalculo);
	}

	public void editar(TempoCalculo tempoCalculo) {
		// TODO Auto-generated method stub
		
		if(reposytory.findAll().size()>0 && tempoCalculo.getId()==null) {
			reposytory.deleteAll();
		}
		
		reposytory.save(tempoCalculo);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public TempoCalculo buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public TempoCalculo buscarPrimeiro() {
		// TODO Auto-generated method stub
		return reposytory.findFirstBy();
	}

	@Transactional(readOnly = true)
	public List<TempoCalculo> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	
	
	public Page<TempoCalculo> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAll(pageable);
	}

	
	
	
	

	
}
