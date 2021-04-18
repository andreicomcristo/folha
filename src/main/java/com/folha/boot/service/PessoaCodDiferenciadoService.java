package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.AreasDeCapacitacaoReposytory;
import com.folha.boot.Reposytory.PessoaCodDiferenciadoReposytory;
import com.folha.boot.domain.AreasDeCapacitacao;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaCodDiferenciado;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class PessoaCodDiferenciadoService {
	@Autowired
	private  PessoaCodDiferenciadoReposytory reposytory;
	
	@Autowired
	private  SimNaoService simNaoService;

	public void salvar(PessoaCodDiferenciado pessoaCodDiferenciado) {
		reposytory.save(pessoaCodDiferenciado);
	}

	public void editar(PessoaCodDiferenciado pessoaCodDiferenciado) {
		reposytory.save(pessoaCodDiferenciado);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public PessoaCodDiferenciado buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<PessoaCodDiferenciado> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findByDtCancelamentoIsNullOrderByIdCodDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc();
	}
	
	public List<PessoaCodDiferenciado> buscarPorUnidade(Unidades unidades) {
		return reposytory.findByIdCodDiferenciadoFkIdUnidadeFkAndDtCancelamentoIsNullOrderByIdCodDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades);
	}
	
	public List<PessoaCodDiferenciado> buscarPorUnidadeEPessoa(Unidades unidades, Pessoa pessoa) {
		return reposytory.findByIdCodDiferenciadoFkIdUnidadeFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdCodDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, pessoa);
	}
	
	
	
	//Buscas para a Escala
	public List<PessoaCodDiferenciado> buscarPorUnidadeEPessoaQuePrecisaAtribuicaoRhENaoPrecisaAprovacaoSede(Unidades unidades, Pessoa pessoa) {
		return reposytory.findByIdCodDiferenciadoFkIdUnidadeFkAndIdPessoaFkAndIdCodDiferenciadoFkIdNecessitaAtribuicaoRhFkAndIdCodDiferenciadoFkIdNecessitaAtribuicaoSedeFkAndDtCancelamentoIsNullOrderByIdCodDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, pessoa, simNaoService.buscarPorSigla("S").get(0),  simNaoService.buscarPorSigla("N").get(0));
	}
	
	public List<PessoaCodDiferenciado> buscarPorUnidadeEPessoaAprovadoSede(Unidades unidades, Pessoa pessoa) {
		return reposytory.findByIdCodDiferenciadoFkIdUnidadeFkAndIdPessoaFkAndIdCodDiferenciadoFkIdNecessitaAtribuicaoSedeFkAndIdOperadorConfirmacaoSedeFkIsNotNullAndDtCancelamentoIsNullOrderByIdCodDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, pessoa, simNaoService.buscarPorSigla("S").get(0));
	}
	
	
	
	//Listagem Paginada

	@Transactional(readOnly = true)
	public Page<PessoaCodDiferenciado> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByDtCancelamentoIsNullOrderByIdCodDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(  pageable);
	}

	@Transactional(readOnly = true)
	public Page<PessoaCodDiferenciado> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdCodDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(  nome.toUpperCase().trim(), pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<PessoaCodDiferenciado> findPaginatedUnidade(String unidade , int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCodDiferenciadoFkIdUnidadeFkNomeFantasiaContainingAndDtCancelamentoIsNullOrderByIdCodDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc( unidade.toUpperCase().trim(), pageable);
	}
	
	
	
	
	
}
