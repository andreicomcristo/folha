package com.folha.boot.service.seguranca;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PermissaoReposytory;
import com.folha.boot.domain.LocalidadeEscala;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.seguranca.Permissao;

@Service
@Transactional(readOnly = false)
public class PermissaoService {

	@Autowired
	private  PermissaoReposytory reposytory;

	public void salvar(Permissao Permissao) {
		reposytory.save(Permissao);
	}

	public void editar(Permissao Permissao) {
		reposytory.save(Permissao);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public Permissao buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	/*
	@Transactional(readOnly = true)
	public List<Permissao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findByDtCancelamentoIsNullOrderByNomeAtividadeAsc();
	}
	
	public List<Permissao> buscarPorNome(String nomeAtividade) {
		return reposytory.findByNomeAtividadeContainingAndDtCancelamentoIsNullOrderByNomeAtividadeAsc(nomeAtividade.toUpperCase().trim());
	}
	*/
	public List<Permissao> buscarTodos() {
		return reposytory.findAllByOrderByNomeAsc();
	}
	
	public List<Permissao> buscarPorNome( String nome) {
		return reposytory.findByNomeContainingOrderByNomeAsc( nome.toUpperCase().trim());
	}
	
	
	@Transactional(readOnly = true)
	public Page<Permissao> findPaginated(Unidades unidades ,int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByNomeAsc( pageable);
	}

	@Transactional(readOnly = true)
	public Page<Permissao> findPaginatedNome(Unidades unidades ,String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByNomeContainingOrderByNomeAsc(  nome.toUpperCase().trim(), pageable);
	}
	
	
}
