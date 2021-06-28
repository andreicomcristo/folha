package com.folha.boot.Reposytory;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.UnidadeTurno;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.Turnos;

@Repository
public interface UnidadeTurnoReposytory extends JpaRepository<UnidadeTurno, Long> {
	
	public List<UnidadeTurno> findAllByOrderByIdUnidadeFkNomeFantasiaAscIdTurnoFkNomeTurnoAsc( );
	
	public List<UnidadeTurno> findByIdUnidadeFkNomeFantasiaContainingOrderByIdUnidadeFkNomeFantasiaAscIdTurnoFkNomeTurnoAsc(String nome);
	
	public List<UnidadeTurno> findByIdUnidadeFkOrderByIdUnidadeFkNomeFantasiaAscIdTurnoFkNomeTurnoAsc(Unidades unidades);
	
	public List<UnidadeTurno> findByIdUnidadeFkAndIdTurnoFkOrderByIdUnidadeFkNomeFantasiaAscIdTurnoFkNomeTurnoAsc(Unidades unidades, Turnos turnos);
	
	
	public Page<UnidadeTurno> findAllByOrderByIdUnidadeFkNomeFantasiaAscIdTurnoFkNomeTurnoAsc( final Pageable pageable);
	
	public Page<UnidadeTurno> findByIdUnidadeFkNomeFantasiaContainingOrderByIdUnidadeFkNomeFantasiaAscIdTurnoFkNomeTurnoAsc(String nome, final Pageable pageable);
	
	
}
