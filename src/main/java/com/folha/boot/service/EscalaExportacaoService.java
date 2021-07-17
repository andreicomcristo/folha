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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.EscalaReposytoty;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.EscalaAlteracoes;
import com.folha.boot.domain.EscalaPosTransparencia;
import com.folha.boot.domain.PessoaDocumentosConselho;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
@Transactional(readOnly = false)
public class EscalaExportacaoService {

	@Autowired
	private EscalaReposytoty reposytory;
	
	@Autowired
	private PessoaDocumentosConselhoService pessoaDocumentosConselhoService;
	
	@Autowired
	private EscalaCalculosService escalaCalculosService;
	
	
	public ByteArrayInputStream exportarExcel(List<Escala> lista) {
		try(Workbook workbook = new XSSFWorkbook()){
			Sheet sheet = workbook.createSheet("Cidades");
			
			Row row = sheet.createRow(0);
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        // Creating header
	        
	        Cell cell = row.createCell(0);
	        cell.setCellValue("Ord");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(1);
	        cell.setCellValue("Id");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(2);
	        cell.setCellValue("Mes");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(3);
	        cell.setCellValue("Escala");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(4);
	        cell.setCellValue("Nome");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(5);
	        cell.setCellValue("Cpf");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(6);
	        cell.setCellValue("Matrícula");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(7);
	        cell.setCellValue("CH");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(8);
	        cell.setCellValue("Nível");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(9);
	        cell.setCellValue("Cargo");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(10);
	        cell.setCellValue("Folha");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(11);
	        cell.setCellValue("Regime");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(12);
	        cell.setCellValue("Presencial");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(13);
	        cell.setCellValue("Diferenciado");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(14);
	        cell.setCellValue("Ch Dif");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(15);
	        cell.setCellValue("Incr Risco");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(16);
	        cell.setCellValue("Turma");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(17);
	        cell.setCellValue("Dia 01");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(18);
	        cell.setCellValue("Dia 02");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(19);
	        cell.setCellValue("Dia 03");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(20);
	        cell.setCellValue("Dia 04");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(21);
	        cell.setCellValue("Dia 05");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(22);
	        cell.setCellValue("Dia 06");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(23);
	        cell.setCellValue("Dia 07");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(24);
	        cell.setCellValue("Dia 08");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(25);
	        cell.setCellValue("Dia 09");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(26);
	        cell.setCellValue("Dia 10");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(27);
	        cell.setCellValue("Dia 11");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(28);
	        cell.setCellValue("Dia 12");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(29);
	        cell.setCellValue("Dia 13");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(30);
	        cell.setCellValue("Dia 14");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(31);
	        cell.setCellValue("Dia 15");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(32);
	        cell.setCellValue("Dia 16");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(33);
	        cell.setCellValue("Dia 17");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(34);
	        cell.setCellValue("Dia 18");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(35);
	        cell.setCellValue("Dia 19");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(36);
	        cell.setCellValue("Dia 20");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(37);
	        cell.setCellValue("Dia 21");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(38);
	        cell.setCellValue("Dia 22");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(39);
	        cell.setCellValue("Dia 23");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(40);
	        cell.setCellValue("Dia 24");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(41);
	        cell.setCellValue("Dia 25");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(42);
	        cell.setCellValue("Dia 26");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(43);
	        cell.setCellValue("Dia 27");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(44);
	        cell.setCellValue("Dia 28");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(45);
	        cell.setCellValue("Dia 29");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(46);
	        cell.setCellValue("Dia 30");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(47);
	        cell.setCellValue("Dia 31");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(48);
	        cell.setCellValue("Horas Dia");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(49);
	        cell.setCellValue("Horas Noite");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(50);
	        cell.setCellValue("Horas Semana");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(51);
	        cell.setCellValue("Horas Final de Semana");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(52);
	        cell.setCellValue("Horas Totais");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(53);
	        cell.setCellValue("Coordenação");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(54);
	        cell.setCellValue("Localidade");
	        cell.setCellStyle(headerCellStyle);
	        

	        cell = row.createCell(55);
	        cell.setCellValue("Atividade");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(56);
	        cell.setCellValue("Unidade");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(57);
	        cell.setCellValue("Avaliacao Cumpre Assiduidade (sim/nao)");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(58);
	        cell.setCellValue("Avaliacao Cumpre Permanencia (sim/nao)");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(59);
	        cell.setCellValue("Avaliacao Cumpre Formalizacao (sim/nao)");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(60);
	        cell.setCellValue("Avaliacao Cumpre de Atividades (sim/nao)");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(61);
	        cell.setCellValue("Vinculo");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(62);
	        cell.setCellValue("Ultima Edicao");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(63);
	        cell.setCellValue("Quem Editou");
	        cell.setCellStyle(headerCellStyle);
	        
	        
	        
	        
	        
	        // Creating data rows for each customer
	        for(int i = 0; i < lista.size(); i++) {
	        	Row dataRow = sheet.createRow(i + 1);
	        	dataRow.createCell(0).setCellValue((i+1));
	        	dataRow.createCell(1).setCellValue(lista.get(i).getId());
	        	dataRow.createCell(2).setCellValue(lista.get(i).getIdAnoMesFk().getNomeAnoMes());
	        	dataRow.createCell(3).setCellValue(lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao()+"-"+lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade()+"-"+ lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade() );
	        	dataRow.createCell(4).setCellValue(lista.get(i).getIdFuncionarioFk().getIdPessoaFk().getNome()  );
	        	dataRow.createCell(5).setCellValue(lista.get(i).getIdFuncionarioFk().getIdPessoaFk().getCpf() );
	        	dataRow.createCell(6).setCellValue(lista.get(i).getIdFuncionarioFk().getMatricula() );
	        	dataRow.createCell(7).setCellValue(lista.get(i).getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria() );
	        	dataRow.createCell(8).setCellValue(lista.get(i).getIdFuncionarioFk().getIdCargoAtualFk().getIdNivelCargoFk().getNomeNivelCargo() );
	        	dataRow.createCell(9).setCellValue(lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getNomeCargo()+"-"+lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getNomeEspecialidadeCargo() );
	        	dataRow.createCell(10).setCellValue(lista.get(i).getIdTipoFolhaFk().getNomeTipoFolha() );
	        	dataRow.createCell(11).setCellValue(lista.get(i).getIdRegimeFk().getNomeRegimeDeTrabalho() );
	        	dataRow.createCell(12).setCellValue(lista.get(i).getIdPresencialSimNaoFk().getDescricao() );
	        	dataRow.createCell(13).setCellValue(lista.get(i).getIdComplementoPlantaoSimNaoFk().getDescricao() );
	        	dataRow.createCell(14).setCellValue(lista.get(i).getIdChDifSimNaoFk().getDescricao() );
	        	dataRow.createCell(15).setCellValue(lista.get(i).getIdIncrementoDeRiscoSimNaoFk().getDescricao() );
	        	dataRow.createCell(16).setCellValue(lista.get(i).getIdTurmaFk().getNomeTurma() );
	        	dataRow.createCell(17).setCellValue(lista.get(i).getDia01Fk().getNomeTurno() );
	        	dataRow.createCell(18).setCellValue(lista.get(i).getDia02Fk().getNomeTurno() );
	        	dataRow.createCell(19).setCellValue(lista.get(i).getDia03Fk().getNomeTurno() );
	        	dataRow.createCell(20).setCellValue(lista.get(i).getDia04Fk().getNomeTurno() );
	        	dataRow.createCell(21).setCellValue(lista.get(i).getDia05Fk().getNomeTurno() );
	        	dataRow.createCell(22).setCellValue(lista.get(i).getDia06Fk().getNomeTurno() );
	        	dataRow.createCell(23).setCellValue(lista.get(i).getDia07Fk().getNomeTurno() );
	        	dataRow.createCell(24).setCellValue(lista.get(i).getDia08Fk().getNomeTurno() );
	        	dataRow.createCell(25).setCellValue(lista.get(i).getDia09Fk().getNomeTurno() );
	        	dataRow.createCell(26).setCellValue(lista.get(i).getDia10Fk().getNomeTurno() );
	        	dataRow.createCell(27).setCellValue(lista.get(i).getDia11Fk().getNomeTurno() );
	        	dataRow.createCell(28).setCellValue(lista.get(i).getDia12Fk().getNomeTurno() );
	        	dataRow.createCell(29).setCellValue(lista.get(i).getDia13Fk().getNomeTurno() );
	        	dataRow.createCell(30).setCellValue(lista.get(i).getDia14Fk().getNomeTurno() );
	        	dataRow.createCell(31).setCellValue(lista.get(i).getDia15Fk().getNomeTurno() );
	        	dataRow.createCell(32).setCellValue(lista.get(i).getDia16Fk().getNomeTurno() );
	        	dataRow.createCell(33).setCellValue(lista.get(i).getDia17Fk().getNomeTurno() );
	        	dataRow.createCell(34).setCellValue(lista.get(i).getDia18Fk().getNomeTurno() );
	        	dataRow.createCell(35).setCellValue(lista.get(i).getDia19Fk().getNomeTurno() );
	        	dataRow.createCell(36).setCellValue(lista.get(i).getDia20Fk().getNomeTurno() );
	        	dataRow.createCell(37).setCellValue(lista.get(i).getDia21Fk().getNomeTurno() );
	        	dataRow.createCell(38).setCellValue(lista.get(i).getDia22Fk().getNomeTurno() );
	        	dataRow.createCell(39).setCellValue(lista.get(i).getDia23Fk().getNomeTurno() );
	        	dataRow.createCell(40).setCellValue(lista.get(i).getDia24Fk().getNomeTurno() );
	        	dataRow.createCell(41).setCellValue(lista.get(i).getDia25Fk().getNomeTurno() );
	        	dataRow.createCell(42).setCellValue(lista.get(i).getDia26Fk().getNomeTurno() );
	        	dataRow.createCell(43).setCellValue(lista.get(i).getDia27Fk().getNomeTurno() );
	        	dataRow.createCell(44).setCellValue(lista.get(i).getDia28Fk().getNomeTurno() );
	        	dataRow.createCell(45).setCellValue(lista.get(i).getDia29Fk().getNomeTurno() );
	        	dataRow.createCell(46).setCellValue(lista.get(i).getDia30Fk().getNomeTurno() );
	        	dataRow.createCell(47).setCellValue(lista.get(i).getDia31Fk().getNomeTurno() );
	        	
	        	dataRow.createCell(48).setCellValue(lista.get(i).getHorasDia() );
	        	dataRow.createCell(49).setCellValue(lista.get(i).getHorasNoite() );
	        	dataRow.createCell(50).setCellValue(lista.get(i).getHorasSemana() );
	        	dataRow.createCell(51).setCellValue(lista.get(i).getHorasFimSemana() );
	        	dataRow.createCell(52).setCellValue(lista.get(i).getHorasTotais() );
	        	
	        	dataRow.createCell(53).setCellValue(lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao() );
	        	dataRow.createCell(54).setCellValue(lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade() );
	        	dataRow.createCell(55).setCellValue(lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade() );
	        	dataRow.createCell(56).setCellValue(lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk().getNomeFantasia() );
	        	
	        	dataRow.createCell(57).setCellValue(lista.get(i).getIdAvaliacaoAssiduidadeFk().getDescricao() );
	        	dataRow.createCell(58).setCellValue(lista.get(i).getIdAvaliacaoPermanenciaFk().getDescricao() );
	        	dataRow.createCell(59).setCellValue(lista.get(i).getIdAvaliacaoFormalizacaoPontoFk().getDescricao() );
	        	dataRow.createCell(60).setCellValue(lista.get(i).getIdAvaliacaoAtividadesBurocraticasFk().getDescricao() );
	        	
	        	dataRow.createCell(61).setCellValue(lista.get(i).getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo() );
	        	
	        	dataRow.createCell(62).setCellValue(lista.get(i).getDtMudanca().getDate()+"/"+(lista.get(i).getDtMudanca().getMonth()+1)+"/"+(lista.get(i).getDtMudanca().getYear()+1900)  );
	        	dataRow.createCell(63).setCellValue(lista.get(i).getIdOperadorMudancaFk().getIdPessoaFk().getNome() );
	        	
	        	
	        	
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
	        sheet.autoSizeColumn(16);
	        sheet.autoSizeColumn(17);
	        sheet.autoSizeColumn(18);
	        sheet.autoSizeColumn(19);
	        sheet.autoSizeColumn(20);
	        sheet.autoSizeColumn(21);
	        sheet.autoSizeColumn(22);
	        sheet.autoSizeColumn(23);
	        sheet.autoSizeColumn(24);
	        sheet.autoSizeColumn(25);
	        sheet.autoSizeColumn(26);
	        sheet.autoSizeColumn(27);
	        sheet.autoSizeColumn(28);
	        sheet.autoSizeColumn(29);
	        sheet.autoSizeColumn(30);
	        sheet.autoSizeColumn(31);
	        sheet.autoSizeColumn(32);
	        sheet.autoSizeColumn(33);
	        sheet.autoSizeColumn(34);
	        sheet.autoSizeColumn(35);
	        sheet.autoSizeColumn(36);
	        sheet.autoSizeColumn(37);
	        sheet.autoSizeColumn(38);
	        sheet.autoSizeColumn(39);
	        sheet.autoSizeColumn(40);
	        sheet.autoSizeColumn(41);
	        sheet.autoSizeColumn(42);
	        sheet.autoSizeColumn(43);
	        sheet.autoSizeColumn(44);
	        sheet.autoSizeColumn(45);
	        sheet.autoSizeColumn(46);
	        sheet.autoSizeColumn(47);
	        sheet.autoSizeColumn(48);
	        sheet.autoSizeColumn(49);
	        sheet.autoSizeColumn(50);
	        sheet.autoSizeColumn(51);
	        sheet.autoSizeColumn(52);
	        sheet.autoSizeColumn(53);
	        sheet.autoSizeColumn(54);
	        sheet.autoSizeColumn(55);
	        sheet.autoSizeColumn(56);
	        sheet.autoSizeColumn(57);
	        sheet.autoSizeColumn(58);
	        sheet.autoSizeColumn(59);
	        sheet.autoSizeColumn(60);
	        sheet.autoSizeColumn(61);
	        sheet.autoSizeColumn(62);
	        sheet.autoSizeColumn(63);
	        
	        
	        
	        
	        
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        workbook.write(outputStream);
	        return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ByteArrayInputStream exportarPdf(List<Escala> lista) {

		Document document = new Document(PageSize.A4.rotate(),0,0,10,10);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(64);
			table.setWidthPercentage(97);
			table.setWidths(new int[] { 1, 1, 2, 4, 4, 3, 2, 1, 1, 4,  2, 2, 1, 1, 1, 1, 2, 1, 1, 1,  1, 1, 1, 1, 1, 1, 1, 1, 1, 1,  1, 1, 1, 1, 1, 1, 1, 1, 1, 1,  1, 1, 1, 1, 1, 1, 1, 1, 2, 2,  2, 2, 2, 2, 2, 2, 4, 2, 2, 2,  2, 2, 2, 4 });

			// Tipos de Fonte
			Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,6);
			Font cabecalhoFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,3);
			Font corpoFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 3);
			Font nomeSistemaFont = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 6);
			Font rodapeFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 3);
			
			//Cabeçalho
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Ord", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Id", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Mes", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Escala", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Nome", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Cpf", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Matr", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Ch", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Niv", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Cargo", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Folha", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Regime", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Pres", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Dif", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Ch Dif", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("In Ri", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Turma", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("01", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("02", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("03", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("04", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("05", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("06", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("07", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("08", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("09", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("10", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("11", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("12", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("13", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("14", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("15", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("16", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("17", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("18", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("19", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("20", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("21", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("22", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("23", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("24", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("25", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("26", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("27", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("28", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("29", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("30", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("31", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Horas Dia", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Horas Noite", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Horas Semana", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Horas Fim Semana", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Horas Totais", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Coordenacao", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Localidade", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Atividade", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Unidade", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Avaliacao Cumpre Assiduidade", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Avaliacao Cumpre Permanencia", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Avaliacao Cumpre Formalizacao", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Avaliacao Cumpre Atividades", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Vinculo", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Ultima Edicao", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Quem Editou", cabecalhoFont));
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
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao()+"-"+lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade()+"-"+ lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdPessoaFk().getNome() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdPessoaFk().getCpf() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getMatricula() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getNomeCargo()+"-"+lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getNomeEspecialidadeCargo() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdTipoFolhaFk().getNomeTipoFolha() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdRegimeFk().getNomeRegimeDeTrabalho() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdPresencialSimNaoFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdComplementoPlantaoSimNaoFk().getDescricao() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdChDifSimNaoFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdIncrementoDeRiscoSimNaoFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdTurmaFk().getNomeTurma() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia01Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia02Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia03Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia04Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia05Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia06Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia07Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia08Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia09Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia10Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia11Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia12Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia13Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia14Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia15Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia16Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia17Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia18Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia19Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia20Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia21Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia22Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia23Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia24Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia25Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia26Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia27Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia28Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia29Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia30Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia31Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasDia()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasNoite()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasSemana()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasFimSemana()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasTotais()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk().getNomeFantasia() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdAvaliacaoAssiduidadeFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdAvaliacaoPermanenciaFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdAvaliacaoFormalizacaoPontoFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdAvaliacaoAtividadesBurocraticasFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDtMudanca().getDate()+"/"+(lista.get(i).getDtMudanca().getMonth()+1)+"/"+(lista.get(i).getDtMudanca().getYear()+1900) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdOperadorMudancaFk().getIdPessoaFk().getNome() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				
				
					
				
			
			
			}
			
			// Titulo
			
			PdfPTable tableTitulo = new PdfPTable(1);
			tableTitulo.setWidthPercentage(97);
			tableTitulo.setWidths(new int[] { 64 });
			PdfPCell cellTitulo;
			cellTitulo = new PdfPCell(new Phrase("Escalas", tituloFont) );
			cellTitulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableTitulo.addCell(cellTitulo);
			
			
			// Rodape
			PdfPTable tableRodape = new PdfPTable(1);
			tableRodape.setWidthPercentage(97);
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

	

	public ByteArrayInputStream exportarPdfSetorial(List<Escala> lista) {

		Document document = new Document(PageSize.A4.rotate(),0,0,10,10);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(44);
			table.setWidthPercentage(97);
			table.setWidths(new int[] { 1,1,2,3,3,1,1,2,2,1,   1,1,1,1,1,1,1,1,1,1,   1,1,1,1,1,1,1,1,1,1,   1,1,1,1,1,1,1,1,1,1,   1,1,1,4 });

			// Tipos de Fonte
			Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,6);
			Font cabecalhoFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,6);
			Font corpoFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6);
			Font nomeSistemaFont = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 6);
			Font rodapeFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 3);
			
			//Cabeçalho
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Ord", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Id", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Mes", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Escala", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Nome", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Ch", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Niv", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Cargo", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Folha", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Turma", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("01", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("02", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("03", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("04", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("05", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("06", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("07", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("08", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("09", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("10", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("11", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("12", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("13", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("14", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("15", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("16", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("17", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("18", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("19", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("20", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("21", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("22", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("23", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("24", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("25", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("26", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("27", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("28", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("29", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("30", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("31", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Hor Tot", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Conselho", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Unidade", cabecalhoFont));
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
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao()+"-"+lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade()+"-"+ lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdPessoaFk().getNome() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getNomeCargo()+"-"+lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getNomeEspecialidadeCargo() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdTipoFolhaFk().getNomeTipoFolha() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdTurmaFk().getNomeTurma() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia01Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia02Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia03Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia04Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia05Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia06Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia07Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia08Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia09Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia10Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia11Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia12Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia13Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia14Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia15Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia16Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia17Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia18Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia19Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia20Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia21Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia22Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia23Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia24Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia25Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia26Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia27Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia28Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia29Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia30Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia31Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasTotais()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				List<PessoaDocumentosConselho> listaConselhos = pessoaDocumentosConselhoService.buscarPorPessoaOrdemDataValidade(lista.get(i).getIdFuncionarioFk().getIdPessoaFk());
				String conselho = "";
				if(!listaConselhos.isEmpty()) {conselho = listaConselhos.get(0).getNumeroConselho();}
				
				cell = new PdfPCell(new Phrase(conselho ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk().getNomeFantasia() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				
			}
			
			// Titulo
			
			PdfPTable tableTitulo = new PdfPTable(1);
			tableTitulo.setWidthPercentage(97);
			tableTitulo.setWidths(new int[] { 64 });
			PdfPCell cellTitulo;
			cellTitulo = new PdfPCell(new Phrase("Escalas", tituloFont) );
			cellTitulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableTitulo.addCell(cellTitulo);
			
			
			// Rodape
			PdfPTable tableRodape = new PdfPTable(1);
			tableRodape.setWidthPercentage(97);
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


	
	public ByteArrayInputStream exportarExcelPosTransparencia(List<EscalaPosTransparencia> lista) {
		try(Workbook workbook = new XSSFWorkbook()){
			Sheet sheet = workbook.createSheet("Cidades");
			
			Row row = sheet.createRow(0);
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        // Creating header
	        
	        Cell cell = row.createCell(0);
	        cell.setCellValue("Ord");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(1);
	        cell.setCellValue("Id");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(2);
	        cell.setCellValue("Mes");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(3);
	        cell.setCellValue("Escala");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(4);
	        cell.setCellValue("Nome");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(5);
	        cell.setCellValue("Cpf");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(6);
	        cell.setCellValue("Matrícula");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(7);
	        cell.setCellValue("CH");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(8);
	        cell.setCellValue("Nível");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(9);
	        cell.setCellValue("Cargo");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(10);
	        cell.setCellValue("Folha");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(11);
	        cell.setCellValue("Regime");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(12);
	        cell.setCellValue("Presencial");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(13);
	        cell.setCellValue("Diferenciado");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(14);
	        cell.setCellValue("Ch Dif");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(15);
	        cell.setCellValue("Incr Risco");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(16);
	        cell.setCellValue("Turma");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(17);
	        cell.setCellValue("Dia 01");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(18);
	        cell.setCellValue("Dia 02");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(19);
	        cell.setCellValue("Dia 03");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(20);
	        cell.setCellValue("Dia 04");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(21);
	        cell.setCellValue("Dia 05");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(22);
	        cell.setCellValue("Dia 06");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(23);
	        cell.setCellValue("Dia 07");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(24);
	        cell.setCellValue("Dia 08");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(25);
	        cell.setCellValue("Dia 09");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(26);
	        cell.setCellValue("Dia 10");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(27);
	        cell.setCellValue("Dia 11");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(28);
	        cell.setCellValue("Dia 12");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(29);
	        cell.setCellValue("Dia 13");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(30);
	        cell.setCellValue("Dia 14");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(31);
	        cell.setCellValue("Dia 15");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(32);
	        cell.setCellValue("Dia 16");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(33);
	        cell.setCellValue("Dia 17");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(34);
	        cell.setCellValue("Dia 18");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(35);
	        cell.setCellValue("Dia 19");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(36);
	        cell.setCellValue("Dia 20");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(37);
	        cell.setCellValue("Dia 21");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(38);
	        cell.setCellValue("Dia 22");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(39);
	        cell.setCellValue("Dia 23");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(40);
	        cell.setCellValue("Dia 24");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(41);
	        cell.setCellValue("Dia 25");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(42);
	        cell.setCellValue("Dia 26");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(43);
	        cell.setCellValue("Dia 27");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(44);
	        cell.setCellValue("Dia 28");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(45);
	        cell.setCellValue("Dia 29");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(46);
	        cell.setCellValue("Dia 30");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(47);
	        cell.setCellValue("Dia 31");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(48);
	        cell.setCellValue("Horas Dia");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(49);
	        cell.setCellValue("Horas Noite");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(50);
	        cell.setCellValue("Horas Semana");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(51);
	        cell.setCellValue("Horas Final de Semana");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(52);
	        cell.setCellValue("Horas Totais");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(53);
	        cell.setCellValue("Coordenação");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(54);
	        cell.setCellValue("Localidade");
	        cell.setCellStyle(headerCellStyle);
	        

	        cell = row.createCell(55);
	        cell.setCellValue("Atividade");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(56);
	        cell.setCellValue("Unidade");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(57);
	        cell.setCellValue("Avaliacao Cumpre Assiduidade (sim/nao)");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(58);
	        cell.setCellValue("Avaliacao Cumpre Permanencia (sim/nao)");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(59);
	        cell.setCellValue("Avaliacao Cumpre Formalizacao (sim/nao)");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(60);
	        cell.setCellValue("Avaliacao Cumpre de Atividades (sim/nao)");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(61);
	        cell.setCellValue("Vinculo");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(62);
	        cell.setCellValue("Ultima Edicao");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(63);
	        cell.setCellValue("Quem Editou");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(64);
	        cell.setCellValue("Dt Cancelamento");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(65);
	        cell.setCellValue("Quem Cancelou");
	        cell.setCellStyle(headerCellStyle);
	        
	        
	        
	        
	        
	        // Creating data rows for each customer
	        for(int i = 0; i < lista.size(); i++) {
	        	Row dataRow = sheet.createRow(i + 1);
	        	dataRow.createCell(0).setCellValue((i+1));
	        	dataRow.createCell(1).setCellValue(lista.get(i).getId());
	        	dataRow.createCell(2).setCellValue(lista.get(i).getIdAnoMesFk().getNomeAnoMes());
	        	dataRow.createCell(3).setCellValue(lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao()+"-"+lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade()+"-"+ lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade() );
	        	dataRow.createCell(4).setCellValue(lista.get(i).getIdFuncionarioFk().getIdPessoaFk().getNome()  );
	        	dataRow.createCell(5).setCellValue(lista.get(i).getIdFuncionarioFk().getIdPessoaFk().getCpf() );
	        	dataRow.createCell(6).setCellValue(lista.get(i).getIdFuncionarioFk().getMatricula() );
	        	dataRow.createCell(7).setCellValue(lista.get(i).getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria() );
	        	dataRow.createCell(8).setCellValue(lista.get(i).getIdFuncionarioFk().getIdCargoAtualFk().getIdNivelCargoFk().getNomeNivelCargo() );
	        	dataRow.createCell(9).setCellValue(lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getNomeCargo()+"-"+lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getNomeEspecialidadeCargo() );
	        	dataRow.createCell(10).setCellValue(lista.get(i).getIdTipoFolhaFk().getNomeTipoFolha() );
	        	dataRow.createCell(11).setCellValue(lista.get(i).getIdRegimeFk().getNomeRegimeDeTrabalho() );
	        	dataRow.createCell(12).setCellValue(lista.get(i).getIdPresencialSimNaoFk().getDescricao() );
	        	dataRow.createCell(13).setCellValue(lista.get(i).getIdComplementoPlantaoSimNaoFk().getDescricao() );
	        	dataRow.createCell(14).setCellValue(lista.get(i).getIdChDifSimNaoFk().getDescricao() );
	        	dataRow.createCell(15).setCellValue(lista.get(i).getIdIncrementoDeRiscoSimNaoFk().getDescricao() );
	        	dataRow.createCell(16).setCellValue(lista.get(i).getIdTurmaFk().getNomeTurma() );
	        	dataRow.createCell(17).setCellValue(lista.get(i).getDia01Fk().getNomeTurno() );
	        	dataRow.createCell(18).setCellValue(lista.get(i).getDia02Fk().getNomeTurno() );
	        	dataRow.createCell(19).setCellValue(lista.get(i).getDia03Fk().getNomeTurno() );
	        	dataRow.createCell(20).setCellValue(lista.get(i).getDia04Fk().getNomeTurno() );
	        	dataRow.createCell(21).setCellValue(lista.get(i).getDia05Fk().getNomeTurno() );
	        	dataRow.createCell(22).setCellValue(lista.get(i).getDia06Fk().getNomeTurno() );
	        	dataRow.createCell(23).setCellValue(lista.get(i).getDia07Fk().getNomeTurno() );
	        	dataRow.createCell(24).setCellValue(lista.get(i).getDia08Fk().getNomeTurno() );
	        	dataRow.createCell(25).setCellValue(lista.get(i).getDia09Fk().getNomeTurno() );
	        	dataRow.createCell(26).setCellValue(lista.get(i).getDia10Fk().getNomeTurno() );
	        	dataRow.createCell(27).setCellValue(lista.get(i).getDia11Fk().getNomeTurno() );
	        	dataRow.createCell(28).setCellValue(lista.get(i).getDia12Fk().getNomeTurno() );
	        	dataRow.createCell(29).setCellValue(lista.get(i).getDia13Fk().getNomeTurno() );
	        	dataRow.createCell(30).setCellValue(lista.get(i).getDia14Fk().getNomeTurno() );
	        	dataRow.createCell(31).setCellValue(lista.get(i).getDia15Fk().getNomeTurno() );
	        	dataRow.createCell(32).setCellValue(lista.get(i).getDia16Fk().getNomeTurno() );
	        	dataRow.createCell(33).setCellValue(lista.get(i).getDia17Fk().getNomeTurno() );
	        	dataRow.createCell(34).setCellValue(lista.get(i).getDia18Fk().getNomeTurno() );
	        	dataRow.createCell(35).setCellValue(lista.get(i).getDia19Fk().getNomeTurno() );
	        	dataRow.createCell(36).setCellValue(lista.get(i).getDia20Fk().getNomeTurno() );
	        	dataRow.createCell(37).setCellValue(lista.get(i).getDia21Fk().getNomeTurno() );
	        	dataRow.createCell(38).setCellValue(lista.get(i).getDia22Fk().getNomeTurno() );
	        	dataRow.createCell(39).setCellValue(lista.get(i).getDia23Fk().getNomeTurno() );
	        	dataRow.createCell(40).setCellValue(lista.get(i).getDia24Fk().getNomeTurno() );
	        	dataRow.createCell(41).setCellValue(lista.get(i).getDia25Fk().getNomeTurno() );
	        	dataRow.createCell(42).setCellValue(lista.get(i).getDia26Fk().getNomeTurno() );
	        	dataRow.createCell(43).setCellValue(lista.get(i).getDia27Fk().getNomeTurno() );
	        	dataRow.createCell(44).setCellValue(lista.get(i).getDia28Fk().getNomeTurno() );
	        	dataRow.createCell(45).setCellValue(lista.get(i).getDia29Fk().getNomeTurno() );
	        	dataRow.createCell(46).setCellValue(lista.get(i).getDia30Fk().getNomeTurno() );
	        	dataRow.createCell(47).setCellValue(lista.get(i).getDia31Fk().getNomeTurno() );
	        	
	        	dataRow.createCell(48).setCellValue(lista.get(i).getHorasDia() );
	        	dataRow.createCell(49).setCellValue(lista.get(i).getHorasNoite() );
	        	dataRow.createCell(50).setCellValue(lista.get(i).getHorasSemana() );
	        	dataRow.createCell(51).setCellValue(lista.get(i).getHorasFimSemana() );
	        	dataRow.createCell(52).setCellValue(lista.get(i).getHorasTotais() );
	        	
	        	dataRow.createCell(53).setCellValue(lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao() );
	        	dataRow.createCell(54).setCellValue(lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade() );
	        	dataRow.createCell(55).setCellValue(lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade() );
	        	dataRow.createCell(56).setCellValue(lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk().getNomeFantasia() );
	        	
	        	dataRow.createCell(57).setCellValue(lista.get(i).getIdAvaliacaoAssiduidadeFk().getDescricao() );
	        	dataRow.createCell(58).setCellValue(lista.get(i).getIdAvaliacaoPermanenciaFk().getDescricao() );
	        	dataRow.createCell(59).setCellValue(lista.get(i).getIdAvaliacaoFormalizacaoPontoFk().getDescricao() );
	        	dataRow.createCell(60).setCellValue(lista.get(i).getIdAvaliacaoAtividadesBurocraticasFk().getDescricao() );
	        	
	        	dataRow.createCell(61).setCellValue(lista.get(i).getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo() );
	        	
	        	dataRow.createCell(62).setCellValue(lista.get(i).getDtMudanca().getDate()+"/"+(lista.get(i).getDtMudanca().getMonth()+1)+"/"+(lista.get(i).getDtMudanca().getYear()+1900)  );
	        	dataRow.createCell(63).setCellValue(lista.get(i).getIdOperadorMudancaFk().getIdPessoaFk().getNome() );
	        	
	        	String dtCancelamento = "";
				if(lista.get(i).getDtCancelamento()!=null) {dtCancelamento =lista.get(i).getDtCancelamento().getDate()+"/"+(lista.get(i).getDtMudanca().getMonth()+1)+"/"+(lista.get(i).getDtMudanca().getYear()+1900);}
	        	dataRow.createCell(64).setCellValue(dtCancelamento );
	        	
	        	String operadorCancelamento = "";
				if(lista.get(i).getIdOperadorCancelamentoFk()!=null) {operadorCancelamento =lista.get(i).getIdOperadorCancelamentoFk().getIdPessoaFk().getNome();}
	        	dataRow.createCell(65).setCellValue(operadorCancelamento );
	        	
				        	
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
	        sheet.autoSizeColumn(16);
	        sheet.autoSizeColumn(17);
	        sheet.autoSizeColumn(18);
	        sheet.autoSizeColumn(19);
	        sheet.autoSizeColumn(20);
	        sheet.autoSizeColumn(21);
	        sheet.autoSizeColumn(22);
	        sheet.autoSizeColumn(23);
	        sheet.autoSizeColumn(24);
	        sheet.autoSizeColumn(25);
	        sheet.autoSizeColumn(26);
	        sheet.autoSizeColumn(27);
	        sheet.autoSizeColumn(28);
	        sheet.autoSizeColumn(29);
	        sheet.autoSizeColumn(30);
	        sheet.autoSizeColumn(31);
	        sheet.autoSizeColumn(32);
	        sheet.autoSizeColumn(33);
	        sheet.autoSizeColumn(34);
	        sheet.autoSizeColumn(35);
	        sheet.autoSizeColumn(36);
	        sheet.autoSizeColumn(37);
	        sheet.autoSizeColumn(38);
	        sheet.autoSizeColumn(39);
	        sheet.autoSizeColumn(40);
	        sheet.autoSizeColumn(41);
	        sheet.autoSizeColumn(42);
	        sheet.autoSizeColumn(43);
	        sheet.autoSizeColumn(44);
	        sheet.autoSizeColumn(45);
	        sheet.autoSizeColumn(46);
	        sheet.autoSizeColumn(47);
	        sheet.autoSizeColumn(48);
	        sheet.autoSizeColumn(49);
	        sheet.autoSizeColumn(50);
	        sheet.autoSizeColumn(51);
	        sheet.autoSizeColumn(52);
	        sheet.autoSizeColumn(53);
	        sheet.autoSizeColumn(54);
	        sheet.autoSizeColumn(55);
	        sheet.autoSizeColumn(56);
	        sheet.autoSizeColumn(57);
	        sheet.autoSizeColumn(58);
	        sheet.autoSizeColumn(59);
	        sheet.autoSizeColumn(60);
	        sheet.autoSizeColumn(61);
	        sheet.autoSizeColumn(62);
	        sheet.autoSizeColumn(63);
	        sheet.autoSizeColumn(64);
	        sheet.autoSizeColumn(65);
	        
	        
	        
	        
	        
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        workbook.write(outputStream);
	        return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ByteArrayInputStream exportarPdfPosTransparencia(List<EscalaPosTransparencia> lista) {

		Document document = new Document(PageSize.A4.rotate(),0,0,10,10);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(66);
			table.setWidthPercentage(97);
			table.setWidths(new int[] { 1, 1, 2, 4, 4, 3, 2, 1, 1, 4,  2, 2, 1, 1, 1, 1, 2, 1, 1, 1,  1, 1, 1, 1, 1, 1, 1, 1, 1, 1,  1, 1, 1, 1, 1, 1, 1, 1, 1, 1,  1, 1, 1, 1, 1, 1, 1, 1, 2, 2,  2, 2, 2, 2, 2, 2, 4, 2, 2, 2,  2, 2, 2, 4, 2, 4 });

			// Tipos de Fonte
			Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,6);
			Font cabecalhoFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,3);
			Font corpoFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 3);
			Font nomeSistemaFont = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 6);
			Font rodapeFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 3);
			
			//Cabeçalho
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Ord", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Id", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Mes", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Escala", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Nome", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Cpf", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Matr", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Ch", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Niv", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Cargo", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Folha", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Regime", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Pres", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Dif", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Ch Dif", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("In Ri", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Turma", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("01", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("02", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("03", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("04", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("05", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("06", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("07", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("08", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("09", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("10", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("11", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("12", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("13", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("14", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("15", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("16", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("17", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("18", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("19", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("20", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("21", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("22", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("23", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("24", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("25", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("26", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("27", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("28", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("29", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("30", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("31", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Horas Dia", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Horas Noite", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Horas Semana", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Horas Fim Semana", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Horas Totais", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Coordenacao", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Localidade", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Atividade", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Unidade", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Avaliacao Cumpre Assiduidade", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Avaliacao Cumpre Permanencia", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Avaliacao Cumpre Formalizacao", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Avaliacao Cumpre Atividades", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Vinculo", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Ultima Edicao", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Quem Editou", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Dt Cancel", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Quem Cancelou", cabecalhoFont));
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
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao()+"-"+lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade()+"-"+ lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdPessoaFk().getNome() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdPessoaFk().getCpf() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getMatricula() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getNomeCargo()+"-"+lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getNomeEspecialidadeCargo() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdTipoFolhaFk().getNomeTipoFolha() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdRegimeFk().getNomeRegimeDeTrabalho() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdPresencialSimNaoFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdComplementoPlantaoSimNaoFk().getDescricao() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdChDifSimNaoFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdIncrementoDeRiscoSimNaoFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdTurmaFk().getNomeTurma() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia01Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia02Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia03Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia04Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia05Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia06Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia07Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia08Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia09Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia10Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia11Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia12Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia13Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia14Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia15Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia16Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia17Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia18Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia19Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia20Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia21Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia22Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia23Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia24Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia25Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia26Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia27Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia28Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia29Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia30Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia31Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasDia()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasNoite()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasSemana()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasFimSemana()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasTotais()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk().getNomeFantasia() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdAvaliacaoAssiduidadeFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdAvaliacaoPermanenciaFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdAvaliacaoFormalizacaoPontoFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdAvaliacaoAtividadesBurocraticasFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDtMudanca().getDate()+"/"+(lista.get(i).getDtMudanca().getMonth()+1)+"/"+(lista.get(i).getDtMudanca().getYear()+1900) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdOperadorMudancaFk().getIdPessoaFk().getNome() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				String dtCancelamento = "";
				if(lista.get(i).getDtCancelamento()!=null) {dtCancelamento =lista.get(i).getDtCancelamento().getDate()+"/"+(lista.get(i).getDtMudanca().getMonth()+1)+"/"+(lista.get(i).getDtMudanca().getYear()+1900);}
				cell = new PdfPCell(new Phrase( dtCancelamento ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				String operadorCancelamento = "";
				if(lista.get(i).getIdOperadorCancelamentoFk()!=null) {operadorCancelamento =lista.get(i).getIdOperadorCancelamentoFk().getIdPessoaFk().getNome();}
				cell = new PdfPCell(new Phrase( operadorCancelamento ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				
					
				
			
			
			}
			
			// Titulo
			
			PdfPTable tableTitulo = new PdfPTable(1);
			tableTitulo.setWidthPercentage(97);
			tableTitulo.setWidths(new int[] { 64 });
			PdfPCell cellTitulo;
			cellTitulo = new PdfPCell(new Phrase("Escalas Alteradas depois do envio para o Portal da Transparencia", tituloFont) );
			cellTitulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableTitulo.addCell(cellTitulo);
			
			
			// Rodape
			PdfPTable tableRodape = new PdfPTable(1);
			tableRodape.setWidthPercentage(97);
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


	public ByteArrayInputStream exportarExcelEscalaAlteracao(List<EscalaAlteracoes> lista) {
		try(Workbook workbook = new XSSFWorkbook()){
			Sheet sheet = workbook.createSheet("Cidades");
			
			Row row = sheet.createRow(0);
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        // Creating header
	        
	        Cell cell = row.createCell(0);
	        cell.setCellValue("Ord");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(1);
	        cell.setCellValue("Id");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(2);
	        cell.setCellValue("Mes");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(3);
	        cell.setCellValue("Escala");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(4);
	        cell.setCellValue("Nome");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(5);
	        cell.setCellValue("Cpf");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(6);
	        cell.setCellValue("Matrícula");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(7);
	        cell.setCellValue("CH");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(8);
	        cell.setCellValue("Nível");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(9);
	        cell.setCellValue("Cargo");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(10);
	        cell.setCellValue("Folha");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(11);
	        cell.setCellValue("Regime");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(12);
	        cell.setCellValue("Presencial");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(13);
	        cell.setCellValue("Diferenciado");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(14);
	        cell.setCellValue("Ch Dif");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(15);
	        cell.setCellValue("Incr Risco");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(16);
	        cell.setCellValue("Turma");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(17);
	        cell.setCellValue("Dia 01");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(18);
	        cell.setCellValue("Dia 02");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(19);
	        cell.setCellValue("Dia 03");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(20);
	        cell.setCellValue("Dia 04");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(21);
	        cell.setCellValue("Dia 05");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(22);
	        cell.setCellValue("Dia 06");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(23);
	        cell.setCellValue("Dia 07");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(24);
	        cell.setCellValue("Dia 08");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(25);
	        cell.setCellValue("Dia 09");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(26);
	        cell.setCellValue("Dia 10");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(27);
	        cell.setCellValue("Dia 11");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(28);
	        cell.setCellValue("Dia 12");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(29);
	        cell.setCellValue("Dia 13");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(30);
	        cell.setCellValue("Dia 14");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(31);
	        cell.setCellValue("Dia 15");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(32);
	        cell.setCellValue("Dia 16");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(33);
	        cell.setCellValue("Dia 17");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(34);
	        cell.setCellValue("Dia 18");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(35);
	        cell.setCellValue("Dia 19");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(36);
	        cell.setCellValue("Dia 20");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(37);
	        cell.setCellValue("Dia 21");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(38);
	        cell.setCellValue("Dia 22");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(39);
	        cell.setCellValue("Dia 23");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(40);
	        cell.setCellValue("Dia 24");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(41);
	        cell.setCellValue("Dia 25");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(42);
	        cell.setCellValue("Dia 26");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(43);
	        cell.setCellValue("Dia 27");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(44);
	        cell.setCellValue("Dia 28");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(45);
	        cell.setCellValue("Dia 29");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(46);
	        cell.setCellValue("Dia 30");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(47);
	        cell.setCellValue("Dia 31");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(48);
	        cell.setCellValue("Horas Dia");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(49);
	        cell.setCellValue("Horas Noite");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(50);
	        cell.setCellValue("Horas Semana");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(51);
	        cell.setCellValue("Horas Final de Semana");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(52);
	        cell.setCellValue("Horas Totais");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(53);
	        cell.setCellValue("Coordenação");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(54);
	        cell.setCellValue("Localidade");
	        cell.setCellStyle(headerCellStyle);
	        

	        cell = row.createCell(55);
	        cell.setCellValue("Atividade");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(56);
	        cell.setCellValue("Unidade");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(57);
	        cell.setCellValue("Avaliacao Cumpre Assiduidade (sim/nao)");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(58);
	        cell.setCellValue("Avaliacao Cumpre Permanencia (sim/nao)");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(59);
	        cell.setCellValue("Avaliacao Cumpre Formalizacao (sim/nao)");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(60);
	        cell.setCellValue("Avaliacao Cumpre de Atividades (sim/nao)");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(61);
	        cell.setCellValue("Vinculo");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(62);
	        cell.setCellValue("Ultima Edicao");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(63);
	        cell.setCellValue("Quem Editou");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(64);
	        cell.setCellValue("Dt Cancelamento");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(65);
	        cell.setCellValue("Quem Cancelou");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(66);
	        cell.setCellValue("Data");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(67);
	        cell.setCellValue("Hora");
	        cell.setCellStyle(headerCellStyle);
	        
	        
	        
	        
	        
	        // Creating data rows for each customer
	        for(int i = 0; i < lista.size(); i++) {
	        	Row dataRow = sheet.createRow(i + 1);
	        	dataRow.createCell(0).setCellValue((i+1));
	        	dataRow.createCell(1).setCellValue(lista.get(i).getId());
	        	dataRow.createCell(2).setCellValue(lista.get(i).getIdAnoMesFk().getNomeAnoMes());
	        	dataRow.createCell(3).setCellValue(lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao()+"-"+lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade()+"-"+ lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade() );
	        	dataRow.createCell(4).setCellValue(lista.get(i).getIdFuncionarioFk().getIdPessoaFk().getNome()  );
	        	dataRow.createCell(5).setCellValue(lista.get(i).getIdFuncionarioFk().getIdPessoaFk().getCpf() );
	        	dataRow.createCell(6).setCellValue(lista.get(i).getIdFuncionarioFk().getMatricula() );
	        	dataRow.createCell(7).setCellValue(lista.get(i).getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria() );
	        	dataRow.createCell(8).setCellValue(lista.get(i).getIdFuncionarioFk().getIdCargoAtualFk().getIdNivelCargoFk().getNomeNivelCargo() );
	        	dataRow.createCell(9).setCellValue(lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getNomeCargo()+"-"+lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getNomeEspecialidadeCargo() );
	        	dataRow.createCell(10).setCellValue(lista.get(i).getIdTipoFolhaFk().getNomeTipoFolha() );
	        	dataRow.createCell(11).setCellValue(lista.get(i).getIdRegimeFk().getNomeRegimeDeTrabalho() );
	        	dataRow.createCell(12).setCellValue(lista.get(i).getIdPresencialSimNaoFk().getDescricao() );
	        	dataRow.createCell(13).setCellValue(lista.get(i).getIdComplementoPlantaoSimNaoFk().getDescricao() );
	        	dataRow.createCell(14).setCellValue(lista.get(i).getIdChDifSimNaoFk().getDescricao() );
	        	dataRow.createCell(15).setCellValue(lista.get(i).getIdIncrementoDeRiscoSimNaoFk().getDescricao() );
	        	dataRow.createCell(16).setCellValue(lista.get(i).getIdTurmaFk().getNomeTurma() );
	        	dataRow.createCell(17).setCellValue(lista.get(i).getDia01Fk().getNomeTurno() );
	        	dataRow.createCell(18).setCellValue(lista.get(i).getDia02Fk().getNomeTurno() );
	        	dataRow.createCell(19).setCellValue(lista.get(i).getDia03Fk().getNomeTurno() );
	        	dataRow.createCell(20).setCellValue(lista.get(i).getDia04Fk().getNomeTurno() );
	        	dataRow.createCell(21).setCellValue(lista.get(i).getDia05Fk().getNomeTurno() );
	        	dataRow.createCell(22).setCellValue(lista.get(i).getDia06Fk().getNomeTurno() );
	        	dataRow.createCell(23).setCellValue(lista.get(i).getDia07Fk().getNomeTurno() );
	        	dataRow.createCell(24).setCellValue(lista.get(i).getDia08Fk().getNomeTurno() );
	        	dataRow.createCell(25).setCellValue(lista.get(i).getDia09Fk().getNomeTurno() );
	        	dataRow.createCell(26).setCellValue(lista.get(i).getDia10Fk().getNomeTurno() );
	        	dataRow.createCell(27).setCellValue(lista.get(i).getDia11Fk().getNomeTurno() );
	        	dataRow.createCell(28).setCellValue(lista.get(i).getDia12Fk().getNomeTurno() );
	        	dataRow.createCell(29).setCellValue(lista.get(i).getDia13Fk().getNomeTurno() );
	        	dataRow.createCell(30).setCellValue(lista.get(i).getDia14Fk().getNomeTurno() );
	        	dataRow.createCell(31).setCellValue(lista.get(i).getDia15Fk().getNomeTurno() );
	        	dataRow.createCell(32).setCellValue(lista.get(i).getDia16Fk().getNomeTurno() );
	        	dataRow.createCell(33).setCellValue(lista.get(i).getDia17Fk().getNomeTurno() );
	        	dataRow.createCell(34).setCellValue(lista.get(i).getDia18Fk().getNomeTurno() );
	        	dataRow.createCell(35).setCellValue(lista.get(i).getDia19Fk().getNomeTurno() );
	        	dataRow.createCell(36).setCellValue(lista.get(i).getDia20Fk().getNomeTurno() );
	        	dataRow.createCell(37).setCellValue(lista.get(i).getDia21Fk().getNomeTurno() );
	        	dataRow.createCell(38).setCellValue(lista.get(i).getDia22Fk().getNomeTurno() );
	        	dataRow.createCell(39).setCellValue(lista.get(i).getDia23Fk().getNomeTurno() );
	        	dataRow.createCell(40).setCellValue(lista.get(i).getDia24Fk().getNomeTurno() );
	        	dataRow.createCell(41).setCellValue(lista.get(i).getDia25Fk().getNomeTurno() );
	        	dataRow.createCell(42).setCellValue(lista.get(i).getDia26Fk().getNomeTurno() );
	        	dataRow.createCell(43).setCellValue(lista.get(i).getDia27Fk().getNomeTurno() );
	        	dataRow.createCell(44).setCellValue(lista.get(i).getDia28Fk().getNomeTurno() );
	        	dataRow.createCell(45).setCellValue(lista.get(i).getDia29Fk().getNomeTurno() );
	        	dataRow.createCell(46).setCellValue(lista.get(i).getDia30Fk().getNomeTurno() );
	        	dataRow.createCell(47).setCellValue(lista.get(i).getDia31Fk().getNomeTurno() );
	        	
	        	dataRow.createCell(48).setCellValue(lista.get(i).getHorasDia() );
	        	dataRow.createCell(49).setCellValue(lista.get(i).getHorasNoite() );
	        	dataRow.createCell(50).setCellValue(lista.get(i).getHorasSemana() );
	        	dataRow.createCell(51).setCellValue(lista.get(i).getHorasFimSemana() );
	        	dataRow.createCell(52).setCellValue(lista.get(i).getHorasTotais() );
	        	
	        	dataRow.createCell(53).setCellValue(lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao() );
	        	dataRow.createCell(54).setCellValue(lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade() );
	        	dataRow.createCell(55).setCellValue(lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade() );
	        	dataRow.createCell(56).setCellValue(lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk().getNomeFantasia() );
	        	
	        	dataRow.createCell(57).setCellValue(lista.get(i).getIdAvaliacaoAssiduidadeFk().getDescricao() );
	        	dataRow.createCell(58).setCellValue(lista.get(i).getIdAvaliacaoPermanenciaFk().getDescricao() );
	        	dataRow.createCell(59).setCellValue(lista.get(i).getIdAvaliacaoFormalizacaoPontoFk().getDescricao() );
	        	dataRow.createCell(60).setCellValue(lista.get(i).getIdAvaliacaoAtividadesBurocraticasFk().getDescricao() );
	        	
	        	dataRow.createCell(61).setCellValue(lista.get(i).getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo() );
	        	
	        	dataRow.createCell(62).setCellValue(lista.get(i).getDtMudanca().getDate()+"/"+(lista.get(i).getDtMudanca().getMonth()+1)+"/"+(lista.get(i).getDtMudanca().getYear()+1900)  );
	        	dataRow.createCell(63).setCellValue(lista.get(i).getIdOperadorMudancaFk().getIdPessoaFk().getNome() );
	        	
	        	String dtCancelamento = "";
				if(lista.get(i).getDtCancelamento()!=null) {dtCancelamento =lista.get(i).getDtCancelamento().getDate()+"/"+(lista.get(i).getDtMudanca().getMonth()+1)+"/"+(lista.get(i).getDtMudanca().getYear()+1900);}
	        	dataRow.createCell(64).setCellValue(dtCancelamento );
	        	
	        	String operadorCancelamento = "";
				if(lista.get(i).getIdOperadorCancelamentoFk()!=null) {operadorCancelamento =lista.get(i).getIdOperadorCancelamentoFk().getIdPessoaFk().getNome();}
	        	dataRow.createCell(65).setCellValue(operadorCancelamento );
	        	
	        	String dtAlteracao = "";
				if(lista.get(i).getDtAlteracao()!=null) {dtAlteracao =lista.get(i).getDtAlteracao().getDate()+"/"+(lista.get(i).getDtMudanca().getMonth()+1)+"/"+(lista.get(i).getDtMudanca().getYear()+1900);}
	        	dataRow.createCell(66).setCellValue(dtAlteracao );
	        	
	        	String horaAlteracao = "";
				if(lista.get(i).getHoraAlteracao()!=null) {horaAlteracao =lista.get(i).getHoraAlteracao().getHours()+":"+(lista.get(i).getHoraAlteracao().getMinutes())+":"+(lista.get(i).getHoraAlteracao().getSeconds());}
	        	dataRow.createCell(67).setCellValue(horaAlteracao );
				        	
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
	        sheet.autoSizeColumn(16);
	        sheet.autoSizeColumn(17);
	        sheet.autoSizeColumn(18);
	        sheet.autoSizeColumn(19);
	        sheet.autoSizeColumn(20);
	        sheet.autoSizeColumn(21);
	        sheet.autoSizeColumn(22);
	        sheet.autoSizeColumn(23);
	        sheet.autoSizeColumn(24);
	        sheet.autoSizeColumn(25);
	        sheet.autoSizeColumn(26);
	        sheet.autoSizeColumn(27);
	        sheet.autoSizeColumn(28);
	        sheet.autoSizeColumn(29);
	        sheet.autoSizeColumn(30);
	        sheet.autoSizeColumn(31);
	        sheet.autoSizeColumn(32);
	        sheet.autoSizeColumn(33);
	        sheet.autoSizeColumn(34);
	        sheet.autoSizeColumn(35);
	        sheet.autoSizeColumn(36);
	        sheet.autoSizeColumn(37);
	        sheet.autoSizeColumn(38);
	        sheet.autoSizeColumn(39);
	        sheet.autoSizeColumn(40);
	        sheet.autoSizeColumn(41);
	        sheet.autoSizeColumn(42);
	        sheet.autoSizeColumn(43);
	        sheet.autoSizeColumn(44);
	        sheet.autoSizeColumn(45);
	        sheet.autoSizeColumn(46);
	        sheet.autoSizeColumn(47);
	        sheet.autoSizeColumn(48);
	        sheet.autoSizeColumn(49);
	        sheet.autoSizeColumn(50);
	        sheet.autoSizeColumn(51);
	        sheet.autoSizeColumn(52);
	        sheet.autoSizeColumn(53);
	        sheet.autoSizeColumn(54);
	        sheet.autoSizeColumn(55);
	        sheet.autoSizeColumn(56);
	        sheet.autoSizeColumn(57);
	        sheet.autoSizeColumn(58);
	        sheet.autoSizeColumn(59);
	        sheet.autoSizeColumn(60);
	        sheet.autoSizeColumn(61);
	        sheet.autoSizeColumn(62);
	        sheet.autoSizeColumn(63);
	        sheet.autoSizeColumn(64);
	        sheet.autoSizeColumn(65);
	        sheet.autoSizeColumn(66);
	        sheet.autoSizeColumn(67);
	        
	        
	        
	        
	        
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        workbook.write(outputStream);
	        return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ByteArrayInputStream exportarPdfEscalaAlteracao(List<EscalaAlteracoes> lista) {

		Document document = new Document(PageSize.A4.rotate(),0,0,10,10);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(68);
			table.setWidthPercentage(97);
			table.setWidths(new int[] { 1, 1, 2, 4, 4, 3, 2, 1, 1, 4,  2, 2, 1, 1, 1, 1, 2, 1, 1, 1,  1, 1, 1, 1, 1, 1, 1, 1, 1, 1,  1, 1, 1, 1, 1, 1, 1, 1, 1, 1,  1, 1, 1, 1, 1, 1, 1, 1, 2, 2,  2, 2, 2, 2, 2, 2, 4, 2, 2, 2,  2, 2, 2, 4, 2, 4, 2, 2 });

			// Tipos de Fonte
			Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,6);
			Font cabecalhoFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,3);
			Font corpoFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 3);
			Font nomeSistemaFont = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 6);
			Font rodapeFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 3);
			
			//Cabeçalho
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Ord", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Id", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Mes", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Escala", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Nome", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Cpf", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Matr", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Ch", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Niv", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Cargo", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Folha", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Regime", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Pres", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Dif", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Ch Dif", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("In Ri", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Turma", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("01", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("02", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("03", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("04", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("05", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("06", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("07", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("08", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("09", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("10", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("11", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("12", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("13", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("14", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("15", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("16", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("17", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("18", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("19", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("20", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("21", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("22", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("23", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("24", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("25", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("26", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("27", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("28", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("29", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("30", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("31", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Horas Dia", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Horas Noite", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Horas Semana", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Horas Fim Semana", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Horas Totais", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Coordenacao", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Localidade", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Atividade", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Unidade", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Avaliacao Cumpre Assiduidade", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Avaliacao Cumpre Permanencia", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Avaliacao Cumpre Formalizacao", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Avaliacao Cumpre Atividades", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Vinculo", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Ultima Edicao", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Quem Editou", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Dt Cancel", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Quem Cancelou", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Data", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Hora", cabecalhoFont));
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
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao()+"-"+lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade()+"-"+ lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdPessoaFk().getNome() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdPessoaFk().getCpf() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getMatricula() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getNomeCargo()+"-"+lista.get(i).getIdFuncionarioFk().getIdEspecialidadeAtualFk().getNomeEspecialidadeCargo() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdTipoFolhaFk().getNomeTipoFolha() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdRegimeFk().getNomeRegimeDeTrabalho() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdPresencialSimNaoFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdComplementoPlantaoSimNaoFk().getDescricao() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdChDifSimNaoFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdIncrementoDeRiscoSimNaoFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdTurmaFk().getNomeTurma() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia01Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia02Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia03Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia04Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia05Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia06Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia07Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia08Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia09Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia10Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia11Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia12Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia13Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia14Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia15Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia16Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia17Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia18Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia19Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia20Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia21Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia22Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia23Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia24Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia25Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia26Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia27Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia28Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia29Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia30Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDia31Fk().getNomeTurno() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasDia()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasNoite()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasSemana()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasFimSemana()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(lista.get(i).getHorasTotais()) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getNomeCoordenacao() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk().getNomeFantasia() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdAvaliacaoAssiduidadeFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdAvaliacaoPermanenciaFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdAvaliacaoFormalizacaoPontoFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdAvaliacaoAtividadesBurocraticasFk().getSigla() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getDtMudanca().getDate()+"/"+(lista.get(i).getDtMudanca().getMonth()+1)+"/"+(lista.get(i).getDtMudanca().getYear()+1900) ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(lista.get(i).getIdOperadorMudancaFk().getIdPessoaFk().getNome() ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				String dtCancelamento = "";
				if(lista.get(i).getDtCancelamento()!=null) {dtCancelamento =lista.get(i).getDtCancelamento().getDate()+"/"+(lista.get(i).getDtMudanca().getMonth()+1)+"/"+(lista.get(i).getDtMudanca().getYear()+1900);}
				cell = new PdfPCell(new Phrase( dtCancelamento ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				String operadorCancelamento = "";
				if(lista.get(i).getIdOperadorCancelamentoFk()!=null) {operadorCancelamento =lista.get(i).getIdOperadorCancelamentoFk().getIdPessoaFk().getNome();}
				cell = new PdfPCell(new Phrase( operadorCancelamento ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				String dtAlteracao = "";
				if(lista.get(i).getDtAlteracao()!=null) {dtAlteracao =lista.get(i).getDtAlteracao().getDate()+"/"+(lista.get(i).getDtMudanca().getMonth()+1)+"/"+(lista.get(i).getDtMudanca().getYear()+1900);}
				cell = new PdfPCell(new Phrase( dtAlteracao ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				String horaAlteracao = "";
				if(lista.get(i).getHoraAlteracao()!=null) {horaAlteracao =lista.get(i).getHoraAlteracao().getHours()+":"+(lista.get(i).getHoraAlteracao().getMinutes())+":"+(lista.get(i).getHoraAlteracao().getSeconds());}
				cell = new PdfPCell(new Phrase( horaAlteracao ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
					
				
			
			
			}
			
			// Titulo
			
			PdfPTable tableTitulo = new PdfPTable(1);
			tableTitulo.setWidthPercentage(97);
			tableTitulo.setWidths(new int[] { 64 });
			PdfPCell cellTitulo;
			cellTitulo = new PdfPCell(new Phrase("Todas as Alteraçõs nas Escalas", tituloFont) );
			cellTitulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableTitulo.addCell(cellTitulo);
			
			
			// Rodape
			PdfPTable tableRodape = new PdfPTable(1);
			tableRodape.setWidthPercentage(97);
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



	
	//Escala Colaborador
	public ByteArrayInputStream exportarPdfEscalaColaborador(Escala escala) {

		Document document = new Document(PageSize.A4.rotate(),0,0,10,10);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(7);
			table.setWidthPercentage(97);
			table.setWidths(new int[] { 1,1,1,1,1,1,1 });

			// Tipos de Fonte
			Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14);
			Font subtitulosFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,10);
			Font demaisDadosFont = FontFactory.getFont(FontFactory.HELVETICA,9);
			Font demaisDados4Font = FontFactory.getFont(FontFactory.HELVETICA,6);
			Font cabecalhoFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,12);
			Font corpoFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 7);
			Font nomeSistemaFont = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 6);
			Font rodapeFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 4);
			
			//Cabeçalho
			
			String nomeColuna1 = escalaCalculosService.obtemNomeDiaColuna(escala.getIdAnoMesFk().getNomeAnoMes(), 1);
			String nomeColuna2 = escalaCalculosService.obtemNomeDiaColuna(escala.getIdAnoMesFk().getNomeAnoMes(), 2);
			String nomeColuna3 = escalaCalculosService.obtemNomeDiaColuna(escala.getIdAnoMesFk().getNomeAnoMes(), 3);
			String nomeColuna4 = escalaCalculosService.obtemNomeDiaColuna(escala.getIdAnoMesFk().getNomeAnoMes(), 4);
			String nomeColuna5 = escalaCalculosService.obtemNomeDiaColuna(escala.getIdAnoMesFk().getNomeAnoMes(), 5);
			String nomeColuna6 = escalaCalculosService.obtemNomeDiaColuna(escala.getIdAnoMesFk().getNomeAnoMes(), 6);
			String nomeColuna7 = escalaCalculosService.obtemNomeDiaColuna(escala.getIdAnoMesFk().getNomeAnoMes(), 7);
			
			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase(nomeColuna1, cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase(nomeColuna2, cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase(nomeColuna3, cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase(nomeColuna4, cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase(nomeColuna5, cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase(nomeColuna6, cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase(nomeColuna7, cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			


			// Corpo
			
				PdfPCell cell;

				String turno01 = "";
				if(!escala.getDia01Fk().getNomeTurno().equalsIgnoreCase("")) {turno01= "01-"+ escala.getDia01Fk().getNomeTurno()+" ["+escala.getDia01Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno01 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno02 = "";
				if(!escala.getDia02Fk().getNomeTurno().equalsIgnoreCase("")) {turno02= "02-"+ escala.getDia02Fk().getNomeTurno()+" ["+escala.getDia02Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno02 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno03 = "";
				if(!escala.getDia03Fk().getNomeTurno().equalsIgnoreCase("")) {turno03= "03-"+ escala.getDia03Fk().getNomeTurno()+" ["+escala.getDia03Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno03 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno04 = "";
				if(!escala.getDia04Fk().getNomeTurno().equalsIgnoreCase("")) {turno04= "04-"+ escala.getDia04Fk().getNomeTurno()+" ["+escala.getDia04Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno04 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno05 = "";
				if(!escala.getDia05Fk().getNomeTurno().equalsIgnoreCase("")) {turno05= "05-"+ escala.getDia05Fk().getNomeTurno()+" ["+escala.getDia05Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno05 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno06 = "";
				if(!escala.getDia06Fk().getNomeTurno().equalsIgnoreCase("")) {turno06= "06-"+ escala.getDia06Fk().getNomeTurno()+" ["+escala.getDia06Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno06 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno07 = "";
				if(!escala.getDia07Fk().getNomeTurno().equalsIgnoreCase("")) {turno07= "07-"+ escala.getDia07Fk().getNomeTurno()+" ["+escala.getDia07Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno07 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno08 = "";
				if(!escala.getDia08Fk().getNomeTurno().equalsIgnoreCase("")) {turno08= "08-"+ escala.getDia08Fk().getNomeTurno()+" ["+escala.getDia08Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno08 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno09 = "";
				if(!escala.getDia09Fk().getNomeTurno().equalsIgnoreCase("")) {turno09= "09-"+ escala.getDia09Fk().getNomeTurno()+" ["+escala.getDia09Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno09 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno10 = "";
				if(!escala.getDia10Fk().getNomeTurno().equalsIgnoreCase("")) {turno10= "10-"+ escala.getDia10Fk().getNomeTurno()+" ["+escala.getDia10Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno10 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno11 = "";
				if(!escala.getDia11Fk().getNomeTurno().equalsIgnoreCase("")) {turno11= "11-"+ escala.getDia11Fk().getNomeTurno()+" ["+escala.getDia11Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno11 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno12 = "";
				if(!escala.getDia12Fk().getNomeTurno().equalsIgnoreCase("")) {turno12= "12-"+ escala.getDia12Fk().getNomeTurno()+" ["+escala.getDia12Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno12 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno13 = "";
				if(!escala.getDia13Fk().getNomeTurno().equalsIgnoreCase("")) {turno13= "13-"+ escala.getDia13Fk().getNomeTurno()+" ["+escala.getDia13Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno13 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno14 = "";
				if(!escala.getDia14Fk().getNomeTurno().equalsIgnoreCase("")) {turno14= "14-"+ escala.getDia14Fk().getNomeTurno()+" ["+escala.getDia14Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno14 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno15 = "";
				if(!escala.getDia15Fk().getNomeTurno().equalsIgnoreCase("")) {turno15= "15-"+ escala.getDia15Fk().getNomeTurno()+" ["+escala.getDia15Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno15 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno16 = "";
				if(!escala.getDia16Fk().getNomeTurno().equalsIgnoreCase("")) {turno16= "16-"+ escala.getDia16Fk().getNomeTurno()+" ["+escala.getDia16Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno16 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno17 = "";
				if(!escala.getDia17Fk().getNomeTurno().equalsIgnoreCase("")) {turno17= "17-"+ escala.getDia17Fk().getNomeTurno()+" ["+escala.getDia17Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno17 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno18 = "";
				if(!escala.getDia18Fk().getNomeTurno().equalsIgnoreCase("")) {turno18= "18-"+ escala.getDia18Fk().getNomeTurno()+" ["+escala.getDia18Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno18 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno19 = "";
				if(!escala.getDia19Fk().getNomeTurno().equalsIgnoreCase("")) {turno19= "19-"+ escala.getDia19Fk().getNomeTurno()+" ["+escala.getDia19Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno19 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno20 = "";
				if(!escala.getDia20Fk().getNomeTurno().equalsIgnoreCase("")) {turno20= "20-"+ escala.getDia20Fk().getNomeTurno()+" ["+escala.getDia20Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno20 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno21 = "";
				if(!escala.getDia21Fk().getNomeTurno().equalsIgnoreCase("")) {turno21= "21-"+ escala.getDia21Fk().getNomeTurno()+" ["+escala.getDia21Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno21 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno22 = "";
				if(!escala.getDia22Fk().getNomeTurno().equalsIgnoreCase("")) {turno22= "22-"+ escala.getDia22Fk().getNomeTurno()+" ["+escala.getDia22Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno22 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno23 = "";
				if(!escala.getDia23Fk().getNomeTurno().equalsIgnoreCase("")) {turno23= "23-"+ escala.getDia23Fk().getNomeTurno()+" ["+escala.getDia23Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno23 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno24 = "";
				if(!escala.getDia24Fk().getNomeTurno().equalsIgnoreCase("")) {turno24= "24-"+ escala.getDia24Fk().getNomeTurno()+" ["+escala.getDia24Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno24 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno25 = "";
				if(!escala.getDia25Fk().getNomeTurno().equalsIgnoreCase("")) {turno25= "25-"+ escala.getDia25Fk().getNomeTurno()+" ["+escala.getDia25Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno25 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno26 = "";
				if(!escala.getDia26Fk().getNomeTurno().equalsIgnoreCase("")) {turno26= "26-"+ escala.getDia26Fk().getNomeTurno()+" ["+escala.getDia26Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno26 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno27 = "";
				if(!escala.getDia27Fk().getNomeTurno().equalsIgnoreCase("")) {turno27= "27-"+ escala.getDia27Fk().getNomeTurno()+" ["+escala.getDia27Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno27 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno28 = "";
				if(!escala.getDia28Fk().getNomeTurno().equalsIgnoreCase("")) {turno28= "28-"+ escala.getDia28Fk().getNomeTurno()+" ["+escala.getDia28Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno28 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno29 = "";
				if(!escala.getDia29Fk().getNomeTurno().equalsIgnoreCase("")) {turno29= "29-"+ escala.getDia29Fk().getNomeTurno()+" ["+escala.getDia29Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno29 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno30 = "";
				if(!escala.getDia30Fk().getNomeTurno().equalsIgnoreCase("")) {turno30= "30-"+ escala.getDia30Fk().getNomeTurno()+" ["+escala.getDia30Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno30 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				String turno31 = "";
				if(!escala.getDia31Fk().getNomeTurno().equalsIgnoreCase("")) {turno31= "31-"+ escala.getDia31Fk().getNomeTurno()+" ["+escala.getDia31Fk().getDescricaoTurno()+"]";}
				cell = new PdfPCell(new Phrase(turno31 ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase("",corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase("" ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase("" ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase("" ,corpoFont) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				
				
			
			
			// Titulo
			
			PdfPTable tableTitulo = new PdfPTable(1);
			tableTitulo.setWidthPercentage(97);
			tableTitulo.setWidths(new int[] { 64 });
			PdfPCell cellTitulo;
			cellTitulo = new PdfPCell(new Phrase("Escala do(a) Colaborador(a)", tituloFont) );
			cellTitulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableTitulo.addCell(cellTitulo);
			
			
			// Rodape
			PdfPTable tableRodape = new PdfPTable(1);
			tableRodape.setWidthPercentage(97);
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
			
			
			

			
			// Demais Dados 1
			PdfPTable tableDemaisDados1 = new PdfPTable(5);
			tableDemaisDados1.setWidthPercentage(97);
			
			tableDemaisDados1.setWidths(new int[] { 3,1,1,1,1 });
			PdfPCell cellDemaisDados1;
			
			cellDemaisDados1 = new PdfPCell(new Phrase("Unidade", subtitulosFont) );
			cellDemaisDados1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados1.addCell(cellDemaisDados1);
			
			cellDemaisDados1 = new PdfPCell(new Phrase("Coordenação", subtitulosFont) );
			cellDemaisDados1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados1.addCell(cellDemaisDados1);
			
			cellDemaisDados1 = new PdfPCell(new Phrase("Localidade", subtitulosFont) );
			cellDemaisDados1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados1.addCell(cellDemaisDados1);
			
			cellDemaisDados1 = new PdfPCell(new Phrase("Atividade", subtitulosFont) );
			cellDemaisDados1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados1.addCell(cellDemaisDados1);
			
			cellDemaisDados1 = new PdfPCell(new Phrase("Mes", subtitulosFont) );
			cellDemaisDados1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados1.addCell(cellDemaisDados1);
			
			
			
			cellDemaisDados1 = new PdfPCell(new Phrase(escala.getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk().getNomeFantasia(), demaisDadosFont) );
			cellDemaisDados1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados1.addCell(cellDemaisDados1);
			
			cellDemaisDados1 = new PdfPCell(new Phrase(escala.getIdCoordenacaoFk().getNomeCoordenacao(), demaisDadosFont) );
			cellDemaisDados1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados1.addCell(cellDemaisDados1);
			
			cellDemaisDados1 = new PdfPCell(new Phrase(escala.getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade(), demaisDadosFont) );
			cellDemaisDados1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados1.addCell(cellDemaisDados1);
			
			cellDemaisDados1 = new PdfPCell(new Phrase(escala.getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade(), demaisDadosFont) );
			cellDemaisDados1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados1.addCell(cellDemaisDados1);
			
			cellDemaisDados1 = new PdfPCell(new Phrase(escala.getIdAnoMesFk().getNomeAnoMes(), demaisDadosFont) );
			cellDemaisDados1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados1.addCell(cellDemaisDados1);
			
						
			
			// Demais Dados 2
			PdfPTable tableDemaisDados2 = new PdfPTable(4);
			tableDemaisDados2.setWidthPercentage(97);
			
			tableDemaisDados2.setWidths(new int[] { 3,1,1,1 });
			PdfPCell cellDemaisDados2;
			
			cellDemaisDados2 = new PdfPCell(new Phrase("Nome", subtitulosFont) );
			cellDemaisDados2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados2.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados2.addCell(cellDemaisDados2);
			
			cellDemaisDados2 = new PdfPCell(new Phrase("Cpf", subtitulosFont) );
			cellDemaisDados2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados2.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados2.addCell(cellDemaisDados2);
			
			cellDemaisDados2 = new PdfPCell(new Phrase("Matricula", subtitulosFont) );
			cellDemaisDados2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados2.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados2.addCell(cellDemaisDados2);
			
			cellDemaisDados2 = new PdfPCell(new Phrase("Ch", subtitulosFont) );
			cellDemaisDados2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados2.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados2.addCell(cellDemaisDados2);
			
			
			
			cellDemaisDados2 = new PdfPCell(new Phrase(escala.getIdFuncionarioFk().getIdPessoaFk().getNome(), demaisDadosFont) );
			cellDemaisDados2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados2.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados2.addCell(cellDemaisDados2);
			
			cellDemaisDados2 = new PdfPCell(new Phrase(escala.getIdFuncionarioFk().getIdPessoaFk().getCpf(), demaisDadosFont) );
			cellDemaisDados2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados2.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados2.addCell(cellDemaisDados2);
			
			cellDemaisDados2 = new PdfPCell(new Phrase(escala.getIdFuncionarioFk().getMatricula(), demaisDadosFont) );
			cellDemaisDados2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados2.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados2.addCell(cellDemaisDados2);
			
			cellDemaisDados2 = new PdfPCell(new Phrase(escala.getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria()+"", demaisDadosFont) );
			cellDemaisDados2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados2.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados2.addCell(cellDemaisDados2);
			

			
			// Demais Dados 3
			PdfPTable tableDemaisDados3 = new PdfPTable(7);
			tableDemaisDados3.setWidthPercentage(97);
			
			tableDemaisDados3.setWidths(new int[] { 1,1,1,1,1,1,1 });
			PdfPCell cellDemaisDados3;
			
			cellDemaisDados3 = new PdfPCell(new Phrase("Folha", subtitulosFont) );
			cellDemaisDados3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados3.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados3.addCell(cellDemaisDados3);
			
			cellDemaisDados3 = new PdfPCell(new Phrase("Regime", subtitulosFont) );
			cellDemaisDados3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados3.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados3.addCell(cellDemaisDados3);
			
			cellDemaisDados3 = new PdfPCell(new Phrase("Horas Dia", subtitulosFont) );
			cellDemaisDados3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados3.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados3.addCell(cellDemaisDados3);
			
			cellDemaisDados3 = new PdfPCell(new Phrase("Horas Noite", subtitulosFont) );
			cellDemaisDados3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados3.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados3.addCell(cellDemaisDados3);
			
			cellDemaisDados3 = new PdfPCell(new Phrase("Horas Semana", subtitulosFont) );
			cellDemaisDados3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados3.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados3.addCell(cellDemaisDados3);
			
			cellDemaisDados3 = new PdfPCell(new Phrase("Horas Fim Semana", subtitulosFont) );
			cellDemaisDados3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados3.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados3.addCell(cellDemaisDados3);
			
			cellDemaisDados3 = new PdfPCell(new Phrase("Horas Totais", subtitulosFont) );
			cellDemaisDados3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados3.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados3.addCell(cellDemaisDados3);
			
			
			
			
			
			cellDemaisDados3 = new PdfPCell(new Phrase(escala.getIdTipoFolhaFk().getNomeTipoFolha(), demaisDadosFont) );
			cellDemaisDados3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados3.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados3.addCell(cellDemaisDados3);
			
			cellDemaisDados3 = new PdfPCell(new Phrase(escala.getIdRegimeFk().getNomeRegimeDeTrabalho()+"-"+escala.getIdRegimeFk().getDescricaoRegimeDeTrabalho(), demaisDadosFont) );
			cellDemaisDados3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados3.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados3.addCell(cellDemaisDados3);
			
			cellDemaisDados3 = new PdfPCell(new Phrase(escala.getHorasDia()+"", demaisDadosFont) );
			cellDemaisDados3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados3.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados3.addCell(cellDemaisDados3);
			
			cellDemaisDados3 = new PdfPCell(new Phrase(escala.getHorasNoite()+"", demaisDadosFont) );
			cellDemaisDados3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados3.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados3.addCell(cellDemaisDados3);
			
			cellDemaisDados3 = new PdfPCell(new Phrase(escala.getHorasSemana()+"", demaisDadosFont) );
			cellDemaisDados3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados3.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados3.addCell(cellDemaisDados3);
			
			cellDemaisDados3 = new PdfPCell(new Phrase(escala.getHorasFimSemana()+"", demaisDadosFont) );
			cellDemaisDados3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados3.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados3.addCell(cellDemaisDados3);
			
			cellDemaisDados3 = new PdfPCell(new Phrase(escala.getHorasTotais()+"", demaisDadosFont) );
			cellDemaisDados3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados3.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados3.addCell(cellDemaisDados3);
			

			
			// Demais Dados 4
			PdfPTable tableDemaisDados4 = new PdfPTable(2);
			tableDemaisDados4.setWidthPercentage(97);
			
			tableDemaisDados4.setWidths(new int[] { 1,3 });
			PdfPCell cellDemaisDados4;
			
			cellDemaisDados4 = new PdfPCell(new Phrase("Presencial", demaisDados4Font) );
			cellDemaisDados4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados4.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados4.addCell(cellDemaisDados4);
			
			cellDemaisDados4 = new PdfPCell(new Phrase("Última edição realizada por", demaisDados4Font) );
			cellDemaisDados4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados4.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados4.addCell(cellDemaisDados4);
			
			
			
			cellDemaisDados4 = new PdfPCell(new Phrase(escala.getIdPresencialSimNaoFk().getDescricao(), demaisDados4Font) );
			cellDemaisDados4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados4.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados4.addCell(cellDemaisDados4);
			
			cellDemaisDados4 = new PdfPCell(new Phrase(escala.getIdOperadorMudancaFk().getIdPessoaFk().getNome()+"-"+escala.getDtMudanca().getDate()+"/"+(escala.getDtMudanca().getMonth()+1)+"/"+(escala.getDtMudanca().getYear()+1900), demaisDados4Font) );
			cellDemaisDados4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellDemaisDados4.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableDemaisDados4.addCell(cellDemaisDados4);
			
			
			
			
			
			
			
			//Montando Documento
			PdfWriter.getInstance(document, out);
			document.open();
			document.add(tableTitulo);
			document.add(tableDemaisDados1);
			document.add(tableDemaisDados2);
			document.add(tableDemaisDados3);
			document.add(table);
			document.add(tableDemaisDados4);
			document.add(tableRodape);

			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}

	
	
	
}
