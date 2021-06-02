package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Pessoa;

import com.folha.boot.domain.PessoaComplementoDePlantao;
import com.folha.boot.domain.Unidades;

@Repository
public interface PessoaComplementoDePlantaoReposytory extends JpaRepository<PessoaComplementoDePlantao, Long>{

	public List<PessoaComplementoDePlantao> findByIdUnidadeFkAndIdPessoaFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, Pessoa pessoa, AnoMes anoMes);
	
	public List<PessoaComplementoDePlantao> findByIdUnidadeFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, Pessoa pessoa);
	
	public List<PessoaComplementoDePlantao> findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades);

	public List<PessoaComplementoDePlantao> findByIdUnidadeFkAndIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, String nome);
	
	public List<PessoaComplementoDePlantao> findByIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes);
	
	public List<PessoaComplementoDePlantao> findByIdUnidadeFkAndIdAnoMesFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes, Pessoa pessoa);
	
	public Page<PessoaComplementoDePlantao> findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, final Pageable page);
	
	public Page<PessoaComplementoDePlantao> findByIdUnidadeFkAndIdAnoMesFkNomeAnoMesContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, String nome, final Pageable page);
	
	
}
