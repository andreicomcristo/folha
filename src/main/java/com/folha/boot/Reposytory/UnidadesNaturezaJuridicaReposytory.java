package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.UnidadesNaturezaJuridica;

@Repository
public interface UnidadesNaturezaJuridicaReposytory extends JpaRepository<UnidadesNaturezaJuridica, Long> {

	public List<UnidadesNaturezaJuridica> findAllByOrderByNomeNaturezaJuridicaAsc();

	public List<UnidadesNaturezaJuridica> findByNomeNaturezaJuridicaContainingOrderByNomeNaturezaJuridicaAsc(String nomeNaturezaJuridica);
}
