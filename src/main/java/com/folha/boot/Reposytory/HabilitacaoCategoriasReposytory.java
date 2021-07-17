package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.HabilitacaoCategorias;

@Repository
public interface HabilitacaoCategoriasReposytory extends JpaRepository<HabilitacaoCategorias, Long> {

	public List<HabilitacaoCategorias> findAllByOrderByNomeHabilitacaoCategoriaAsc();
	
	public List<HabilitacaoCategorias> findByNomeHabilitacaoCategoriaContainingOrderByNomeHabilitacaoCategoriaAsc(String habilitacaoCategorias);
}
