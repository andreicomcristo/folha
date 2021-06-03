package com.folha.boot.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import com.folha.boot.Reposytory.RubricaPensaoReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.RubricaPensao;
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
public class RubricaPensaoService {

	@Autowired
	private RubricaPensaoReposytory reposytory;
	
	@Autowired
	private AnoMesService anoMesService;

	public void salvar(RubricaPensao rubricaPensao) {
		// TODO Auto-generated method stub
		reposytory.save(rubricaPensao);
	}

	public void editar(RubricaPensao rubricaPensao) {
		// TODO Auto-generated method stub
		reposytory.save(rubricaPensao);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public RubricaPensao buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<RubricaPensao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc();
	}
	
	@Transactional(readOnly = true)
	public List<RubricaPensao> buscarListaParaPensaoNotemplateCadastro(Pessoa pessoa) {
		// TODO Auto-generated method stub
		List<RubricaPensao> lista = new ArrayList<>();
		RubricaPensao rubricaPensao = buscarPrimeiroPorPessoa(pessoa);
		
		if(rubricaPensao!= null) {
			AnoMes anoMes = rubricaPensao.getIdAnoMesFk();
			lista = reposytory.findByIdAnoMesFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(anoMes, pessoa);
		}
		
		return lista;
	}
	
	@Transactional(readOnly = true)
	public RubricaPensao buscarPrimeiroPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findFirstByIdPessoaFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(pessoa);
	}
	
	
	
	public List<RubricaPensao> buscarPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findByIdPessoaFkOrderByIdAnoMesFkNomeAnoMesDesc(pessoa);
	}
	@Transactional(readOnly = true)
	public List<RubricaPensao> buscarPorMesExato(AnoMes anoMes) {
		return reposytory.findByIdAnoMesFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(anoMes);
	}
	
	@Transactional(readOnly = true)
	public List<RubricaPensao> buscarPorMesEPEssoa(AnoMes anoMes, Pessoa pessoa) {
		return reposytory.findByIdAnoMesFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(anoMes, pessoa);
	}
	
	@Transactional(readOnly = true)
	public List<RubricaPensao> buscarPorNome(String nome) {
		return reposytory.findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(nome);
	}
		
	public Page<RubricaPensao> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(pageable);
	}

	public Page<RubricaPensao> findPaginatedAnoMes(int pageNo, int pageSize, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdAnoMesFkNomeAnoMesContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(nome.toUpperCase().trim(), pageable);
	}
	
	public Page<RubricaPensao> findPaginatedNome(int pageNo, int pageSize, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdPessoaFkNomeAsc(nome.toUpperCase().trim(), pageable);
	}
	
	
	
	//Herdar de um mes para o outro
	public void herdarDeUmMesParaOOutro(Long anoMesInicial, Long anoMesFinal) {
		
		List<RubricaPensao> listaInicial = buscarPorMesExato(anoMesService.buscarPorId(anoMesInicial)); 
		List<RubricaPensao> listaFinal = buscarPorMesExato(anoMesService.buscarPorId(anoMesFinal));
		
		if( (!listaInicial.isEmpty())  &&  (listaFinal.isEmpty()) ) {
			for(int i=0;i<listaInicial.size();i++) {
				RubricaPensao f = new RubricaPensao();
				f.setId(null);
				f.setIdAnoMesFk(anoMesService.buscarPorId(anoMesFinal));
				f.setAgencia( listaInicial.get(i).getAgencia() );
				f.setConta( listaInicial.get(i).getConta() );
				f.setCpfBeneficiario( listaInicial.get(i).getCpfBeneficiario() );
				f.setDvAgencia( listaInicial.get(i).getDvAgencia() );
				f.setDvConta(listaInicial.get(i).getDvConta());
				f.setIdBancoFk(listaInicial.get(i).getIdBancoFk());
				f.setIdPessoaFk(listaInicial.get(i).getIdPessoaFk());
				f.setNomeBeneficiario(listaInicial.get(i).getNomeBeneficiario());
				f.setObservacao(listaInicial.get(i).getObservacao());
				f.setOperacaoVariacao(listaInicial.get(i).getOperacaoVariacao());
				f.setPercentagem(listaInicial.get(i).getPercentagem());
				f.setValor(listaInicial.get(i).getValor());
				
				salvar(f);
			}
		}
	}
	
	
	public ByteArrayInputStream exportarExcel(List<RubricaPensao> lista) {
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
	        cell.setCellValue("Mês");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(3);
	        cell.setCellValue("Nome");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(4);
	        cell.setCellValue("Cpf");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(5);
	        cell.setCellValue("Beneficiário");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(6);
	        cell.setCellValue("Cpf");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(7);
	        cell.setCellValue("Valor");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(8);
	        cell.setCellValue("Percentagem");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(9);
	        cell.setCellValue("Banco");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(10);
	        cell.setCellValue("Op");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(11);
	        cell.setCellValue("Ag");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(12);
	        cell.setCellValue("Dv");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(13);
	        cell.setCellValue("Conta");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(14);
	        cell.setCellValue("Dv");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(15);
	        cell.setCellValue("Obs");
	        cell.setCellStyle(headerCellStyle);
	        
	        
	        // Creating data rows for each customer
	        for(int i = 0; i < lista.size(); i++) {
	        	Row dataRow = sheet.createRow(i + 1);
	        	dataRow.createCell(0).setCellValue((i+1));
	        	dataRow.createCell(1).setCellValue(lista.get(i).getId());
	        	dataRow.createCell(2).setCellValue(lista.get(i).getIdAnoMesFk().getNomeAnoMes());
	        	dataRow.createCell(3).setCellValue(lista.get(i).getIdPessoaFk().getNome());
	        	dataRow.createCell(4).setCellValue(lista.get(i).getIdPessoaFk().getCpf());
	        	dataRow.createCell(5).setCellValue(lista.get(i).getNomeBeneficiario());
	        	dataRow.createCell(6).setCellValue(lista.get(i).getCpfBeneficiario());
	        	dataRow.createCell(7).setCellValue(lista.get(i).getValor());
	        	dataRow.createCell(8).setCellValue(lista.get(i).getPercentagem());
	        	
	        	dataRow.createCell(9).setCellValue(lista.get(i).getIdBancoFk().getCodigoBanco()+"-"+lista.get(i).getIdBancoFk().getNomeBanco());
	        	dataRow.createCell(10).setCellValue(lista.get(i).getOperacaoVariacao());
	        	dataRow.createCell(11).setCellValue(lista.get(i).getAgencia());
	        	dataRow.createCell(12).setCellValue(lista.get(i).getDvAgencia());
	        	dataRow.createCell(13).setCellValue(lista.get(i).getConta());
	        	dataRow.createCell(14).setCellValue(lista.get(i).getDvConta());
	        	
	        	dataRow.createCell(15).setCellValue(lista.get(i).getObservacao());
	        	
	        }
	
	        // Making size of column auto resize to fit with data
	        sheet.autoSizeColumn(0);
	        sheet.autoSizeColumn(1);
	        sheet.autoSizeColumn(2);
	        sheet.autoSizeColumn(3);
	        sheet.autoSizeColumn(4);
	        sheet.autoSizeColumn(5);
	        sheet.autoSizeColumn(6);
	        sheet.autoSizeColumn(7);
	        sheet.autoSizeColumn(8);
	        sheet.autoSizeColumn(9);
	        sheet.autoSizeColumn(10);
	        sheet.autoSizeColumn(11);
	        sheet.autoSizeColumn(12);
	        sheet.autoSizeColumn(13);
	        sheet.autoSizeColumn(14);
	        sheet.autoSizeColumn(15);
	        
	        
	        
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        workbook.write(outputStream);
	        return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ByteArrayInputStream exportarPdf(List<RubricaPensao> lista) {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(16);
			table.setWidthPercentage(90);
			table.setWidths(new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2});

			// Tipos de Fonte
			Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14);
			Font cabecalhoFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,6);
			Font corpoFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 5);
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

			hcell = new PdfPCell(new Phrase("Mês", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Nome", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("CPF", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Beneficiário", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Cpf", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Valor", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Percentagem", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Banco", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Op", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Agência", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Dv", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Conta", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Dv", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Obs", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			
			
			

			// Corpo
			for (int i=0; i<lista.size();i++) {

				PdfPCell cell;

				cell = new PdfPCell(new Phrase( String.valueOf(i+1) ,corpoFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase( String.valueOf( lista.get(i).getId()) ,corpoFont) );
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(lista.get(i).getIdAnoMesFk().getNomeAnoMes() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdPessoaFk().getNome() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdPessoaFk().getCpf() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(  String.valueOf(lista.get(i).getNomeBeneficiario())   ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getCpfBeneficiario() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getValor()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getPercentagem()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getIdBancoFk().getCodigoBanco()+"-"+lista.get(i).getIdBancoFk().getNomeBanco()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getOperacaoVariacao()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getAgencia()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getDvAgencia()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getConta()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getDvConta()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getObservacao()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				
				
				
			
			
			}
			
			// Titulo
			
			PdfPTable tableTitulo = new PdfPTable(1);
			tableTitulo.setWidthPercentage(90);
			tableTitulo.setWidths(new int[] { 6 });
			PdfPCell cellTitulo;
			cellTitulo = new PdfPCell(new Phrase("Pensão", tituloFont) );
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
