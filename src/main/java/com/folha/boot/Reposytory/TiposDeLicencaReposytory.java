package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.folha.boot.domain.TiposDeLicenca;

public interface TiposDeLicencaReposytory extends JpaRepository<TiposDeLicenca, Long> {

	public List<TiposDeLicenca> findAllByOrderByDescricaoTipoLicencaAsc();

	public List<TiposDeLicenca> findByDescricaoTipoLicencaContainingOrderByDescricaoTipoLicencaAsc(String descricaoTipoLicenca);

}
