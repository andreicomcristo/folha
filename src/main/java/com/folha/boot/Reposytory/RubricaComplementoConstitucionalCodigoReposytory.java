package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.RubricaComplementoConstitucional;
import com.folha.boot.domain.RubricaComplementoConstitucionalCodigo;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.Unidades;

@Repository
public interface RubricaComplementoConstitucionalCodigoReposytory extends JpaRepository<RubricaComplementoConstitucionalCodigo, Long>{

	public List<RubricaComplementoConstitucionalCodigo> findAllByOrderByCodigoAsc();

	public List<RubricaComplementoConstitucionalCodigo> findByCodigoContainingOrderByCodigoAsc(String nome);
	
	public List<RubricaComplementoConstitucionalCodigo> findByCodigoOrderByCodigoAsc(String nome);
	
	public Page<RubricaComplementoConstitucionalCodigo> findAllByOrderByCodigoAsc( final Pageable page);
	
	public Page<RubricaComplementoConstitucionalCodigo> findByCodigoContainingOrderByCodigoAsc(String nome, final Pageable page);
	
}
