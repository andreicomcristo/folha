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
import com.folha.boot.domain.RubricaSomaIrfCodigo;
import com.folha.boot.domain.Unidades;

@Repository
public interface RubricaSomaIrfCodigoReposytory extends JpaRepository<RubricaSomaIrfCodigo, Long>{

	public List<RubricaSomaIrfCodigo> findAllByOrderByCodigoAsc();

	public List<RubricaSomaIrfCodigo> findByCodigoContainingOrderByCodigoAsc(String nome);
	
	public List<RubricaSomaIrfCodigo> findByCodigoOrderByCodigoAsc(String nome);
	
	public Page<RubricaSomaIrfCodigo> findAllByOrderByCodigoAsc( final Pageable page);
	
	public Page<RubricaSomaIrfCodigo> findByCodigoContainingOrderByCodigoAsc(String nome, final Pageable page);
	
}
