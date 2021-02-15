package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.Escolaridades;

@Repository
public interface EscolaridadesReposytory extends JpaRepository<Escolaridades, Long> {

	public List<Escolaridades> findAllByOrderByNomeEscolaridadeAsc();
	
	public List<Escolaridades> findByNomeEscolaridadeContainingOrderByNomeEscolaridadeAsc(String nomeEscolaridade);
}
