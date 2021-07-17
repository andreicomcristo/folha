package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.RubricaCodigo;


@Repository
public interface RubricaCodigoReposytory extends JpaRepository<RubricaCodigo, Long>{

	public List<RubricaCodigo> findAllByOrderByCodigoAsc();

	public List<RubricaCodigo> findByCodigoContainingOrderByCodigoAsc(String nome);
	
	public List<RubricaCodigo> findByCodigoOrderByCodigoAsc(String nome);
	
	public List<RubricaCodigo> findByCodigoAndVariacaoOrderByCodigoAsc(String nome, String variacao);
	
	public Page<RubricaCodigo> findAllByOrderByCodigoAsc( final Pageable page);
	
	public Page<RubricaCodigo> findByCodigoContainingOrderByCodigoAsc(String nome, final Pageable page);
	
}
