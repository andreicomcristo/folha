package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.RubricaComplementoConstitucional;
import com.folha.boot.domain.RubricaComplementoConstitucionalCodigo;
import com.folha.boot.domain.RubricaGeralSomaCodigo;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.Unidades;

@Repository
public interface RubricaGeralSomaCodigoReposytory extends JpaRepository<RubricaGeralSomaCodigo, Long>{

	public List<RubricaGeralSomaCodigo> findAllByOrderByCodigoAsc();

	public List<RubricaGeralSomaCodigo> findByCodigoContainingOrderByCodigoAsc(String nome);
	
	public List<RubricaGeralSomaCodigo> findByCodigoOrderByCodigoAsc(String nome);
	
	public Page<RubricaGeralSomaCodigo> findAllByOrderByCodigoAsc( final Pageable page);
	
	public Page<RubricaGeralSomaCodigo> findByCodigoContainingOrderByCodigoAsc(String nome, final Pageable page);
	
}
