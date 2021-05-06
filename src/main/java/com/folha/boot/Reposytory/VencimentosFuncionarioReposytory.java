package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RubricaCodigo;
import com.folha.boot.domain.VencimentosFuncionario;


@Repository
public interface VencimentosFuncionarioReposytory extends JpaRepository<VencimentosFuncionario, Long>{

	public List<VencimentosFuncionario> findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	
	public List<VencimentosFuncionario> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(AnoMes anoMes);
	
	public List<VencimentosFuncionario> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome);
	
	public List<VencimentosFuncionario> findByIdCodigoFkAndIdAnoMesFkAndIdFuncionarioFk(RubricaCodigo rubricaGeralSomaCodigo, AnoMes anoMes, PessoaFuncionarios pessoaFuncionarios);
	
	public Page<VencimentosFuncionario> findAllByOrderByIdAnoMesFkNomeAnoMesDesc(final Pageable page);
	
	public Page<VencimentosFuncionario> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(String nome, final Pageable page);
}
