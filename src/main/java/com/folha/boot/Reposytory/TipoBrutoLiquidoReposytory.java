package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.TipoBrutoLiquido;


@Repository
public interface TipoBrutoLiquidoReposytory extends JpaRepository<TipoBrutoLiquido, Long>{

	public List<TipoBrutoLiquido> findAllByOrderByNomeAsc();
	
	public List<TipoBrutoLiquido> findByNomeContainingOrderByNomeAsc(String nome);
	
	
	public Page<TipoBrutoLiquido> findAllByOrderByNomeAsc( final Pageable page);
	
	public Page<TipoBrutoLiquido> findByNomeContainingOrderByNomeAsc( String nome, final Pageable page);
	
}
