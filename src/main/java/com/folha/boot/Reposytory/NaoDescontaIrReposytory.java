package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.NaoDescontaIr;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;

@Repository
public interface NaoDescontaIrReposytory extends JpaRepository<NaoDescontaIr, Long>{

	
	public List<NaoDescontaIr> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(AnoMes anoMes);
	
	public List<NaoDescontaIr> findByIdAnoMesFkAndIdFuncionarioFkOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(AnoMes anoMes, PessoaFuncionarios pessoaFuncionarios);
	
	public List<NaoDescontaIr> findByIdAnoMesFkAndIdFuncionarioFkIdPessoaFkOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(AnoMes anoMes, Pessoa pessoa);
	
	public List<NaoDescontaIr> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(String nome);
	
	public List<NaoDescontaIr> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc();
	
	
	
	
	public Page<NaoDescontaIr> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc(String nome, final Pageable page);
	
	public Page<NaoDescontaIr> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdFuncionarioFkIdPessoaFkNomeAsc( final Pageable page);
	
}
