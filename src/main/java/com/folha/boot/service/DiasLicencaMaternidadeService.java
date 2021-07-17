package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.DiasLicencaMaternidadeReposytory;
import com.folha.boot.domain.DiasLicencaMaternidade;

@Service
@Transactional(readOnly = false)
public class DiasLicencaMaternidadeService {

	@Autowired
	private DiasLicencaMaternidadeReposytory reposytory;
	
	
	public void salvar(DiasLicencaMaternidade diasLicencaMaternidade) {
		// TODO Auto-generated method stub
		
		reposytory.save(diasLicencaMaternidade);
	}

	public void editar(DiasLicencaMaternidade diasLicencaMaternidade) {
		// TODO Auto-generated method stub
		
		reposytory.save(diasLicencaMaternidade);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public DiasLicencaMaternidade buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}
	

	@Transactional(readOnly = true)
	public List<DiasLicencaMaternidade> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findByDtCancelamentoIsNull();
	}
	
	
	
	public Page<DiasLicencaMaternidade> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByDtCancelamentoIsNull(pageable);
	}

	
	
	
	

	
}
