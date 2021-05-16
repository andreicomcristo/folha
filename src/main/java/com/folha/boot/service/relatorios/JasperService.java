package com.folha.boot.service.relatorios;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class JasperService {
	
	@Autowired
	private Connection connection;
	private Map<String, Object> parametros = new HashMap<>();
	private String caminho;
	
	public void addParametros(String key, Object value) {
		this.parametros.put(key, value);
	}
	
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public byte[] gerarRelatorio() {
		byte[] bytes = null;
		try {
			var inputStream = this.getClass().getResourceAsStream(caminho);		
			parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));						
			JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, connection);		
			bytes = JasperExportManager.exportReportToPdf(print);
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;		
	}
}
