package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RubricaCodigo;
import com.folha.boot.domain.RubricaFuncionario;


@Repository
public interface RubricaFuncionarioReposytory extends JpaRepository<RubricaFuncionario, Long>{

	public List<RubricaFuncionario> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<RubricaFuncionario> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<RubricaFuncionario> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public List<RubricaFuncionario> findByIdCodigoFkAndIdAnoMesFkAndIdFuncionarioFk(RubricaCodigo rubricaGeralSomaCodigo, AnoMes anoMes, PessoaFuncionarios pessoaFuncionarios);
	
	public Page<RubricaFuncionario> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<RubricaFuncionario> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
