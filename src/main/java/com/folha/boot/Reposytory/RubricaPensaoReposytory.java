package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresGpf;
import com.folha.boot.domain.FuncionariosFerias;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RubricaPensao;


@Repository
public interface RubricaPensaoReposytory extends JpaRepository<RubricaPensao, Long>{

	public List<RubricaPensao> findAllByDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc();
	
	public List<RubricaPensao> findByIdAnoMesFkNomeAnoMesContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(String nome);
	
	public List<RubricaPensao> findByIdAnoMesFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(AnoMes anoMes);
	
	public List<RubricaPensao> findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(String nome);
	
	public List<RubricaPensao> findByIdAnoMesFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(AnoMes anoMes, Pessoa pessoa);
		
	public List<RubricaPensao> findByIdPessoaFk(Pessoa pessoa);
	
	public Page<RubricaPensao> findAllByDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(final Pageable page);
	
	public Page<RubricaPensao> findByIdAnoMesFkNomeAnoMesContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(String nome, final Pageable page);
	
	public Page<RubricaPensao> findByIdAnoMesFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(AnoMes anoMes, final Pageable page);
	
	public Page<RubricaPensao> findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(String nome, final Pageable page);
	
	
}
