package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HorasFaltasFolhasVariaveisReposytory;
import com.folha.boot.domain.HorasFaltasFolhasVariaveis;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class HorasFaltasFolhasVariaveisService {

	@Autowired
	private  HorasFaltasFolhasVariaveisReposytory reposytory;

	public void salvar(HorasFaltasFolhasVariaveis horasFaltasFolhasVariaveis) {
		reposytory.save(horasFaltasFolhasVariaveis);
	}

	public void editar(HorasFaltasFolhasVariaveis horasFaltasFolhasVariaveis) {
		reposytory.save(horasFaltasFolhasVariaveis);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public HorasFaltasFolhasVariaveis buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	public void salvarLista(List<HorasFaltasFolhasVariaveis> lista) {
		for(int i=0;i<lista.size();i++) {
			salvar(lista.get(i));
		} 
	}
	
	
	public List<HorasFaltasFolhasVariaveis> buscarNaUnidade(Unidades unidades) {
		return reposytory.findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(unidades);
	}
	
	public List<HorasFaltasFolhasVariaveis> buscarNaUnidadePorNome(Unidades unidades, String nome) {
		return reposytory.findByIdUnidadeFkAndIdFuncionarioFkIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(unidades, nome.toUpperCase().trim());
	}
	
	
	public List<HorasFaltasFolhasVariaveis> buscarFaltasADescontar() {
		return reposytory.findByHorasRestantesGreaterThanAndIdAnoMesFkIdEscalaBloqueadaFkSiglaAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(0, "S");
	}
	
	
	@Transactional(readOnly = true)
	public Page<HorasFaltasFolhasVariaveis> findPaginated(Unidades unidades ,int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(unidades,  pageable);
	}

	@Transactional(readOnly = true)
	public Page<HorasFaltasFolhasVariaveis> findPaginatedNome(Unidades unidades ,String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeFkAndIdFuncionarioFkIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc( unidades, nome.toUpperCase().trim(), pageable);
	}
	
	
}
