package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.Unidades;

@Repository
public interface CodigoDiferenciadoReposytory extends JpaRepository<CodigoDiferenciado, Long>{

	public List<CodigoDiferenciado> findAllByOrderByIdUnidadeFkNomeFantasiaAscNomeCodigoDiferenciadoAsc();

	public List<CodigoDiferenciado> findByNomeCodigoDiferenciadoContainingAndIdUnidadeFkOrderByNomeCodigoDiferenciadoAsc(String nomeCodigoDiferenciado, Unidades unidade);
	
	public List<CodigoDiferenciado> findByIdUnidadeFkOrderByNomeCodigoDiferenciadoAsc(Unidades unidade);
	
	public List<CodigoDiferenciado> findByNomeCodigoDiferenciadoContainingOrderByNomeCodigoDiferenciadoAsc(String nome);
	
}
