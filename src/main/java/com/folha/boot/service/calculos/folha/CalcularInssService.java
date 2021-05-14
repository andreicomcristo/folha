package com.folha.boot.service.calculos.folha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasPrevidencia;
import com.folha.boot.service.FaixasPrevidenciaNomeService;
import com.folha.boot.service.FaixasPrevidenciaSevice;

@Service
@Transactional(readOnly = false)
public class CalcularInssService {

	@Autowired
	private  FaixasPrevidenciaSevice faixasPrevidenciaSevice;
	
	public Double valorInss(Double valor, AnoMes anoMes) {
		Double resposta = 0.0;
		List<FaixasPrevidencia> listaFaixas = faixasPrevidenciaSevice.buscarPorAnoMesExato(anoMes);
			for(int i=0;i<listaFaixas.size();i++) {
				if(valor>=listaFaixas.get(i).getBaseCalculoValorInicial() && valor<=listaFaixas.get(i).getBaseCalculoValorFinal()) {
					resposta = (valor*(listaFaixas.get(i).getAliquota()/100)) - (listaFaixas.get(i).getParcelaADevolver()) + (listaFaixas.get(i).getParcelaASubtrair()) ;
					if(resposta<0) {resposta=0.0;}
					break;
				}
			}
		return resposta;
	}
	
}
