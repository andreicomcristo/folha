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
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.Turmas;
import com.folha.boot.domain.Uf;
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
	
	
	public Page<Escala> findPaginated(int pageNo, int pageSize, CoordenacaoEscala coordenacaoEscala, AnoMes anoMes) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAsc(coordenacaoEscala, anoMes, pageable);
	}
	
	public Page<Escala> findPaginatedNome(int pageNo, int pageSize, CoordenacaoEscala coordenacaoEscala, AnoMes anoMes, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdFuncionarioFkIdPessoaFkNomeContainingOrderByIdFuncionarioFkIdPessoaFkNomeAsc(coordenacaoEscala, anoMes, nome.toUpperCase().trim(), pageable);
	}

	public Page<Escala> findPaginatedTurma(int pageNo, int pageSize, CoordenacaoEscala coordenacaoEscala, AnoMes anoMes, Turmas turmas) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCoordenacaoFkAndIdAnoMesFkAndDtCancelamentoIsNullAndIdTurmaFkOrderByIdFuncionarioFkIdPessoaFkNomeAsc(coordenacaoEscala, anoMes, turmas, pageable);
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
			
			salvar(escalaAMudar);
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
	
	
}
