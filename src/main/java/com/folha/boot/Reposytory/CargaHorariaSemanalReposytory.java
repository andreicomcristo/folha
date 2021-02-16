package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.CargaHorariaSemanal;

@Repository
public interface CargaHorariaSemanalReposytory extends JpaRepository<CargaHorariaSemanal, Long> {

	public List<CargaHorariaSemanal> findAllByOrderByCargaHorariaAsc();
	
	public List<CargaHorariaSemanal> findByCargaHorariaOrderByCargaHorariaAsc(int cargaHoraria);
	
}
