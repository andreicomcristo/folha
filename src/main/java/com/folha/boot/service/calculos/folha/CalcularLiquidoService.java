package com.folha.boot.service.calculos.folha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasImpostoDeRenda;
import com.folha.boot.domain.FaixasPrevidencia;
import com.folha.boot.service.FaixasImpostoDeRendaService;
import com.folha.boot.service.FaixasPrevidenciaNomeService;
import com.folha.boot.service.FaixasPrevidenciaSevice;

@Service
@Transactional(readOnly = false)
public class CalcularLiquidoService {

	@Autowired
	private  CalcularInssService calcularInssService;
	@Autowired
	private  CalcularIrService calcularIrService;
	
	public Double calcularLiquido(Double valor, AnoMes anoMes) {
		Double resposta = 0.0;
		resposta = valor - calcularInssService.valorInss(valor, anoMes);
		resposta = resposta - calcularIrService.valorIr(valor, anoMes);
		if(resposta<0) {resposta=0.0;}
		return resposta;
	}
	
}
