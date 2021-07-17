package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.DiasLicencaMaternidade;

@Repository
public interface DiasLicencaMaternidadeReposytory extends JpaRepository<DiasLicencaMaternidade, Long>{

	public List<DiasLicencaMaternidade> findByDtCancelamentoIsNull();
	
	public Page<DiasLicencaMaternidade> findByDtCancelamentoIsNull(final Pageable page);
	
	
}
