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
public class EscalaService {

	@Autowired
	private EscalaReposytoty reposytory;
	@Autowired
	private	UtilidadesDeCalendarioEEscala utilidadesDeCalendarioEEscala;
	@Autowired
	private	UtilidadesMatematicas utilidadesMatematicas;
	
	public void salvar(Escala escala) {
		// TODO Auto-generated method stub
		reposytory.save(escala);
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
	
	public Escala atalhoA(Escala escala) {
		int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
		
		escala.setDia01Fk(null);//MT
		escala.setDia02Fk(null);//N
		//escala.setDia03Fk(null);
		//escala.setDia04Fk(null);
		//escala.setDia05Fk(null);
		//escala.setDia06Fk(null);
		
		escala.setDia07Fk(null);//MT
		escala.setDia08Fk(null);//N
		//escala.setDia09Fk(null);
		//escala.setDia10Fk(null);
		//escala.setDia11Fk(null);
		//escala.setDia12Fk(null);
		
		escala.setDia13Fk(null);//MT
		escala.setDia14Fk(null);//N
		//escala.setDia15Fk(null);
		//escala.setDia16Fk(null);
		//escala.setDia17Fk(null);
		//escala.setDia18Fk(null);
		
		escala.setDia19Fk(null);//MT
		escala.setDia20Fk(null);//N
		//escala.setDia21Fk(null);
		//escala.setDia22Fk(null);
		//escala.setDia23Fk(null);
		//escala.setDia24Fk(null);
		
		escala.setDia25Fk(null);//MT
		escala.setDia26Fk(null);//N
		//escala.setDia27Fk(null);
		//escala.setDia28Fk(null);
		//if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}
		//if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}
		
		if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//MT
		
		
	return escala;	
	}
	
	public Escala atalhoB(Escala escala) {
		int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
		
		//escala.setDia01Fk(null);//
		escala.setDia02Fk(null);//MT
		escala.setDia03Fk(null);//N
		//escala.setDia04Fk(null);
		//escala.setDia05Fk(null);
		//escala.setDia06Fk(null);
		
		//escala.setDia07Fk(null);
		escala.setDia08Fk(null);//MT
		escala.setDia09Fk(null);//N
		//escala.setDia10Fk(null);
		//escala.setDia11Fk(null);
		//escala.setDia12Fk(null);
		
		//escala.setDia13Fk(null);
		escala.setDia14Fk(null);//MT
		escala.setDia15Fk(null);//N
		//escala.setDia16Fk(null);
		//escala.setDia17Fk(null);
		//escala.setDia18Fk(null);
		
		//escala.setDia19Fk(null);
		escala.setDia20Fk(null);//MT
		escala.setDia21Fk(null);//N
		//escala.setDia22Fk(null);
		//escala.setDia23Fk(null);
		//escala.setDia24Fk(null);
		
		//escala.setDia25Fk(null);
		escala.setDia26Fk(null);//MT
		escala.setDia27Fk(null);//N
		//escala.setDia28Fk(null);
		//if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}
		//if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}
		
		//if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}
		
		
	return escala;	
	}
	
	public Escala atalhoC(Escala escala) {
		int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
		
		//escala.setDia01Fk(null);
		//escala.setDia02Fk(null);
		escala.setDia03Fk(null);//MT
		escala.setDia04Fk(null);//N
		//escala.setDia05Fk(null);
		//escala.setDia06Fk(null);
		
		//escala.setDia07Fk(null);
		//escala.setDia08Fk(null);
		escala.setDia09Fk(null);//MT
		escala.setDia10Fk(null);//N
		//escala.setDia11Fk(null);
		//escala.setDia12Fk(null);
		
		//escala.setDia13Fk(null);
		//escala.setDia14Fk(null);
		escala.setDia15Fk(null);//MT
		escala.setDia16Fk(null);//N
		//escala.setDia17Fk(null);
		//escala.setDia18Fk(null);
		
		//escala.setDia19Fk(null);
		//escala.setDia20Fk(null);
		escala.setDia21Fk(null);//MT
		escala.setDia22Fk(null);//N
		//escala.setDia23Fk(null);
		//escala.setDia24Fk(null);
		
		//escala.setDia25Fk(null);
		//escala.setDia26Fk(null);
		escala.setDia27Fk(null);//MT
		escala.setDia28Fk(null);//N
		//if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}
		//if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}
		
		//if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}
		
		
	return escala;	
	}
	
	public Escala atalhoD(Escala escala) {
		int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
		
		//escala.setDia01Fk(null);
		//escala.setDia02Fk(null);
		//escala.setDia03Fk(null);
		escala.setDia04Fk(null);//MT
		escala.setDia05Fk(null);//N
		//escala.setDia06Fk(null);
		
		//escala.setDia07Fk(null);
		//escala.setDia08Fk(null);
		//escala.setDia09Fk(null);
		escala.setDia10Fk(null);//MT
		escala.setDia11Fk(null);//N
		//escala.setDia12Fk(null);
		
		//escala.setDia13Fk(null);
		//escala.setDia14Fk(null);
		//escala.setDia15Fk(null);
		escala.setDia16Fk(null);//MT
		escala.setDia17Fk(null);//N
		//escala.setDia18Fk(null);
		
		//escala.setDia19Fk(null);
		//escala.setDia20Fk(null);
		//escala.setDia21Fk(null);
		escala.setDia22Fk(null);//MT
		escala.setDia23Fk(null);//N
		//escala.setDia24Fk(null);
		
		//escala.setDia25Fk(null);
		//escala.setDia26Fk(null);
		//escala.setDia27Fk(null);
		escala.setDia28Fk(null);//MT
		if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//N
		//if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}
		
		//if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}
		
		
	return escala;	
	}
	
	public Escala atalhoE(Escala escala) {
		int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
		
		//escala.setDia01Fk(null);//
		//escala.setDia02Fk(null);
		//escala.setDia03Fk(null);
		//escala.setDia04Fk(null);
		escala.setDia05Fk(null);//MT
		escala.setDia06Fk(null);//N
		
		//escala.setDia07Fk(null);
		//escala.setDia08Fk(null);
		//escala.setDia09Fk(null);
		//escala.setDia10Fk(null);
		escala.setDia11Fk(null);//MT
		escala.setDia12Fk(null);//N
		
		//escala.setDia13Fk(null);
		//escala.setDia14Fk(null);
		//escala.setDia15Fk(null);
		//escala.setDia16Fk(null);
		escala.setDia17Fk(null);//MT
		escala.setDia18Fk(null);//N
		
		//escala.setDia19Fk(null);
		//escala.setDia20Fk(null);
		//escala.setDia21Fk(null);
		//escala.setDia22Fk(null);
		escala.setDia23Fk(null);//MT
		escala.setDia24Fk(null);//N
		
		//escala.setDia25Fk(null);
		//escala.setDia26Fk(null);
		//escala.setDia27Fk(null);
		//escala.setDia28Fk(null);
		if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//MT
		if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//N
		
		//if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}
		
		
	return escala;	
	}
	
	public Escala atalhoF(Escala escala) {
		int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
		
		escala.setDia01Fk(null);//N
		//escala.setDia02Fk(null);
		//escala.setDia03Fk(null);
		//escala.setDia04Fk(null);
		//escala.setDia05Fk(null);
		escala.setDia06Fk(null);//MT
		
		escala.setDia07Fk(null);//N
		//escala.setDia08Fk(null);
		//escala.setDia09Fk(null);
		//escala.setDia10Fk(null);
		//escala.setDia11Fk(null);
		escala.setDia12Fk(null);//MT
		
		escala.setDia13Fk(null);//N
		//escala.setDia14Fk(null);
		//escala.setDia15Fk(null);
		//escala.setDia16Fk(null);
		//escala.setDia17Fk(null);
		escala.setDia18Fk(null);//MT
		
		escala.setDia19Fk(null);//N
		//escala.setDia20Fk(null);
		//escala.setDia21Fk(null);
		//escala.setDia22Fk(null);
		//escala.setDia23Fk(null);
		escala.setDia24Fk(null);//MT
		
		escala.setDia25Fk(null);//N
		//escala.setDia26Fk(null);
		//escala.setDia27Fk(null);
		//escala.setDia28Fk(null);
		//if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}
		if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//MT
		
		if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//N
		
		
	return escala;	
	}
	
}
