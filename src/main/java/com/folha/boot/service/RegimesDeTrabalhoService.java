package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.RegimesDeTrabalhoReposytory;
import com.folha.boot.domain.RegimesDeTrabalho;

@Service
@Transactional(readOnly = false)
public class RegimesDeTrabalhoService {
	@Autowired
	private RegimesDeTrabalhoReposytory reposytory;

	//@Override
	public void salvar(RegimesDeTrabalho regimesDeTrabalho) {
		reposytory.save(regimesDeTrabalho);
	}
	//@Override
	public void editar(RegimesDeTrabalho regimesDeTrabalho) {
		reposytory.save(regimesDeTrabalho);
	}
	//@Override
	public void excluir(Long id) {
		reposytory.deleteById(id);
	}
	@Transactional(readOnly = true)
	//@Override
	public RegimesDeTrabalho buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	@Transactional(readOnly = true)
	//@Override
	public List<RegimesDeTrabalho> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeRegimeDeTrabalhoAsc();
				}
	//@Override
	public List<RegimesDeTrabalho> buscarPorNome(String regimesDeTrabalho) {
		return reposytory.findByNomeRegimeDeTrabalhoContainingOrderByNomeRegimeDeTrabalhoAsc(regimesDeTrabalho);
	}
	
	//@Override
	public RegimesDeTrabalho buscarPorNomeUnico(String regimesDeTrabalho) {
		return reposytory.findFirstByNomeRegimeDeTrabalhoOrderByNomeRegimeDeTrabalhoAsc(regimesDeTrabalho);
	}
}
