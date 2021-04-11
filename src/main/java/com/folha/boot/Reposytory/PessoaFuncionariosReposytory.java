package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.Unidades;

@Repository
public interface PessoaFuncionariosReposytory extends JpaRepository<PessoaFuncionarios, Long> {

	public List<PessoaFuncionarios> findAllByOrderByMatriculaAsc();

	public List<PessoaFuncionarios> findByMatriculaContainingOrderByMatriculaAsc(String matricula);
	
	public List<PessoaFuncionarios> findByIdPessoaFk(Pessoa pessoa);
	
	public Page<PessoaFuncionarios> findByIdUnidadeAtuacaoAtualFkAndDtCancelamentoIsNullAndIdPessoaFkDtCancelamentoIsNullAndIdSituacaoAtualFkNomeSituacao(Unidades idUnidadeAtuacaoAtualFk, String nomeSituacao, final Pageable page);
	
	public Page<PessoaFuncionarios> findByIdUnidadeAtuacaoAtualFkAndDtCancelamentoIsNullAndIdPessoaFkDtCancelamentoIsNullAndIdSituacaoAtualFkNomeSituacaoAndIdPessoaFkNomeContaining(Unidades idUnidadeAtuacaoAtualFk, String nomeSituacao, String nome, final Pageable page);
	
	//public Page<PessoaFuncionarios> findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNull(CoordenacaoEscala idCoordenacaoFk, AnoMes anoMes,  final Pageable page);
	
	//public Page<PessoaFuncionarios> findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdFuncionarioFkIdPessoaFkNomeContainingOrderByIdFuncionarioFkIdPessoaFkNomeAsc(CoordenacaoEscala idCoordenacaoFk, AnoMes anoMes, String nome , final Pageable page);
	
	//public Page<PessoaFuncionarios> findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdFuncionarioFkIdPessoaFkNomeContainingOrderByIdFuncionarioFkIdPessoaFkNomeAsc(CoordenacaoEscala idCoordenacaoFk, AnoMes anoMes, String nome , final Pageable page);
	
	
	
	//Dados para a preencher alteração Pessoa
	//Metodos para Unidade
	public Page<PessoaFuncionarios> findByIdUnidadeAtuacaoAtualFkAndIdSituacaoAtualFkNomeSituacaoAndIdPessoaFkDtCancelamentoIsNullAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(Unidades unidades, String situacao, final Pageable page);
	public Page<PessoaFuncionarios> findByIdPessoaFkNomeContainingAndIdUnidadeAtuacaoAtualFkAndIdSituacaoAtualFkNomeSituacaoAndIdPessoaFkDtCancelamentoIsNullAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(String nome, Unidades unidades, String situacao, final Pageable page);
	public Page<PessoaFuncionarios> findByIdPessoaFkCpfContainingAndIdUnidadeAtuacaoAtualFkAndIdSituacaoAtualFkNomeSituacaoAndIdPessoaFkDtCancelamentoIsNullAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAsc(String cpf, Unidades unidades, String situacao, final Pageable page);
		
	
	
}
