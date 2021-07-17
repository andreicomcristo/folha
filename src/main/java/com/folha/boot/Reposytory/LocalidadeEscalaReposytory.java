package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.LocalidadeEscala;
import com.folha.boot.domain.Unidades;

@Repository
public interface LocalidadeEscalaReposytory extends JpaRepository<LocalidadeEscala, Long>{

	public List<LocalidadeEscala> findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscNomeLocalidadeAsc(Unidades unidades );
	
	public Page<LocalidadeEscala> findByIdUnidadeFkAndNomeLocalidadeContainingAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscNomeLocalidadeAsc(Unidades unidades , String nome, final Pageable page);
	
	public Page<LocalidadeEscala> findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscNomeLocalidadeAsc(Unidades unidades , final Pageable page);
}
