package com.folha.boot.Reposytory;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.EscalaPosTransparencia;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Turmas;
import com.folha.boot.domain.Unidades;


@Repository
public interface EscalaPosTransparenciaReposytoty extends JpaRepository<EscalaPosTransparencia, Long> {
	
	
}
