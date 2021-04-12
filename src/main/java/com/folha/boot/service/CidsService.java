package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.CidsReposytory;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Cids;

@Service
@Transactional(readOnly = false)
public class CidsService {

	@Autowired
	private CidsReposytory reposytory;
	
	public void salvar(Cids cids) {
		// TODO Auto-generated method stub
		reposytory.save(cids);
	}

	public void editar(Cids cids) {
		// TODO Auto-generated method stub
		reposytory.save(cids);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Cids buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<Cids> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByCodCidAsc();
	}

	public List<Cids> buscarPorNome(String codCid) {
		
		return reposytory.findByCodCidContainingOrderByCodCidAsc(codCid);
	}	
	
	
	
	@Transactional(readOnly = true)
	public Page<Cids> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByCodCidAsc(pageable);
	}

	@Transactional(readOnly = true)
	public Page<Cids> findPaginatedCodigo(int pageNo, int pageSize, String codigo) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByCodCidContainingOrderByCodCidAsc(codigo.toUpperCase().trim(), pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<Cids> findPaginatedDescricao(int pageNo, int pageSize, String descricao) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByDescricaoCidOrderByCodCidAsc(descricao.toUpperCase().trim(), pageable);
	}

	
	
}
