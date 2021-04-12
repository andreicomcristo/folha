package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Cids;
import com.folha.boot.domain.Uf;

@Repository
public interface CidsReposytory extends JpaRepository<Cids, Long> {

	public List<Cids> findAllByOrderByCodCidAsc();

	public List<Cids> findByCodCidContainingOrderByCodCidAsc(String codCid);
	
	public Page<Cids> findAllByOrderByCodCidAsc(final Pageable page);
	
	public Page<Cids> findByCodCidContainingOrderByCodCidAsc(String codigo, final Pageable page);
	
	public Page<Cids> findByDescricaoCidContainingOrderByCodCidAsc(String descricao, final Pageable page);
	
}
