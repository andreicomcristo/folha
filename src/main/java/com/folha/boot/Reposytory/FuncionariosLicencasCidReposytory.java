package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.FuncionariosLicencasCid;

@Repository
public interface FuncionariosLicencasCidReposytory extends JpaRepository<FuncionariosLicencasCid , Long>{

}
