package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.EscalaCodDiferenciado;


@Repository
public interface EscalaCodDiferenciadoReposytory extends JpaRepository<EscalaCodDiferenciado, Long> {

	public List<EscalaCodDiferenciado> findByIdEscalaFkAndDtCancelamentoIsNullOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAsc(Escala escala);
	
	public List<EscalaCodDiferenciado> findByIdEscalaFkAndIdCodigoDiferenciadoFkAndDtCancelamentoIsNullOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAsc(Escala escala, CodigoDiferenciado codigoDiferenciado);
	
	public List<EscalaCodDiferenciado> findByDtCancelamentoIsNullOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAsc();

	
	
	//Listagem normal paginada
	
	public Page<EscalaCodDiferenciado> findByIdEscalaFkAndDtCancelamentoIsNullOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAsc(Escala escala, final Pageable page);
	
	public Page<EscalaCodDiferenciado> findByDtCancelamentoIsNullOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAsc( final Pageable page );

}
