package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.LocalidadeEscala;

@Repository
public interface LocalidadeEscalaReposytory extends JpaRepository<LocalidadeEscala, Long>{

}
