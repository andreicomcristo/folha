package com.folha.boot.service;

import java.util.Date;
import java.util.List;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.EscalaAlteracoesReposytoty;
import com.folha.boot.Reposytory.EscalaPosTransparenciaReposytoty;
import com.folha.boot.Reposytory.EscalaReposytoty;
import com.folha.boot.Reposytory.PessoaDocumentosReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.EscalaAlteracoes;
import com.folha.boot.domain.EscalaPosTransparencia;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Turmas;
import com.folha.boot.domain.Uf;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;
import com.folha.boot.service.util.UtilidadesMatematicas;

@Service
@Transactional(readOnly = false)
public class EscalaAlteracoesService {

	@Autowired
	private EscalaAlteracoesReposytoty reposytory;
	
	
	public EscalaAlteracoes salvar(EscalaAlteracoes escala) {
		// TODO Auto-generated method stub
		return reposytory.save(escala);
	}
	
	public void editar(EscalaAlteracoes escala) {
		// TODO Auto-generated method stub
		reposytory.save(escala);
	}

	public void cancelar(EscalaAlteracoes escala) {
		// TODO Auto-generated method stub
		escala.setDtCancelamento(new Date());
		reposytory.save(escala);
	}
	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public EscalaAlteracoes buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<EscalaAlteracoes> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<EscalaAlteracoes> buscarNaUnidade(Unidades unidades, AnoMes anoMes) {
		// TODO Auto-generated method stub
		return reposytory.findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkOrderByDtAlteracaoDescHoraAlteracaoDescIdFuncionarioFkIdPessoaFkNomeAsc(unidades, anoMes);
	}
	
	@Transactional(readOnly = true)
	public List<EscalaAlteracoes> buscarEmTodasAsUnidades( AnoMes anoMes) {
		// TODO Auto-generated method stub
		return reposytory.findByIdAnoMesFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc( anoMes);
	}
	
