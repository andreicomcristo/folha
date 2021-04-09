package com.folha.boot.Reposytory;




import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.EscalaAlteracoes;
import com.folha.boot.domain.EscalaPosTransparencia;
import com.folha.boot.domain.Unidades;


@Repository
public interface EscalaAlteracoesReposytoty extends JpaRepository<EscalaAlteracoes, Long> {
	
	public List<EscalaAlteracoes> findByIdAnoMesFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc( AnoMes anoMes);
	
	public List<EscalaAlteracoes> findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes);
	
	public Page<EscalaAlteracoes> findByIdAnoMesFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(AnoMes anoMes, final Pageable page);
	
	public Page<EscalaAlteracoes> findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes, final Pageable page);
	
	public Page<EscalaAlteracoes> findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndIdFuncionarioFkIdPessoaFkNomeContainingOrderByIdFuncionarioFkIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes, String nome, final Pageable page);
	
	
	
}
