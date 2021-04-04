package com.folha.boot.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.EscalaReposytoty;
import com.folha.boot.Reposytory.PessoaDocumentosReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;
import com.folha.boot.service.util.UtilidadesMatematicas;

@Service
@Transactional(readOnly = false)
public class EscalaCalculosService {

	@Autowired
	private EscalaReposytoty reposytory;
	@Autowired
	private	UtilidadesDeCalendarioEEscala utilidadesDeCalendarioEEscala;
	@Autowired
	private	UtilidadesMatematicas utilidadesMatematicas;
	@Autowired
	private	TurnosService turnosService;
	@Autowired
	private	SimNaoService simNaoService;
	
	public String obtemNomeDiaColuna(String anoMes, int coluna) {
		Date dataColuna = new Date( Integer.parseInt(anoMes.substring(0, 4))-1900 , Integer.parseInt(anoMes.substring(4, 6))-1, coluna);
		String nomeColuna = "";
		switch (dataColuna.getDay()) {
			case 0:
				nomeColuna = "DOM"; break;
			case 1:
				nomeColuna = "SEG"; break;
			case 2:
				nomeColuna = "TER"; break;
			case 3:
				nomeColuna = "QUA"; break;
			case 4:
				nomeColuna = "QUI"; break;
			case 5:
				nomeColuna = "SEX"; break;
			case 6:
				nomeColuna = "SAB"; break;
		}
		return nomeColuna;
	}
	
	public int quantidadeDeDiasNoMes(String anoMesDaEscala) {
		return utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(anoMesDaEscala);
	}
	
	public double quantidadeDePlantoesNaEscala(Escala escala) {
		return utilidadesDeCalendarioEEscala.plantoesNaEscala(escala);
	}
	
	public int quantidadeDeHorasTotaisNaEscala(Escala escala) {
		return utilidadesDeCalendarioEEscala.horasTotaisEscala(escala);
	}
	
	public int quantidadeDeHorasDiaNaEscala(Escala escala) {
		return utilidadesDeCalendarioEEscala.horasDiaEscala(escala);
	}
	
	public int quantidadeDeHorasNoiteNaEscala(Escala escala) {
		return utilidadesDeCalendarioEEscala.horasNoiteEscala(escala);
	}
	
	public int quantidadeDeHorasSemanaNaEscala(Escala escala) {
		return utilidadesDeCalendarioEEscala.horasSemanaEscala(escala);
	}
	
	public int quantidadeDeHorasFimDeSemanaNaEscala(Escala escala) {
		return utilidadesDeCalendarioEEscala.horasFimDeSemanaEscala(escala);
	}
	
	public Escala calcularDadosEscala(Escala escala) {
		escala.setHorasTotais(quantidadeDeHorasTotaisNaEscala(escala));
		escala.setHorasDia(quantidadeDeHorasDiaNaEscala(escala));
		escala.setHorasNoite(quantidadeDeHorasNoiteNaEscala(escala));
		escala.setHorasSemana(quantidadeDeHorasSemanaNaEscala(escala));
		escala.setHorasFimSemana(quantidadeDeHorasFimDeSemanaNaEscala(escala));
		escala.setPlantoes( utilidadesMatematicas.ajustaValorDecimal( quantidadeDePlantoesNaEscala(escala),2));
	return escala;	
	}
	
	public Escala converteTurnoNuloEmFolga(Escala escala) {
		if(escala.getDia01Fk()==null) {escala.setDia01Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia02Fk()==null) {escala.setDia02Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia03Fk()==null) {escala.setDia03Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia04Fk()==null) {escala.setDia04Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia05Fk()==null) {escala.setDia05Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia06Fk()==null) {escala.setDia06Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia07Fk()==null) {escala.setDia07Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia08Fk()==null) {escala.setDia08Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia09Fk()==null) {escala.setDia09Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia10Fk()==null) {escala.setDia10Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia11Fk()==null) {escala.setDia11Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia12Fk()==null) {escala.setDia12Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia13Fk()==null) {escala.setDia13Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia14Fk()==null) {escala.setDia14Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia15Fk()==null) {escala.setDia15Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia16Fk()==null) {escala.setDia16Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia17Fk()==null) {escala.setDia17Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia18Fk()==null) {escala.setDia18Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia19Fk()==null) {escala.setDia19Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia20Fk()==null) {escala.setDia20Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia21Fk()==null) {escala.setDia21Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia22Fk()==null) {escala.setDia22Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia23Fk()==null) {escala.setDia23Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia24Fk()==null) {escala.setDia24Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia25Fk()==null) {escala.setDia25Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia26Fk()==null) {escala.setDia26Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia27Fk()==null) {escala.setDia27Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia28Fk()==null) {escala.setDia28Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia29Fk()==null) {escala.setDia29Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia30Fk()==null) {escala.setDia30Fk(turnosService.buscarPorNome(""));}
		if(escala.getDia31Fk()==null) {escala.setDia31Fk(turnosService.buscarPorNome(""));}
		
		if(escala.getIdLiberacaoDobraInvertidaSimNaoFk()==null) {escala.setIdLiberacaoDobraInvertidaSimNaoFk(simNaoService.buscarPorSigla("N").get(0));}
		
		return escala;
	}
	
}
