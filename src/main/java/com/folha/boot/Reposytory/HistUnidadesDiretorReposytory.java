package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.HistUnidadesDiretor;

@Repository
public interface HistUnidadesDiretorReposytory extends JpaRepository<HistUnidadesDiretor, Long> {

}
