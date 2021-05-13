package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.NaoDescontaInss;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.Unidades;

@Repository
public interface NaoDescontaInssReposytory extends JpaRepository<NaoDescontaInss, Long>{

	
	public List<NaoDescontaInss> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(AnoMes anoMes);
	
	public List<NaoDescontaInss> findByIdAnoMesFkAndIdFuncionarioFkOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(AnoMes anoMes, PessoaFuncionarios pessoaFuncionarios);
	
	public List<NaoDescontaInss> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(String nome);
	
	public List<NaoDescontaInss> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc();
	
	
	
	
	public Page<NaoDescontaInss> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(String nome, final Pageable page);
	
	public Page<NaoDescontaInss> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc( final Pageable page);
	
}
