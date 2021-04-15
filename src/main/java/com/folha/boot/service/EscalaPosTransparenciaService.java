package com.folha.boot.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.EscalaPosTransparenciaReposytoty;
import com.folha.boot.Reposytory.EscalaReposytoty;
import com.folha.boot.Reposytory.PessoaDocumentosReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;
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
public class EscalaPosTransparenciaService {

	@Autowired
	private EscalaPosTransparenciaReposytoty reposytory;
	
	
	public EscalaPosTransparencia salvar(EscalaPosTransparencia escala) {
		// TODO Auto-generated method stub
		return reposytory.save(escala);
	}
	
	public void editar(EscalaPosTransparencia escala) {
		// TODO Auto-generated method stub
		reposytory.save(escala);
	}

	public void cancelar(EscalaPosTransparencia escala) {
		// TODO Auto-generated method stub
		escala.setDtCancelamento(new Date());
		reposytory.save(escala);
	}
	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public EscalaPosTransparencia buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<EscalaPosTransparencia> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<EscalaPosTransparencia> buscarNaUnidade(Unidades unidades, AnoMes anoMes) {
		// TODO Auto-generated method stub
		return reposytory.findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(unidades, anoMes);
	}
	
	@Transactional(readOnly = true)
	public List<EscalaPosTransparencia> buscarEmTodasAsUnidades( AnoMes anoMes) {
		// TODO Auto-generated method stub
		return reposytory.findByIdAnoMesFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc( anoMes);
	}
	
