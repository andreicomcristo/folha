package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.Unidades;

@Repository
public interface RubricaInsalubridadeCodigoReposytory extends JpaRepository<RubricaInsalubridadeCodigo, Long>{

	public List<RubricaInsalubridadeCodigo> findAllByOrderByCodigoAsc();

	public List<RubricaInsalubridadeCodigo> findByCodigoContainingOrderByCodigoAsc(String nome);
	
	public List<RubricaInsalubridadeCodigo> findByCodigoOrderByCodigoAsc(String nome);
	
	public Page<RubricaInsalubridadeCodigo> findAllByOrderByCodigoAsc( final Pageable page);
	
	public Page<RubricaInsalubridadeCodigo> findByCodigoContainingOrderByCodigoAsc(String nome, final Pageable page);
	
}
