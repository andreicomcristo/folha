package com.folha.boot.domain.calculos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AnoMes;

@Repository
public interface AnoMesReposytory extends JpaRepository<AnoMes, Long>{

}
