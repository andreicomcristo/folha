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
	
	
	
}
