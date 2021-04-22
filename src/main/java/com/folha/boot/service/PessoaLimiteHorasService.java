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
import com.folha.boot.Reposytory.PessoaLimiteHorasReposytory;
import com.folha.boot.domain.AreasDeCapacitacao;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaCodDiferenciado;
import com.folha.boot.domain.PessoaLimiteHoras;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class PessoaLimiteHorasService {
	@Autowired
	private  PessoaLimiteHorasReposytory reposytory;
	
	@Autowired
	private  SimNaoService simNaoService;

	public void salvar(PessoaLimiteHoras pessoaLimiteHoras) {
		reposytory.save(pessoaLimiteHoras);
	}

	public void editar(PessoaLimiteHoras pessoaLimiteHoras) {
		reposytory.save(pessoaLimiteHoras);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public PessoaLimiteHoras buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<PessoaLimiteHoras> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findByDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc();
	}
	
	public List<PessoaLimiteHoras> buscarPorUnidade(Unidades unidades) {
		return reposytory.findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades);
	}
	
	public List<PessoaLimiteHoras> buscarPorUnidadeEPessoa(Unidades unidades, Pessoa pessoa) {
		return reposytory.findByIdUnidadeFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, pessoa);
	}
	
	public List<PessoaLimiteHoras> buscarPorAprovarSede() {
		return reposytory.findByIdAvaliacaoSedeSimNaoFkIsNullAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc();
	}
	
	
	//Buscas para a Escala
	
	public List<PessoaLimiteHoras> buscarPorUnidadeEPessoaAprovadoSede(Unidades unidades, Pessoa pessoa) {
		return reposytory.findByIdUnidadeFkAndIdPessoaFkAndIdAvaliacaoSedeSimNaoFkAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, pessoa, simNaoService.buscarPorSigla("S").get(0));
	}
	
	
	
	//Listagem Paginada

	@Transactional(readOnly = true)
	public Page<PessoaLimiteHoras> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(  pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<PessoaLimiteHoras> findPaginatedUnidade(Unidades unidades, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades,  pageable);
	}

	@Transactional(readOnly = true)
	public Page<PessoaLimiteHoras> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(  nome.toUpperCase().trim(), pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<PessoaLimiteHoras> findPaginatedNomeUnidade(Unidades unidades, String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeFkAndIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc( unidades, nome.toUpperCase().trim(), pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<PessoaLimiteHoras> findPaginatedUnidade(String unidade , int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeFkNomeFantasiaContainingAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc( unidade.toUpperCase().trim(), pageable);
	}
	
	
	
	
	
}
