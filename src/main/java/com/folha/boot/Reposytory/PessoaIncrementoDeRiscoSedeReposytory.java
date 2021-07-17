package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaIncrementoDeRiscoSede;
import com.folha.boot.domain.Unidades;

@Repository
public interface PessoaIncrementoDeRiscoSedeReposytory extends JpaRepository<PessoaIncrementoDeRiscoSede, Long>{

	public List<PessoaIncrementoDeRiscoSede> findByIdUnidadeFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc(Unidades unidades, Pessoa pessoa);
	
	public List<PessoaIncrementoDeRiscoSede> findByIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc( Pessoa pessoa);
	
	public List<PessoaIncrementoDeRiscoSede> findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc(Unidades unidades);

	public List<PessoaIncrementoDeRiscoSede> findByIdUnidadeFkAndIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc(Unidades unidades, String nome);
	
	public Page<PessoaIncrementoDeRiscoSede> findByDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc( final Pageable page);
	
	public Page<PessoaIncrementoDeRiscoSede> findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc(String nome, final Pageable page);
	
	
	
	
}
