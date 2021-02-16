package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.TiposDeFiliacao;

@Repository
public interface TiposDeFiliacaoReposytory extends JpaRepository<TiposDeFiliacao, Long> {

	public List<TiposDeFiliacao> findAllByOrderByNomeTipoFiliacaoAsc();
	
	public List<TiposDeFiliacao> findByNomeTipoFiliacaoContainingOrderByNomeTipoFiliacaoAsc(String nomeTipoFiliacao);

}
