package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaCodDiferenciado;
import com.folha.boot.domain.PessoaLimiteHoras;
import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.Unidades;

@Repository
public interface PessoaLimiteHorasReposytory extends JpaRepository<PessoaLimiteHoras, Long> {

	public List<PessoaLimiteHoras> findByDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc();

	public List<PessoaLimiteHoras> findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades);
	
	public List<PessoaLimiteHoras> findByIdUnidadeFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, Pessoa pessoa);
	
	public List<PessoaLimiteHoras> findByIdAvaliacaoSedeSimNaoFkIsNullAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc();
	
	public List<PessoaLimiteHoras> findByIdUnidadeFkAndIdPessoaFkAndIdAvaliacaoSedeSimNaoFkAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, Pessoa pessoa, SimNao simNao);
	
	
	//Listagem normal paginada
	
	public Page<PessoaLimiteHoras> findByDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc( final Pageable page);
	
	public Page<PessoaLimiteHoras> findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc( String nome, final Pageable page);
	
	public Page<PessoaLimiteHoras> findByIdUnidadeFkNomeFantasiaContainingAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc( String unidade, final Pageable page);
	
	public Page<PessoaLimiteHoras> findByIdUnidadeFkAndIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades ,String nome, final Pageable page);
	
	public Page<PessoaLimiteHoras> findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, final Pageable page);
	
	
	
}
