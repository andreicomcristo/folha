package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AcessoOperadoresCoordenacao;

@Repository
public interface AcessoOperadoresCoordenacaoReposytory extends JpaRepository<AcessoOperadoresCoordenacao, Long>{

	
}
