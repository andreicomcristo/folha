package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.BancosReposytory;
import com.folha.boot.Reposytory.RubricaVencimentoReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.RubricaVencimento;
import com.folha.boot.domain.models.calculos.RubricasVencimento;

@Service
@Transactional(readOnly = false)
public class RubricaVencimentoService {	
	@Autowired
	private RubricaVencimentoReposytory reposytory;

	//@Override
	public void salvar(RubricaVencimento rubricaVencimento) {
		reposytory.save(rubricaVencimento);
	}
	
	public void salvarLista( List <RubricasVencimento> lista) {
		for(int i=0;i<lista.size();i++) {
			RubricaVencimento r = new RubricaVencimento();
			r.setId(null);
			r.setCodigo(lista.get(i).getCodigo());
			r.setDescricao(lista.get(i).getDescricao());
			r.setIdAnoMesFk(lista.get(i).getAnoMes());
			r.setIdFonteFk(lista.get(i).getFonte());
			r.setIdFuncionarioFk(lista.get(i).getPessoaFuncionarios());
			r.setIdNaturezaFk(lista.get(i).getNatureza());
			r.setIdTipoBrutoLiquidoFk(lista.get(i).getTipoBrutoLiquido());
			r.setIdUnidadeFk(lista.get(i).getUnidade());
			r.setPercentagem(lista.get(i).getPercentagem());
			r.setSequencia(lista.get(i).getSequencia());
			r.setValorBruto(lista.get(i).getValorBruto());
			r.setValorIr(lista.get(i).getValorIr());
			r.setValorLiquido(lista.get(i).getValorLiquido());
			r.setValorPatronal(lista.get(i).getValorPatronal());
			r.setValorPrevidencia(lista.get(i).getValorPrevidencia());
			r.setVariacao(lista.get(i).getVariacao());
			
			salvar(r);
		}
	}

	//@Override
	public void editar(RubricaVencimento rubricaVencimento) {
		reposytory.save(rubricaVencimento);
	}

	//@Override
	public void excluir(Long id) {
		reposytory.deleteById(id);
	}
	
	public void excluirPorMes(AnoMes anoMes) {
		reposytory.deleteByIdAnoMesFk(anoMes);
	}

	@Transactional(readOnly = true)
	//@Override
	public RubricaVencimento buscarPorId(Long id) {
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	//@Override
	public List<RubricaVencimento> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	//@Override
	public List<RubricaVencimento> buscarPorMes(AnoMes anoMes) {
		return reposytory.findByIdAnoMesFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAscSequenciaAscIdUnidadeFkNomeFantasiaAsc(anoMes);
	}
	
}
