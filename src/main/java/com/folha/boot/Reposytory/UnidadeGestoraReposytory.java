package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.UnidadeGestora;
import com.folha.boot.domain.Unidades;

@Repository
public interface UnidadeGestoraReposytory extends JpaRepository<UnidadeGestora, Long> {

	public List<UnidadeGestora> findByNomeFantasiaContainingOrderByNomeFantasiaAsc(String nomeFantasia);
}
