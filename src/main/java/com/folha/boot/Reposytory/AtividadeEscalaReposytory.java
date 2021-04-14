package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.Unidades;

@Repository
public interface AtividadeEscalaReposytory extends JpaRepository<AtividadeEscala, Long>{

	public List<AtividadeEscala> findByDtCancelamentoIsNullOrderByNomeAtividadeAsc();

	public List<AtividadeEscala> findByIdUnidadeFkAndDtCancelamentoIsNullOrderByNomeAtividadeAsc(Unidades unidades);
	
	public List<AtividadeEscala> findByNomeAtividadeContainingAndDtCancelamentoIsNullOrderByNomeAtividadeAsc(String nomeAtividade);
	
	public List<AtividadeEscala> findByIdUnidadeFkAndNomeAtividadeContainingAndDtCancelamentoIsNullOrderByNomeAtividadeAsc(Unidades unidades, String nome);
	
	
	
	
	public Page<AtividadeEscala> findByIdUnidadeFkAndDtCancelamentoIsNullOrderByNomeAtividadeAsc(Unidades unidades, final Pageable page);
	
	public Page<AtividadeEscala> findByIdUnidadeFkAndNomeAtividadeContainingAndDtCancelamentoIsNullOrderByNomeAtividadeAsc(Unidades unidades, String nome, final Pageable page);
	
}
