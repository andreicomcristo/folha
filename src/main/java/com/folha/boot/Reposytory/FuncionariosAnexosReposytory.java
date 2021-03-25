package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.FuncionariosAnexos;

@Repository
public interface FuncionariosAnexosReposytory extends JpaRepository<FuncionariosAnexos, Long>{

}
