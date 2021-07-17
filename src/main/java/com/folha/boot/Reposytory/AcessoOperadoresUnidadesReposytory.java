package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AcessoOperadoresUnidades;

@Repository
public interface AcessoOperadoresUnidadesReposytory extends JpaRepository<AcessoOperadoresUnidades, Long>{

}
