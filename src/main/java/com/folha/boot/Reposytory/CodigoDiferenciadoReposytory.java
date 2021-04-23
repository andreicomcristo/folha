package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.Unidades;

@Repository
public interface CodigoDiferenciadoReposytory extends JpaRepository<CodigoDiferenciado, Long>{

	public List<CodigoDiferenciado> findByDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscNomeCodigoDiferenciadoAsc();

	public List<CodigoDiferenciado> findByNomeCodigoDiferenciadoContainingAndIdUnidadeFkAndDtCancelamentoIsNullOrderByNomeCodigoDiferenciadoAsc(String nomeCodigoDiferenciado, Unidades unidade);
	
	public List<CodigoDiferenciado> findByNomeCodigoDiferenciadoAndIdUnidadeFkAndDtCancelamentoIsNullOrderByNomeCodigoDiferenciadoAsc(String nomeCodigoDiferenciado, Unidades unidade);
	
	public List<CodigoDiferenciado> findByIdUnidadeFkAndDtCancelamentoIsNullOrderByNomeCodigoDiferenciadoAsc(Unidades unidade);
	
	public List<CodigoDiferenciado> findByIdUnidadeFkAndIdNecessitaAtribuicaoRhFkAndDtCancelamentoIsNullOrderByNomeCodigoDiferenciadoAsc(Unidades unidade, SimNao sim);
	
	
	public List<CodigoDiferenciado> findByNomeCodigoDiferenciadoContainingAndDtCancelamentoIsNullOrderByNomeCodigoDiferenciadoAsc(String nome);
	
}
