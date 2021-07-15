package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.EscalaHorasPagasReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.EscalaHorasPagas;
import com.folha.boot.domain.models.calculos.EscalasNoMes;


@Service
@Transactional(readOnly = false)
public class EscalaHorasPagasService {	
	@Autowired
	private EscalaHorasPagasReposytory reposytory;

	//@Override
	public void salvar(EscalaHorasPagas escalaHorasPagas) {
		reposytory.save(escalaHorasPagas);
	}
	
	public void salvarLista( List <EscalasNoMes> lista) {
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).getReferencias().getObsReferencias()!=null) {
				if(!lista.get(i).getReferencias().getObsReferencias().equalsIgnoreCase("")) {
					EscalaHorasPagas r = new EscalaHorasPagas();
					r.setId(null);
					r.setHorasA(lista.get(i).getEscala().getHorasA());
					r.setHorasB(lista.get(i).getEscala().getHorasB());
					r.setHorasC(lista.get(i).getEscala().getHorasC());
					r.setHorasDia(lista.get(i).getEscala().getHorasDia());
					r.setHorasFimSemana(lista.get(i).getEscala().getHorasFimSemana());
					r.setHorasNoite(lista.get(i).getEscala().getHorasNoite());
					r.setHorasSemana(lista.get(i).getEscala().getHorasSemana());
					r.setHorasTotais(lista.get(i).getEscala().getHorasTotais());
					r.setIdAnoMesFk(lista.get(i).getEscala().getIdAnoMesFk());
					r.setIdCoordenacaoFk(lista.get(i).getEscala().getIdCoordenacaoFk());
					r.setIdFuncionarioFk(lista.get(i).getEscala().getIdFuncionarioFk());
					r.setIdRegimeFk(lista.get(i).getEscala().getIdRegimeFk());
					r.setIdTipoFolhaFk(lista.get(i).getEscala().getIdTipoFolhaFk());
					r.setObservacoes(lista.get(i).getEscala().getObservacoes());
					r.setPlantoes(lista.get(i).getEscala().getPlantoes());
					
					salvar(r);
				}
			}
		}
	}

	//@Override
	public void editar(EscalaHorasPagas escalaHorasPagas) {
		reposytory.save(escalaHorasPagas);
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
	public EscalaHorasPagas buscarPorId(Long id) {
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	//@Override
	public List<EscalaHorasPagas> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	//@Override
	public List<EscalaHorasPagas> buscarPorMes(AnoMes anoMes) {
		return reposytory.findByIdAnoMesFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAsc(anoMes);
	}
	
	//@Override
	public List<EscalaHorasPagas> buscarPorMesEFuncionario(AnoMes anoMes, PessoaFuncionarios funcionario) {
		return reposytory.findByIdAnoMesFkAndIdFuncionarioFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAsc(anoMes, funcionario);
	}
	
	//@Override
	public List<EscalaHorasPagas> buscarPorMesEPessoa(AnoMes anoMes, Pessoa pessoa) {
		return reposytory.findByIdAnoMesFkAndIdFuncionarioFkIdPessoaFkOrderByIdAnoMesFkAscIdFuncionarioFkIdPessoaFkCpfAscIdFuncionarioFkMatriculaAsc(anoMes, pessoa);
	}
	
}
