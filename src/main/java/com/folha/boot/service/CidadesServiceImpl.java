package com.folha.boot.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import com.folha.boot.Reposytory.CidadesReposytory;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Uf;

@Service
@Transactional(readOnly = false)
public class CidadesServiceImpl implements CidadesService{

	@Autowired
	private CidadesReposytory reposytory;
	
	@Override
	public void salvar(Cidades cidades) {
		// TODO Auto-generated method stub
		reposytory.save(cidades);
	}

	@Override
	public void editar(Cidades cidades) {
		// TODO Auto-generated method stub
		reposytory.save(cidades);	
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Cidades buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cidades> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeCidadeAsc();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Cidades> buscarDuzentos() {
		// TODO Auto-generated method stub
		List<Cidades> lista = reposytory.findAllByOrderByNomeCidadeAsc();
		if (lista.size() > 300) {
			for (int i = lista.size() - 1; i > 200; i--) {
				lista.remove(i);
			}			
		}
		return lista;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Cidades> buscarPorNome(String nomeCidade) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeCidadeContainingOrderByNomeCidadeAsc(nomeCidade);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Cidades> buscarPorIdUf(Uf uf) {
		// TODO Auto-generated method stub
		return reposytory.findByIdUfFk(uf);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Cidades> buscarDuzentos(Uf uf) {
		// TODO Auto-generated method stub
		List<Cidades> lista = reposytory.findByIdUfFk(uf);
		if (lista.size() > 300) {
			for (int i = lista.size() - 1; i > 200; i--) {
				lista.remove(i);
			}			
		}
		return lista;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Cidades> buscarDuzentos(String nomeCidade) {
		// TODO Auto-generated method stub
		List<Cidades> lista = reposytory.findByNomeCidadeContainingOrderByNomeCidadeAsc(nomeCidade.toUpperCase().trim());
		if (lista.size() > 300) {
			for (int i = lista.size() - 1; i > 200; i--) {
				lista.remove(i);
			}			
		}
		return lista;
	}

	@Override
	public Page<Cidades> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByNomeCidadeAsc(pageable);
	}

	@Override
	public Page<Cidades> findPaginatedNome(int pageNo, int pageSize, String nomeCidade) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByNomeCidadeContainingOrderByNomeCidadeAsc(nomeCidade.toUpperCase().trim(), pageable);
	}

	@Override
	public Page<Cidades> findPaginatedEstado(int pageNo, int pageSize, Uf uf) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUfFkOrderByNomeCidadeAsc(uf, pageable);
	}
	
	@Override
	public ByteArrayInputStream exportarExcel(List<Cidades> listaCidades) {
		try(Workbook workbook = new XSSFWorkbook()){
			Sheet sheet = workbook.createSheet("Cidades");
			
			Row row = sheet.createRow(0);
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        // Creating header
	        
	        Cell cell = row.createCell(0);
	        cell.setCellValue("Ordem");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(1);
	        cell.setCellValue("Id");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(2);
	        cell.setCellValue("Cidade");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(3);
	        cell.setCellValue("Estado/Província");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(4);
	        cell.setCellValue("UF");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(5);
	        cell.setCellValue("Pais");
	        cell.setCellStyle(headerCellStyle);
	        
	        // Creating data rows for each customer
	        for(int i = 0; i < listaCidades.size(); i++) {
	        	Row dataRow = sheet.createRow(i + 1);
	        	dataRow.createCell(0).setCellValue((i+1));
	        	dataRow.createCell(1).setCellValue(listaCidades.get(i).getId());
	        	dataRow.createCell(2).setCellValue(listaCidades.get(i).getNomeCidade());
	        	dataRow.createCell(3).setCellValue(listaCidades.get(i).getIdUfFk().getNomeUf());
	        	dataRow.createCell(4).setCellValue(listaCidades.get(i).getIdUfFk().getSiglaUf());
	        	dataRow.createCell(5).setCellValue(listaCidades.get(i).getIdPaisFk().getNomePais());
	        }
	
	        // Making size of column auto resize to fit with data
	        sheet.autoSizeColumn(0);
	        sheet.autoSizeColumn(1);
	        sheet.autoSizeColumn(2);
	        sheet.autoSizeColumn(3);
	        sheet.autoSizeColumn(4);
	        sheet.autoSizeColumn(5);
	        
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        workbook.write(outputStream);
	        return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	
	
}
