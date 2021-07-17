package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.HistUnidadesNaturezaJuridica;

@Repository
public interface HistUnidadesNaturezaJuridicaReposytory extends JpaRepository<HistUnidadesNaturezaJuridica, Long> {

}
