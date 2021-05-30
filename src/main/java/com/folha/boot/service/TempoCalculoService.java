package com.folha.boot.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.FaixasValoresParametrosCalculoFolhasExtrasReposytory;
import com.folha.boot.Reposytory.TempoCalculoReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.TempoCalculo;
import com.folha.boot.domain.Unidades;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
@Transactional(readOnly = false)
public class TempoCalculoService {

	@Autowired
	private TempoCalculoReposytory reposytory;
	
	
	public void salvar(TempoCalculo tempoCalculo) {
		// TODO Auto-generated method stub
		
		if(reposytory.findAll().size()>0 && tempoCalculo.getId()==null) {
			reposytory.deleteAll();
		}
		
		reposytory.save(tempoCalculo);
	}

	public void editar(TempoCalculo tempoCalculo) {
		// TODO Auto-generated method stub
		
		if(reposytory.findAll().size()>0 && tempoCalculo.getId()==null) {
			reposytory.deleteAll();
		}
		
		reposytory.save(tempoCalculo);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public TempoCalculo buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public TempoCalculo buscarPrimeiro() {
		// TODO Auto-generated method stub
		return reposytory.findFirstBy();
	}

	@Transactional(readOnly = true)
	public List<TempoCalculo> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	
	
	public Page<TempoCalculo> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAll(pageable);
	}

	
	
	
	

	
}
