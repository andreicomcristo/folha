package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Fonte;


@Repository
public interface FonteReposytory extends JpaRepository<Fonte, Long>{

	public List<Fonte> findAllByOrderByNomeAsc();
	
	public List<Fonte> findByNomeContainingOrderByNomeAsc(String nome);
	
	
	public Page<Fonte> findAllByOrderByNomeAsc( final Pageable page);
	
	public Page<Fonte> findByNomeContainingOrderByNomeAsc( String nome, final Pageable page);
	
}