	public Page<EscalaPosTransparencia> findPaginatedPosTransparenciaGlobal(int pageNo, int pageSize,  AnoMes anoMes) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdAnoMesFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc( anoMes, pageable);
	}
	
	public Page<EscalaPosTransparencia> findPaginatedNomePosTransparenciaGlobal(int pageNo, int pageSize, String nome, AnoMes anoMes) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdAnoMesFkAndIdFuncionarioFkIdPessoaFkNomeContainingOrderByIdFuncionarioFkIdPessoaFkNomeAsc(anoMes, nome, pageable);
	}
	
	public Page<EscalaPosTransparencia> findPaginatedPosTransparencia(int pageNo, int pageSize, Unidades unidades, AnoMes anoMes) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(unidades, anoMes, pageable);
	}
	
	public Page<EscalaPosTransparencia> findPaginatedNomePosTransparencia(int pageNo, int pageSize, Unidades unidades, AnoMes anoMes, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndIdFuncionarioFkIdPessoaFkNomeContainingOrderByIdFuncionarioFkIdPessoaFkNomeAsc(unidades, anoMes, nome.toUpperCase().trim(), pageable);
	}

	public EscalaPosTransparencia converteDeEscalaParaEscalaPosTransparencia(Escala escala) {
		EscalaPosTransparencia escalaPosTransparencia = new EscalaPosTransparencia();
	
		escalaPosTransparencia.setDia01Fk(escala.getDia01Fk());
		escalaPosTransparencia.setDia02Fk(escala.getDia02Fk());
		escalaPosTransparencia.setDia03Fk(escala.getDia03Fk());
		escalaPosTransparencia.setDia04Fk(escala.getDia04Fk());
		escalaPosTransparencia.setDia05Fk(escala.getDia05Fk());
		escalaPosTransparencia.setDia06Fk(escala.getDia06Fk());
		escalaPosTransparencia.setDia07Fk(escala.getDia07Fk());
		escalaPosTransparencia.setDia08Fk(escala.getDia08Fk());
		escalaPosTransparencia.setDia09Fk(escala.getDia09Fk());
		escalaPosTransparencia.setDia10Fk(escala.getDia10Fk());
		escalaPosTransparencia.setDia11Fk(escala.getDia11Fk());
		escalaPosTransparencia.setDia12Fk(escala.getDia12Fk());
		escalaPosTransparencia.setDia13Fk(escala.getDia13Fk());
		escalaPosTransparencia.setDia14Fk(escala.getDia14Fk());
		escalaPosTransparencia.setDia15Fk(escala.getDia15Fk());
		escalaPosTransparencia.setDia16Fk(escala.getDia16Fk());
		escalaPosTransparencia.setDia17Fk(escala.getDia17Fk());
		escalaPosTransparencia.setDia18Fk(escala.getDia18Fk());
		escalaPosTransparencia.setDia19Fk(escala.getDia19Fk());
		escalaPosTransparencia.setDia20Fk(escala.getDia20Fk());
		escalaPosTransparencia.setDia21Fk(escala.getDia21Fk());
		escalaPosTransparencia.setDia22Fk(escala.getDia22Fk());
		escalaPosTransparencia.setDia23Fk(escala.getDia23Fk());
		escalaPosTransparencia.setDia24Fk(escala.getDia24Fk());
		escalaPosTransparencia.setDia25Fk(escala.getDia25Fk());
		escalaPosTransparencia.setDia26Fk(escala.getDia26Fk());
		escalaPosTransparencia.setDia27Fk(escala.getDia27Fk());
		escalaPosTransparencia.setDia28Fk(escala.getDia28Fk());
		escalaPosTransparencia.setDia29Fk(escala.getDia29Fk());
		escalaPosTransparencia.setDia30Fk(escala.getDia30Fk());
		escalaPosTransparencia.setDia31Fk(escala.getDia31Fk());
		
		escalaPosTransparencia.setDtCancelamento(escala.getDtCancelamento());
		escalaPosTransparencia.setDtMudanca(escala.getDtMudanca());
		escalaPosTransparencia.setHorasDia(escala.getHorasDia());
		escalaPosTransparencia.setHorasFimSemana(escala.getHorasFimSemana());
		escalaPosTransparencia.setHorasNoite(escala.getHorasNoite());
		escalaPosTransparencia.setHorasSemana(escala.getHorasSemana());
		escalaPosTransparencia.setHorasTotais(escala.getHorasTotais());
		escalaPosTransparencia.setId(null);
		escalaPosTransparencia.setIdAnoMesFk(escala.getIdAnoMesFk());
		escalaPosTransparencia.setIdAvaliacaoAssiduidadeFk(escala.getIdAvaliacaoAssiduidadeFk());
		escalaPosTransparencia.setIdAvaliacaoAtividadesBurocraticasFk(escala.getIdAvaliacaoAtividadesBurocraticasFk());
		escalaPosTransparencia.setIdAvaliacaoFormalizacaoPontoFk(escala.getIdAvaliacaoFormalizacaoPontoFk());
		escalaPosTransparencia.setIdAvaliacaoPermanenciaFk(escala.getIdAvaliacaoPermanenciaFk());
		escalaPosTransparencia.setIdChDifSimNaoFk(escala.getIdChDifSimNaoFk());
		escalaPosTransparencia.setIdCodigoDiferenciadoFk(escala.getIdCodigoDiferenciadoFk());
		escalaPosTransparencia.setIdCoordenacaoFk(escala.getIdCoordenacaoFk());
		escalaPosTransparencia.setIdOperadorCancelamentoFk(escala.getIdOperadorCancelamentoFk());
		escalaPosTransparencia.setIdOperadorMudancaFk(escala.getIdOperadorMudancaFk());
		escalaPosTransparencia.setIdFuncionarioFk(escala.getIdFuncionarioFk());
		escalaPosTransparencia.setIdIncrementoDeRiscoSimNaoFk(escala.getIdIncrementoDeRiscoSimNaoFk());
		escalaPosTransparencia.setIdLiberacaoDobraInvertidaSimNaoFk(escala.getIdLiberacaoDobraInvertidaSimNaoFk());
		escalaPosTransparencia.setIdPresencialSimNaoFk(escala.getIdPresencialSimNaoFk());
		escalaPosTransparencia.setIdRegimeFk(escala.getIdRegimeFk());
		escalaPosTransparencia.setIdTipoFolhaFk(escala.getIdTipoFolhaFk());
		escalaPosTransparencia.setIdTurmaFk(escala.getIdTurmaFk());
		escalaPosTransparencia.setPlantoes(escala.getPlantoes());
		escalaPosTransparencia.setObservacoes(escala.getObservacoes());
	
		escalaPosTransparencia.setId(null);
		
		return escalaPosTransparencia;
	}
	
	
}
