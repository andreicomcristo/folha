package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.folha.boot.domain.Pessoa;

import com.folha.boot.domain.PessoaComplementoDePlantaoSede;
import com.folha.boot.domain.Unidades;

@Repository
public interface PessoaComplementoDePlantaoSedeReposytory extends JpaRepository<PessoaComplementoDePlantaoSede, Long>{

	public List<PessoaComplementoDePlantaoSede> findByIdUnidadeFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc(Unidades unidades, Pessoa pessoa);
	
	public List<PessoaComplementoDePlantaoSede> findByIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc( Pessoa pessoa);
	
	public List<PessoaComplementoDePlantaoSede> findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc(Unidades unidades);

	public List<PessoaComplementoDePlantaoSede> findByIdUnidadeFkAndIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc(Unidades unidades, String nome);
	
	public Page<PessoaComplementoDePlantaoSede> findByDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc( final Pageable page);
	
	public Page<PessoaComplementoDePlantaoSede> findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc(String nome, final Pageable page);
	
	
}
