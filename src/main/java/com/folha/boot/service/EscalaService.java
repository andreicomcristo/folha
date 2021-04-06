package com.folha.boot.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.EscalaReposytoty;
import com.folha.boot.Reposytory.PessoaDocumentosReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;
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
public class EscalaService {

	@Autowired
	private EscalaReposytoty reposytory;
	
	
	public Escala salvar(Escala escala) {
		// TODO Auto-generated method stub
		Escala escala1 = reposytory.save(escala);
		return escala1;
	}
	
	public void editar(Escala escala) {
		// TODO Auto-generated method stub
		reposytory.save(escala);
	}

	public void cancelar(Escala escala) {
		// TODO Auto-generated method stub
		escala.setDtCancelamento(new Date());
		reposytory.save(escala);
	}
	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public Escala buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<Escala> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	
	public List<Escala> buscarPorCoordenacaoEAnoMes(CoordenacaoEscala coordenacaoEscala, AnoMes anoMes) {
		// TODO Auto-generated method stub
		return reposytory.buscarPorCoordenacaoEAnoMes(coordenacaoEscala, anoMes);
	}
	
	public List<Escala> buscarPorPessoaEAnoMes(Pessoa pessoa, AnoMes anoMes) {
		// TODO Auto-generated method stub
		return reposytory.buscarPorPessoaEAnoMes( pessoa, anoMes);
	}
	
	//Busca Exportacao
	public List<Escala> buscarExportacao( CoordenacaoEscala coordenacaoEscala, AnoMes anoMes) {
		return this.reposytory.findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAsc(coordenacaoEscala, anoMes);
	}
	
	//Busca Exportacao Setorial Servico
	public List<Escala> buscarExportacaoSetorialServico( CoordenacaoEscala coordenacaoEscala, AnoMes anoMes) {
		return this.reposytory.findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdTurmaFkNomeTurmaAscIdFuncionarioFkIdPessoaFkNomeAsc(coordenacaoEscala, anoMes);
	}
	
	//Busca Exportacao Todos
	public List<Escala> buscarExportacaoTodos( Unidades unidades, AnoMes anoMes) {
		return this.reposytory.findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAsc(unidades, anoMes);
	}
	
