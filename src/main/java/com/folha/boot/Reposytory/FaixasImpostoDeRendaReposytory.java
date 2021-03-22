package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.FaixasImpostoDeRenda;

@Repository
public interface FaixasImpostoDeRendaReposytory extends JpaRepository<FaixasImpostoDeRenda , Long> {
     
	public List<FaixasImpostoDeRenda> findAllByOrderByAnoMesAsc();
	
	public List<FaixasImpostoDeRenda> findByAnoMesContainingOrderByAnoMesAsc(String anoMes);
	
}
