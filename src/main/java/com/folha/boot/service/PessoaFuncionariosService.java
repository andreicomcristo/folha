package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PessoaFuncionariosReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class PessoaFuncionariosService {

	@Autowired
	private PessoaFuncionariosReposytory reposytory;
	
	public void salvar(PessoaFuncionarios pessoaFuncionarios) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaFuncionarios);
	}

	
	public void editar(PessoaFuncionarios pessoaFuncionarios) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaFuncionarios);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public PessoaFuncionarios buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<PessoaFuncionarios> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	
	public List<PessoaFuncionarios> buscarPorMatricula(String matricula) {
		// TODO Auto-generated method stub
		return reposytory.findByMatriculaContainingOrderByMatriculaAsc(matricula);
	}

	public List<PessoaFuncionarios> buscarPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findByIdPessoaFk(pessoa);
	}
	
	public Page<PessoaFuncionarios> findPaginated(int pageNo, int pageSize, Unidades unidades, String ativo) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeAtuacaoAtualFkAndDtCancelamentoIsNullAndIdPessoaFkDtCancelamentoIsNullAndIdSituacaoAtualFkNomeSituacao(unidades, ativo, pageable);
	}
	
	public Page<PessoaFuncionarios> findPaginatedNome(int pageNo, int pageSize, Unidades unidades, String ativo, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeAtuacaoAtualFkAndDtCancelamentoIsNullAndIdPessoaFkDtCancelamentoIsNullAndIdSituacaoAtualFkNomeSituacaoAndIdPessoaFkNomeContaining(unidades, ativo, nome.toUpperCase().trim(), pageable);
	}

	
}
