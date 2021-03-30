package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.CoordenacaoEscala;

@Repository
public interface CoordenacaoEscalaReposytory extends JpaRepository<CoordenacaoEscala, Long>{

public List<CoordenacaoEscala> findAllByOrderByNomeCoordenacaoAsc();
	
	public List<CoordenacaoEscala> findByNomeCoordenacaoContainingOrderByNomeCoordenacaoAsc(String nomeCoordenacao);
}
