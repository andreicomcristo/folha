package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PlanilhaImportacaoGenteDesktopReposytory;
import com.folha.boot.domain.PlanilhaImportacaoGenteDesktop;

@Service
@Transactional(readOnly = false)
public class PlanilhaImportacaoGenteDesktopService {

	@Autowired
	private  PlanilhaImportacaoGenteDesktopReposytory reposytory;

	public void salvar(PlanilhaImportacaoGenteDesktop planilhaImportacaoGenteDesktop) {
		reposytory.save(planilhaImportacaoGenteDesktop);
	}

	public void editar(PlanilhaImportacaoGenteDesktop planilhaImportacaoGenteDesktop) {
		reposytory.save(planilhaImportacaoGenteDesktop);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public PlanilhaImportacaoGenteDesktop buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<PlanilhaImportacaoGenteDesktop> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
}
