package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.HistUnidadesRegime;

@Repository
public interface HistUnidadesRegimeReposytory extends JpaRepository<HistUnidadesRegime, Long> {

}
