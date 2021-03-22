package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Cargos;
import com.folha.boot.domain.CargosEspecialidade;

@Repository
public interface CargosEspecialidadeReposytory extends JpaRepository<CargosEspecialidade, Long> {

	public List<CargosEspecialidade> findAllByOrderByIdCargoFkNomeCargoAscNomeEspecialidadeCargoAsc();
	
	public List<CargosEspecialidade> findAllByOrderByIdCargoFkAscNomeEspecialidadeCargoAsc();

	public List<CargosEspecialidade> findByNomeEspecialidadeCargoContainingOrderByNomeEspecialidadeCargoAsc(String nomeEspecialidadeCargo);
	
	public List<CargosEspecialidade> findByIdCargoFkOrderByNomeEspecialidadeCargoAsc(Cargos cargos);
}
