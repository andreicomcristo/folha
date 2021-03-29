package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.Turnos;

@Repository
public interface SimNaoReposytory extends JpaRepository<SimNao, Long>{

	public List<SimNao> findBySigla(String sigla);
}
