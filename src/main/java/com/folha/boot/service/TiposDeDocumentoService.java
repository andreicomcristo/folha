package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.TiposDeDocumentoReposytory;
import com.folha.boot.domain.TiposDeDocumento;

@Service
@Transactional(readOnly = false)
public class TiposDeDocumentoService {

	@Autowired
	private TiposDeDocumentoReposytory reposytory;
	
	
	public void salvar(TiposDeDocumento tiposDeDocumento) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeDocumento);
	}

	
	public void editar(TiposDeDocumento tiposDeDocumento) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeDocumento);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public TiposDeDocumento buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<TiposDeDocumento> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderBySiglaDocumentoAsc();
	}
	
	
	public List<TiposDeDocumento> buscarPorNome(String SiglaDocumento) {
		return reposytory.findBySiglaDocumentoContainingOrderBySiglaDocumentoAsc(SiglaDocumento);
	}
	
}
