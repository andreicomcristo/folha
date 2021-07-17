package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.TiposDeCapacitacao;

@Repository
public interface TiposDeCapacitacaoReposytory extends JpaRepository<TiposDeCapacitacao, Long>{

}
