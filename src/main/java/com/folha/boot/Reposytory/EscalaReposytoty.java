package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;


@Repository
public interface EscalaReposytoty extends JpaRepository<Escala, Long> {
	
	@Query("from Escala where 0=0 and dtCancelamento is null and idCoordenacaoFk = :coordenacaoEscala and idAnoMesFk = :anoMes")
	public List<Escala> buscarPorCoordenacaoEAnoMes( CoordenacaoEscala coordenacaoEscala, AnoMes anoMes);
	
	
}
