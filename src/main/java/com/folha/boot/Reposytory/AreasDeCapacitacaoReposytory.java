package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AreasDeCapacitacao;

@Repository
public interface AreasDeCapacitacaoReposytory extends JpaRepository<AreasDeCapacitacao, Long>{

	
}
