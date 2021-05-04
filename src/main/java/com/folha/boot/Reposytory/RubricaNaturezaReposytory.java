package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.RubricaNatureza;
import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.Turnos;

@Repository
public interface RubricaNaturezaReposytory extends JpaRepository<RubricaNatureza, Long>{

	public List<RubricaNatureza> findBySigla(String sigla);
}
