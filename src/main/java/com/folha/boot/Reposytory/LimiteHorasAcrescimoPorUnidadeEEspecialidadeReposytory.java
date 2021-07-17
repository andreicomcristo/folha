package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.domain.LimiteHorasAcrescimoPorUnidadeEEspecialidade;
import com.folha.boot.domain.Unidades;

@Repository
public interface LimiteHorasAcrescimoPorUnidadeEEspecialidadeReposytory extends JpaRepository<LimiteHorasAcrescimoPorUnidadeEEspecialidade, Long>{

	public List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> findByIdUnidadeFkNomeFantasiaContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> findFirstByIdUnidadeFkAndIdAnoMesFkAndIdEspecialidadeFkOrderByIdAnoMesFkNomeAnoMesDesc(Unidades unidades, AnoMes anoMes, CargosEspecialidade cargosEspecialidade );
	
	public List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public Page<LimiteHorasAcrescimoPorUnidadeEEspecialidade> findAllByOrderByIdAnoMesFkNomeAnoMesDesc( final Pageable page);
	
	public Page<LimiteHorasAcrescimoPorUnidadeEEspecialidade> findByIdUnidadeFkNomeFantasiaContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
	
}
