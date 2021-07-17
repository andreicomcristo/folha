package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.HistFuncionariosAutorizacao;

@Repository
public interface HistFuncionariosAutorizacaoReposytory extends JpaRepository<HistFuncionariosAutorizacao, Long> {

}
