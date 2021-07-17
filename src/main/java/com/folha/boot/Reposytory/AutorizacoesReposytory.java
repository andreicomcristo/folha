package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Autorizacoes;

@Repository
public interface AutorizacoesReposytory extends JpaRepository<Autorizacoes, Long>{

}
