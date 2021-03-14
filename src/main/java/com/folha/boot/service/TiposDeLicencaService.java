package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.TiposDeLicencaReposytory;
import com.folha.boot.domain.TiposDeLicenca;

@Service
@Transactional(readOnly = false)
public class TiposDeLicencaService {

	@Autowired
	private TiposDeLicencaReposytory reposytory;
	
	public void salvar(TiposDeLicenca tiposDeLicenca) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeLicenca);
	}
	
	public void editar(TiposDeLicenca tiposDeLicenca) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeLicenca);
	}
	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public TiposDeLicenca buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<TiposDeLicenca> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByDescricaoTipoLicencaAsc();
	}
	@Transactional(readOnly = true)
	public List<TiposDeLicenca> buscarPorNome(String descricaoTipoLicenca) {
		return reposytory.findByDescricaoTipoLicencaContainingOrderByDescricaoTipoLicencaAsc(descricaoTipoLicenca);
	}
}