	public Page<Escala> findPaginated(int pageNo, int pageSize, CoordenacaoEscala coordenacaoEscala, AnoMes anoMes) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAsc(coordenacaoEscala, anoMes, pageable);
	}
	
	public Page<Escala> findPaginatedTodos(int pageNo, int pageSize, Unidades unidades, AnoMes anoMes) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAsc(unidades, anoMes, pageable);
	}
	
	public Page<Escala> findPaginatedNome(int pageNo, int pageSize, CoordenacaoEscala coordenacaoEscala, AnoMes anoMes, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdFuncionarioFkIdPessoaFkNomeContainingOrderByIdFuncionarioFkIdPessoaFkNomeAsc(coordenacaoEscala, anoMes, nome.toUpperCase().trim(), pageable);
	}
	
	public Page<Escala> findPaginatedNomeTodos(int pageNo, int pageSize, Unidades unidades, AnoMes anoMes, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdFuncionarioFkIdPessoaFkNomeContainingOrderByIdFuncionarioFkIdPessoaFkNomeAsc(unidades, anoMes, nome.toUpperCase().trim(), pageable);
	}

	public Page<Escala> findPaginatedTurma(int pageNo, int pageSize, CoordenacaoEscala coordenacaoEscala, AnoMes anoMes, Turmas turmas) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdTurmaFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(coordenacaoEscala, anoMes, turmas, pageable);
	}
	
	public Page<Escala> findPaginatedTurmaTodos(int pageNo, int pageSize, Unidades unidades, AnoMes anoMes, Turmas turmas) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdTurmaFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(unidades, anoMes, turmas, pageable);
	}
	
	public Page<Escala> findPaginatedCargo(int pageNo, int pageSize, CoordenacaoEscala coordenacaoEscala, AnoMes anoMes, CargosEspecialidade cargosEspecialidade) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdFuncionarioFkIdEspecialidadeAtualFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(coordenacaoEscala, anoMes, cargosEspecialidade, pageable);
	}
	
	public Page<Escala> findPaginatedCargoTodos(int pageNo, int pageSize, Unidades unidades, AnoMes anoMes, CargosEspecialidade cargosEspecialidade) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdFuncionarioFkIdEspecialidadeAtualFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(unidades, anoMes, cargosEspecialidade, pageable);
	}
	
	public Page<Escala> findPaginatedFolha(int pageNo, int pageSize, CoordenacaoEscala coordenacaoEscala, AnoMes anoMes, TiposDeFolha tiposDeFolha) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdTipoFolhaFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(coordenacaoEscala, anoMes, tiposDeFolha, pageable);
	}
	
	public Page<Escala> findPaginatedFolhaTodos(int pageNo, int pageSize, Unidades unidades, AnoMes anoMes, TiposDeFolha tiposDeFolha) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdTipoFolhaFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(unidades, anoMes, tiposDeFolha, pageable);
	}
	
	
	public void lancarTurma(Escala escala) {
		List<Escala> lista = buscarPorCoordenacaoEAnoMesZeradas(escala.getIdCoordenacaoFk(), escala.getIdAnoMesFk(), escala.getIdTurmaFk());
		
		for(int i=0;i<lista.size();i++) {
			Escala escalaAMudar = lista.get(i);
			
			escalaAMudar.setDia01Fk(escala.getDia01Fk());
			escalaAMudar.setDia02Fk(escala.getDia02Fk());
			escalaAMudar.setDia03Fk(escala.getDia03Fk());
			escalaAMudar.setDia04Fk(escala.getDia04Fk());
			escalaAMudar.setDia05Fk(escala.getDia05Fk());
			escalaAMudar.setDia06Fk(escala.getDia06Fk());
			escalaAMudar.setDia07Fk(escala.getDia07Fk());
			escalaAMudar.setDia08Fk(escala.getDia08Fk());
			escalaAMudar.setDia09Fk(escala.getDia09Fk());
			escalaAMudar.setDia10Fk(escala.getDia10Fk());
			escalaAMudar.setDia11Fk(escala.getDia11Fk());
			escalaAMudar.setDia12Fk(escala.getDia12Fk());
			escalaAMudar.setDia13Fk(escala.getDia13Fk());
			escalaAMudar.setDia14Fk(escala.getDia14Fk());
			escalaAMudar.setDia15Fk(escala.getDia15Fk());
			escalaAMudar.setDia16Fk(escala.getDia16Fk());
			escalaAMudar.setDia17Fk(escala.getDia17Fk());
			escalaAMudar.setDia18Fk(escala.getDia18Fk());
			escalaAMudar.setDia19Fk(escala.getDia19Fk());
			escalaAMudar.setDia20Fk(escala.getDia20Fk());
			escalaAMudar.setDia21Fk(escala.getDia21Fk());
			escalaAMudar.setDia22Fk(escala.getDia22Fk());
			escalaAMudar.setDia23Fk(escala.getDia23Fk());
			escalaAMudar.setDia24Fk(escala.getDia24Fk());
			escalaAMudar.setDia25Fk(escala.getDia25Fk());
			escalaAMudar.setDia26Fk(escala.getDia26Fk());
			escalaAMudar.setDia27Fk(escala.getDia27Fk());
			escalaAMudar.setDia28Fk(escala.getDia28Fk());
			escalaAMudar.setDia29Fk(escala.getDia29Fk());
			escalaAMudar.setDia30Fk(escala.getDia30Fk());
			escalaAMudar.setDia31Fk(escala.getDia31Fk());
			
			escalaAMudar.setHorasDia(escala.getHorasDia());
			escalaAMudar.setHorasFimSemana(escala.getHorasFimSemana());
			escalaAMudar.setHorasNoite(escala.getHorasNoite());
			escalaAMudar.setHorasSemana(escala.getHorasSemana());
			escalaAMudar.setHorasTotais(escala.getHorasTotais());
			
			escalaAMudar.setIdOperadorMudancaFk(escala.getIdOperadorMudancaFk());
			escalaAMudar.setDtMudanca(escala.getDtMudanca());
			
			//AVALIAÇÃO PARA SABER SE TEM CHOQUES
			String choque = choquesEmEscalaOnipresenca(escalaAMudar);
			String choqueDescansoDepoisNoturno = choquesEmEscalaDepoisDoNoturno(escalaAMudar);
			if(choque.length()==0 && choqueDescansoDepoisNoturno.length()==0) {
				salvar(escalaAMudar);
			}
			
			
		}
	}
	
	public List<Escala> buscarPorCoordenacaoEAnoMesZeradas(CoordenacaoEscala coordenacaoEscala, AnoMes anoMes, Turmas turmas) {
		return reposytory.buscarPorCoordenacaoEAnoMesTurmaZeradas(coordenacaoEscala, anoMes, turmas);
	}
	
	
	public String choquesEmEscalaOnipresenca(Escala escala) {
    	String resposta = "";
    	List<Escala> lista = buscarPorPessoaEAnoMes(escala.getIdFuncionarioFk().getIdPessoaFk(), escala.getIdAnoMesFk());
    	
    	for(int i=0;i<lista.size();i++) {
    		
    		if(escala.getId()!=lista.get(i).getId()) {
	    		
    			String respostaInterna = "";
    			
    			//Dia 01
    			if((escala.getDia01Fk().getHorasManha()>0)  && (lista.get(i).getDia01Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"1 manha;";
	    		}
    			if(escala.getDia01Fk().getHorasTarde()>0  && lista.get(i).getDia01Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"1 tarde;";
	    		}
    			if(escala.getDia01Fk().getHorasNoite()>0  && lista.get(i).getDia01Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"1 noite;";
	    		}
    			
    			//Dia 02
    			if((escala.getDia02Fk().getHorasManha()>0)  && (lista.get(i).getDia02Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"2 manha;";
	    		}
    			if(escala.getDia02Fk().getHorasTarde()>0  && lista.get(i).getDia02Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"2 tarde;";
	    		}
    			if(escala.getDia02Fk().getHorasNoite()>0  && lista.get(i).getDia02Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"2 noite;";
	    		}
    			
    			//Dia 03
    			if((escala.getDia03Fk().getHorasManha()>0)  && (lista.get(i).getDia03Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"3 manha;";
	    		}
    			if(escala.getDia03Fk().getHorasTarde()>0  && lista.get(i).getDia03Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"3 tarde;";
	    		}
    			if(escala.getDia03Fk().getHorasNoite()>0  && lista.get(i).getDia03Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"3 noite;";
	    		}
    			
    			//Dia 04
    			if((escala.getDia04Fk().getHorasManha()>0)  && (lista.get(i).getDia04Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"4 manha;";
	    		}
    			if(escala.getDia04Fk().getHorasTarde()>0  && lista.get(i).getDia04Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"4 tarde;";
	    		}
    			if(escala.getDia04Fk().getHorasNoite()>0  && lista.get(i).getDia04Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"4 noite;";
	    		}
    			
    			//Dia 05
    			if((escala.getDia05Fk().getHorasManha()>0)  && (lista.get(i).getDia05Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"5 manha;";
	    		}
    			if(escala.getDia05Fk().getHorasTarde()>0  && lista.get(i).getDia05Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"5 tarde;";
	    		}
    			if(escala.getDia05Fk().getHorasNoite()>0  && lista.get(i).getDia05Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"5 noite;";
	    		}
    			
    			//Dia 06
    			if((escala.getDia06Fk().getHorasManha()>0)  && (lista.get(i).getDia06Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"6 manha;";
	    		}
    			if(escala.getDia06Fk().getHorasTarde()>0  && lista.get(i).getDia06Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"6 tarde;";
	    		}
    			if(escala.getDia06Fk().getHorasNoite()>0  && lista.get(i).getDia06Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"6 noite;";
	    		}
    			
    			//Dia 07
    			if((escala.getDia07Fk().getHorasManha()>0)  && (lista.get(i).getDia07Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"7 manha;";
	    		}
    			if(escala.getDia07Fk().getHorasTarde()>0  && lista.get(i).getDia07Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"7 tarde;";
	    		}
    			if(escala.getDia07Fk().getHorasNoite()>0  && lista.get(i).getDia07Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"7 noite;";
	    		}
    			
    			//Dia 08
    			if((escala.getDia08Fk().getHorasManha()>0)  && (lista.get(i).getDia08Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"8 manha;";
	    		}
    			if(escala.getDia08Fk().getHorasTarde()>0  && lista.get(i).getDia08Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"8 tarde;";
	    		}
    			if(escala.getDia08Fk().getHorasNoite()>0  && lista.get(i).getDia08Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"8 noite;";
	    		}
    			
    			//Dia 09
    			if((escala.getDia09Fk().getHorasManha()>0)  && (lista.get(i).getDia09Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"9 manha;";
	    		}
    			if(escala.getDia09Fk().getHorasTarde()>0  && lista.get(i).getDia09Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"9 tarde;";
	    		}
    			if(escala.getDia09Fk().getHorasNoite()>0  && lista.get(i).getDia09Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"9 noite;";
	    		}
    			
    			//Dia 10
    			if((escala.getDia10Fk().getHorasManha()>0)  && (lista.get(i).getDia10Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"10 manha;";
	    		}
    			if(escala.getDia10Fk().getHorasTarde()>0  && lista.get(i).getDia10Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"10 tarde;";
	    		}
    			if(escala.getDia10Fk().getHorasNoite()>0  && lista.get(i).getDia10Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"10 noite;";
	    		}
    			
    			//Dia 11
    			if((escala.getDia11Fk().getHorasManha()>0)  && (lista.get(i).getDia11Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"11 manha;";
	    		}
    			if(escala.getDia11Fk().getHorasTarde()>0  && lista.get(i).getDia11Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"11 tarde;";
	    		}
    			if(escala.getDia11Fk().getHorasNoite()>0  && lista.get(i).getDia11Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"11 noite;";
	    		}
    			
    			//Dia 12
    			if((escala.getDia12Fk().getHorasManha()>0)  && (lista.get(i).getDia12Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"12 manha;";
	    		}
    			if(escala.getDia12Fk().getHorasTarde()>0  && lista.get(i).getDia12Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"12 tarde;";
	    		}
    			if(escala.getDia12Fk().getHorasNoite()>0  && lista.get(i).getDia12Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"12 noite;";
	    		}
    			
    			//Dia 13
    			if((escala.getDia13Fk().getHorasManha()>0)  && (lista.get(i).getDia13Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"13 manha;";
	    		}
    			if(escala.getDia13Fk().getHorasTarde()>0  && lista.get(i).getDia13Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"13 tarde;";
	    		}
    			if(escala.getDia13Fk().getHorasNoite()>0  && lista.get(i).getDia13Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"13 noite;";
	    		}
    			
    			//Dia 14
    			if((escala.getDia14Fk().getHorasManha()>0)  && (lista.get(i).getDia14Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"14 manha;";
	    		}
    			if(escala.getDia14Fk().getHorasTarde()>0  && lista.get(i).getDia14Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"14 tarde;";
	    		}
    			if(escala.getDia14Fk().getHorasNoite()>0  && lista.get(i).getDia14Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"14 noite;";
	    		}
    			
    			//Dia 15
    			if((escala.getDia15Fk().getHorasManha()>0)  && (lista.get(i).getDia15Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"15 manha;";
	    		}
    			if(escala.getDia15Fk().getHorasTarde()>0  && lista.get(i).getDia15Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"15 tarde;";
	    		}
    			if(escala.getDia15Fk().getHorasNoite()>0  && lista.get(i).getDia15Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"15 noite;";
	    		}
    			
    			//Dia 16
    			if((escala.getDia16Fk().getHorasManha()>0)  && (lista.get(i).getDia16Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"16 manha;";
	    		}
    			if(escala.getDia16Fk().getHorasTarde()>0  && lista.get(i).getDia16Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"16 tarde;";
	    		}
    			if(escala.getDia16Fk().getHorasNoite()>0  && lista.get(i).getDia16Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"16 noite;";
	    		}
    			
    			//Dia 17
    			if((escala.getDia17Fk().getHorasManha()>0)  && (lista.get(i).getDia17Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"17 manha;";
	    		}
    			if(escala.getDia17Fk().getHorasTarde()>0  && lista.get(i).getDia17Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"17 tarde;";
	    		}
    			if(escala.getDia17Fk().getHorasNoite()>0  && lista.get(i).getDia17Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"17 noite;";
	    		}
    			
    			//Dia 18
    			if((escala.getDia18Fk().getHorasManha()>0)  && (lista.get(i).getDia18Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"18 manha;";
	    		}
    			if(escala.getDia18Fk().getHorasTarde()>0  && lista.get(i).getDia18Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"18 tarde;";
	    		}
    			if(escala.getDia18Fk().getHorasNoite()>0  && lista.get(i).getDia18Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"18 noite;";
	    		}
    			
    			//Dia 19
    			if((escala.getDia19Fk().getHorasManha()>0)  && (lista.get(i).getDia19Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"19 manha;";
	    		}
    			if(escala.getDia19Fk().getHorasTarde()>0  && lista.get(i).getDia19Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"19 tarde;";
	    		}
    			if(escala.getDia19Fk().getHorasNoite()>0  && lista.get(i).getDia19Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"19 noite;";
	    		}
    			
    			//Dia 20
    			if((escala.getDia20Fk().getHorasManha()>0)  && (lista.get(i).getDia20Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"20 manha;";
	    		}
    			if(escala.getDia20Fk().getHorasTarde()>0  && lista.get(i).getDia20Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"20 tarde;";
	    		}
    			if(escala.getDia20Fk().getHorasNoite()>0  && lista.get(i).getDia20Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"20 noite;";
	    		}
    			
    			//Dia 21
    			if((escala.getDia21Fk().getHorasManha()>0)  && (lista.get(i).getDia21Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"21 manha;";
	    		}
    			if(escala.getDia21Fk().getHorasTarde()>0  && lista.get(i).getDia21Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"21 tarde;";
	    		}
    			if(escala.getDia21Fk().getHorasNoite()>0  && lista.get(i).getDia21Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"21 noite;";
	    		}
    			
    			//Dia 22
    			if((escala.getDia22Fk().getHorasManha()>0)  && (lista.get(i).getDia22Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"22 manha;";
	    		}
    			if(escala.getDia22Fk().getHorasTarde()>0  && lista.get(i).getDia22Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"22 tarde;";
	    		}
    			if(escala.getDia22Fk().getHorasNoite()>0  && lista.get(i).getDia22Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"22 noite;";
	    		}
    			
    			//Dia 23
    			if((escala.getDia23Fk().getHorasManha()>0)  && (lista.get(i).getDia23Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"23 manha;";
	    		}
    			if(escala.getDia23Fk().getHorasTarde()>0  && lista.get(i).getDia23Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"23 tarde;";
	    		}
    			if(escala.getDia23Fk().getHorasNoite()>0  && lista.get(i).getDia23Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"23 noite;";
	    		}
    			
    			//Dia 24
    			if((escala.getDia24Fk().getHorasManha()>0)  && (lista.get(i).getDia24Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"24 manha;";
	    		}
    			if(escala.getDia24Fk().getHorasTarde()>0  && lista.get(i).getDia24Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"24 tarde;";
	    		}
    			if(escala.getDia24Fk().getHorasNoite()>0  && lista.get(i).getDia24Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"24 noite;";
	    		}
    			
    			//Dia 25
    			if((escala.getDia25Fk().getHorasManha()>0)  && (lista.get(i).getDia25Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"25 manha;";
	    		}
    			if(escala.getDia25Fk().getHorasTarde()>0  && lista.get(i).getDia25Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"25 tarde;";
	    		}
    			if(escala.getDia25Fk().getHorasNoite()>0  && lista.get(i).getDia25Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"25 noite;";
	    		}
    			
    			//Dia 26
    			if((escala.getDia26Fk().getHorasManha()>0)  && (lista.get(i).getDia26Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"26 manha;";
	    		}
    			if(escala.getDia26Fk().getHorasTarde()>0  && lista.get(i).getDia26Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"26 tarde;";
	    		}
    			if(escala.getDia26Fk().getHorasNoite()>0  && lista.get(i).getDia26Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"26 noite;";
	    		}
    			
    			//Dia 27
    			if((escala.getDia27Fk().getHorasManha()>0)  && (lista.get(i).getDia27Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"27 manha;";
	    		}
    			if(escala.getDia27Fk().getHorasTarde()>0  && lista.get(i).getDia27Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"27 tarde;";
	    		}
    			if(escala.getDia27Fk().getHorasNoite()>0  && lista.get(i).getDia27Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"27 noite;";
	    		}
    			
    			//Dia 28
    			if((escala.getDia28Fk().getHorasManha()>0)  && (lista.get(i).getDia28Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"28 manha;";
	    		}
    			if(escala.getDia28Fk().getHorasTarde()>0  && lista.get(i).getDia28Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"28 tarde;";
	    		}
    			if(escala.getDia28Fk().getHorasNoite()>0  && lista.get(i).getDia28Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"28 noite;";
	    		}
    			
    			//Dia 29
    			if((escala.getDia29Fk().getHorasManha()>0)  && (lista.get(i).getDia29Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"29 manha;";
	    		}
    			if(escala.getDia29Fk().getHorasTarde()>0  && lista.get(i).getDia29Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"29 tarde;";
	    		}
    			if(escala.getDia29Fk().getHorasNoite()>0  && lista.get(i).getDia29Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"29 noite;";
	    		}
    			
    			//Dia 30
    			if((escala.getDia30Fk().getHorasManha()>0)  && (lista.get(i).getDia30Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"30 manha;";
	    		}
    			if(escala.getDia30Fk().getHorasTarde()>0  && lista.get(i).getDia30Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"30 tarde;";
	    		}
    			if(escala.getDia30Fk().getHorasNoite()>0  && lista.get(i).getDia30Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"30 noite;";
	    		}
    			
    			//Dia 31
    			if((escala.getDia31Fk().getHorasManha()>0)  && (lista.get(i).getDia31Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"31 manha;";
	    		}
    			if(escala.getDia31Fk().getHorasTarde()>0  && lista.get(i).getDia31Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"31 tarde;";
	    		}
    			if(escala.getDia31Fk().getHorasNoite()>0  && lista.get(i).getDia31Fk().getHorasNoite()>0 ) {
    				respostaInterna = respostaInterna+"31 noite;";
	    		}
    			
    			if(respostaInterna.length()>0) {respostaInterna = lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk().getNomeFantasia()+"-"+lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao()+"-"+lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade()+"-"+lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade()+" "+respostaInterna;}
    			
    			if(respostaInterna.length()>0) {resposta = resposta+respostaInterna;}    			
    		}
    	}
    	
    	if(resposta.length()>0) {resposta = "Choque: "+resposta;}
    	
    	return resposta;
    }
	
	public String choquesEmEscalaDepoisDoNoturno(Escala escala) {
    	String resposta = "";
    	List<Escala> lista = buscarPorPessoaEAnoMes(escala.getIdFuncionarioFk().getIdPessoaFk(), escala.getIdAnoMesFk());
    	lista.add(escala);
    	
    	int horasNoite01 = 0;
    	int horasDia01 = 0;
    	int horasNoite02 = 0;
    	int horasDia02 = 0;
    	int horasNoite03 = 0;
    	int horasDia03 = 0;
    	int horasNoite04 = 0;
    	int horasDia04 = 0;
    	int horasNoite05 = 0;
    	int horasDia05 = 0;
    	int horasNoite06 = 0;
    	int horasDia06 = 0;
    	int horasNoite07 = 0;
    	int horasDia07 = 0;
    	int horasNoite08 = 0;
    	int horasDia08 = 0;
    	int horasNoite09 = 0;
    	int horasDia09 = 0;
    	int horasNoite10 = 0;
    	int horasDia10 = 0;
    	int horasNoite11 = 0;
    	int horasDia11 = 0;
    	int horasNoite12 = 0;
    	int horasDia12 = 0;
    	int horasNoite13 = 0;
    	int horasDia13 = 0;
    	int horasNoite14 = 0;
    	int horasDia14 = 0;
    	int horasNoite15 = 0;
    	int horasDia15 = 0;
    	int horasNoite16 = 0;
    	int horasDia16 = 0;
    	int horasNoite17 = 0;
    	int horasDia17 = 0;
    	int horasNoite18 = 0;
    	int horasDia18 = 0;
    	int horasNoite19 = 0;
    	int horasDia19 = 0;
    	int horasNoite20 = 0;
    	int horasDia20 = 0;
    	int horasNoite21 = 0;
    	int horasDia21 = 0;
    	int horasNoite22 = 0;
    	int horasDia22 = 0;
    	int horasNoite23 = 0;
    	int horasDia23 = 0;
    	int horasNoite24 = 0;
    	int horasDia24 = 0;
    	int horasNoite25 = 0;
    	int horasDia25 = 0;
    	int horasNoite26 = 0;
    	int horasDia26 = 0;
    	int horasNoite27 = 0;
    	int horasDia27 = 0;
    	int horasNoite28 = 0;
    	int horasDia28 = 0;
    	int horasNoite29 = 0;
    	int horasDia29 = 0;
    	int horasNoite30 = 0;
    	int horasDia30 = 0;
    	int horasNoite31 = 0;
    	int horasDia31 = 0;
    	
    	for(int i = 0;i<lista.size();i++) {
    		horasDia01   = horasDia01   + lista.get(i).getDia01Fk().getHorasManha() + lista.get(i).getDia01Fk().getHorasTarde();
    		horasNoite01 = horasNoite01 + lista.get(i).getDia01Fk().getHorasNoite() ;
    		
    		horasDia02   = horasDia02   + lista.get(i).getDia02Fk().getHorasManha() + lista.get(i).getDia02Fk().getHorasTarde();
    		horasNoite02 = horasNoite02 + lista.get(i).getDia02Fk().getHorasNoite() ;
    		
    		horasDia03   = horasDia03   + lista.get(i).getDia03Fk().getHorasManha() + lista.get(i).getDia03Fk().getHorasTarde();
    		horasNoite03 = horasNoite03 + lista.get(i).getDia03Fk().getHorasNoite() ;
    		
    		horasDia04   = horasDia04   + lista.get(i).getDia04Fk().getHorasManha() + lista.get(i).getDia04Fk().getHorasTarde();
    		horasNoite04 = horasNoite04 + lista.get(i).getDia04Fk().getHorasNoite() ;
    		
    		horasDia05   = horasDia05   + lista.get(i).getDia05Fk().getHorasManha() + lista.get(i).getDia05Fk().getHorasTarde();
    		horasNoite05 = horasNoite05 + lista.get(i).getDia05Fk().getHorasNoite() ;
    		
    		horasDia06   = horasDia06   + lista.get(i).getDia06Fk().getHorasManha() + lista.get(i).getDia06Fk().getHorasTarde();
    		horasNoite06 = horasNoite06 + lista.get(i).getDia06Fk().getHorasNoite() ;
    		
    		horasDia07   = horasDia07   + lista.get(i).getDia07Fk().getHorasManha() + lista.get(i).getDia07Fk().getHorasTarde();
    		horasNoite07 = horasNoite07 + lista.get(i).getDia07Fk().getHorasNoite() ;
    		
    		horasDia08   = horasDia08   + lista.get(i).getDia08Fk().getHorasManha() + lista.get(i).getDia08Fk().getHorasTarde();
    		horasNoite08 = horasNoite08 + lista.get(i).getDia08Fk().getHorasNoite() ;
    		
    		horasDia09   = horasDia09   + lista.get(i).getDia09Fk().getHorasManha() + lista.get(i).getDia09Fk().getHorasTarde();
    		horasNoite09 = horasNoite09 + lista.get(i).getDia09Fk().getHorasNoite() ;
    		
    		horasDia10   = horasDia10   + lista.get(i).getDia10Fk().getHorasManha() + lista.get(i).getDia10Fk().getHorasTarde();
    		horasNoite10 = horasNoite10 + lista.get(i).getDia10Fk().getHorasNoite() ;
    		
    		horasDia11   = horasDia11   + lista.get(i).getDia11Fk().getHorasManha() + lista.get(i).getDia11Fk().getHorasTarde();
    		horasNoite11 = horasNoite11 + lista.get(i).getDia11Fk().getHorasNoite() ;
    		
    		horasDia12   = horasDia12   + lista.get(i).getDia12Fk().getHorasManha() + lista.get(i).getDia12Fk().getHorasTarde();
    		horasNoite12 = horasNoite12 + lista.get(i).getDia12Fk().getHorasNoite() ;
    		
    		horasDia13   = horasDia13   + lista.get(i).getDia13Fk().getHorasManha() + lista.get(i).getDia13Fk().getHorasTarde();
    		horasNoite13 = horasNoite13 + lista.get(i).getDia13Fk().getHorasNoite() ;
    		
    		horasDia14   = horasDia14   + lista.get(i).getDia14Fk().getHorasManha() + lista.get(i).getDia14Fk().getHorasTarde();
    		horasNoite14 = horasNoite14 + lista.get(i).getDia14Fk().getHorasNoite() ;
    		
    		horasDia15   = horasDia15   + lista.get(i).getDia15Fk().getHorasManha() + lista.get(i).getDia15Fk().getHorasTarde();
    		horasNoite15 = horasNoite15 + lista.get(i).getDia15Fk().getHorasNoite() ;
    		
    		horasDia16   = horasDia16   + lista.get(i).getDia16Fk().getHorasManha() + lista.get(i).getDia16Fk().getHorasTarde();
    		horasNoite16 = horasNoite16 + lista.get(i).getDia16Fk().getHorasNoite() ;
    		
    		horasDia17   = horasDia17   + lista.get(i).getDia17Fk().getHorasManha() + lista.get(i).getDia17Fk().getHorasTarde();
    		horasNoite17 = horasNoite17 + lista.get(i).getDia17Fk().getHorasNoite() ;
    		
    		horasDia18   = horasDia17   + lista.get(i).getDia18Fk().getHorasManha() + lista.get(i).getDia18Fk().getHorasTarde();
    		horasNoite18 = horasNoite18 + lista.get(i).getDia18Fk().getHorasNoite() ;
    		
    		horasDia19   = horasDia19   + lista.get(i).getDia19Fk().getHorasManha() + lista.get(i).getDia19Fk().getHorasTarde();
    		horasNoite19 = horasNoite19 + lista.get(i).getDia19Fk().getHorasNoite() ;
    		
    		horasDia20   = horasDia20   + lista.get(i).getDia20Fk().getHorasManha() + lista.get(i).getDia20Fk().getHorasTarde();
    		horasNoite20 = horasNoite20 + lista.get(i).getDia20Fk().getHorasNoite() ;
    		
    		horasDia21   = horasDia21   + lista.get(i).getDia21Fk().getHorasManha() + lista.get(i).getDia21Fk().getHorasTarde();
    		horasNoite21 = horasNoite21 + lista.get(i).getDia21Fk().getHorasNoite() ;
    		
    		horasDia22   = horasDia22   + lista.get(i).getDia22Fk().getHorasManha() + lista.get(i).getDia22Fk().getHorasTarde();
    		horasNoite22 = horasNoite22 + lista.get(i).getDia22Fk().getHorasNoite() ;
    		
    		horasDia23   = horasDia23   + lista.get(i).getDia23Fk().getHorasManha() + lista.get(i).getDia23Fk().getHorasTarde();
    		horasNoite23 = horasNoite23 + lista.get(i).getDia23Fk().getHorasNoite() ;
    		
    		horasDia24   = horasDia24   + lista.get(i).getDia24Fk().getHorasManha() + lista.get(i).getDia24Fk().getHorasTarde();
    		horasNoite24 = horasNoite24 + lista.get(i).getDia24Fk().getHorasNoite() ;
    		
    		horasDia25   = horasDia25   + lista.get(i).getDia25Fk().getHorasManha() + lista.get(i).getDia25Fk().getHorasTarde();
    		horasNoite25 = horasNoite25 + lista.get(i).getDia25Fk().getHorasNoite() ;
    		
    		horasDia26   = horasDia26   + lista.get(i).getDia26Fk().getHorasManha() + lista.get(i).getDia26Fk().getHorasTarde();
    		horasNoite26 = horasNoite26 + lista.get(i).getDia26Fk().getHorasNoite() ;
    		
    		horasDia27   = horasDia27   + lista.get(i).getDia27Fk().getHorasManha() + lista.get(i).getDia27Fk().getHorasTarde();
    		horasNoite27 = horasNoite27 + lista.get(i).getDia27Fk().getHorasNoite() ;
    		
    		horasDia28   = horasDia28   + lista.get(i).getDia28Fk().getHorasManha() + lista.get(i).getDia28Fk().getHorasTarde();
    		horasNoite28 = horasNoite28 + lista.get(i).getDia28Fk().getHorasNoite() ;
    		
    		horasDia29   = horasDia29   + lista.get(i).getDia29Fk().getHorasManha() + lista.get(i).getDia29Fk().getHorasTarde();
    		horasNoite29 = horasNoite29 + lista.get(i).getDia29Fk().getHorasNoite() ;
    		
    		horasDia30   = horasDia30   + lista.get(i).getDia30Fk().getHorasManha() + lista.get(i).getDia30Fk().getHorasTarde();
    		horasNoite30 = horasNoite30 + lista.get(i).getDia30Fk().getHorasNoite() ;
    		
    		horasDia31   = horasDia31   + lista.get(i).getDia31Fk().getHorasManha() + lista.get(i).getDia31Fk().getHorasTarde();
    		horasNoite31 = horasNoite31 + lista.get(i).getDia31Fk().getHorasNoite() ;
    		
    	}
    	
    	
    	if((horasNoite01>0) && (horasDia02>0) ) {
    		resposta = resposta + "01 noite para 02 dia; ";
    	}
    	if((horasNoite02>0) && (horasDia03>0) ) {
    		resposta = resposta + "02 noite para 03 dia; ";
    	}
    	if((horasNoite03>0) && (horasDia04>0) ) {
    		resposta = resposta + "03 noite para 04 dia; ";
    	}
    	if((horasNoite04>0) && (horasDia05>0) ) {
    		resposta = resposta + "04 noite para 05 dia; ";
    	}
    	if((horasNoite05>0) && (horasDia06>0) ) {
    		resposta = resposta + "05 noite para 06 dia; ";
    	}
    	if((horasNoite06>0) && (horasDia07>0) ) {
    		resposta = resposta + "06 noite para 07 dia; ";
    	}
    	if((horasNoite07>0) && (horasDia08>0) ) {
    		resposta = resposta + "07 noite para 08 dia; ";
    	}
    	if((horasNoite08>0) && (horasDia09>0) ) {
    		resposta = resposta + "08 noite para 09 dia; ";
    	}
    	if((horasNoite09>0) && (horasDia10>0) ) {
    		resposta = resposta + "09 noite para 10 dia; ";
    	}
    	if((horasNoite10>0) && (horasDia11>0) ) {
    		resposta = resposta + "10 noite para 11 dia; ";
    	}
    	if((horasNoite11>0) && (horasDia12>0) ) {
    		resposta = resposta + "11 noite para 12 dia; ";
    	}
    	if((horasNoite12>0) && (horasDia13>0) ) {
    		resposta = resposta + "12 noite para 13 dia; ";
    	}
    	if((horasNoite13>0) && (horasDia14>0) ) {
    		resposta = resposta + "13 noite para 14 dia; ";
    	}
    	if((horasNoite14>0) && (horasDia15>0) ) {
    		resposta = resposta + "14 noite para 15 dia; ";
    	}
    	if((horasNoite15>0) && (horasDia16>0) ) {
    		resposta = resposta + "15 noite para 16 dia; ";
    	}
    	if((horasNoite16>0) && (horasDia17>0) ) {
    		resposta = resposta + "16 noite para 17 dia; ";
    	}
    	if((horasNoite17>0) && (horasDia18>0) ) {
    		resposta = resposta + "17 noite para 18 dia; ";
    	}
    	if((horasNoite18>0) && (horasDia19>0) ) {
    		resposta = resposta + "18 noite para 19 dia; ";
    	}
    	if((horasNoite19>0) && (horasDia20>0) ) {
    		resposta = resposta + "19 noite para 20 dia; ";
    	}
    	if((horasNoite20>0) && (horasDia21>0) ) {
    		resposta = resposta + "20 noite para 21 dia; ";
    	}
    	if((horasNoite21>0) && (horasDia22>0) ) {
    		resposta = resposta + "21 noite para 22 dia; ";
    	}
    	if((horasNoite22>0) && (horasDia23>0) ) {
    		resposta = resposta + "22 noite para 23 dia; ";
    	}
    	if((horasNoite23>0) && (horasDia24>0) ) {
    		resposta = resposta + "23 noite para 24 dia; ";
    	}
    	if((horasNoite24>0) && (horasDia25>0) ) {
    		resposta = resposta + "24 noite para 25 dia; ";
    	}
    	if((horasNoite25>0) && (horasDia26>0) ) {
    		resposta = resposta + "25 noite para 26 dia; ";
    	}
    	if((horasNoite26>0) && (horasDia27>0) ) {
    		resposta = resposta + "26 noite para 27 dia; ";
    	}
    	if((horasNoite27>0) && (horasDia28>0) ) {
    		resposta = resposta + "27 noite para 28 dia; ";
    	}
    	if((horasNoite28>0) && (horasDia29>0) ) {
    		resposta = resposta + "28 noite para 29 dia; ";
    	}
    	if((horasNoite29>0) && (horasDia30>0) ) {
    		resposta = resposta + "29 noite para 30 dia; ";
    	}
    	if((horasNoite30>0) && (horasDia31>0) ) {
    		resposta = resposta + "30 noite para 31 dia; ";
    	}
    	
    	
	    if(escala.getHorasTotais()>0) {	
	    	if(resposta.length()>0) {
	    		String escalaSetor = ""; 
	    		for(int i=0; i<lista.size();i++) {
	    			if(lista.get(i).getHorasTotais()>0) {
	    				String novoDado = lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk().getNomeFantasia()+"-"+ lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao()+"-"+lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade()+"-"+lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade()+"["+lista.get(i).getHorasTotais()+"]"+";";
	    				if(!escalaSetor.contains(novoDado)) {
	    					escalaSetor = escalaSetor + novoDado;
	    				}
	    			}
	    		}
	    		resposta = escalaSetor+" "+resposta;
	    		resposta = "Descanso depois do noturno: "+resposta;}
	    }else {resposta = "";}
    	
    	
	    
    	return resposta;
    }
	
	
	
}
