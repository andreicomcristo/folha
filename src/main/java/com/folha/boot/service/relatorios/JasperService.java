package com.folha.boot.service.relatorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class JasperService {
	
	@Autowired
	private Connection connection;
	
	private Map<String, Object> params = new HashMap<>();
	
	/*public void addParams(String key, Object value) {
		this.params.put(key, value);
	}**/
	
	public byte[] exportarPDF() {
		byte[] bytes = null;
		try {
			var inputStream = this.getClass().getResourceAsStream("/jasper/funcionarios-01.jasper");
			
			var parametros = new HashMap<String, Object>();
			
			parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
			
			//File file = ResourceUtils.getFile(JASPER_DIRETORIO.concat(JASPER_PREFIXO).concat(code).concat(JASPER_SUFIXO));
			
			//JasperPrint print = JasperFillManager.fillReport(file.getAbsolutePath(), params, connection);
			JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, connection);
			
			bytes = JasperExportManager.exportReportToPdf(print);
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;		
	}
}
