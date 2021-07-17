package com.folha.boot.Reposytory;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.RegimeDeTrabalhoTurno;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.Turnos;

@Repository
public interface RegimeDeTrabalhoTurnoReposytory extends JpaRepository<RegimeDeTrabalhoTurno, Long> {
	
	public List<RegimeDeTrabalhoTurno> findAllByOrderByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoAscIdTurnoFkNomeTurnoAsc( );
	
	public List<RegimeDeTrabalhoTurno> findByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoContainingOrderByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoAscIdTurnoFkNomeTurnoAsc(String nome);
	
	public List<RegimeDeTrabalhoTurno> findByIdRegimeDeTrabalhoFkOrderByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoAscIdTurnoFkNomeTurnoAsc(RegimesDeTrabalho regimesDeTrabalho);
	
	public List<RegimeDeTrabalhoTurno> findByIdRegimeDeTrabalhoFkAndIdTurnoFkOrderByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoAscIdTurnoFkNomeTurnoAsc(RegimesDeTrabalho regimesDeTrabalho, Turnos turnos);
	
	
	public Page<RegimeDeTrabalhoTurno> findAllByOrderByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoAscIdTurnoFkNomeTurnoAsc( final Pageable pageable);
	
	public Page<RegimeDeTrabalhoTurno> findByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoContainingOrderByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoAscIdTurnoFkNomeTurnoAsc(String nome, final Pageable pageable);
	
	
}
