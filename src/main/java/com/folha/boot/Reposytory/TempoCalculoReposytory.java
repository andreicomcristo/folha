package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.FatorPatronal;
import com.folha.boot.domain.TempoCalculo;
import com.folha.boot.domain.Unidades;

@Repository
public interface TempoCalculoReposytory extends JpaRepository<TempoCalculo, Long>{

	public List<TempoCalculo> findAll();
	
	public TempoCalculo findFirstBy();
	
	public Page<TempoCalculo> findAll(final Pageable page);
	
	
}
