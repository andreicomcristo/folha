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
import com.folha.boot.domain.EscalaPosTransparencia;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Turmas;
import com.folha.boot.domain.Turnos;
import com.folha.boot.domain.Uf;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;
import com.folha.boot.service.util.UtilidadesMatematicas;

@Service
@Transactional(readOnly = false)
public class EscalaService {

	@Autowired
	private EscalaReposytoty reposytory;
	
	@Autowired
	private PessoaLimiteHorasService pessoaLimiteHorasService;
	@Autowired
	private LimiteHorasAcrescimoPorUnidadeEEspecialidadeService limiteHorasAcrescimoPorUnidadeEEspecialidadeService;
	
	
	
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
	
	public Page<Escala> findPaginatedColaborador(int pageNo, int pageSize, Pessoa pessoa, AnoMes anoMes) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdFuncionarioFkIdPessoaFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkNomeAsc(pessoa, anoMes, pageable);
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
			escalaAMudar.setHorasA(escala.getHorasA());
			escalaAMudar.setHorasB(escala.getHorasB());
			escalaAMudar.setHorasC(escala.getHorasC());
			
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
    		if(String.valueOf(lista.get(i).getId()).equalsIgnoreCase( String.valueOf(escala.getId())) ) {lista.remove(i); i=i-1;}
    	}
    	
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
    			if(escala.getDia01Fk().getHorasNoite()>0  && ( lista.get(i).getDia01Fk().getHorasNoite() + lista.get(i).getDia01Fk().getHorasA() + lista.get(i).getDia01Fk().getHorasB()+ lista.get(i).getDia01Fk().getHorasC() )>0 ) {
    				respostaInterna = respostaInterna+"1 noite;";
	    		}
    			
    			//Dia 02
    			if((escala.getDia02Fk().getHorasManha()>0)  && (lista.get(i).getDia02Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"2 manha;";
	    		}
    			if(escala.getDia02Fk().getHorasTarde()>0  && lista.get(i).getDia02Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"2 tarde;";
	    		}
    			if(escala.getDia02Fk().getHorasNoite()>0  && ( lista.get(i).getDia02Fk().getHorasNoite() + lista.get(i).getDia02Fk().getHorasA() + lista.get(i).getDia02Fk().getHorasB()+ lista.get(i).getDia02Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"2 noite;";
	    		}
    			
    			//Dia 03
    			if((escala.getDia03Fk().getHorasManha()>0)  && (lista.get(i).getDia03Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"3 manha;";
	    		}
    			if(escala.getDia03Fk().getHorasTarde()>0  && lista.get(i).getDia03Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"3 tarde;";
	    		}
    			if(escala.getDia03Fk().getHorasNoite()>0  && ( lista.get(i).getDia03Fk().getHorasNoite() + lista.get(i).getDia03Fk().getHorasA() + lista.get(i).getDia03Fk().getHorasB()+ lista.get(i).getDia03Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"3 noite;";
	    		}
    			
    			//Dia 04
    			if((escala.getDia04Fk().getHorasManha()>0)  && (lista.get(i).getDia04Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"4 manha;";
	    		}
    			if(escala.getDia04Fk().getHorasTarde()>0  && lista.get(i).getDia04Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"4 tarde;";
	    		}
    			if(escala.getDia04Fk().getHorasNoite()>0  && ( lista.get(i).getDia04Fk().getHorasNoite() + lista.get(i).getDia04Fk().getHorasA() + lista.get(i).getDia04Fk().getHorasB()+ lista.get(i).getDia04Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"4 noite;";
	    		}
    			
    			//Dia 05
    			if((escala.getDia05Fk().getHorasManha()>0)  && (lista.get(i).getDia05Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"5 manha;";
	    		}
    			if(escala.getDia05Fk().getHorasTarde()>0  && lista.get(i).getDia05Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"5 tarde;";
	    		}
    			if(escala.getDia05Fk().getHorasNoite()>0  && ( lista.get(i).getDia05Fk().getHorasNoite() + lista.get(i).getDia05Fk().getHorasA() + lista.get(i).getDia05Fk().getHorasB()+ lista.get(i).getDia05Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"5 noite;";
	    		}
    			
    			//Dia 06
    			if((escala.getDia06Fk().getHorasManha()>0)  && (lista.get(i).getDia06Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"6 manha;";
	    		}
    			if(escala.getDia06Fk().getHorasTarde()>0  && lista.get(i).getDia06Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"6 tarde;";
	    		}
    			if(escala.getDia06Fk().getHorasNoite()>0  && ( lista.get(i).getDia06Fk().getHorasNoite() + lista.get(i).getDia06Fk().getHorasA() + lista.get(i).getDia06Fk().getHorasB()+ lista.get(i).getDia06Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"6 noite;";
	    		}
    			
    			//Dia 07
    			if((escala.getDia07Fk().getHorasManha()>0)  && (lista.get(i).getDia07Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"7 manha;";
	    		}
    			if(escala.getDia07Fk().getHorasTarde()>0  && lista.get(i).getDia07Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"7 tarde;";
	    		}
    			if(escala.getDia07Fk().getHorasNoite()>0  && ( lista.get(i).getDia07Fk().getHorasNoite() + lista.get(i).getDia07Fk().getHorasA() + lista.get(i).getDia07Fk().getHorasB()+ lista.get(i).getDia07Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"7 noite;";
	    		}
    			
    			//Dia 08
    			if((escala.getDia08Fk().getHorasManha()>0)  && (lista.get(i).getDia08Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"8 manha;";
	    		}
    			if(escala.getDia08Fk().getHorasTarde()>0  && lista.get(i).getDia08Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"8 tarde;";
	    		}
    			if(escala.getDia08Fk().getHorasNoite()>0  && ( lista.get(i).getDia08Fk().getHorasNoite() + lista.get(i).getDia08Fk().getHorasA() + lista.get(i).getDia08Fk().getHorasB()+ lista.get(i).getDia08Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"8 noite;";
	    		}
    			
    			//Dia 09
    			if((escala.getDia09Fk().getHorasManha()>0)  && (lista.get(i).getDia09Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"9 manha;";
	    		}
    			if(escala.getDia09Fk().getHorasTarde()>0  && lista.get(i).getDia09Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"9 tarde;";
	    		}
    			if(escala.getDia09Fk().getHorasNoite()>0  && ( lista.get(i).getDia09Fk().getHorasNoite() + lista.get(i).getDia09Fk().getHorasA() + lista.get(i).getDia09Fk().getHorasB()+ lista.get(i).getDia09Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"9 noite;";
	    		}
    			
    			//Dia 10
    			if((escala.getDia10Fk().getHorasManha()>0)  && (lista.get(i).getDia10Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"10 manha;";
	    		}
    			if(escala.getDia10Fk().getHorasTarde()>0  && lista.get(i).getDia10Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"10 tarde;";
	    		}
    			if(escala.getDia10Fk().getHorasNoite()>0  && ( lista.get(i).getDia10Fk().getHorasNoite() + lista.get(i).getDia10Fk().getHorasA() + lista.get(i).getDia10Fk().getHorasB()+ lista.get(i).getDia10Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"10 noite;";
	    		}
    			
    			//Dia 11
    			if((escala.getDia11Fk().getHorasManha()>0)  && (lista.get(i).getDia11Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"11 manha;";
	    		}
    			if(escala.getDia11Fk().getHorasTarde()>0  && lista.get(i).getDia11Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"11 tarde;";
	    		}
    			if(escala.getDia11Fk().getHorasNoite()>0  && ( lista.get(i).getDia11Fk().getHorasNoite() + lista.get(i).getDia11Fk().getHorasA() + lista.get(i).getDia11Fk().getHorasB()+ lista.get(i).getDia11Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"11 noite;";
	    		}
    			
    			//Dia 12
    			if((escala.getDia12Fk().getHorasManha()>0)  && (lista.get(i).getDia12Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"12 manha;";
	    		}
    			if(escala.getDia12Fk().getHorasTarde()>0  && lista.get(i).getDia12Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"12 tarde;";
	    		}
    			if(escala.getDia12Fk().getHorasNoite()>0  && ( lista.get(i).getDia12Fk().getHorasNoite() + lista.get(i).getDia12Fk().getHorasA() + lista.get(i).getDia12Fk().getHorasB()+ lista.get(i).getDia12Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"12 noite;";
	    		}
    			
    			//Dia 13
    			if((escala.getDia13Fk().getHorasManha()>0)  && (lista.get(i).getDia13Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"13 manha;";
	    		}
    			if(escala.getDia13Fk().getHorasTarde()>0  && lista.get(i).getDia13Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"13 tarde;";
	    		}
    			if(escala.getDia13Fk().getHorasNoite()>0  && ( lista.get(i).getDia13Fk().getHorasNoite() + lista.get(i).getDia13Fk().getHorasA() + lista.get(i).getDia13Fk().getHorasB()+ lista.get(i).getDia13Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"13 noite;";
	    		}
    			
    			//Dia 14
    			if((escala.getDia14Fk().getHorasManha()>0)  && (lista.get(i).getDia14Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"14 manha;";
	    		}
    			if(escala.getDia14Fk().getHorasTarde()>0  && lista.get(i).getDia14Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"14 tarde;";
	    		}
    			if(escala.getDia14Fk().getHorasNoite()>0  && ( lista.get(i).getDia14Fk().getHorasNoite() + lista.get(i).getDia14Fk().getHorasA() + lista.get(i).getDia14Fk().getHorasB()+ lista.get(i).getDia14Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"14 noite;";
	    		}
    			
    			//Dia 15
    			if((escala.getDia15Fk().getHorasManha()>0)  && (lista.get(i).getDia15Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"15 manha;";
	    		}
    			if(escala.getDia15Fk().getHorasTarde()>0  && lista.get(i).getDia15Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"15 tarde;";
	    		}
    			if(escala.getDia15Fk().getHorasNoite()>0  && ( lista.get(i).getDia15Fk().getHorasNoite() + lista.get(i).getDia15Fk().getHorasA() + lista.get(i).getDia15Fk().getHorasB()+ lista.get(i).getDia15Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"15 noite;";
	    		}
    			
    			//Dia 16
    			if((escala.getDia16Fk().getHorasManha()>0)  && (lista.get(i).getDia16Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"16 manha;";
	    		}
    			if(escala.getDia16Fk().getHorasTarde()>0  && lista.get(i).getDia16Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"16 tarde;";
	    		}
    			if(escala.getDia16Fk().getHorasNoite()>0  && ( lista.get(i).getDia16Fk().getHorasNoite() + lista.get(i).getDia16Fk().getHorasA() + lista.get(i).getDia16Fk().getHorasB()+ lista.get(i).getDia16Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"16 noite;";
	    		}
    			
    			//Dia 17
    			if((escala.getDia17Fk().getHorasManha()>0)  && (lista.get(i).getDia17Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"17 manha;";
	    		}
    			if(escala.getDia17Fk().getHorasTarde()>0  && lista.get(i).getDia17Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"17 tarde;";
	    		}
    			if(escala.getDia17Fk().getHorasNoite()>0  && ( lista.get(i).getDia17Fk().getHorasNoite() + lista.get(i).getDia17Fk().getHorasA() + lista.get(i).getDia17Fk().getHorasB()+ lista.get(i).getDia17Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"17 noite;";
	    		}
    			
    			//Dia 18
    			if((escala.getDia18Fk().getHorasManha()>0)  && (lista.get(i).getDia18Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"18 manha;";
	    		}
    			if(escala.getDia18Fk().getHorasTarde()>0  && lista.get(i).getDia18Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"18 tarde;";
	    		}
    			if(escala.getDia18Fk().getHorasNoite()>0  && ( lista.get(i).getDia18Fk().getHorasNoite() + lista.get(i).getDia18Fk().getHorasA() + lista.get(i).getDia18Fk().getHorasB()+ lista.get(i).getDia18Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"18 noite;";
	    		}
    			
    			//Dia 19
    			if((escala.getDia19Fk().getHorasManha()>0)  && (lista.get(i).getDia19Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"19 manha;";
	    		}
    			if(escala.getDia19Fk().getHorasTarde()>0  && lista.get(i).getDia19Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"19 tarde;";
	    		}
    			if(escala.getDia19Fk().getHorasNoite()>0  && ( lista.get(i).getDia19Fk().getHorasNoite() + lista.get(i).getDia19Fk().getHorasA() + lista.get(i).getDia19Fk().getHorasB()+ lista.get(i).getDia19Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"19 noite;";
	    		}
    			
    			//Dia 20
    			if((escala.getDia20Fk().getHorasManha()>0)  && (lista.get(i).getDia20Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"20 manha;";
	    		}
    			if(escala.getDia20Fk().getHorasTarde()>0  && lista.get(i).getDia20Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"20 tarde;";
	    		}
    			if(escala.getDia20Fk().getHorasNoite()>0  && ( lista.get(i).getDia20Fk().getHorasNoite() + lista.get(i).getDia20Fk().getHorasA() + lista.get(i).getDia20Fk().getHorasB()+ lista.get(i).getDia20Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"20 noite;";
	    		}
    			
    			//Dia 21
    			if((escala.getDia21Fk().getHorasManha()>0)  && (lista.get(i).getDia21Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"21 manha;";
	    		}
    			if(escala.getDia21Fk().getHorasTarde()>0  && lista.get(i).getDia21Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"21 tarde;";
	    		}
    			if(escala.getDia21Fk().getHorasNoite()>0  && ( lista.get(i).getDia21Fk().getHorasNoite() + lista.get(i).getDia21Fk().getHorasA() + lista.get(i).getDia21Fk().getHorasB()+ lista.get(i).getDia21Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"21 noite;";
	    		}
    			
    			//Dia 22
    			if((escala.getDia22Fk().getHorasManha()>0)  && (lista.get(i).getDia22Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"22 manha;";
	    		}
    			if(escala.getDia22Fk().getHorasTarde()>0  && lista.get(i).getDia22Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"22 tarde;";
	    		}
    			if(escala.getDia22Fk().getHorasNoite()>0  && ( lista.get(i).getDia22Fk().getHorasNoite() + lista.get(i).getDia22Fk().getHorasA() + lista.get(i).getDia22Fk().getHorasB()+ lista.get(i).getDia22Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"22 noite;";
	    		}
    			
    			//Dia 23
    			if((escala.getDia23Fk().getHorasManha()>0)  && (lista.get(i).getDia23Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"23 manha;";
	    		}
    			if(escala.getDia23Fk().getHorasTarde()>0  && lista.get(i).getDia23Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"23 tarde;";
	    		}
    			if(escala.getDia23Fk().getHorasNoite()>0  && ( lista.get(i).getDia23Fk().getHorasNoite() + lista.get(i).getDia23Fk().getHorasA() + lista.get(i).getDia23Fk().getHorasB()+ lista.get(i).getDia23Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"23 noite;";
	    		}
    			
    			//Dia 24
    			if((escala.getDia24Fk().getHorasManha()>0)  && (lista.get(i).getDia24Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"24 manha;";
	    		}
    			if(escala.getDia24Fk().getHorasTarde()>0  && lista.get(i).getDia24Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"24 tarde;";
	    		}
    			if(escala.getDia24Fk().getHorasNoite()>0  && ( lista.get(i).getDia24Fk().getHorasNoite() + lista.get(i).getDia24Fk().getHorasA() + lista.get(i).getDia24Fk().getHorasB()+ lista.get(i).getDia24Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"24 noite;";
	    		}
    			
    			//Dia 25
    			if((escala.getDia25Fk().getHorasManha()>0)  && (lista.get(i).getDia25Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"25 manha;";
	    		}
    			if(escala.getDia25Fk().getHorasTarde()>0  && lista.get(i).getDia25Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"25 tarde;";
	    		}
    			if(escala.getDia25Fk().getHorasNoite()>0  && ( lista.get(i).getDia25Fk().getHorasNoite() + lista.get(i).getDia25Fk().getHorasA() + lista.get(i).getDia25Fk().getHorasB()+ lista.get(i).getDia25Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"25 noite;";
	    		}
    			
    			//Dia 26
    			if((escala.getDia26Fk().getHorasManha()>0)  && (lista.get(i).getDia26Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"26 manha;";
	    		}
    			if(escala.getDia26Fk().getHorasTarde()>0  && lista.get(i).getDia26Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"26 tarde;";
	    		}
    			if(escala.getDia26Fk().getHorasNoite()>0  && ( lista.get(i).getDia26Fk().getHorasNoite() + lista.get(i).getDia26Fk().getHorasA() + lista.get(i).getDia26Fk().getHorasB()+ lista.get(i).getDia26Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"26 noite;";
	    		}
    			
    			//Dia 27
    			if((escala.getDia27Fk().getHorasManha()>0)  && (lista.get(i).getDia27Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"27 manha;";
	    		}
    			if(escala.getDia27Fk().getHorasTarde()>0  && lista.get(i).getDia27Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"27 tarde;";
	    		}
    			if(escala.getDia27Fk().getHorasNoite()>0  && ( lista.get(i).getDia27Fk().getHorasNoite() + lista.get(i).getDia27Fk().getHorasA() + lista.get(i).getDia27Fk().getHorasB()+ lista.get(i).getDia27Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"27 noite;";
	    		}
    			
    			//Dia 28
    			if((escala.getDia28Fk().getHorasManha()>0)  && (lista.get(i).getDia28Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"28 manha;";
	    		}
    			if(escala.getDia28Fk().getHorasTarde()>0  && lista.get(i).getDia28Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"28 tarde;";
	    		}
    			if(escala.getDia28Fk().getHorasNoite()>0  && ( lista.get(i).getDia28Fk().getHorasNoite() + lista.get(i).getDia28Fk().getHorasA() + lista.get(i).getDia28Fk().getHorasB()+ lista.get(i).getDia28Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"28 noite;";
	    		}
    			
    			//Dia 29
    			if((escala.getDia29Fk().getHorasManha()>0)  && (lista.get(i).getDia29Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"29 manha;";
	    		}
    			if(escala.getDia29Fk().getHorasTarde()>0  && lista.get(i).getDia29Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"29 tarde;";
	    		}
    			if(escala.getDia29Fk().getHorasNoite()>0  && ( lista.get(i).getDia29Fk().getHorasNoite() + lista.get(i).getDia29Fk().getHorasA() + lista.get(i).getDia29Fk().getHorasB()+ lista.get(i).getDia29Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"29 noite;";
	    		}
    			
    			//Dia 30
    			if((escala.getDia30Fk().getHorasManha()>0)  && (lista.get(i).getDia30Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"30 manha;";
	    		}
    			if(escala.getDia30Fk().getHorasTarde()>0  && lista.get(i).getDia30Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"30 tarde;";
	    		}
    			if(escala.getDia30Fk().getHorasNoite()>0  && ( lista.get(i).getDia30Fk().getHorasNoite() + lista.get(i).getDia30Fk().getHorasA() + lista.get(i).getDia30Fk().getHorasB()+ lista.get(i).getDia30Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"30 noite;";
	    		}
    			
    			//Dia 31
    			if((escala.getDia31Fk().getHorasManha()>0)  && (lista.get(i).getDia31Fk().getHorasManha()>0) ) {
    				respostaInterna = respostaInterna+"31 manha;";
	    		}
    			if(escala.getDia31Fk().getHorasTarde()>0  && lista.get(i).getDia31Fk().getHorasTarde()>0 ) {
    				respostaInterna = respostaInterna+"31 tarde;";
	    		}
    			if(escala.getDia31Fk().getHorasNoite()>0  && ( lista.get(i).getDia31Fk().getHorasNoite() + lista.get(i).getDia31Fk().getHorasA() + lista.get(i).getDia31Fk().getHorasB()+ lista.get(i).getDia31Fk().getHorasC() ) >0 ) {
    				respostaInterna = respostaInterna+"31 noite;";
	    		}
    			
    			if(respostaInterna.length()>0) {respostaInterna = lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk().getNomeFantasia()+"-"+lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao()+"-"+lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade()+"-"+lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade()+" "+respostaInterna;}
    			
    			if(respostaInterna.length()>0) {resposta = resposta+respostaInterna;}    			
    		}
    	}
    	
    	if(resposta.length()>0) {resposta = "Choque: "+resposta;}
    	
    	resposta = resposta + excedeLimiteDeHoras(escala);
    	
    	return resposta;
    }
	
	public String choquesEmEscalaDepoisDoNoturno(Escala escala) {
    	String resposta = "";
    	List<Escala> lista = buscarPorPessoaEAnoMes(escala.getIdFuncionarioFk().getIdPessoaFk(), escala.getIdAnoMesFk());
    	
    	for(int i=0;i<lista.size();i++) {
    		if(String.valueOf(lista.get(i).getId()).equalsIgnoreCase( String.valueOf(escala.getId())) ) {lista.remove(i); i=i-1;}
    	}
    	
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
    		horasNoite01 = horasNoite01 + lista.get(i).getDia01Fk().getHorasNoite() + lista.get(i).getDia01Fk().getHorasA() + lista.get(i).getDia01Fk().getHorasB() + lista.get(i).getDia01Fk().getHorasC() ;
    		
    		horasDia02   = horasDia02   + lista.get(i).getDia02Fk().getHorasManha() + lista.get(i).getDia02Fk().getHorasTarde();
    		horasNoite02 = horasNoite02 + lista.get(i).getDia02Fk().getHorasNoite() + lista.get(i).getDia02Fk().getHorasA() + lista.get(i).getDia02Fk().getHorasB() + lista.get(i).getDia02Fk().getHorasC() ;
    		
    		horasDia03   = horasDia03   + lista.get(i).getDia03Fk().getHorasManha() + lista.get(i).getDia03Fk().getHorasTarde();
    		horasNoite03 = horasNoite03 + lista.get(i).getDia03Fk().getHorasNoite() + lista.get(i).getDia03Fk().getHorasA() + lista.get(i).getDia03Fk().getHorasB() + lista.get(i).getDia03Fk().getHorasC() ;
    		
    		horasDia04   = horasDia04   + lista.get(i).getDia04Fk().getHorasManha() + lista.get(i).getDia04Fk().getHorasTarde();
    		horasNoite04 = horasNoite04 + lista.get(i).getDia04Fk().getHorasNoite() + lista.get(i).getDia04Fk().getHorasA() + lista.get(i).getDia04Fk().getHorasB() + lista.get(i).getDia04Fk().getHorasC() ;
    		
    		horasDia05   = horasDia05   + lista.get(i).getDia05Fk().getHorasManha() + lista.get(i).getDia05Fk().getHorasTarde();
    		horasNoite05 = horasNoite05 + lista.get(i).getDia05Fk().getHorasNoite() + lista.get(i).getDia05Fk().getHorasA() + lista.get(i).getDia05Fk().getHorasB() + lista.get(i).getDia05Fk().getHorasC() ;
    		
    		horasDia06   = horasDia06   + lista.get(i).getDia06Fk().getHorasManha() + lista.get(i).getDia06Fk().getHorasTarde();
    		horasNoite06 = horasNoite06 + lista.get(i).getDia06Fk().getHorasNoite() + lista.get(i).getDia06Fk().getHorasA() + lista.get(i).getDia06Fk().getHorasB() + lista.get(i).getDia06Fk().getHorasC() ;
    		
    		horasDia07   = horasDia07   + lista.get(i).getDia07Fk().getHorasManha() + lista.get(i).getDia07Fk().getHorasTarde();
    		horasNoite07 = horasNoite07 + lista.get(i).getDia07Fk().getHorasNoite() + lista.get(i).getDia07Fk().getHorasA() + lista.get(i).getDia07Fk().getHorasB() + lista.get(i).getDia07Fk().getHorasC() ;
    		
    		horasDia08   = horasDia08   + lista.get(i).getDia08Fk().getHorasManha() + lista.get(i).getDia08Fk().getHorasTarde();
    		horasNoite08 = horasNoite08 + lista.get(i).getDia08Fk().getHorasNoite() + lista.get(i).getDia08Fk().getHorasA() + lista.get(i).getDia08Fk().getHorasB() + lista.get(i).getDia08Fk().getHorasC() ;
    		
    		horasDia09   = horasDia09   + lista.get(i).getDia09Fk().getHorasManha() + lista.get(i).getDia09Fk().getHorasTarde();
    		horasNoite09 = horasNoite09 + lista.get(i).getDia09Fk().getHorasNoite() + lista.get(i).getDia09Fk().getHorasA() + lista.get(i).getDia09Fk().getHorasB() + lista.get(i).getDia09Fk().getHorasC() ;
    		
    		horasDia10   = horasDia10   + lista.get(i).getDia10Fk().getHorasManha() + lista.get(i).getDia10Fk().getHorasTarde();
    		horasNoite10 = horasNoite10 + lista.get(i).getDia10Fk().getHorasNoite() + lista.get(i).getDia10Fk().getHorasA() + lista.get(i).getDia10Fk().getHorasB() + lista.get(i).getDia10Fk().getHorasC() ;
    		
    		horasDia11   = horasDia11   + lista.get(i).getDia11Fk().getHorasManha() + lista.get(i).getDia11Fk().getHorasTarde();
    		horasNoite11 = horasNoite11 + lista.get(i).getDia11Fk().getHorasNoite() + lista.get(i).getDia11Fk().getHorasA() + lista.get(i).getDia11Fk().getHorasB() + lista.get(i).getDia11Fk().getHorasC() ;
    		
    		horasDia12   = horasDia12   + lista.get(i).getDia12Fk().getHorasManha() + lista.get(i).getDia12Fk().getHorasTarde();
    		horasNoite12 = horasNoite12 + lista.get(i).getDia12Fk().getHorasNoite() + lista.get(i).getDia12Fk().getHorasA() + lista.get(i).getDia12Fk().getHorasB() + lista.get(i).getDia12Fk().getHorasC() ;
    		
    		horasDia13   = horasDia13   + lista.get(i).getDia13Fk().getHorasManha() + lista.get(i).getDia13Fk().getHorasTarde();
    		horasNoite13 = horasNoite13 + lista.get(i).getDia13Fk().getHorasNoite() + lista.get(i).getDia13Fk().getHorasA() + lista.get(i).getDia13Fk().getHorasB() + lista.get(i).getDia13Fk().getHorasC() ;
    		
    		horasDia14   = horasDia14   + lista.get(i).getDia14Fk().getHorasManha() + lista.get(i).getDia14Fk().getHorasTarde();
    		horasNoite14 = horasNoite14 + lista.get(i).getDia14Fk().getHorasNoite() + lista.get(i).getDia14Fk().getHorasA() + lista.get(i).getDia14Fk().getHorasB() + lista.get(i).getDia14Fk().getHorasC() ;
    		
    		horasDia15   = horasDia15   + lista.get(i).getDia15Fk().getHorasManha() + lista.get(i).getDia15Fk().getHorasTarde();
    		horasNoite15 = horasNoite15 + lista.get(i).getDia15Fk().getHorasNoite() + lista.get(i).getDia15Fk().getHorasA() + lista.get(i).getDia15Fk().getHorasB() + lista.get(i).getDia15Fk().getHorasC() ;
    		
    		horasDia16   = horasDia16   + lista.get(i).getDia16Fk().getHorasManha() + lista.get(i).getDia16Fk().getHorasTarde();
    		horasNoite16 = horasNoite16 + lista.get(i).getDia16Fk().getHorasNoite() + lista.get(i).getDia16Fk().getHorasA() + lista.get(i).getDia16Fk().getHorasB() + lista.get(i).getDia16Fk().getHorasC() ;
    		
    		horasDia17   = horasDia17   + lista.get(i).getDia17Fk().getHorasManha() + lista.get(i).getDia17Fk().getHorasTarde();
    		horasNoite17 = horasNoite17 + lista.get(i).getDia17Fk().getHorasNoite() + lista.get(i).getDia17Fk().getHorasA() + lista.get(i).getDia17Fk().getHorasB() + lista.get(i).getDia17Fk().getHorasC() ;
    		
    		horasDia18   = horasDia17   + lista.get(i).getDia18Fk().getHorasManha() + lista.get(i).getDia18Fk().getHorasTarde();
    		horasNoite18 = horasNoite18 + lista.get(i).getDia18Fk().getHorasNoite() + lista.get(i).getDia18Fk().getHorasA() + lista.get(i).getDia18Fk().getHorasB() + lista.get(i).getDia18Fk().getHorasC() ;
    		
    		horasDia19   = horasDia19   + lista.get(i).getDia19Fk().getHorasManha() + lista.get(i).getDia19Fk().getHorasTarde();
    		horasNoite19 = horasNoite19 + lista.get(i).getDia19Fk().getHorasNoite() + lista.get(i).getDia19Fk().getHorasA() + lista.get(i).getDia19Fk().getHorasB() + lista.get(i).getDia19Fk().getHorasC() ;
    		
    		horasDia20   = horasDia20   + lista.get(i).getDia20Fk().getHorasManha() + lista.get(i).getDia20Fk().getHorasTarde();
    		horasNoite20 = horasNoite20 + lista.get(i).getDia20Fk().getHorasNoite() + lista.get(i).getDia20Fk().getHorasA() + lista.get(i).getDia20Fk().getHorasB() + lista.get(i).getDia20Fk().getHorasC() ;
    		
    		horasDia21   = horasDia21   + lista.get(i).getDia21Fk().getHorasManha() + lista.get(i).getDia21Fk().getHorasTarde();
    		horasNoite21 = horasNoite21 + lista.get(i).getDia21Fk().getHorasNoite() + lista.get(i).getDia21Fk().getHorasA() + lista.get(i).getDia21Fk().getHorasB() + lista.get(i).getDia21Fk().getHorasC() ;
    		
    		horasDia22   = horasDia22   + lista.get(i).getDia22Fk().getHorasManha() + lista.get(i).getDia22Fk().getHorasTarde();
    		horasNoite22 = horasNoite22 + lista.get(i).getDia22Fk().getHorasNoite() + lista.get(i).getDia22Fk().getHorasA() + lista.get(i).getDia22Fk().getHorasB() + lista.get(i).getDia22Fk().getHorasC() ;
    		
    		horasDia23   = horasDia23   + lista.get(i).getDia23Fk().getHorasManha() + lista.get(i).getDia23Fk().getHorasTarde();
    		horasNoite23 = horasNoite23 + lista.get(i).getDia23Fk().getHorasNoite() + lista.get(i).getDia23Fk().getHorasA() + lista.get(i).getDia23Fk().getHorasB() + lista.get(i).getDia23Fk().getHorasC() ;
    		
    		horasDia24   = horasDia24   + lista.get(i).getDia24Fk().getHorasManha() + lista.get(i).getDia24Fk().getHorasTarde();
    		horasNoite24 = horasNoite24 + lista.get(i).getDia24Fk().getHorasNoite() + lista.get(i).getDia24Fk().getHorasA() + lista.get(i).getDia24Fk().getHorasB() + lista.get(i).getDia24Fk().getHorasC() ;
    		
    		horasDia25   = horasDia25   + lista.get(i).getDia25Fk().getHorasManha() + lista.get(i).getDia25Fk().getHorasTarde();
    		horasNoite25 = horasNoite25 + lista.get(i).getDia25Fk().getHorasNoite() + lista.get(i).getDia25Fk().getHorasA() + lista.get(i).getDia25Fk().getHorasB() + lista.get(i).getDia25Fk().getHorasC() ;
    		
    		horasDia26   = horasDia26   + lista.get(i).getDia26Fk().getHorasManha() + lista.get(i).getDia26Fk().getHorasTarde();
    		horasNoite26 = horasNoite26 + lista.get(i).getDia26Fk().getHorasNoite() + lista.get(i).getDia26Fk().getHorasA() + lista.get(i).getDia26Fk().getHorasB() + lista.get(i).getDia26Fk().getHorasC() ;
    		
    		horasDia27   = horasDia27   + lista.get(i).getDia27Fk().getHorasManha() + lista.get(i).getDia27Fk().getHorasTarde();
    		horasNoite27 = horasNoite27 + lista.get(i).getDia27Fk().getHorasNoite() + lista.get(i).getDia27Fk().getHorasA() + lista.get(i).getDia27Fk().getHorasB() + lista.get(i).getDia27Fk().getHorasC() ;
    		
    		horasDia28   = horasDia28   + lista.get(i).getDia28Fk().getHorasManha() + lista.get(i).getDia28Fk().getHorasTarde();
    		horasNoite28 = horasNoite28 + lista.get(i).getDia28Fk().getHorasNoite() + lista.get(i).getDia28Fk().getHorasA() + lista.get(i).getDia28Fk().getHorasB() + lista.get(i).getDia28Fk().getHorasC() ;
    		
    		horasDia29   = horasDia29   + lista.get(i).getDia29Fk().getHorasManha() + lista.get(i).getDia29Fk().getHorasTarde();
    		horasNoite29 = horasNoite29 + lista.get(i).getDia29Fk().getHorasNoite() + lista.get(i).getDia29Fk().getHorasA() + lista.get(i).getDia29Fk().getHorasB() + lista.get(i).getDia29Fk().getHorasC() ;
    		
    		horasDia30   = horasDia30   + lista.get(i).getDia30Fk().getHorasManha() + lista.get(i).getDia30Fk().getHorasTarde();
    		horasNoite30 = horasNoite30 + lista.get(i).getDia30Fk().getHorasNoite() + lista.get(i).getDia30Fk().getHorasA() + lista.get(i).getDia30Fk().getHorasB() + lista.get(i).getDia30Fk().getHorasC() ;
    		
    		horasDia31   = horasDia31   + lista.get(i).getDia31Fk().getHorasManha() + lista.get(i).getDia31Fk().getHorasTarde();
    		horasNoite31 = horasNoite31 + lista.get(i).getDia31Fk().getHorasNoite() + lista.get(i).getDia31Fk().getHorasA() + lista.get(i).getDia31Fk().getHorasB() + lista.get(i).getDia31Fk().getHorasC() ;
    		
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
	
	
	
	public Escala converteDeEscalaParaEscala(Escala escala) {
		Escala escalaNova = new Escala();
	
		Turnos t01 = new Turnos();
		t01.setDescricaoTurno(escala.getDia01Fk().getDescricaoTurno());
		t01.setHorasManha(escala.getDia01Fk().getHorasManha());
		t01.setHorasNoite(escala.getDia01Fk().getHorasNoite());
		t01.setHorasA(escala.getDia01Fk().getHorasA());
		t01.setHorasB(escala.getDia01Fk().getHorasB());
		t01.setHorasC(escala.getDia01Fk().getHorasC());
		t01.setHorasTarde(escala.getDia01Fk().getHorasTarde());
		t01.setId(escala.getDia01Fk().getId());
		t01.setNomeTurno(escala.getDia01Fk().getNomeTurno());
		t01.setPlantoes(escala.getDia01Fk().getPlantoes());
		escalaNova.setDia01Fk(t01);
		
		Turnos t02 = new Turnos();
		t02.setDescricaoTurno(escala.getDia02Fk().getDescricaoTurno());
		t02.setHorasManha(escala.getDia02Fk().getHorasManha());
		t02.setHorasNoite(escala.getDia02Fk().getHorasNoite());
		t02.setHorasA(escala.getDia02Fk().getHorasA());
		t02.setHorasB(escala.getDia02Fk().getHorasB());
		t02.setHorasC(escala.getDia02Fk().getHorasC());
		t02.setHorasTarde(escala.getDia02Fk().getHorasTarde());
		t02.setId(escala.getDia02Fk().getId());
		t02.setNomeTurno(escala.getDia02Fk().getNomeTurno());
		t02.setPlantoes(escala.getDia02Fk().getPlantoes());
		escalaNova.setDia02Fk(t02);
		
		Turnos t03 = new Turnos();
		t03.setDescricaoTurno(escala.getDia03Fk().getDescricaoTurno());
		t03.setHorasManha(escala.getDia03Fk().getHorasManha());
		t03.setHorasNoite(escala.getDia03Fk().getHorasNoite());
		t03.setHorasA(escala.getDia03Fk().getHorasA());
		t03.setHorasB(escala.getDia03Fk().getHorasB());
		t03.setHorasC(escala.getDia03Fk().getHorasC());
		t03.setHorasTarde(escala.getDia03Fk().getHorasTarde());
		t03.setId(escala.getDia03Fk().getId());
		t03.setNomeTurno(escala.getDia03Fk().getNomeTurno());
		t03.setPlantoes(escala.getDia03Fk().getPlantoes());
		escalaNova.setDia03Fk(t03);
		
		Turnos t04 = new Turnos();
		t04.setDescricaoTurno(escala.getDia04Fk().getDescricaoTurno());
		t04.setHorasManha(escala.getDia04Fk().getHorasManha());
		t04.setHorasNoite(escala.getDia04Fk().getHorasNoite());
		t04.setHorasA(escala.getDia04Fk().getHorasA());
		t04.setHorasB(escala.getDia04Fk().getHorasB());
		t04.setHorasC(escala.getDia04Fk().getHorasC());
		t04.setHorasTarde(escala.getDia04Fk().getHorasTarde());
		t04.setId(escala.getDia04Fk().getId());
		t04.setNomeTurno(escala.getDia04Fk().getNomeTurno());
		t04.setPlantoes(escala.getDia04Fk().getPlantoes());
		escalaNova.setDia04Fk(t04);
		
		Turnos t05 = new Turnos();
		t05.setDescricaoTurno(escala.getDia05Fk().getDescricaoTurno());
		t05.setHorasManha(escala.getDia05Fk().getHorasManha());
		t05.setHorasNoite(escala.getDia05Fk().getHorasNoite());
		t05.setHorasA(escala.getDia05Fk().getHorasA());
		t05.setHorasB(escala.getDia05Fk().getHorasB());
		t05.setHorasC(escala.getDia05Fk().getHorasC());
		t05.setHorasTarde(escala.getDia05Fk().getHorasTarde());
		t05.setId(escala.getDia05Fk().getId());
		t05.setNomeTurno(escala.getDia05Fk().getNomeTurno());
		t05.setPlantoes(escala.getDia05Fk().getPlantoes());
		escalaNova.setDia05Fk(t05);
		
		Turnos t06 = new Turnos();
		t06.setDescricaoTurno(escala.getDia06Fk().getDescricaoTurno());
		t06.setHorasManha(escala.getDia06Fk().getHorasManha());
		t06.setHorasNoite(escala.getDia06Fk().getHorasNoite());
		t06.setHorasA(escala.getDia06Fk().getHorasA());
		t06.setHorasB(escala.getDia06Fk().getHorasB());
		t06.setHorasC(escala.getDia06Fk().getHorasC());
		t06.setHorasTarde(escala.getDia06Fk().getHorasTarde());
		t06.setId(escala.getDia06Fk().getId());
		t06.setNomeTurno(escala.getDia06Fk().getNomeTurno());
		t06.setPlantoes(escala.getDia06Fk().getPlantoes());
		escalaNova.setDia06Fk(t06);
		
		Turnos t07 = new Turnos();
		t07.setDescricaoTurno(escala.getDia07Fk().getDescricaoTurno());
		t07.setHorasManha(escala.getDia07Fk().getHorasManha());
		t07.setHorasNoite(escala.getDia07Fk().getHorasNoite());
		t07.setHorasA(escala.getDia07Fk().getHorasA());
		t07.setHorasB(escala.getDia07Fk().getHorasB());
		t07.setHorasC(escala.getDia07Fk().getHorasC());
		t07.setHorasTarde(escala.getDia07Fk().getHorasTarde());
		t07.setId(escala.getDia07Fk().getId());
		t07.setNomeTurno(escala.getDia07Fk().getNomeTurno());
		t07.setPlantoes(escala.getDia07Fk().getPlantoes());
		escalaNova.setDia07Fk(t07);
		
		Turnos t08 = new Turnos();
		t08.setDescricaoTurno(escala.getDia08Fk().getDescricaoTurno());
		t08.setHorasManha(escala.getDia08Fk().getHorasManha());
		t08.setHorasNoite(escala.getDia08Fk().getHorasNoite());
		t08.setHorasA(escala.getDia08Fk().getHorasA());
		t08.setHorasB(escala.getDia08Fk().getHorasB());
		t08.setHorasC(escala.getDia08Fk().getHorasC());
		t08.setHorasTarde(escala.getDia08Fk().getHorasTarde());
		t08.setId(escala.getDia08Fk().getId());
		t08.setNomeTurno(escala.getDia08Fk().getNomeTurno());
		t08.setPlantoes(escala.getDia08Fk().getPlantoes());
		escalaNova.setDia08Fk(t08);
		
		Turnos t09 = new Turnos();
		t09.setDescricaoTurno(escala.getDia09Fk().getDescricaoTurno());
		t09.setHorasManha(escala.getDia09Fk().getHorasManha());
		t09.setHorasNoite(escala.getDia09Fk().getHorasNoite());
		t09.setHorasA(escala.getDia09Fk().getHorasA());
		t09.setHorasB(escala.getDia09Fk().getHorasB());
		t09.setHorasC(escala.getDia09Fk().getHorasC());
		t09.setHorasTarde(escala.getDia09Fk().getHorasTarde());
		t09.setId(escala.getDia09Fk().getId());
		t09.setNomeTurno(escala.getDia09Fk().getNomeTurno());
		t09.setPlantoes(escala.getDia09Fk().getPlantoes());
		escalaNova.setDia09Fk(t09);
		
		Turnos t10 = new Turnos();
		t10.setDescricaoTurno(escala.getDia10Fk().getDescricaoTurno());
		t10.setHorasManha(escala.getDia10Fk().getHorasManha());
		t10.setHorasNoite(escala.getDia10Fk().getHorasNoite());
		t10.setHorasA(escala.getDia10Fk().getHorasA());
		t10.setHorasB(escala.getDia10Fk().getHorasB());
		t10.setHorasC(escala.getDia10Fk().getHorasC());
		t10.setHorasTarde(escala.getDia10Fk().getHorasTarde());
		t10.setId(escala.getDia10Fk().getId());
		t10.setNomeTurno(escala.getDia10Fk().getNomeTurno());
		t10.setPlantoes(escala.getDia10Fk().getPlantoes());
		escalaNova.setDia10Fk(t10);
		
		Turnos t11 = new Turnos();
		t11.setDescricaoTurno(escala.getDia11Fk().getDescricaoTurno());
		t11.setHorasManha(escala.getDia11Fk().getHorasManha());
		t11.setHorasNoite(escala.getDia11Fk().getHorasNoite());
		t11.setHorasA(escala.getDia11Fk().getHorasA());
		t11.setHorasB(escala.getDia11Fk().getHorasB());
		t11.setHorasC(escala.getDia11Fk().getHorasC());
		t11.setHorasTarde(escala.getDia11Fk().getHorasTarde());
		t11.setId(escala.getDia11Fk().getId());
		t11.setNomeTurno(escala.getDia11Fk().getNomeTurno());
		t11.setPlantoes(escala.getDia11Fk().getPlantoes());
		escalaNova.setDia11Fk(t11);
		
		Turnos t12 = new Turnos();
		t12.setDescricaoTurno(escala.getDia12Fk().getDescricaoTurno());
		t12.setHorasManha(escala.getDia12Fk().getHorasManha());
		t12.setHorasNoite(escala.getDia12Fk().getHorasNoite());
		t12.setHorasA(escala.getDia12Fk().getHorasA());
		t12.setHorasB(escala.getDia12Fk().getHorasB());
		t12.setHorasC(escala.getDia12Fk().getHorasC());
		t12.setHorasTarde(escala.getDia12Fk().getHorasTarde());
		t12.setId(escala.getDia12Fk().getId());
		t12.setNomeTurno(escala.getDia12Fk().getNomeTurno());
		t12.setPlantoes(escala.getDia12Fk().getPlantoes());
		escalaNova.setDia12Fk(t12);
		
		Turnos t13 = new Turnos();
		t13.setDescricaoTurno(escala.getDia13Fk().getDescricaoTurno());
		t13.setHorasManha(escala.getDia13Fk().getHorasManha());
		t13.setHorasNoite(escala.getDia13Fk().getHorasNoite());
		t13.setHorasA(escala.getDia13Fk().getHorasA());
		t13.setHorasB(escala.getDia13Fk().getHorasB());
		t13.setHorasC(escala.getDia13Fk().getHorasC());
		t13.setHorasTarde(escala.getDia13Fk().getHorasTarde());
		t13.setId(escala.getDia13Fk().getId());
		t13.setNomeTurno(escala.getDia13Fk().getNomeTurno());
		t13.setPlantoes(escala.getDia13Fk().getPlantoes());
		escalaNova.setDia13Fk(t13);
		
		Turnos t14 = new Turnos();
		t14.setDescricaoTurno(escala.getDia14Fk().getDescricaoTurno());
		t14.setHorasManha(escala.getDia14Fk().getHorasManha());
		t14.setHorasNoite(escala.getDia14Fk().getHorasNoite());
		t14.setHorasA(escala.getDia14Fk().getHorasA());
		t14.setHorasB(escala.getDia14Fk().getHorasB());
		t14.setHorasC(escala.getDia14Fk().getHorasC());
		t14.setHorasTarde(escala.getDia14Fk().getHorasTarde());
		t14.setId(escala.getDia14Fk().getId());
		t14.setNomeTurno(escala.getDia14Fk().getNomeTurno());
		t14.setPlantoes(escala.getDia14Fk().getPlantoes());
		escalaNova.setDia14Fk(t14);
		
		Turnos t15 = new Turnos();
		t15.setDescricaoTurno(escala.getDia15Fk().getDescricaoTurno());
		t15.setHorasManha(escala.getDia15Fk().getHorasManha());
		t15.setHorasNoite(escala.getDia15Fk().getHorasNoite());
		t15.setHorasA(escala.getDia15Fk().getHorasA());
		t15.setHorasB(escala.getDia15Fk().getHorasB());
		t15.setHorasC(escala.getDia15Fk().getHorasC());
		t15.setHorasTarde(escala.getDia15Fk().getHorasTarde());
		t15.setId(escala.getDia15Fk().getId());
		t15.setNomeTurno(escala.getDia15Fk().getNomeTurno());
		t15.setPlantoes(escala.getDia15Fk().getPlantoes());
		escalaNova.setDia15Fk(t15);
		
		Turnos t16 = new Turnos();
		t16.setDescricaoTurno(escala.getDia16Fk().getDescricaoTurno());
		t16.setHorasManha(escala.getDia16Fk().getHorasManha());
		t16.setHorasNoite(escala.getDia16Fk().getHorasNoite());
		t16.setHorasA(escala.getDia16Fk().getHorasA());
		t16.setHorasB(escala.getDia16Fk().getHorasB());
		t16.setHorasC(escala.getDia16Fk().getHorasC());
		t16.setHorasTarde(escala.getDia16Fk().getHorasTarde());
		t16.setId(escala.getDia16Fk().getId());
		t16.setNomeTurno(escala.getDia16Fk().getNomeTurno());
		t16.setPlantoes(escala.getDia16Fk().getPlantoes());
		escalaNova.setDia16Fk(t16);
		
		Turnos t17 = new Turnos();
		t17.setDescricaoTurno(escala.getDia17Fk().getDescricaoTurno());
		t17.setHorasManha(escala.getDia17Fk().getHorasManha());
		t17.setHorasNoite(escala.getDia17Fk().getHorasNoite());
		t17.setHorasA(escala.getDia17Fk().getHorasA());
		t17.setHorasB(escala.getDia17Fk().getHorasB());
		t17.setHorasC(escala.getDia17Fk().getHorasC());
		t17.setHorasTarde(escala.getDia17Fk().getHorasTarde());
		t17.setId(escala.getDia17Fk().getId());
		t17.setNomeTurno(escala.getDia17Fk().getNomeTurno());
		t17.setPlantoes(escala.getDia17Fk().getPlantoes());
		escalaNova.setDia17Fk(t17);
		
		Turnos t18 = new Turnos();
		t18.setDescricaoTurno(escala.getDia18Fk().getDescricaoTurno());
		t18.setHorasManha(escala.getDia18Fk().getHorasManha());
		t18.setHorasNoite(escala.getDia18Fk().getHorasNoite());
		t18.setHorasA(escala.getDia18Fk().getHorasA());
		t18.setHorasB(escala.getDia18Fk().getHorasB());
		t18.setHorasC(escala.getDia18Fk().getHorasC());
		t18.setHorasTarde(escala.getDia18Fk().getHorasTarde());
		t18.setId(escala.getDia18Fk().getId());
		t18.setNomeTurno(escala.getDia18Fk().getNomeTurno());
		t18.setPlantoes(escala.getDia18Fk().getPlantoes());
		escalaNova.setDia18Fk(t18);
		
		Turnos t19 = new Turnos();
		t19.setDescricaoTurno(escala.getDia19Fk().getDescricaoTurno());
		t19.setHorasManha(escala.getDia19Fk().getHorasManha());
		t19.setHorasNoite(escala.getDia19Fk().getHorasNoite());
		t19.setHorasA(escala.getDia19Fk().getHorasA());
		t19.setHorasB(escala.getDia19Fk().getHorasB());
		t19.setHorasC(escala.getDia19Fk().getHorasC());
		t19.setHorasTarde(escala.getDia19Fk().getHorasTarde());
		t19.setId(escala.getDia19Fk().getId());
		t19.setNomeTurno(escala.getDia19Fk().getNomeTurno());
		t19.setPlantoes(escala.getDia19Fk().getPlantoes());
		escalaNova.setDia19Fk(t19);
		
		Turnos t20 = new Turnos();
		t20.setDescricaoTurno(escala.getDia20Fk().getDescricaoTurno());
		t20.setHorasManha(escala.getDia20Fk().getHorasManha());
		t20.setHorasNoite(escala.getDia20Fk().getHorasNoite());
		t20.setHorasA(escala.getDia20Fk().getHorasA());
		t20.setHorasB(escala.getDia20Fk().getHorasB());
		t20.setHorasC(escala.getDia20Fk().getHorasC());
		t20.setHorasTarde(escala.getDia20Fk().getHorasTarde());
		t20.setId(escala.getDia20Fk().getId());
		t20.setNomeTurno(escala.getDia20Fk().getNomeTurno());
		t20.setPlantoes(escala.getDia20Fk().getPlantoes());
		escalaNova.setDia20Fk(t20);

		Turnos t21 = new Turnos();
		t21.setDescricaoTurno(escala.getDia21Fk().getDescricaoTurno());
		t21.setHorasManha(escala.getDia21Fk().getHorasManha());
		t21.setHorasNoite(escala.getDia21Fk().getHorasNoite());
		t21.setHorasA(escala.getDia21Fk().getHorasA());
		t21.setHorasB(escala.getDia21Fk().getHorasB());
		t21.setHorasC(escala.getDia21Fk().getHorasC());
		t21.setHorasTarde(escala.getDia21Fk().getHorasTarde());
		t21.setId(escala.getDia21Fk().getId());
		t21.setNomeTurno(escala.getDia21Fk().getNomeTurno());
		t21.setPlantoes(escala.getDia21Fk().getPlantoes());
		escalaNova.setDia21Fk(t21);
		
		Turnos t22 = new Turnos();
		t22.setDescricaoTurno(escala.getDia22Fk().getDescricaoTurno());
		t22.setHorasManha(escala.getDia22Fk().getHorasManha());
		t22.setHorasNoite(escala.getDia22Fk().getHorasNoite());
		t22.setHorasA(escala.getDia22Fk().getHorasA());
		t22.setHorasB(escala.getDia22Fk().getHorasB());
		t22.setHorasC(escala.getDia22Fk().getHorasC());
		t22.setHorasTarde(escala.getDia22Fk().getHorasTarde());
		t22.setId(escala.getDia22Fk().getId());
		t22.setNomeTurno(escala.getDia22Fk().getNomeTurno());
		t22.setPlantoes(escala.getDia22Fk().getPlantoes());
		escalaNova.setDia22Fk(t22);
		
		Turnos t23 = new Turnos();
		t23.setDescricaoTurno(escala.getDia23Fk().getDescricaoTurno());
		t23.setHorasManha(escala.getDia23Fk().getHorasManha());
		t23.setHorasNoite(escala.getDia23Fk().getHorasNoite());
		t23.setHorasA(escala.getDia23Fk().getHorasA());
		t23.setHorasB(escala.getDia23Fk().getHorasB());
		t23.setHorasC(escala.getDia23Fk().getHorasC());
		t23.setHorasTarde(escala.getDia23Fk().getHorasTarde());
		t23.setId(escala.getDia23Fk().getId());
		t23.setNomeTurno(escala.getDia23Fk().getNomeTurno());
		t23.setPlantoes(escala.getDia23Fk().getPlantoes());
		escalaNova.setDia23Fk(t23);
		
		Turnos t24 = new Turnos();
		t24.setDescricaoTurno(escala.getDia24Fk().getDescricaoTurno());
		t24.setHorasManha(escala.getDia24Fk().getHorasManha());
		t24.setHorasNoite(escala.getDia24Fk().getHorasNoite());
		t24.setHorasA(escala.getDia24Fk().getHorasA());
		t24.setHorasB(escala.getDia24Fk().getHorasB());
		t24.setHorasC(escala.getDia24Fk().getHorasC());
		t24.setHorasTarde(escala.getDia24Fk().getHorasTarde());
		t24.setId(escala.getDia24Fk().getId());
		t24.setNomeTurno(escala.getDia24Fk().getNomeTurno());
		t24.setPlantoes(escala.getDia24Fk().getPlantoes());
		escalaNova.setDia24Fk(t24);
		
		Turnos t25 = new Turnos();
		t25.setDescricaoTurno(escala.getDia25Fk().getDescricaoTurno());
		t25.setHorasManha(escala.getDia25Fk().getHorasManha());
		t25.setHorasNoite(escala.getDia25Fk().getHorasNoite());
		t25.setHorasA(escala.getDia25Fk().getHorasA());
		t25.setHorasB(escala.getDia25Fk().getHorasB());
		t25.setHorasC(escala.getDia25Fk().getHorasC());
		t25.setHorasTarde(escala.getDia25Fk().getHorasTarde());
		t25.setId(escala.getDia25Fk().getId());
		t25.setNomeTurno(escala.getDia25Fk().getNomeTurno());
		t25.setPlantoes(escala.getDia25Fk().getPlantoes());
		escalaNova.setDia25Fk(t25);
		
		Turnos t26 = new Turnos();
		t26.setDescricaoTurno(escala.getDia26Fk().getDescricaoTurno());
		t26.setHorasManha(escala.getDia26Fk().getHorasManha());
		t26.setHorasNoite(escala.getDia26Fk().getHorasNoite());
		t26.setHorasA(escala.getDia26Fk().getHorasA());
		t26.setHorasB(escala.getDia26Fk().getHorasB());
		t26.setHorasC(escala.getDia26Fk().getHorasC());
		t26.setHorasTarde(escala.getDia26Fk().getHorasTarde());
		t26.setId(escala.getDia26Fk().getId());
		t26.setNomeTurno(escala.getDia26Fk().getNomeTurno());
		t26.setPlantoes(escala.getDia26Fk().getPlantoes());
		escalaNova.setDia26Fk(t26);
		
		Turnos t27 = new Turnos();
		t27.setDescricaoTurno(escala.getDia27Fk().getDescricaoTurno());
		t27.setHorasManha(escala.getDia27Fk().getHorasManha());
		t27.setHorasNoite(escala.getDia27Fk().getHorasNoite());
		t27.setHorasA(escala.getDia27Fk().getHorasA());
		t27.setHorasB(escala.getDia27Fk().getHorasB());
		t27.setHorasC(escala.getDia27Fk().getHorasC());
		t27.setHorasTarde(escala.getDia27Fk().getHorasTarde());
		t27.setId(escala.getDia27Fk().getId());
		t27.setNomeTurno(escala.getDia27Fk().getNomeTurno());
		t27.setPlantoes(escala.getDia27Fk().getPlantoes());
		escalaNova.setDia27Fk(t27);
		
		Turnos t28 = new Turnos();
		t28.setDescricaoTurno(escala.getDia28Fk().getDescricaoTurno());
		t28.setHorasManha(escala.getDia28Fk().getHorasManha());
		t28.setHorasNoite(escala.getDia28Fk().getHorasNoite());
		t28.setHorasA(escala.getDia28Fk().getHorasA());
		t28.setHorasB(escala.getDia28Fk().getHorasB());
		t28.setHorasC(escala.getDia28Fk().getHorasC());
		t28.setHorasTarde(escala.getDia28Fk().getHorasTarde());
		t28.setId(escala.getDia28Fk().getId());
		t28.setNomeTurno(escala.getDia28Fk().getNomeTurno());
		t28.setPlantoes(escala.getDia28Fk().getPlantoes());
		escalaNova.setDia28Fk(t28);
		
		Turnos t29 = new Turnos();
		t29.setDescricaoTurno(escala.getDia29Fk().getDescricaoTurno());
		t29.setHorasManha(escala.getDia29Fk().getHorasManha());
		t29.setHorasNoite(escala.getDia29Fk().getHorasNoite());
		t29.setHorasA(escala.getDia29Fk().getHorasA());
		t29.setHorasB(escala.getDia29Fk().getHorasB());
		t29.setHorasC(escala.getDia29Fk().getHorasC());
		t29.setHorasTarde(escala.getDia29Fk().getHorasTarde());
		t29.setId(escala.getDia29Fk().getId());
		t29.setNomeTurno(escala.getDia29Fk().getNomeTurno());
		t29.setPlantoes(escala.getDia29Fk().getPlantoes());
		escalaNova.setDia29Fk(t29);
		
		Turnos t30 = new Turnos();
		t30.setDescricaoTurno(escala.getDia30Fk().getDescricaoTurno());
		t30.setHorasManha(escala.getDia30Fk().getHorasManha());
		t30.setHorasNoite(escala.getDia30Fk().getHorasNoite());
		t30.setHorasA(escala.getDia30Fk().getHorasA());
		t30.setHorasB(escala.getDia30Fk().getHorasB());
		t30.setHorasC(escala.getDia30Fk().getHorasC());
		t30.setHorasTarde(escala.getDia30Fk().getHorasTarde());
		t30.setId(escala.getDia30Fk().getId());
		t30.setNomeTurno(escala.getDia30Fk().getNomeTurno());
		t30.setPlantoes(escala.getDia30Fk().getPlantoes());
		escalaNova.setDia30Fk(t30);
		
		Turnos t31 = new Turnos();
		t31.setDescricaoTurno(escala.getDia31Fk().getDescricaoTurno());
		t31.setHorasManha(escala.getDia31Fk().getHorasManha());
		t31.setHorasNoite(escala.getDia31Fk().getHorasNoite());
		t31.setHorasA(escala.getDia31Fk().getHorasA());
		t31.setHorasB(escala.getDia31Fk().getHorasB());
		t31.setHorasC(escala.getDia31Fk().getHorasC());
		t31.setHorasTarde(escala.getDia31Fk().getHorasTarde());
		t31.setId(escala.getDia31Fk().getId());
		t31.setNomeTurno(escala.getDia31Fk().getNomeTurno());
		t31.setPlantoes(escala.getDia31Fk().getPlantoes());
		escalaNova.setDia31Fk(t31);

		
		
		escalaNova.setDtCancelamento(escala.getDtCancelamento());
		escalaNova.setDtMudanca(escala.getDtMudanca());
		escalaNova.setHorasDia(escala.getHorasDia());
		escalaNova.setHorasFimSemana(escala.getHorasFimSemana());
		escalaNova.setHorasNoite(escala.getHorasNoite());
		escalaNova.setHorasSemana(escala.getHorasSemana());
		escalaNova.setHorasTotais(escala.getHorasTotais());
		escalaNova.setId(null);
		escalaNova.setIdAnoMesFk(escala.getIdAnoMesFk());
		escalaNova.setIdAvaliacaoAssiduidadeFk(escala.getIdAvaliacaoAssiduidadeFk());
		escalaNova.setIdAvaliacaoAtividadesBurocraticasFk(escala.getIdAvaliacaoAtividadesBurocraticasFk());
		escalaNova.setIdAvaliacaoFormalizacaoPontoFk(escala.getIdAvaliacaoFormalizacaoPontoFk());
		escalaNova.setIdAvaliacaoPermanenciaFk(escala.getIdAvaliacaoPermanenciaFk());
		escalaNova.setIdChDifSimNaoFk(escala.getIdChDifSimNaoFk());
		escalaNova.setIdComplementoPlantaoSimNaoFk(escala.getIdComplementoPlantaoSimNaoFk());
		escalaNova.setIdCoordenacaoFk(escala.getIdCoordenacaoFk());
		escalaNova.setIdOperadorCancelamentoFk(escala.getIdOperadorCancelamentoFk());
		escalaNova.setIdOperadorMudancaFk(escala.getIdOperadorMudancaFk());
		escalaNova.setIdFuncionarioFk(escala.getIdFuncionarioFk());
		escalaNova.setIdIncrementoDeRiscoSimNaoFk(escala.getIdIncrementoDeRiscoSimNaoFk());
		escalaNova.setIdLiberacaoDobraInvertidaSimNaoFk(escala.getIdLiberacaoDobraInvertidaSimNaoFk());
		escalaNova.setIdPresencialSimNaoFk(escala.getIdPresencialSimNaoFk());
		escalaNova.setIdRegimeFk(escala.getIdRegimeFk());
		escalaNova.setIdTipoFolhaFk(escala.getIdTipoFolhaFk());
		escalaNova.setIdTurmaFk(escala.getIdTurmaFk());
		escalaNova.setPlantoes(escala.getPlantoes());
		escalaNova.setObservacoes(escala.getObservacoes());
	
		escalaNova.setId(null);
		
		return escalaNova;
	}
	
	
	public Escala converteDeEscalaParaEscalaComId(Escala escala) {
		Escala escalaNova = new Escala();
	
		
		Turnos t01 = new Turnos();
		t01.setDescricaoTurno(escala.getDia01Fk().getDescricaoTurno());
		t01.setHorasManha(escala.getDia01Fk().getHorasManha());
		t01.setHorasNoite(escala.getDia01Fk().getHorasNoite());
		t01.setHorasA(escala.getDia01Fk().getHorasA());
		t01.setHorasB(escala.getDia01Fk().getHorasB());
		t01.setHorasC(escala.getDia01Fk().getHorasC());
		t01.setHorasTarde(escala.getDia01Fk().getHorasTarde());
		t01.setId(escala.getDia01Fk().getId());
		t01.setNomeTurno(escala.getDia01Fk().getNomeTurno());
		t01.setPlantoes(escala.getDia01Fk().getPlantoes());
		escalaNova.setDia01Fk(t01);
		
		Turnos t02 = new Turnos();
		t02.setDescricaoTurno(escala.getDia02Fk().getDescricaoTurno());
		t02.setHorasManha(escala.getDia02Fk().getHorasManha());
		t02.setHorasNoite(escala.getDia02Fk().getHorasNoite());
		t02.setHorasA(escala.getDia02Fk().getHorasA());
		t02.setHorasB(escala.getDia02Fk().getHorasB());
		t02.setHorasC(escala.getDia02Fk().getHorasC());
		t02.setHorasTarde(escala.getDia02Fk().getHorasTarde());
		t02.setId(escala.getDia02Fk().getId());
		t02.setNomeTurno(escala.getDia02Fk().getNomeTurno());
		t02.setPlantoes(escala.getDia02Fk().getPlantoes());
		escalaNova.setDia02Fk(t02);
		
		Turnos t03 = new Turnos();
		t03.setDescricaoTurno(escala.getDia03Fk().getDescricaoTurno());
		t03.setHorasManha(escala.getDia03Fk().getHorasManha());
		t03.setHorasNoite(escala.getDia03Fk().getHorasNoite());
		t03.setHorasA(escala.getDia03Fk().getHorasA());
		t03.setHorasB(escala.getDia03Fk().getHorasB());
		t03.setHorasC(escala.getDia03Fk().getHorasC());
		t03.setHorasTarde(escala.getDia03Fk().getHorasTarde());
		t03.setId(escala.getDia03Fk().getId());
		t03.setNomeTurno(escala.getDia03Fk().getNomeTurno());
		t03.setPlantoes(escala.getDia03Fk().getPlantoes());
		escalaNova.setDia03Fk(t03);
		
		Turnos t04 = new Turnos();
		t04.setDescricaoTurno(escala.getDia04Fk().getDescricaoTurno());
		t04.setHorasManha(escala.getDia04Fk().getHorasManha());
		t04.setHorasNoite(escala.getDia04Fk().getHorasNoite());
		t04.setHorasA(escala.getDia04Fk().getHorasA());
		t04.setHorasB(escala.getDia04Fk().getHorasB());
		t04.setHorasC(escala.getDia04Fk().getHorasC());
		t04.setHorasTarde(escala.getDia04Fk().getHorasTarde());
		t04.setId(escala.getDia04Fk().getId());
		t04.setNomeTurno(escala.getDia04Fk().getNomeTurno());
		t04.setPlantoes(escala.getDia04Fk().getPlantoes());
		escalaNova.setDia04Fk(t04);
		
		Turnos t05 = new Turnos();
		t05.setDescricaoTurno(escala.getDia05Fk().getDescricaoTurno());
		t05.setHorasManha(escala.getDia05Fk().getHorasManha());
		t05.setHorasNoite(escala.getDia05Fk().getHorasNoite());
		t05.setHorasA(escala.getDia05Fk().getHorasA());
		t05.setHorasB(escala.getDia05Fk().getHorasB());
		t05.setHorasC(escala.getDia05Fk().getHorasC());
		t05.setHorasTarde(escala.getDia05Fk().getHorasTarde());
		t05.setId(escala.getDia05Fk().getId());
		t05.setNomeTurno(escala.getDia05Fk().getNomeTurno());
		t05.setPlantoes(escala.getDia05Fk().getPlantoes());
		escalaNova.setDia05Fk(t05);
		
		Turnos t06 = new Turnos();
		t06.setDescricaoTurno(escala.getDia06Fk().getDescricaoTurno());
		t06.setHorasManha(escala.getDia06Fk().getHorasManha());
		t06.setHorasNoite(escala.getDia06Fk().getHorasNoite());
		t06.setHorasA(escala.getDia06Fk().getHorasA());
		t06.setHorasB(escala.getDia06Fk().getHorasB());
		t06.setHorasC(escala.getDia06Fk().getHorasC());
		t06.setHorasTarde(escala.getDia06Fk().getHorasTarde());
		t06.setId(escala.getDia06Fk().getId());
		t06.setNomeTurno(escala.getDia06Fk().getNomeTurno());
		t06.setPlantoes(escala.getDia06Fk().getPlantoes());
		escalaNova.setDia06Fk(t06);
		
		Turnos t07 = new Turnos();
		t07.setDescricaoTurno(escala.getDia07Fk().getDescricaoTurno());
		t07.setHorasManha(escala.getDia07Fk().getHorasManha());
		t07.setHorasNoite(escala.getDia07Fk().getHorasNoite());
		t07.setHorasA(escala.getDia07Fk().getHorasA());
		t07.setHorasB(escala.getDia07Fk().getHorasB());
		t07.setHorasC(escala.getDia07Fk().getHorasC());
		t07.setHorasTarde(escala.getDia07Fk().getHorasTarde());
		t07.setId(escala.getDia07Fk().getId());
		t07.setNomeTurno(escala.getDia07Fk().getNomeTurno());
		t07.setPlantoes(escala.getDia07Fk().getPlantoes());
		escalaNova.setDia07Fk(t07);
		
		Turnos t08 = new Turnos();
		t08.setDescricaoTurno(escala.getDia08Fk().getDescricaoTurno());
		t08.setHorasManha(escala.getDia08Fk().getHorasManha());
		t08.setHorasNoite(escala.getDia08Fk().getHorasNoite());
		t08.setHorasA(escala.getDia08Fk().getHorasA());
		t08.setHorasB(escala.getDia08Fk().getHorasB());
		t08.setHorasC(escala.getDia08Fk().getHorasC());
		t08.setHorasTarde(escala.getDia08Fk().getHorasTarde());
		t08.setId(escala.getDia08Fk().getId());
		t08.setNomeTurno(escala.getDia08Fk().getNomeTurno());
		t08.setPlantoes(escala.getDia08Fk().getPlantoes());
		escalaNova.setDia08Fk(t08);
		
		Turnos t09 = new Turnos();
		t09.setDescricaoTurno(escala.getDia09Fk().getDescricaoTurno());
		t09.setHorasManha(escala.getDia09Fk().getHorasManha());
		t09.setHorasNoite(escala.getDia09Fk().getHorasNoite());
		t09.setHorasA(escala.getDia09Fk().getHorasA());
		t09.setHorasB(escala.getDia09Fk().getHorasB());
		t09.setHorasC(escala.getDia09Fk().getHorasC());
		t09.setHorasTarde(escala.getDia09Fk().getHorasTarde());
		t09.setId(escala.getDia09Fk().getId());
		t09.setNomeTurno(escala.getDia09Fk().getNomeTurno());
		t09.setPlantoes(escala.getDia09Fk().getPlantoes());
		escalaNova.setDia09Fk(t09);
		
		Turnos t10 = new Turnos();
		t10.setDescricaoTurno(escala.getDia10Fk().getDescricaoTurno());
		t10.setHorasManha(escala.getDia10Fk().getHorasManha());
		t10.setHorasNoite(escala.getDia10Fk().getHorasNoite());
		t10.setHorasA(escala.getDia10Fk().getHorasA());
		t10.setHorasB(escala.getDia10Fk().getHorasB());
		t10.setHorasC(escala.getDia10Fk().getHorasC());
		t10.setHorasTarde(escala.getDia10Fk().getHorasTarde());
		t10.setId(escala.getDia10Fk().getId());
		t10.setNomeTurno(escala.getDia10Fk().getNomeTurno());
		t10.setPlantoes(escala.getDia10Fk().getPlantoes());
		escalaNova.setDia10Fk(t10);
		
		Turnos t11 = new Turnos();
		t11.setDescricaoTurno(escala.getDia11Fk().getDescricaoTurno());
		t11.setHorasManha(escala.getDia11Fk().getHorasManha());
		t11.setHorasNoite(escala.getDia11Fk().getHorasNoite());
		t11.setHorasA(escala.getDia11Fk().getHorasA());
		t11.setHorasB(escala.getDia11Fk().getHorasB());
		t11.setHorasC(escala.getDia11Fk().getHorasC());
		t11.setHorasTarde(escala.getDia11Fk().getHorasTarde());
		t11.setId(escala.getDia11Fk().getId());
		t11.setNomeTurno(escala.getDia11Fk().getNomeTurno());
		t11.setPlantoes(escala.getDia11Fk().getPlantoes());
		escalaNova.setDia11Fk(t11);
		
		Turnos t12 = new Turnos();
		t12.setDescricaoTurno(escala.getDia12Fk().getDescricaoTurno());
		t12.setHorasManha(escala.getDia12Fk().getHorasManha());
		t12.setHorasNoite(escala.getDia12Fk().getHorasNoite());
		t12.setHorasA(escala.getDia12Fk().getHorasA());
		t12.setHorasB(escala.getDia12Fk().getHorasB());
		t12.setHorasC(escala.getDia12Fk().getHorasC());
		t12.setHorasTarde(escala.getDia12Fk().getHorasTarde());
		t12.setId(escala.getDia12Fk().getId());
		t12.setNomeTurno(escala.getDia12Fk().getNomeTurno());
		t12.setPlantoes(escala.getDia12Fk().getPlantoes());
		escalaNova.setDia12Fk(t12);
		
		Turnos t13 = new Turnos();
		t13.setDescricaoTurno(escala.getDia13Fk().getDescricaoTurno());
		t13.setHorasManha(escala.getDia13Fk().getHorasManha());
		t13.setHorasNoite(escala.getDia13Fk().getHorasNoite());
		t13.setHorasA(escala.getDia13Fk().getHorasA());
		t13.setHorasB(escala.getDia13Fk().getHorasB());
		t13.setHorasC(escala.getDia13Fk().getHorasC());
		t13.setHorasTarde(escala.getDia13Fk().getHorasTarde());
		t13.setId(escala.getDia13Fk().getId());
		t13.setNomeTurno(escala.getDia13Fk().getNomeTurno());
		t13.setPlantoes(escala.getDia13Fk().getPlantoes());
		escalaNova.setDia13Fk(t13);
		
		Turnos t14 = new Turnos();
		t14.setDescricaoTurno(escala.getDia14Fk().getDescricaoTurno());
		t14.setHorasManha(escala.getDia14Fk().getHorasManha());
		t14.setHorasNoite(escala.getDia14Fk().getHorasNoite());
		t14.setHorasA(escala.getDia14Fk().getHorasA());
		t14.setHorasB(escala.getDia14Fk().getHorasB());
		t14.setHorasC(escala.getDia14Fk().getHorasC());
		t14.setHorasTarde(escala.getDia14Fk().getHorasTarde());
		t14.setId(escala.getDia14Fk().getId());
		t14.setNomeTurno(escala.getDia14Fk().getNomeTurno());
		t14.setPlantoes(escala.getDia14Fk().getPlantoes());
		escalaNova.setDia14Fk(t14);
		
		Turnos t15 = new Turnos();
		t15.setDescricaoTurno(escala.getDia15Fk().getDescricaoTurno());
		t15.setHorasManha(escala.getDia15Fk().getHorasManha());
		t15.setHorasNoite(escala.getDia15Fk().getHorasNoite());
		t15.setHorasA(escala.getDia15Fk().getHorasA());
		t15.setHorasB(escala.getDia15Fk().getHorasB());
		t15.setHorasC(escala.getDia15Fk().getHorasC());
		t15.setHorasTarde(escala.getDia15Fk().getHorasTarde());
		t15.setId(escala.getDia15Fk().getId());
		t15.setNomeTurno(escala.getDia15Fk().getNomeTurno());
		t15.setPlantoes(escala.getDia15Fk().getPlantoes());
		escalaNova.setDia15Fk(t15);
		
		Turnos t16 = new Turnos();
		t16.setDescricaoTurno(escala.getDia16Fk().getDescricaoTurno());
		t16.setHorasManha(escala.getDia16Fk().getHorasManha());
		t16.setHorasNoite(escala.getDia16Fk().getHorasNoite());
		t16.setHorasA(escala.getDia16Fk().getHorasA());
		t16.setHorasB(escala.getDia16Fk().getHorasB());
		t16.setHorasC(escala.getDia16Fk().getHorasC());
		t16.setHorasTarde(escala.getDia16Fk().getHorasTarde());
		t16.setId(escala.getDia16Fk().getId());
		t16.setNomeTurno(escala.getDia16Fk().getNomeTurno());
		t16.setPlantoes(escala.getDia16Fk().getPlantoes());
		escalaNova.setDia16Fk(t16);
		
		Turnos t17 = new Turnos();
		t17.setDescricaoTurno(escala.getDia17Fk().getDescricaoTurno());
		t17.setHorasManha(escala.getDia17Fk().getHorasManha());
		t17.setHorasNoite(escala.getDia17Fk().getHorasNoite());
		t17.setHorasA(escala.getDia17Fk().getHorasA());
		t17.setHorasB(escala.getDia17Fk().getHorasB());
		t17.setHorasC(escala.getDia17Fk().getHorasC());
		t17.setHorasTarde(escala.getDia17Fk().getHorasTarde());
		t17.setId(escala.getDia17Fk().getId());
		t17.setNomeTurno(escala.getDia17Fk().getNomeTurno());
		t17.setPlantoes(escala.getDia17Fk().getPlantoes());
		escalaNova.setDia17Fk(t17);
		
		Turnos t18 = new Turnos();
		t18.setDescricaoTurno(escala.getDia18Fk().getDescricaoTurno());
		t18.setHorasManha(escala.getDia18Fk().getHorasManha());
		t18.setHorasNoite(escala.getDia18Fk().getHorasNoite());
		t18.setHorasA(escala.getDia18Fk().getHorasA());
		t18.setHorasB(escala.getDia18Fk().getHorasB());
		t18.setHorasC(escala.getDia18Fk().getHorasC());
		t18.setHorasTarde(escala.getDia18Fk().getHorasTarde());
		t18.setId(escala.getDia18Fk().getId());
		t18.setNomeTurno(escala.getDia18Fk().getNomeTurno());
		t18.setPlantoes(escala.getDia18Fk().getPlantoes());
		escalaNova.setDia18Fk(t18);
		
		Turnos t19 = new Turnos();
		t19.setDescricaoTurno(escala.getDia19Fk().getDescricaoTurno());
		t19.setHorasManha(escala.getDia19Fk().getHorasManha());
		t19.setHorasNoite(escala.getDia19Fk().getHorasNoite());
		t19.setHorasA(escala.getDia19Fk().getHorasA());
		t19.setHorasB(escala.getDia19Fk().getHorasB());
		t19.setHorasC(escala.getDia19Fk().getHorasC());
		t19.setHorasTarde(escala.getDia19Fk().getHorasTarde());
		t19.setId(escala.getDia19Fk().getId());
		t19.setNomeTurno(escala.getDia19Fk().getNomeTurno());
		t19.setPlantoes(escala.getDia19Fk().getPlantoes());
		escalaNova.setDia19Fk(t19);
		
		Turnos t20 = new Turnos();
		t20.setDescricaoTurno(escala.getDia20Fk().getDescricaoTurno());
		t20.setHorasManha(escala.getDia20Fk().getHorasManha());
		t20.setHorasNoite(escala.getDia20Fk().getHorasNoite());
		t20.setHorasA(escala.getDia20Fk().getHorasA());
		t20.setHorasB(escala.getDia20Fk().getHorasB());
		t20.setHorasC(escala.getDia20Fk().getHorasC());
		t20.setHorasTarde(escala.getDia20Fk().getHorasTarde());
		t20.setId(escala.getDia20Fk().getId());
		t20.setNomeTurno(escala.getDia20Fk().getNomeTurno());
		t20.setPlantoes(escala.getDia20Fk().getPlantoes());
		escalaNova.setDia20Fk(t20);

		Turnos t21 = new Turnos();
		t21.setDescricaoTurno(escala.getDia21Fk().getDescricaoTurno());
		t21.setHorasManha(escala.getDia21Fk().getHorasManha());
		t21.setHorasNoite(escala.getDia21Fk().getHorasNoite());
		t21.setHorasA(escala.getDia21Fk().getHorasA());
		t21.setHorasB(escala.getDia21Fk().getHorasB());
		t21.setHorasC(escala.getDia21Fk().getHorasC());
		t21.setHorasTarde(escala.getDia21Fk().getHorasTarde());
		t21.setId(escala.getDia21Fk().getId());
		t21.setNomeTurno(escala.getDia21Fk().getNomeTurno());
		t21.setPlantoes(escala.getDia21Fk().getPlantoes());
		escalaNova.setDia21Fk(t21);
		
		Turnos t22 = new Turnos();
		t22.setDescricaoTurno(escala.getDia22Fk().getDescricaoTurno());
		t22.setHorasManha(escala.getDia22Fk().getHorasManha());
		t22.setHorasNoite(escala.getDia22Fk().getHorasNoite());
		t22.setHorasA(escala.getDia22Fk().getHorasA());
		t22.setHorasB(escala.getDia22Fk().getHorasB());
		t22.setHorasC(escala.getDia22Fk().getHorasC());
		t22.setHorasTarde(escala.getDia22Fk().getHorasTarde());
		t22.setId(escala.getDia22Fk().getId());
		t22.setNomeTurno(escala.getDia22Fk().getNomeTurno());
		t22.setPlantoes(escala.getDia22Fk().getPlantoes());
		escalaNova.setDia22Fk(t22);
		
		Turnos t23 = new Turnos();
		t23.setDescricaoTurno(escala.getDia23Fk().getDescricaoTurno());
		t23.setHorasManha(escala.getDia23Fk().getHorasManha());
		t23.setHorasNoite(escala.getDia23Fk().getHorasNoite());
		t23.setHorasA(escala.getDia23Fk().getHorasA());
		t23.setHorasB(escala.getDia23Fk().getHorasB());
		t23.setHorasC(escala.getDia23Fk().getHorasC());
		t23.setHorasTarde(escala.getDia23Fk().getHorasTarde());
		t23.setId(escala.getDia23Fk().getId());
		t23.setNomeTurno(escala.getDia23Fk().getNomeTurno());
		t23.setPlantoes(escala.getDia23Fk().getPlantoes());
		escalaNova.setDia23Fk(t23);
		
		Turnos t24 = new Turnos();
		t24.setDescricaoTurno(escala.getDia24Fk().getDescricaoTurno());
		t24.setHorasManha(escala.getDia24Fk().getHorasManha());
		t24.setHorasNoite(escala.getDia24Fk().getHorasNoite());
		t24.setHorasA(escala.getDia24Fk().getHorasA());
		t24.setHorasB(escala.getDia24Fk().getHorasB());
		t24.setHorasC(escala.getDia24Fk().getHorasC());
		t24.setHorasTarde(escala.getDia24Fk().getHorasTarde());
		t24.setId(escala.getDia24Fk().getId());
		t24.setNomeTurno(escala.getDia24Fk().getNomeTurno());
		t24.setPlantoes(escala.getDia24Fk().getPlantoes());
		escalaNova.setDia24Fk(t24);
		
		Turnos t25 = new Turnos();
		t25.setDescricaoTurno(escala.getDia25Fk().getDescricaoTurno());
		t25.setHorasManha(escala.getDia25Fk().getHorasManha());
		t25.setHorasNoite(escala.getDia25Fk().getHorasNoite());
		t25.setHorasA(escala.getDia25Fk().getHorasA());
		t25.setHorasB(escala.getDia25Fk().getHorasB());
		t25.setHorasC(escala.getDia25Fk().getHorasC());
		t25.setHorasTarde(escala.getDia25Fk().getHorasTarde());
		t25.setId(escala.getDia25Fk().getId());
		t25.setNomeTurno(escala.getDia25Fk().getNomeTurno());
		t25.setPlantoes(escala.getDia25Fk().getPlantoes());
		escalaNova.setDia25Fk(t25);
		
		Turnos t26 = new Turnos();
		t26.setDescricaoTurno(escala.getDia26Fk().getDescricaoTurno());
		t26.setHorasManha(escala.getDia26Fk().getHorasManha());
		t26.setHorasNoite(escala.getDia26Fk().getHorasNoite());
		t26.setHorasA(escala.getDia26Fk().getHorasA());
		t26.setHorasB(escala.getDia26Fk().getHorasB());
		t26.setHorasC(escala.getDia26Fk().getHorasC());
		t26.setHorasTarde(escala.getDia26Fk().getHorasTarde());
		t26.setId(escala.getDia26Fk().getId());
		t26.setNomeTurno(escala.getDia26Fk().getNomeTurno());
		t26.setPlantoes(escala.getDia26Fk().getPlantoes());
		escalaNova.setDia26Fk(t26);
		
		Turnos t27 = new Turnos();
		t27.setDescricaoTurno(escala.getDia27Fk().getDescricaoTurno());
		t27.setHorasManha(escala.getDia27Fk().getHorasManha());
		t27.setHorasNoite(escala.getDia27Fk().getHorasNoite());
		t27.setHorasA(escala.getDia27Fk().getHorasA());
		t27.setHorasB(escala.getDia27Fk().getHorasB());
		t27.setHorasC(escala.getDia27Fk().getHorasC());
		t27.setHorasTarde(escala.getDia27Fk().getHorasTarde());
		t27.setId(escala.getDia27Fk().getId());
		t27.setNomeTurno(escala.getDia27Fk().getNomeTurno());
		t27.setPlantoes(escala.getDia27Fk().getPlantoes());
		escalaNova.setDia27Fk(t27);
		
		Turnos t28 = new Turnos();
		t28.setDescricaoTurno(escala.getDia28Fk().getDescricaoTurno());
		t28.setHorasManha(escala.getDia28Fk().getHorasManha());
		t28.setHorasNoite(escala.getDia28Fk().getHorasNoite());
		t28.setHorasA(escala.getDia28Fk().getHorasA());
		t28.setHorasB(escala.getDia28Fk().getHorasB());
		t28.setHorasC(escala.getDia28Fk().getHorasC());
		t28.setHorasTarde(escala.getDia28Fk().getHorasTarde());
		t28.setId(escala.getDia28Fk().getId());
		t28.setNomeTurno(escala.getDia28Fk().getNomeTurno());
		t28.setPlantoes(escala.getDia28Fk().getPlantoes());
		escalaNova.setDia28Fk(t28);
		
		Turnos t29 = new Turnos();
		t29.setDescricaoTurno(escala.getDia29Fk().getDescricaoTurno());
		t29.setHorasManha(escala.getDia29Fk().getHorasManha());
		t29.setHorasNoite(escala.getDia29Fk().getHorasNoite());
		t29.setHorasA(escala.getDia29Fk().getHorasA());
		t29.setHorasB(escala.getDia29Fk().getHorasB());
		t29.setHorasC(escala.getDia29Fk().getHorasC());
		t29.setHorasTarde(escala.getDia29Fk().getHorasTarde());
		t29.setId(escala.getDia29Fk().getId());
		t29.setNomeTurno(escala.getDia29Fk().getNomeTurno());
		t29.setPlantoes(escala.getDia29Fk().getPlantoes());
		escalaNova.setDia29Fk(t29);
		
		Turnos t30 = new Turnos();
		t30.setDescricaoTurno(escala.getDia30Fk().getDescricaoTurno());
		t30.setHorasManha(escala.getDia30Fk().getHorasManha());
		t30.setHorasNoite(escala.getDia30Fk().getHorasNoite());
		t30.setHorasA(escala.getDia30Fk().getHorasA());
		t30.setHorasB(escala.getDia30Fk().getHorasB());
		t30.setHorasC(escala.getDia30Fk().getHorasC());
		t30.setHorasTarde(escala.getDia30Fk().getHorasTarde());
		t30.setId(escala.getDia30Fk().getId());
		t30.setNomeTurno(escala.getDia30Fk().getNomeTurno());
		t30.setPlantoes(escala.getDia30Fk().getPlantoes());
		escalaNova.setDia30Fk(t30);
		
		Turnos t31 = new Turnos();
		t31.setDescricaoTurno(escala.getDia31Fk().getDescricaoTurno());
		t31.setHorasManha(escala.getDia31Fk().getHorasManha());
		t31.setHorasNoite(escala.getDia31Fk().getHorasNoite());
		t31.setHorasA(escala.getDia31Fk().getHorasA());
		t31.setHorasB(escala.getDia31Fk().getHorasB());
		t31.setHorasC(escala.getDia31Fk().getHorasC());
		t31.setHorasTarde(escala.getDia31Fk().getHorasTarde());
		t31.setId(escala.getDia31Fk().getId());
		t31.setNomeTurno(escala.getDia31Fk().getNomeTurno());
		t31.setPlantoes(escala.getDia31Fk().getPlantoes());
		escalaNova.setDia31Fk(t31);
		
		
		
		
		
		escalaNova.setDtCancelamento(escala.getDtCancelamento());
		escalaNova.setDtMudanca(escala.getDtMudanca());
		escalaNova.setHorasDia(escala.getHorasDia());
		escalaNova.setHorasFimSemana(escala.getHorasFimSemana());
		escalaNova.setHorasNoite(escala.getHorasNoite());
		escalaNova.setHorasSemana(escala.getHorasSemana());
		escalaNova.setHorasTotais(escala.getHorasTotais());
		escalaNova.setIdAnoMesFk(escala.getIdAnoMesFk());
		escalaNova.setIdAvaliacaoAssiduidadeFk(escala.getIdAvaliacaoAssiduidadeFk());
		escalaNova.setIdAvaliacaoAtividadesBurocraticasFk(escala.getIdAvaliacaoAtividadesBurocraticasFk());
		escalaNova.setIdAvaliacaoFormalizacaoPontoFk(escala.getIdAvaliacaoFormalizacaoPontoFk());
		escalaNova.setIdAvaliacaoPermanenciaFk(escala.getIdAvaliacaoPermanenciaFk());
		escalaNova.setIdChDifSimNaoFk(escala.getIdChDifSimNaoFk());
		escalaNova.setIdComplementoPlantaoSimNaoFk(escala.getIdComplementoPlantaoSimNaoFk());
		escalaNova.setIdCoordenacaoFk(escala.getIdCoordenacaoFk());
		escalaNova.setIdOperadorCancelamentoFk(escala.getIdOperadorCancelamentoFk());
		escalaNova.setIdOperadorMudancaFk(escala.getIdOperadorMudancaFk());
		escalaNova.setIdFuncionarioFk(escala.getIdFuncionarioFk());
		escalaNova.setIdIncrementoDeRiscoSimNaoFk(escala.getIdIncrementoDeRiscoSimNaoFk());
		escalaNova.setIdLiberacaoDobraInvertidaSimNaoFk(escala.getIdLiberacaoDobraInvertidaSimNaoFk());
		escalaNova.setIdPresencialSimNaoFk(escala.getIdPresencialSimNaoFk());
		escalaNova.setIdRegimeFk(escala.getIdRegimeFk());
		escalaNova.setIdTipoFolhaFk(escala.getIdTipoFolhaFk());
		escalaNova.setIdTurmaFk(escala.getIdTurmaFk());
		escalaNova.setPlantoes(escala.getPlantoes());
		escalaNova.setObservacoes(escala.getObservacoes());
	
		escalaNova.setId(escala.getId());
		
		return escalaNova;
	}
	
	public String excedeLimiteDeHoras(Escala escala) {
		String resposta = "";
		
		if(escala.getIdTipoFolhaFk().getIdTipoRemuneracaoFk().getNomeTipoRemuneracao().contains("VARIAVEL")) {
			if(limiteDeHorasIndividual(escala)<escala.getHorasTotais()) {
				resposta = "Excede limite mensal de horas. A margem atual é de "+limiteDeHorasIndividual(escala)+" horas. E você quer lançar "+escala.getHorasTotais()+".";
			}
		}
		if(resposta.length()>0) {resposta = " "+resposta;}
		
		//LIBERANDO TODOS OS LIMITES
		resposta = "";
		return resposta;
	}
	
	public int limiteDeHorasIndividual(Escala escala) {
		int resposta = 240;
		
		//Retirando as 48 horas para todos os medicos
		if(escala.getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo().equalsIgnoreCase("T") ) {resposta = resposta-48;}
		
		//Acrescentando as 66 horas a mais para as especioalidades médias diferentes
		if( !limiteHorasAcrescimoPorUnidadeEEspecialidadeService.buscarLimite( escala.getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk() , escala.getIdAnoMesFk(), escala.getIdFuncionarioFk().getIdEspecialidadeAtualFk()).isEmpty()  ) {
			resposta = resposta+  limiteHorasAcrescimoPorUnidadeEEspecialidadeService.buscarLimite( escala.getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk() , escala.getIdAnoMesFk(), escala.getIdFuncionarioFk().getIdEspecialidadeAtualFk()).get(0).getHoras();
		}
		
		
		//Altereando limite de horas para excepcionalidades cadastradas
		if(!pessoaLimiteHorasService.buscarPorUnidadeEPessoaAprovadoSede(escala.getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk(), escala.getIdFuncionarioFk().getIdPessoaFk()).isEmpty()) {
			resposta = pessoaLimiteHorasService.buscarPorUnidadeEPessoaAprovadoSede(escala.getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk(), escala.getIdFuncionarioFk().getIdPessoaFk()).get(0).getHoras();
		}
		
		
		//Tirando as horas efetivas
		if(!escala.getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo().contains("PRESTADOR")) {
			resposta = resposta - (escala.getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria()*4);
		}
		//Tirando as horas variaveis
		List <Escala> lista = buscarPorPessoaEAnoMes(escala);
			for(int i=0;i<lista.size();i++) {
				if(lista.get(i).getIdTipoFolhaFk().getIdTipoRemuneracaoFk().getNomeTipoRemuneracao().contains("VARIAVEL")) {
					if(escala!=lista.get(i)) {
						resposta = resposta-lista.get(i).getHorasTotais();
					}
				}
			}
		
		return resposta;
	}

	public List<Escala> buscarPorPessoaEAnoMes( Escala escala) {
		Pessoa pessoa = escala.getIdFuncionarioFk().getIdPessoaFk();
		AnoMes anoMes = escala.getIdAnoMesFk();
		return this.reposytory.findByIdFuncionarioFkIdPessoaFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAscIdTipoFolhaFkAscIdFuncionarioFkIdPessoaFkNomeAsc(pessoa, anoMes);
	}
	
	public int buscarQuantidadeDeEscalasPorMes(AnoMes anoMes){
		int resposta = buscarPorMes(anoMes).size();
		return resposta;
	}
	
	public List<Escala> buscarPorMes( AnoMes anoMes) {
		return this.reposytory.findByIdAnoMesFkAndDtCancelamentoIsNullOrderByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAscIdTipoFolhaFkAscIdFuncionarioFkIdPessoaFkNomeAsc( anoMes);
	}
	
}
