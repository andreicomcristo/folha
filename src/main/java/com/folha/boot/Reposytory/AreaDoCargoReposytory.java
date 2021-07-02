package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.AreaDoCargo;

@Repository
public interface AreaDoCargoReposytory extends JpaRepository<AreaDoCargo, Long> {

	public List<AreaDoCargo> findAllByOrderByNomeAsc();

	public List<AreaDoCargo> findByNomeOrderByNomeAsc(String nome);
	
	public AreaDoCargo findFirstByNomeOrderByNomeAsc(String nome);
	
	
}
