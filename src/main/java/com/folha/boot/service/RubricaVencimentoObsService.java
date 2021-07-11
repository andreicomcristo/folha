package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.RubricaVencimentoObsReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RubricaVencimentoObs;
import com.folha.boot.domain.models.calculos.EscalasNoMes;


@Service
@Transactional(readOnly = false)
public class RubricaVencimentoObsService {	
	@Autowired
	private RubricaVencimentoObsReposytory reposytory;

	//@Override
	public void salvar(RubricaVencimentoObs rubricaVencimentoObs) {
		reposytory.save(rubricaVencimentoObs);
	}
	
	public void salvarLista( List <EscalasNoMes> lista) {
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).getReferencias().getObsReferencias()!=null) {
				if(!lista.get(i).getReferencias().getObsReferencias().equalsIgnoreCase("")) {
					RubricaVencimentoObs r = new RubricaVencimentoObs();
					r.setId(null);
					r.setIdFuncionarioFk(lista.get(i).getEscala().getIdFuncionarioFk());
					r.setIdAnoMesFk(lista.get(i).getEscala().getIdAnoMesFk());
					r.setObservacao(lista.get(i).getReferencias().getObsReferencias());
					salvar(r);
				}
			}
		}
	}

	//@Override
	public void editar(RubricaVencimentoObs rubricaVencimentoObs) {
		reposytory.save(rubricaVencimentoObs);
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
	public RubricaVencimentoObs buscarPorId(Long id) {
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	//@Override
	public List<RubricaVencimentoObs> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	//@Override
	public List<RubricaVencimentoObs> buscarPorMes(AnoMes anoMes) {
		return reposytory.findByIdAnoMesFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAsc(anoMes);
	}
	
	//@Override
	public List<RubricaVencimentoObs> buscarPorMesEFuncionario(AnoMes anoMes, PessoaFuncionarios funcionario) {
		return reposytory.findByIdAnoMesFkAndIdFuncionarioFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAsc(anoMes, funcionario);
	}
	
	//@Override
	public List<RubricaVencimentoObs> buscarPorMesEPessoa(AnoMes anoMes, Pessoa pessoa) {
		return reposytory.findByIdAnoMesFkAndIdFuncionarioFkIdPessoaFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAsc(anoMes, pessoa);
	}
	
}
