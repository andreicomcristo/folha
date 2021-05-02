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
import com.folha.boot.domain.RubricaGeralSubtracaoCodigo;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.Unidades;

@Repository
public interface RubricaGeralSubtracaoCodigoReposytory extends JpaRepository<RubricaGeralSubtracaoCodigo, Long>{

	public List<RubricaGeralSubtracaoCodigo> findAllByOrderByCodigoAsc();

	public List<RubricaGeralSubtracaoCodigo> findByCodigoContainingOrderByCodigoAsc(String nome);
	
	public List<RubricaGeralSubtracaoCodigo> findByCodigoOrderByCodigoAsc(String nome);
	
	public Page<RubricaGeralSubtracaoCodigo> findAllByOrderByCodigoAsc( final Pageable page);
	
	public Page<RubricaGeralSubtracaoCodigo> findByCodigoContainingOrderByCodigoAsc(String nome, final Pageable page);
	
}
