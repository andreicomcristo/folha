package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.Rubrica;
import com.folha.boot.domain.RubricaCodigo;


@Repository
public interface RubricaReposytory extends JpaRepository<Rubrica, Long>{

	public List<Rubrica> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<Rubrica> findFirstByIdAnoMesFkAndIdCodigoFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes, RubricaCodigo rubricaCodigo);
	
	public List<Rubrica> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<Rubrica> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public List<Rubrica> findByIdCodigoFkAndIdAnoMesFk(RubricaCodigo rubricaGeralSomaCodigo, AnoMes anoMes);
	
	public Page<Rubrica> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<Rubrica> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
