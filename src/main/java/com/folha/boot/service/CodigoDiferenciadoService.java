package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.CodigoDiferenciadoReposytory;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class CodigoDiferenciadoService {

	@Autowired
	private CodigoDiferenciadoReposytory reposytory;
	
	@Autowired
	private SimNaoService simNaoService;

	public void salvar(CodigoDiferenciado codigoDiferenciado) {
		// TODO Auto-generated method stub
		reposytory.save(codigoDiferenciado);
	}

	public void editar(CodigoDiferenciado codigoDiferenciado) {
		// TODO Auto-generated method stub
		reposytory.save(codigoDiferenciado);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public CodigoDiferenciado buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<CodigoDiferenciado> buscarTodosGeral() {
		// TODO Auto-generated method stub
		return reposytory.findByDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscNomeCodigoDiferenciadoAsc();
	}
	
	@Transactional(readOnly = true)
	public List<CodigoDiferenciado> buscarTodosGeralNaUnidade(Unidades unidade) {
		// TODO Auto-generated method stub
		return reposytory.findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscNomeCodigoDiferenciadoAsc( unidade);
	}
	
	@Transactional(readOnly = true)
	public List<CodigoDiferenciado> buscarTodos(Unidades unidade) {
		// TODO Auto-generated method stub
		return reposytory.findByIdUnidadeFkAndDtCancelamentoIsNullOrderByNomeCodigoDiferenciadoAsc(unidade);
	}
	
	@Transactional(readOnly = true)
	public List<CodigoDiferenciado> buscarPorNome(Unidades unidade, String nome) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeCodigoDiferenciadoContainingAndIdUnidadeFkAndDtCancelamentoIsNullOrderByNomeCodigoDiferenciadoAsc( nome, unidade);
	}
	
	@Transactional(readOnly = true)
	public List<CodigoDiferenciado> buscarPorNomeExato(Unidades unidade, String nome) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeCodigoDiferenciadoAndIdUnidadeFkAndDtCancelamentoIsNullOrderByNomeCodigoDiferenciadoAsc( nome, unidade);
	}
	
	@Transactional(readOnly = true)
	public List<CodigoDiferenciado> buscarPorNomeGeral( String nome) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeCodigoDiferenciadoContainingAndDtCancelamentoIsNullOrderByNomeCodigoDiferenciadoAsc( nome);
	}

	
	@Transactional(readOnly = true)
	public List<CodigoDiferenciado> buscarTodosQuePrecisaDeAtribuicaoRh(Unidades unidade) {
		// TODO Auto-generated method stub
		return reposytory.findByIdUnidadeFkAndIdNecessitaAtribuicaoRhFkAndDtCancelamentoIsNullOrderByNomeCodigoDiferenciadoAsc(unidade, simNaoService.buscarPorSigla("S").get(0));
	}
	
	@Transactional(readOnly = true)
	public List<CodigoDiferenciado> buscarTodosQueNaoPrecisaDeAtribuicaoRh(Unidades unidade) {
		// TODO Auto-generated method stub
		return reposytory.findByIdUnidadeFkAndIdNecessitaAtribuicaoRhFkAndDtCancelamentoIsNullOrderByNomeCodigoDiferenciadoAsc(unidade, simNaoService.buscarPorSigla("N").get(0));
	}
	
}
