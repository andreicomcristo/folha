package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.seguranca.Perfil;

@Repository
public interface PerfilReposytory extends JpaRepository<Perfil, Long> {

}
