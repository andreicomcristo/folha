package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PessoaReposytory;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Pessoa;

@Service
@Transactional(readOnly = false)
public class PessoaService {

	@Autowired
	private PessoaReposytory reposytory;
	
	
	public Pessoa salvar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.save(pessoa);
	}

	
	public void editar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		reposytory.save(pessoa);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public Pessoa buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<Pessoa> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findByDtCancelamentoIsNullOrderByNomeAsc();
	}

	
	public List<Pessoa> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeContainingAndDtCancelamentoIsNullOrderByNomeAsc(nome);
	}
	
	
	public List<Pessoa> buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return reposytory.findByCpfAndDtCancelamentoIsNullOrderByNomeAsc(cpf);
	}
	
	@Transactional(readOnly = true)
	public Page<Pessoa> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByDtCancelamentoIsNullOrderByNomeAsc(pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<Pessoa> findPaginatedNome(int pageNo, int pageSize, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByNomeContainingAndDtCancelamentoIsNullOrderByNomeAsc(pageable, nome);
	}
	
	@Transactional(readOnly = true)
	public Page<Pessoa> findPaginatedCpf(int pageNo, int pageSize, String cpf) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByCpfContainingAndDtCancelamentoIsNullOrderByNomeAsc(pageable, cpf);
	}
	
}
