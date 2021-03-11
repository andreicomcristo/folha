package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.TiposLogradouro;

@Repository
public interface TiposLogradouroReposytory extends JpaRepository<TiposLogradouro, Long> {

	public List<TiposLogradouro> findAllByOrderByNomeTipoLogradouroAsc();

	public List<TiposLogradouro> findByNomeTipoLogradouroContainingOrderByNomeTipoLogradouroAsc(String nomeTipoLogradouro);
	
	public List<TiposLogradouro> findByNomeTipoLogradouroOrderByNomeTipoLogradouroAsc(String nomeTipoLogradouro);

}
