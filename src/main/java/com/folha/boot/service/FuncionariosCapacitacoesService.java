package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.FuncionariosCapacitacoesReposytory;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.FuncionariosCapacitacoes;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class FuncionariosCapacitacoesService {

	@Autowired
	private  FuncionariosCapacitacoesReposytory reposytory;

	public void salvar(FuncionariosCapacitacoes funcionariosCapacitacoes) {
		reposytory.save(funcionariosCapacitacoes);
	}

	public void editar(FuncionariosCapacitacoes funcionariosCapacitacoes) {
		reposytory.save(funcionariosCapacitacoes);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public FuncionariosCapacitacoes buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<FuncionariosCapacitacoes> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findByDtCancelamentoIsNullOrderByDescricaoAsc();
	}
	
	public List<FuncionariosCapacitacoes> buscarPorDescricao(String descricao) {
		return reposytory.findByDescricaoContainingAndDtCancelamentoIsNullOrderByDescricaoAsc(descricao);
	}
	
	
	@Transactional(readOnly = true)
	public Page<FuncionariosCapacitacoes> findPaginated(Unidades unidades ,int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdFuncionarioFkIdUnidadeAtuacaoAtualFkAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAscIdFuncionarioFkIdPessoaFkCpfAsc(unidades,  pageable);
	}

	@Transactional(readOnly = true)
	public Page<FuncionariosCapacitacoes> findPaginatedNome(Unidades unidades ,String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdFuncionarioFkIdUnidadeAtuacaoAtualFkAndIdFuncionarioFkIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAscIdFuncionarioFkIdPessoaFkCpfAsc( unidades, nome.toUpperCase().trim(), pageable);
	}
}
