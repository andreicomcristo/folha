package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.FuncionariosLicencas;

@Repository
public interface FuncionariosLicencasReposytory extends JpaRepository<FuncionariosLicencas , Long>{

}
