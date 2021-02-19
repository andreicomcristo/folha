package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.TiposDeDocumentoReposytory;
import com.folha.boot.domain.TiposDeDocumento;

@Service
@Transactional(readOnly = false)
public class TiposDeDocumentoServiceImpl implements TiposDeDocumentoService {

	@Autowired
	private TiposDeDocumentoReposytory reposytory;
	
	@Override
	public void salvar(TiposDeDocumento tiposDeDocumento) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeDocumento);
	}

	@Override
	public void editar(TiposDeDocumento tiposDeDocumento) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeDocumento);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public TiposDeDocumento buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<TiposDeDocumento> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderBySiglaDocumentoAsc();
	}
	
	@Override
	public List<TiposDeDocumento> buscarPorNome(String SiglaDocumento) {
		return reposytory.findBySiglaDocumentoContainingOrderBySiglaDocumentoAsc(SiglaDocumento);
	}
	
}
