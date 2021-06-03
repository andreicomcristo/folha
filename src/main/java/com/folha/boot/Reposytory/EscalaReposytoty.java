package com.folha.boot.Reposytory;


import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.FuncionariosFeriasPeriodos;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Turmas;
import com.folha.boot.domain.Unidades;


@Repository
public interface EscalaReposytoty extends JpaRepository<Escala, Long> {
	
	@Query("select e from Escala e where 0=0 and e.dtCancelamento is null and e.idCoordenacaoFk = :coordenacaoEscala and e.idAnoMesFk = :anoMes")
	public List<Escala> buscarPorCoordenacaoEAnoMes( CoordenacaoEscala coordenacaoEscala, AnoMes anoMes);
	
	@Query("from Escala where 0=0 and dtCancelamento is null and idCoordenacaoFk = :coordenacaoEscala and idAnoMesFk = :anoMes and idTurmaFk = :turmas and horasTotais = 0")
	public List<Escala> buscarPorCoordenacaoEAnoMesTurmaZeradas( CoordenacaoEscala coordenacaoEscala, AnoMes anoMes, Turmas turmas);
	
	@Query("from Escala where 0=0 and dtCancelamento is null and idFuncionarioFk.idPessoaFk = :pessoa and idAnoMesFk = :anoMes")
	public List<Escala> buscarPorPessoaEAnoMes( Pessoa pessoa, AnoMes anoMes);
	
	
	// Buscar geral dentro do setor Exportacao Setorial Servico
	public List<Escala> findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdTurmaFkNomeTurmaAscIdFuncionarioFkIdPessoaFkNomeAsc(CoordenacaoEscala idCoordenacaoFk, AnoMes anoMes);
	// Buscar geral dentro do setor Exportacao
	public List<Escala> findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAsc(CoordenacaoEscala idCoordenacaoFk, AnoMes anoMes);
	//Buscar geral todos Exportacao
	public List<Escala> findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes);
	
	//Buscar por funcionario folha Efetiva
	public List<Escala> findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndIdFuncionarioFkAndIdTipoFolhaFkIdFolhaEfetivaSimNaoFkSiglaAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes, PessoaFuncionarios funcionario , String s);
		
	
	
	// Buscar geral dentro do setor
	public Page<Escala> findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAsc(CoordenacaoEscala idCoordenacaoFk, AnoMes anoMes,  final Pageable page);
	//Buscar geral todos
	public Page<Escala> findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes,  final Pageable page);
	// buscar por nome dentro do setor
	public Page<Escala> findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdFuncionarioFkIdPessoaFkNomeContainingOrderByIdFuncionarioFkIdPessoaFkNomeAsc(CoordenacaoEscala idCoordenacaoFk, AnoMes anoMes, String nome , final Pageable page);
	//Buscar por nome todos
	public Page<Escala> findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdFuncionarioFkIdPessoaFkNomeContainingOrderByIdFuncionarioFkIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes, String nome , final Pageable page);
	//Buscar por turma dentro do setor
	public Page<Escala> findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdTurmaFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(CoordenacaoEscala idCoordenacaoFk, AnoMes anoMes, Turmas turmas , final Pageable page);
	//Buscar por turma todos
	public Page<Escala> findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdTurmaFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes, Turmas turmas , final Pageable page);
	//Buscar por cargo dentro de um setor
	public Page<Escala> findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdFuncionarioFkIdEspecialidadeAtualFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(CoordenacaoEscala idCoordenacaoFk, AnoMes anoMes, CargosEspecialidade cargosEspecialidade , final Pageable page);
	//Buscar por cargo todos
	public Page<Escala> findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdFuncionarioFkIdEspecialidadeAtualFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes, CargosEspecialidade cargosEspecialidade , final Pageable page);
	//Buscar por tipo de folha dentro de um setor
	public Page<Escala> findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdTipoFolhaFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(CoordenacaoEscala idCoordenacaoFk, AnoMes anoMes, TiposDeFolha tiposDeFolha , final Pageable page);
	//Buscar por tipo de folha todos
	public Page<Escala> findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdTipoFolhaFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(Unidades unidades, AnoMes anoMes, TiposDeFolha tiposDeFolha , final Pageable page);
	//Buscar Escala Colaborador
		public Page<Escala> findByIdFuncionarioFkIdPessoaFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAsc(Pessoa pessoa, AnoMes anoMes,  final Pageable page);
	
	
		public List<Escala> findByIdFuncionarioFkIdPessoaFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAscIdTipoFolhaFkAscIdFuncionarioFkIdPessoaFkNomeAsc (Pessoa pessoa, AnoMes anoMes);
		
		public List<Escala> findByIdAnoMesFkAndDtCancelamentoIsNullOrderByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAscIdTipoFolhaFkAscIdFuncionarioFkIdPessoaFkNomeAsc (AnoMes anoMes);
		
		public List<Escala> findByIdAnoMesFkAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkCpfAscIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAscIdTipoFolhaFkAscIdFuncionarioFkIdPessoaFkNomeAsc (AnoMes anoMes);
		
}
