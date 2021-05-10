package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresGpf;


@Repository
public interface FaixasValoresGpfReposytory extends JpaRepository<FaixasValoresGpf, Long>{

	public List<FaixasValoresGpf> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<FaixasValoresGpf> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<FaixasValoresGpf> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public Page<FaixasValoresGpf> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<FaixasValoresGpf> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
