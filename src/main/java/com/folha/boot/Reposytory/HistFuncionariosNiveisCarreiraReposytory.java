package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.HistFuncionariosNiveisCarreira;

@Repository
public interface HistFuncionariosNiveisCarreiraReposytory extends JpaRepository<HistFuncionariosNiveisCarreira, Long>{

}
