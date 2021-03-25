package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.FuncionariosCapacitacoes;

@Repository
public interface FuncionariosCapacitacoesReposytory extends JpaRepository<FuncionariosCapacitacoes, Long>{

}
