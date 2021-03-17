package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.CodigoDiferenciado;

@Repository
public interface CodigoDiferenciadoReposytory extends JpaRepository<CodigoDiferenciado, Long>{

	public List<CodigoDiferenciado> findAllByOrderByNomeCodigoDiferenciadoAsc();

	public List<CodigoDiferenciado> findByNomeCodigoDiferenciadoContainingOrderByNomeCodigoDiferenciadoAsc(String nomeCodigoDiferenciado);
	
}
