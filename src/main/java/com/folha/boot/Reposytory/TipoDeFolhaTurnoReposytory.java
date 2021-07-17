package com.folha.boot.Reposytory;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.TipoDeFolhaTurno;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Turnos;

@Repository
public interface TipoDeFolhaTurnoReposytory extends JpaRepository<TipoDeFolhaTurno, Long> {
	
	public List<TipoDeFolhaTurno> findAllByOrderByIdTipoDeFolhaFkNomeTipoFolhaAscIdTurnoFkNomeTurnoAsc( );
	
	public List<TipoDeFolhaTurno> findByIdTipoDeFolhaFkNomeTipoFolhaContainingOrderByIdTipoDeFolhaFkNomeTipoFolhaAscIdTurnoFkNomeTurnoAsc(String nome);
	
	public List<TipoDeFolhaTurno> findByIdTipoDeFolhaFkOrderByIdTipoDeFolhaFkNomeTipoFolhaAscIdTurnoFkNomeTurnoAsc(TiposDeFolha tiposDeFolha);
	
	public List<TipoDeFolhaTurno> findByIdTipoDeFolhaFkAndIdTurnoFkOrderByIdTipoDeFolhaFkNomeTipoFolhaAscIdTurnoFkNomeTurnoAsc(TiposDeFolha tiposDeFolha, Turnos turnos);
	
	
	public Page<TipoDeFolhaTurno> findAllByOrderByIdTipoDeFolhaFkNomeTipoFolhaAscIdTurnoFkNomeTurnoAsc( final Pageable pageable);
	
	public Page<TipoDeFolhaTurno> findByIdTipoDeFolhaFkNomeTipoFolhaContainingOrderByIdTipoDeFolhaFkNomeTipoFolhaAscIdTurnoFkNomeTurnoAsc(String nome, final Pageable pageable);
	
	
}
