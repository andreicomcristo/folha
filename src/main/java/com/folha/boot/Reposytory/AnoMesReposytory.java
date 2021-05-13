package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AnoMes;

@Repository
public interface AnoMesReposytory extends JpaRepository<AnoMes, Long> {

	public List<AnoMes> findAllByOrderByNomeAnoMesDesc();

	public List<AnoMes> findByNomeAnoMesOrderByNomeAnoMesDesc(String nomeAnoMes);
	
	public AnoMes findFirstByIdEscalaBloqueadaFkSiglaOrderByNomeAnoMesAsc(String nome);
	
	
}
