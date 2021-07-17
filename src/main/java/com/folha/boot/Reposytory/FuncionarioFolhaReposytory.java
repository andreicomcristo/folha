package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FuncionarioFolha;
import com.folha.boot.domain.PessoaFuncionarios;


@Repository
public interface FuncionarioFolhaReposytory extends JpaRepository<FuncionarioFolha, Long>{

	public List<FuncionarioFolha> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc();
	
	public List<FuncionarioFolha> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(AnoMes anoMes);
	
	public List<FuncionarioFolha> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(String nome);
	
	public List<FuncionarioFolha> findByIdFuncionarioFkAndIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAscIdFolhaFkNomeTipoFolhaAsc(PessoaFuncionarios funcionario, AnoMes anoMes);
	
	public Page<FuncionarioFolha> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(final Pageable page);
	
	public Page<FuncionarioFolha> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(String nome, final Pageable page);
}
