package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.FaixasPrevidenciaReposytory;
import com.folha.boot.domain.FaixasPrevidencia;

@Service
@Transactional(readOnly = false)
public class FaixasPrevidenciaSevice {

	@Autowired
	private FaixasPrevidenciaReposytory reposytory;

	public void salvar(FaixasPrevidencia faixasPrevidencia) {
		// TODO Auto-generated method stub
		reposytory.save(faixasPrevidencia);
	}

	public void editar(FaixasPrevidencia faixasPrevidencia) {
		// TODO Auto-generated method stub
		reposytory.save(faixasPrevidencia);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public FaixasPrevidencia buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<FaixasPrevidencia> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByAnoMesDescBaseCalculoValorInicialAsc();
	}
	@Transactional(readOnly = true)
	public List<FaixasPrevidencia> buscarPorAnoMes(String anoMes) {
		return reposytory.findByAnoMesContainingOrderByAnoMesDescBaseCalculoValorInicialAsc(anoMes);
	}
}
