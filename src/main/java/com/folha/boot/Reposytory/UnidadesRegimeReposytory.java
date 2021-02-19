package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.UnidadesRegime;

@Repository
public interface UnidadesRegimeReposytory extends JpaRepository<UnidadesRegime, Long> {

	public List<UnidadesRegime> findAllByOrderByNomeRegimeUnidLotacaoAsc();

	public List<UnidadesRegime> findByNomeRegimeUnidLotacaoContainingOrderByNomeRegimeUnidLotacaoAsc(String nomeRegimeUnidLotacao);

}
