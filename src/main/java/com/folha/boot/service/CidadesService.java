package com.folha.boot.service;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
public class CidadesService {

	@Autowired
	private CidadesReposytory reposytory;
	
	public void salvar(Cidades cidades) {
		// TODO Auto-generated method stub
		reposytory.save(cidades);
	}

	public void editar(Cidades cidades) {
		// TODO Auto-generated method stub
		reposytory.save(cidades);	
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);		
	}

	@Transactional(readOnly = true)
	public Cidades buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<Cidades> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeCidadeAsc();
	}
	
	@Transactional(readOnly = true)
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
	public List<Cidades> buscarPorNome(String nomeCidade) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeCidadeContainingOrderByNomeCidadeAsc(nomeCidade);
	}
	
	@Transactional(readOnly = true)
	public List<Cidades> buscarPorIdUf(Uf uf) {
		// TODO Auto-generated method stub
		return reposytory.findByIdUfFk(uf);
	}
	
	/*@Transactional(readOnly = true)
	public List<Cidades> buscarDuzentos(Uf uf) {
		// TODO Auto-generated method stub
		List<Cidades> lista = reposytory.findByIdUfFk(uf);
		if (lista.size() > 300) {
			for (int i = lista.size() - 1; i > 200; i--) {
				lista.remove(i);
			}			
		}
		return lista;
	}*/
	
	/*@Transactional(readOnly = true)
	public List<Cidades> buscarDuzentos(String nomeCidade) {
		// TODO Auto-generated method stub
		List<Cidades> lista = reposytory.findByNomeCidadeContainingOrderByNomeCidadeAsc(nomeCidade.toUpperCase().trim());
		if (lista.size() > 300) {
			for (int i = lista.size() - 1; i > 200; i--) {
				lista.remove(i);
			}			
		}
		return lista;
	}*/
	@Transactional(readOnly = true)
	public Page<Cidades> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByNomeCidadeAsc(pageable);
	}

	@Transactional(readOnly = true)
	public Page<Cidades> findPaginatedNome(int pageNo, int pageSize, String nomeCidade) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByNomeCidadeContainingOrderByNomeCidadeAsc(nomeCidade.toUpperCase().trim(), pageable);
	}

	@Transactional(readOnly = true)
	public Page<Cidades> findPaginatedEstado(int pageNo, int pageSize, Uf uf) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUfFkOrderByNomeCidadeAsc(uf, pageable);
	}
			
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

	public ByteArrayInputStream exportarPdf(List<Cidades> listaCidades) {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(6);
			table.setWidthPercentage(90);
			table.setWidths(new int[] { 2, 2, 6, 6, 2, 6 });

			// Tipos de Fonte
			Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14);
			Font cabecalhoFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,8);
			Font corpoFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8);
			Font nomeSistemaFont = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 6);
			Font rodapeFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 4);
			
			//Cabeçalho
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Ordem", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Id", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Cidade", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Estado/Provincia", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("UF", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Pais", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			// Corpo
			for (int i=0; i<listaCidades.size();i++) {

				PdfPCell cell;

				cell = new PdfPCell(new Phrase( String.valueOf(i+1) ,corpoFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase( String.valueOf( listaCidades.get(i).getId()) ,corpoFont) );
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(listaCidades.get(i).getNomeCidade() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(listaCidades.get(i).getIdUfFk().getNomeUf() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(listaCidades.get(i).getIdUfFk().getSiglaUf() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			
				cell = new PdfPCell(new Phrase(listaCidades.get(i).getIdPaisFk().getNomePais() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);		
			}
			
			// Titulo
			
			PdfPTable tableTitulo = new PdfPTable(1);
			tableTitulo.setWidthPercentage(90);
			tableTitulo.setWidths(new int[] { 6 });
			PdfPCell cellTitulo;
			cellTitulo = new PdfPCell(new Phrase("Cidades", tituloFont) );
			cellTitulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableTitulo.addCell(cellTitulo);
						
			// Rodape
			PdfPTable tableRodape = new PdfPTable(1);
			tableRodape.setWidthPercentage(90);
			tableRodape.setWidths(new int[] { 6 });
			PdfPCell cellRodape;
			
			cellRodape = new PdfPCell(new Phrase("Sistema Gente-Web", nomeSistemaFont) );
			cellRodape.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellRodape.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableRodape.addCell(cellRodape);
			
			cellRodape = new PdfPCell(new Phrase(""+new Date() ,rodapeFont)  );
			cellRodape.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellRodape.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableRodape.addCell(cellRodape);
			
			

			PdfWriter.getInstance(document, out);
			document.open();
			document.add(tableTitulo);
			document.add(table);
			document.add(tableRodape);

			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}

	
	
}
