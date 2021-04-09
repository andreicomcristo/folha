package com.folha.boot.Reposytory;




import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.EscalaPosTransparencia;
import com.folha.boot.domain.Unidades;


@Repository
public interface EscalaPosTransparenciaReposytoty extends JpaRepository<EscalaPosTransparencia, Long> {
	
	public List<EscalaPosTransparencia> findByIdAnoMesFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc( AnoMes anoMes);
	
	public List<EscalaPosTransparencia> findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes);
	
	public Page<EscalaPosTransparencia> findByIdAnoMesFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(AnoMes anoMes, final Pageable page);
	
	public Page<EscalaPosTransparencia> findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes, final Pageable page);
	
	public Page<EscalaPosTransparencia> findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndIdFuncionarioFkIdPessoaFkNomeContainingOrderByIdFuncionarioFkIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes, String nome, final Pageable page);
	
	
	
}
