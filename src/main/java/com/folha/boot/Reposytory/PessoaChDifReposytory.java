package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaChDif;
import com.folha.boot.domain.UnidadeAdmiteChDif;
import com.folha.boot.domain.UnidadeAdmiteIncrementoDeRisco;
import com.folha.boot.domain.Unidades;

@Repository
public interface PessoaChDifReposytory extends JpaRepository<PessoaChDif, Long>{

	public List<PessoaChDif> findByIdUnidadeFkAndIdPessoaFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, Pessoa pessoa, AnoMes anoMes);
	
	public List<PessoaChDif> findByIdUnidadeFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, Pessoa pessoa);
	
	public List<PessoaChDif> findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades);

	public List<PessoaChDif> findByIdUnidadeFkAndIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, String nome);
	
	public List<PessoaChDif> findByIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes);
	
	public Page<PessoaChDif> findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, final Pageable page);
	
	public Page<PessoaChDif> findByIdUnidadeFkAndIdAnoMesFkNomeAnoMesContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, String nome, final Pageable page);
	
}
