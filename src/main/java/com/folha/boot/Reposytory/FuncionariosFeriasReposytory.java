package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.FuncionariosFerias;

@Repository
public interface FuncionariosFeriasReposytory extends JpaRepository<FuncionariosFerias ,Long>{

	
}
