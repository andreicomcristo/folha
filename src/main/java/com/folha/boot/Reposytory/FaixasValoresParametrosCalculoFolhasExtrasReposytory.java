package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;

@Repository
public interface FaixasValoresParametrosCalculoFolhasExtrasReposytory extends JpaRepository<FaixasValoresParametrosCalculoFolhasExtras, Long>{

	public List<FaixasValoresParametrosCalculoFolhasExtras> findAllByOrderByCnesUnidadeAsc();

	public List<FaixasValoresParametrosCalculoFolhasExtras> findByCnesUnidadeContainingOrderByCnesUnidadeAsc(String cnesUnidade);
	
	public Page<FaixasValoresParametrosCalculoFolhasExtras> findAllByOrderByAnoMesAscCnesUnidadeAsc(final Pageable page);
	
	public Page<FaixasValoresParametrosCalculoFolhasExtras> findByAnoMesContainingOrderByAnoMesAscCnesUnidadeAsc(String nomeCidade, final Pageable page);
}
