package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.FaixasPrevidencia;

@Repository
public interface FaixasPrevidenciaReposytory extends JpaRepository<FaixasPrevidencia, Long> {

	public List<FaixasPrevidencia> findAllByOrderByAnoMesDescBaseCalculoValorInicialAsc();

	public List<FaixasPrevidencia> findByAnoMesContainingOrderByAnoMesDescBaseCalculoValorInicialAsc(String anoMes);

}
