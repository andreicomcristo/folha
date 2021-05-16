package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresGpf;
import com.folha.boot.domain.RubricaPensao;


@Repository
public interface RubricaPensaoReposytory extends JpaRepository<RubricaPensao, Long>{

	public List<RubricaPensao> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc();
	
	public List<RubricaPensao> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(String nome);
	
	public List<RubricaPensao> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(AnoMes anoMes);
	
	public List<RubricaPensao> findByIdPessoaFkNomeContainingOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(String nome);
	
	
	
	
	
	public Page<RubricaPensao> findAllByOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(final Pageable page);
	
	public Page<RubricaPensao> findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(String nome, final Pageable page);
	
	public Page<RubricaPensao> findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(AnoMes anoMes, final Pageable page);
	
	public Page<RubricaPensao> findByIdPessoaFkNomeContainingOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(String nome, final Pageable page);
}
