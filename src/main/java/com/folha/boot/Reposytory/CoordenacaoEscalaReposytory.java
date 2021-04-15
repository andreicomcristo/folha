package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Unidades;

@Repository
public interface CoordenacaoEscalaReposytory extends JpaRepository<CoordenacaoEscala, Long>{

	public List<CoordenacaoEscala> findByIdLocalidadeFkIdUnidadeFk(Unidades unidades);
	
	
	public Page<CoordenacaoEscala> findByIdLocalidadeFkIdUnidadeFkAndDtCancelamentoIsNullOrderByNomeCoordenacaoAsc(Unidades unidades, final Pageable page);
	
	public Page<CoordenacaoEscala> findByIdLocalidadeFkIdUnidadeFkAndNomeCoordenacaoContainingAndDtCancelamentoIsNullOrderByNomeCoordenacaoAsc(Unidades unidades, String nome, final Pageable page);
	
	
}
