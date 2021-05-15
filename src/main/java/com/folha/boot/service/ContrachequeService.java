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

import com.folha.boot.Reposytory.EscalaReposytoty;
import com.folha.boot.Reposytory.PessoaDocumentosReposytory;
import com.folha.boot.Reposytory.RubricaVencimentoReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.EscalaAlteracoes;
import com.folha.boot.domain.EscalaPosTransparencia;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.PessoaDocumentosConselho;
import com.folha.boot.domain.RubricaVencimento;
import com.folha.boot.domain.RubricaVencimentoObs;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Turmas;
import com.folha.boot.domain.Uf;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;
import com.folha.boot.service.util.UtilidadesDeTexto;
import com.folha.boot.service.util.UtilidadesMatematicas;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
@Transactional(readOnly = false)
public class ContrachequeService {
	
	@Autowired
	private UnidadeGestoraService unidadeGestoraService;
	
	@Autowired
	private RubricaVencimentoService rubricaVencimentoService;
	
	@Autowired
	private RubricaVencimentoObsService rubricaVencimentoObsService;

	
	public ByteArrayInputStream exportarPdfContracheque(AnoMes anoMes, Pessoa pessoa) {

		String nome = pessoa.getNome();
		String cpf = pessoa.getCpf();
		String endereco = "";
		String competencia = anoMes.getNomeAnoMes();
		String pagador = "";
		Double previdencia = 0.0;
		Double ir = 0.0;
		String observacao = "";
		
		Double vantagens = 0.0;
		Double descontos = 0.0;
		Double pensao = 0.0;
		
		Double bruto = 0.0;
		Double liquido = 0.0;
		
		List <RubricaVencimentoObs> listaObservacoes = rubricaVencimentoObsService.buscarPorMesEPessoa(anoMes, pessoa);
		List<RubricaVencimento> listaVencimentos = rubricaVencimentoService.buscarPorMesEPessoa(anoMes, pessoa);
		
		if(!unidadeGestoraService.buscarTodos().isEmpty()) {
			if(unidadeGestoraService.buscarTodos().get(0).getNomeFantasia()!=null) {pagador = pagador + unidadeGestoraService.buscarTodos().get(0).getNomeFantasia();}
			if(unidadeGestoraService.buscarTodos().get(0).getCnpj()!=null) {pagador = pagador + " | " +unidadeGestoraService.buscarTodos().get(0).getCnpj();}
		}
		
		if(!pessoa.getEnderecosList().isEmpty()) {
			String dado = ""; 
			if(pessoa.getEnderecosList().get(0).getIdTipoLogradouroFk().getNomeTipoLogradouro() !=null) {dado = dado + pessoa.getEnderecosList().get(0).getIdTipoLogradouroFk().getNomeTipoLogradouro();}
			if(pessoa.getEnderecosList().get(0).getEnderecoLogradouro() !=null) {dado = dado +" "+pessoa.getEnderecosList().get(0).getEnderecoLogradouro();}
			if(pessoa.getEnderecosList().get(0).getEnderecoNumero() !=null) {dado = dado +", "+pessoa.getEnderecosList().get(0).getEnderecoNumero();}
			if(pessoa.getEnderecosList().get(0).getEnderecoComplemento() !=null) {dado = dado +", "+pessoa.getEnderecosList().get(0).getEnderecoComplemento();}
			if(pessoa.getEnderecosList().get(0).getEnderecoBairro() !=null) {dado = dado +"-"+pessoa.getEnderecosList().get(0).getEnderecoBairro();}
			if(pessoa.getEnderecosList().get(0).getEnderecoCep() !=null) {dado = dado +"-"+pessoa.getEnderecosList().get(0).getEnderecoCep();}
			if(pessoa.getEnderecosList().get(0).getIdEnderecoCidadeFk().getNomeCidade() !=null) {dado = dado +"-"+pessoa.getEnderecosList().get(0).getIdEnderecoCidadeFk().getNomeCidade();}
			if(pessoa.getEnderecosList().get(0).getIdEnderecoCidadeFk().getIdUfFk().getNomeUf() !=null) {dado = dado +"-"+pessoa.getEnderecosList().get(0).getIdEnderecoCidadeFk().getIdUfFk().getNomeUf();}
			if(dado.length()>6) {endereco = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(dado);}
		}
		
		
		
		for(int i=0;i<listaObservacoes.size();i++) {
			if(listaObservacoes.get(i).getObsercavao()!=null) {
				if(!listaObservacoes.get(i).getObsercavao().equalsIgnoreCase("")) {
					observacao = observacao+listaObservacoes.get(i).getObsercavao();
				}
			}
		}
		observacao = observacao.replace(";", "; ");
		observacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(observacao);
		
		
		
		
		//Coletando os dados
		
		List<RubricaVencimento> listaVantagens = new ArrayList<>();
		List<RubricaVencimento> listaDescontos = new ArrayList<>();
		for(int i=0;i<listaVencimentos.size();i++) {
			if(listaVencimentos.get(i).getIdNaturezaFk().getSigla().equalsIgnoreCase("V")) {
				listaVantagens.add(listaVencimentos.get(i));
				previdencia = previdencia + listaVencimentos.get(i).getValorPrevidencia();
				ir = ir + listaVencimentos.get(i).getValorIr();
				vantagens = vantagens+listaVantagens.get(i).getValorBruto();
			}
			if(listaVencimentos.get(i).getIdNaturezaFk().getSigla().equalsIgnoreCase("D")) {
				listaDescontos.add(listaVencimentos.get(i));
				descontos = descontos+listaDescontos.get(i).getValorBruto();
			}
		}
		//Calculando bruto e líquido
		bruto = vantagens;
		bruto = UtilidadesMatematicas.ajustaValorDecimal(bruto, 2);
		liquido = bruto-(descontos+ir+previdencia+pensao);
		liquido = UtilidadesMatematicas.ajustaValorDecimal(liquido, 2);
		
		
		
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			// Tipos de Fonte
			Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14);
			Font cabecalhoFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,8);
			Font corpoFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8);
			Font corpoFont2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6);
			Font nomeSistemaFont = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 6);
			Font rodapeFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 4);
			
			
			
			
			
			// Titulo 0
			PdfPTable tableTitulo0 = new PdfPTable(1);
			tableTitulo0.setWidthPercentage(90);
			tableTitulo0.setWidths(new int[] { 4 });
			PdfPCell cellTitulo0;
			
			cellTitulo0 = new PdfPCell(new Phrase("DEMONSTRATIVO DE VENCIMENTOS", tituloFont) );
			cellTitulo0.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo0.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo0.addCell(cellTitulo0);			
			
			
			
			
			// Titulo 1
			PdfPTable tableTitulo1 = new PdfPTable(2);
			tableTitulo1.setWidthPercentage(90);
			tableTitulo1.setWidths(new int[] { 4, 2 });
			PdfPCell cellTitulo1;
			
			cellTitulo1 = new PdfPCell(new Phrase("Nome", cabecalhoFont) );
			cellTitulo1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo1.addCell(cellTitulo1);
			
			cellTitulo1 = new PdfPCell(new Phrase("Cpf", cabecalhoFont) );
			cellTitulo1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo1.addCell(cellTitulo1);
			
			cellTitulo1 = new PdfPCell(new Phrase( String.valueOf( nome ) ,corpoFont) );
			cellTitulo1.setPaddingLeft(5);
			cellTitulo1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo1.addCell(cellTitulo1);
			
			cellTitulo1 = new PdfPCell(new Phrase( String.valueOf( cpf ) ,corpoFont) );
			cellTitulo1.setPaddingLeft(5);
			cellTitulo1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo1.addCell(cellTitulo1);
			
			
			
			
			// Titulo 2
			PdfPTable tableTitulo2 = new PdfPTable(1);
			tableTitulo2.setWidthPercentage(90);
			tableTitulo2.setWidths(new int[] { 4 });
			PdfPCell cellTitulo2;
			
			cellTitulo2 = new PdfPCell(new Phrase("Endereco", cabecalhoFont) );
			cellTitulo2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo2.addCell(cellTitulo2);
			
			cellTitulo2 = new PdfPCell(new Phrase( String.valueOf( endereco ) ,corpoFont) );
			cellTitulo2.setPaddingLeft(5);
			cellTitulo2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo2.addCell(cellTitulo2);
			
			
			
			
			
			// Titulo 3
			PdfPTable tableTitulo3 = new PdfPTable(2);
			tableTitulo3.setWidthPercentage(90);
			tableTitulo3.setWidths(new int[] { 5, 2 });
			PdfPCell cellTitulo3;
			
			cellTitulo3 = new PdfPCell(new Phrase("Secretaria", cabecalhoFont) );
			cellTitulo3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo3.addCell(cellTitulo3);
			
			cellTitulo3 = new PdfPCell(new Phrase("Competência", cabecalhoFont) );
			cellTitulo3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo3.addCell(cellTitulo3);
			
			cellTitulo3 = new PdfPCell(new Phrase( String.valueOf( pagador ) ,corpoFont) );
			cellTitulo3.setPaddingLeft(5);
			cellTitulo3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo3.addCell(cellTitulo3);
			
			cellTitulo3 = new PdfPCell(new Phrase( String.valueOf( competencia ) ,corpoFont) );
			cellTitulo3.setPaddingLeft(5);
			cellTitulo3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo3.addCell(cellTitulo3);
			
			
			
			
			// Titulo 4
			PdfPTable tableTitulo4 = new PdfPTable(1);
			tableTitulo4.setWidthPercentage(90);
			tableTitulo4.setWidths(new int[] { 4 });
			PdfPCell cellTitulo4;
			
			cellTitulo4 = new PdfPCell(new Phrase("Vantagens", cabecalhoFont) );
			cellTitulo4.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo4.addCell(cellTitulo4);
			
			
			
			
			
			//Cabeçalho
			PdfPTable table = new PdfPTable(6);
			table.setWidthPercentage(90);
			table.setWidths(new int[] { 2, 2, 6, 6, 3, 3 });
			
			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Ordem", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Cód", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Descrição", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Unidade", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Proporção", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Valor", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			
			
			
			
			
			
			
			// Corpo
			for (int i=0; i<listaVantagens.size();i++) {

				PdfPCell cell;

				cell = new PdfPCell(new Phrase( String.valueOf(i+1) ,corpoFont2));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase( String.valueOf( listaVantagens.get(i).getCodigo() +"-"+listaVantagens.get(i).getVariacao()  ) ,corpoFont2) );
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(listaVantagens.get(i).getDescricao() ,corpoFont2) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(listaVantagens.get(i).getIdUnidadeFk().getNomeFantasia() ,corpoFont2) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(  String.valueOf(listaVantagens.get(i).getPercentagem())  ,corpoFont2) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			
				cell = new PdfPCell(new Phrase( String.valueOf(listaVantagens.get(i).getValorBruto()) ,corpoFont2) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);		
			}
			
			
			
			
			
			
			
			// Titulo 5
			PdfPTable tableTitulo5 = new PdfPTable(1);
			tableTitulo5.setWidthPercentage(90);
			tableTitulo5.setWidths(new int[] { 4 });
			PdfPCell cellTitulo5;
			
			cellTitulo5 = new PdfPCell(new Phrase("Descontos", cabecalhoFont) );
			cellTitulo5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo5.addCell(cellTitulo5);
			

			
			//Cabeçalho
			PdfPTable table2 = new PdfPTable(6);
			table2.setWidthPercentage(90);
			table2.setWidths(new int[] { 2, 2, 6, 6, 3, 3 });
			
			
			PdfPCell hcell2;
			hcell2 = new PdfPCell(new Phrase("Ordem", cabecalhoFont));
			hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(hcell);

			hcell2 = new PdfPCell(new Phrase("Cód", cabecalhoFont));
			hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(hcell2);

			hcell2 = new PdfPCell(new Phrase("Descrição", cabecalhoFont));
			hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(hcell2);
			
			hcell2 = new PdfPCell(new Phrase("Unidade", cabecalhoFont));
			hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(hcell2);
			
			hcell2 = new PdfPCell(new Phrase("Proporção", cabecalhoFont));
			hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(hcell2);
			
			hcell2 = new PdfPCell(new Phrase("Valor", cabecalhoFont));
			hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(hcell2);			
			
			
			// Corpo
			for (int i=0; i<listaDescontos.size();i++) {

				PdfPCell cell2;

				cell2 = new PdfPCell(new Phrase( String.valueOf(i+1) ,corpoFont2));
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2.addCell(cell2);

				cell2 = new PdfPCell(new Phrase( String.valueOf( listaDescontos.get(i).getCodigo() +"-"+listaDescontos.get(i).getVariacao()  ) ,corpoFont2) );
				cell2.setPaddingLeft(5);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell2);

				cell2 = new PdfPCell(new Phrase(listaDescontos.get(i).getDescricao() ,corpoFont2) );
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell2);
				
				cell2 = new PdfPCell(new Phrase(listaDescontos.get(i).getIdUnidadeFk().getNomeFantasia() ,corpoFont2) );
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2.addCell(cell2);
				
				cell2 = new PdfPCell(new Phrase(  String.valueOf(listaDescontos.get(i).getPercentagem())  ,corpoFont2) );
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2.addCell(cell2);
			
				cell2 = new PdfPCell(new Phrase( String.valueOf(listaDescontos.get(i).getValorBruto()) ,corpoFont2) );
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2.addCell(cell2);		
			}
						
			
			
			
			// Titulo 6
			PdfPTable tableTitulo6 = new PdfPTable(2);
			tableTitulo6.setWidthPercentage(90);
			tableTitulo6.setWidths(new int[] { 3, 3 });
			PdfPCell cellTitulo6;
			
			cellTitulo6 = new PdfPCell(new Phrase("Previdência", cabecalhoFont) );
			cellTitulo6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo6.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo6.addCell(cellTitulo6);
			
			cellTitulo6 = new PdfPCell(new Phrase("Imposto de Renda", cabecalhoFont) );
			cellTitulo6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo6.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo6.addCell(cellTitulo6);
			
			cellTitulo6 = new PdfPCell(new Phrase( String.valueOf( previdencia ) ,corpoFont) );
			cellTitulo6.setPaddingLeft(5);
			cellTitulo6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo6.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo6.addCell(cellTitulo6);
			
			cellTitulo6 = new PdfPCell(new Phrase( String.valueOf( ir ) ,corpoFont) );
			cellTitulo6.setPaddingLeft(5);
			cellTitulo6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo6.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo6.addCell(cellTitulo6);			
			
			
			
			
			// Titulo 7
			PdfPTable tableTitulo7 = new PdfPTable(1);
			tableTitulo7.setWidthPercentage(90);
			tableTitulo7.setWidths(new int[] { 4 });
			PdfPCell cellTitulo7;
			
			cellTitulo7 = new PdfPCell(new Phrase("Todos os valores correspondem apenas ao pagamento de gratificações, extras e prestadores.", cabecalhoFont) );
			cellTitulo7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo7.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo7.addCell(cellTitulo7);			
			
			
			
			// Titulo 8
			PdfPTable tableTitulo8 = new PdfPTable(1);
			tableTitulo8.setWidthPercentage(90);
			tableTitulo8.setWidths(new int[] { 4 });
			PdfPCell cellTitulo8;
			
			cellTitulo8 = new PdfPCell(new Phrase("Observações", cabecalhoFont) );
			cellTitulo8.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo8.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo8.addCell(cellTitulo8);
			
			cellTitulo8 = new PdfPCell(new Phrase( String.valueOf( observacao ) ,corpoFont2) );
			cellTitulo8.setPaddingLeft(5);
			cellTitulo8.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo8.addCell(cellTitulo8);			
			
			
			// Titulo 9
			PdfPTable tableTitulo9 = new PdfPTable(2);
			tableTitulo9.setWidthPercentage(90);
			tableTitulo9.setWidths(new int[] { 3, 3 });
			PdfPCell cellTitulo9;
			
			cellTitulo9 = new PdfPCell(new Phrase("Bruto", cabecalhoFont) );
			cellTitulo9.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo9.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo9.addCell(cellTitulo9);
			
			cellTitulo9 = new PdfPCell(new Phrase("Líquido", cabecalhoFont) );
			cellTitulo9.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo9.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo9.addCell(cellTitulo9);
			
			cellTitulo9 = new PdfPCell(new Phrase( String.valueOf( bruto ) ,corpoFont) );
			cellTitulo9.setPaddingLeft(5);
			cellTitulo9.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo9.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo9.addCell(cellTitulo9);
			
			cellTitulo9 = new PdfPCell(new Phrase( String.valueOf( liquido ) ,corpoFont) );
			cellTitulo9.setPaddingLeft(5);
			cellTitulo9.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo9.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo9.addCell(cellTitulo9);			
			
			
			
			
			
						
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
			document.add(tableTitulo0);
			document.add(tableTitulo1);
			document.add(tableTitulo2);
			document.add(tableTitulo3);
			document.add(tableTitulo4);
			document.add(table);
			document.add(tableTitulo5);
			document.add(table2);
			document.add(tableTitulo6);
			document.add(tableTitulo7);
			document.add(tableTitulo8);
			document.add(tableTitulo9);
			
			
			document.add(tableRodape);

			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}

	
	
	
	
}