	public Page<EscalaAlteracoes> findPaginatedEscalaAlteracaoGlobal(int pageNo, int pageSize,  AnoMes anoMes) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdAnoMesFkOrderByDtAlteracaoDescHoraAlteracaoDescIdFuncionarioFkIdPessoaFkNomeAsc( anoMes, pageable);
	}
	
	public Page<EscalaAlteracoes> findPaginatedEscalaAlteracao(int pageNo, int pageSize, Unidades unidades, AnoMes anoMes) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkOrderByDtAlteracaoDescHoraAlteracaoDescIdFuncionarioFkIdPessoaFkNomeAsc(unidades, anoMes, pageable);
	}
	
	public Page<EscalaAlteracoes> findPaginatedNomeEscalaAlteracao(int pageNo, int pageSize, Unidades unidades, AnoMes anoMes, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndIdFuncionarioFkIdPessoaFkNomeContainingOrderByDtAlteracaoDescHoraAlteracaoDescIdFuncionarioFkIdPessoaFkNomeAsc(unidades, anoMes, nome.toUpperCase().trim(), pageable);
	}
	
	public Page<EscalaAlteracoes> findPaginatedNomeEscalaAlteracaoGlobal(int pageNo, int pageSize, AnoMes anoMes, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdAnoMesFkAndIdFuncionarioFkIdPessoaFkNomeContainingOrderByDtAlteracaoDescHoraAlteracaoDescIdFuncionarioFkIdPessoaFkNomeAsc( anoMes, nome.toUpperCase().trim(), pageable);
	}

	public EscalaAlteracoes converteDeEscalaParaEscalaAlteracoes(Escala escala) {
		EscalaAlteracoes escalaAlteracoes = new EscalaAlteracoes();
		
		escalaAlteracoes.setDia01Fk(escala.getDia01Fk());
		escalaAlteracoes.setDia02Fk(escala.getDia02Fk());
		escalaAlteracoes.setDia03Fk(escala.getDia03Fk());
		escalaAlteracoes.setDia04Fk(escala.getDia04Fk());
		escalaAlteracoes.setDia05Fk(escala.getDia05Fk());
		escalaAlteracoes.setDia06Fk(escala.getDia06Fk());
		escalaAlteracoes.setDia07Fk(escala.getDia07Fk());
		escalaAlteracoes.setDia08Fk(escala.getDia08Fk());
		escalaAlteracoes.setDia09Fk(escala.getDia09Fk());
		escalaAlteracoes.setDia10Fk(escala.getDia10Fk());
		escalaAlteracoes.setDia11Fk(escala.getDia11Fk());
		escalaAlteracoes.setDia12Fk(escala.getDia12Fk());
		escalaAlteracoes.setDia13Fk(escala.getDia13Fk());
		escalaAlteracoes.setDia14Fk(escala.getDia14Fk());
		escalaAlteracoes.setDia15Fk(escala.getDia15Fk());
		escalaAlteracoes.setDia16Fk(escala.getDia16Fk());
		escalaAlteracoes.setDia17Fk(escala.getDia17Fk());
		escalaAlteracoes.setDia18Fk(escala.getDia18Fk());
		escalaAlteracoes.setDia19Fk(escala.getDia19Fk());
		escalaAlteracoes.setDia20Fk(escala.getDia20Fk());
		escalaAlteracoes.setDia21Fk(escala.getDia21Fk());
		escalaAlteracoes.setDia22Fk(escala.getDia22Fk());
		escalaAlteracoes.setDia23Fk(escala.getDia23Fk());
		escalaAlteracoes.setDia24Fk(escala.getDia24Fk());
		escalaAlteracoes.setDia25Fk(escala.getDia25Fk());
		escalaAlteracoes.setDia26Fk(escala.getDia26Fk());
		escalaAlteracoes.setDia27Fk(escala.getDia27Fk());
		escalaAlteracoes.setDia28Fk(escala.getDia28Fk());
		escalaAlteracoes.setDia29Fk(escala.getDia29Fk());
		escalaAlteracoes.setDia30Fk(escala.getDia30Fk());
		escalaAlteracoes.setDia31Fk(escala.getDia31Fk());
		
		escalaAlteracoes.setDtCancelamento(escala.getDtCancelamento());
		escalaAlteracoes.setDtMudanca(escala.getDtMudanca());
		escalaAlteracoes.setHorasDia(escala.getHorasDia());
		escalaAlteracoes.setHorasFimSemana(escala.getHorasFimSemana());
		escalaAlteracoes.setHorasNoite(escala.getHorasNoite());
		escalaAlteracoes.setHorasSemana(escala.getHorasSemana());
		escalaAlteracoes.setHorasTotais(escala.getHorasTotais());
		escalaAlteracoes.setId(null);
		escalaAlteracoes.setIdAnoMesFk(escala.getIdAnoMesFk());
		escalaAlteracoes.setIdAvaliacaoAssiduidadeFk(escala.getIdAvaliacaoAssiduidadeFk());
		escalaAlteracoes.setIdAvaliacaoAtividadesBurocraticasFk(escala.getIdAvaliacaoAtividadesBurocraticasFk());
		escalaAlteracoes.setIdAvaliacaoFormalizacaoPontoFk(escala.getIdAvaliacaoFormalizacaoPontoFk());
		escalaAlteracoes.setIdAvaliacaoPermanenciaFk(escala.getIdAvaliacaoPermanenciaFk());
		escalaAlteracoes.setIdChDifSimNaoFk(escala.getIdChDifSimNaoFk());
		escalaAlteracoes.setIdCodigoDiferenciadoFk(escala.getIdCodigoDiferenciadoFk());
		escalaAlteracoes.setIdCoordenacaoFk(escala.getIdCoordenacaoFk());
		escalaAlteracoes.setIdOperadorCancelamentoFk(escala.getIdOperadorCancelamentoFk());
		escalaAlteracoes.setIdOperadorMudancaFk(escala.getIdOperadorMudancaFk());
		escalaAlteracoes.setIdFuncionarioFk(escala.getIdFuncionarioFk());
		escalaAlteracoes.setIdIncrementoDeRiscoSimNaoFk(escala.getIdIncrementoDeRiscoSimNaoFk());
		escalaAlteracoes.setIdLiberacaoDobraInvertidaSimNaoFk(escala.getIdLiberacaoDobraInvertidaSimNaoFk());
		escalaAlteracoes.setIdPresencialSimNaoFk(escala.getIdPresencialSimNaoFk());
		escalaAlteracoes.setIdRegimeFk(escala.getIdRegimeFk());
		escalaAlteracoes.setIdTipoFolhaFk(escala.getIdTipoFolhaFk());
		escalaAlteracoes.setIdTurmaFk(escala.getIdTurmaFk());
		escalaAlteracoes.setPlantoes(escala.getPlantoes());
		escalaAlteracoes.setObservacoes(escala.getObservacoes());
		
		Date data = new Date();
		
		escalaAlteracoes.setDtAlteracao(data);
		escalaAlteracoes.setHoraAlteracao(data);
		
		escalaAlteracoes.setId(null);
		
		return escalaAlteracoes;
	}
	
	
}
