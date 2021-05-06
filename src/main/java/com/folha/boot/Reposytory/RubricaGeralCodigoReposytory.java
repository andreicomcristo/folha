package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.RubricaGeralCodigo;


@Repository
public interface RubricaGeralCodigoReposytory extends JpaRepository<RubricaGeralCodigo, Long>{

	public List<RubricaGeralCodigo> findAllByOrderByCodigoAsc();

	public List<RubricaGeralCodigo> findByCodigoContainingOrderByCodigoAsc(String nome);
	
	public List<RubricaGeralCodigo> findByCodigoOrderByCodigoAsc(String nome);
	
	public Page<RubricaGeralCodigo> findAllByOrderByCodigoAsc( final Pageable page);
	
	public Page<RubricaGeralCodigo> findByCodigoContainingOrderByCodigoAsc(String nome, final Pageable page);
	
}
