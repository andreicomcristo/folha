package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.FatorChDif;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaChDif;
import com.folha.boot.domain.PessoaIncrementoDeRisco;
import com.folha.boot.domain.UnidadeAdmiteIncrementoDeRisco;
import com.folha.boot.domain.Unidades;

@Repository
public interface PessoaIncrementoDeRiscoReposytory extends JpaRepository<PessoaIncrementoDeRisco, Long>{

	public List<PessoaIncrementoDeRisco> findByIdUnidadeFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, Pessoa pessoa);
	
	public List<PessoaIncrementoDeRisco> findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades);

	public List<PessoaIncrementoDeRisco> findByIdUnidadeFkAndIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, String nome);
	
	public List<PessoaIncrementoDeRisco> findByIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes);
	
	public Page<PessoaIncrementoDeRisco> findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, final Pageable page);
	
	public Page<PessoaIncrementoDeRisco> findByIdUnidadeFkAndIdAnoMesFkNomeAnoMesContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(Unidades unidades, String nome, final Pageable page);
	
	
}
