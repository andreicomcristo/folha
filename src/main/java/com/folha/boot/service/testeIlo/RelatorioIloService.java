package com.folha.boot.service.testeIlo;

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
import com.folha.boot.domain.RubricaPensaoObs;
import com.folha.boot.domain.RubricaVencimento;
import com.folha.boot.domain.RubricaVencimentoObs;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Turmas;
import com.folha.boot.domain.Uf;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.seguranca.GrupoUsuario;
import com.folha.boot.domain.testeIlo.ObjetoPrincipal;
import com.folha.boot.service.CidadesService;
import com.folha.boot.service.CidsService;
import com.folha.boot.service.RubricaPensaoObsService;
import com.folha.boot.service.RubricaVencimentoObsService;
import com.folha.boot.service.RubricaVencimentoService;
import com.folha.boot.service.UnidadeGestoraService;
import com.folha.boot.service.seguranca.GrupoUsuarioService;
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
public class RelatorioIloService {
	
	@Autowired
	private UnidadeGestoraService unidadeGestoraService;
	
	@Autowired
	private RubricaVencimentoService rubricaVencimentoService;
	
	@Autowired
	private RubricaVencimentoObsService rubricaVencimentoObsService;
	@Autowired
	private RubricaPensaoObsService rubricaPensaoObsService;
	
	@Autowired
	private CidsService cidsService;
	@Autowired
	private CidadesService cidadesService;
	@Autowired
	private GrupoUsuarioService grupoUsuarioService;
	
	
	
	
	
	
	public ByteArrayInputStream exportarPdfDadosIlo() {

		
		ObjetoPrincipal objetoPrincipal = new ObjetoPrincipal();
		objetoPrincipal.setListaCidades(cidadesService.buscarTodos());
		objetoPrincipal.setListaCids(cidsService.buscarTodos());
		objetoPrincipal.setListaGrupoUsuario(grupoUsuarioService.buscarTodos());
		
		
		
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			// Tipos de Fonte
			Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14);
			Font cabecalhoFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,8);
			Font cabecalhoFont2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD,6);
			Font corpoFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 7);
			Font corpoFont2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6);
			Font corpoFont3 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 5);
			Font nomeSistemaFont = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 6);
			Font rodapeFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 4);
			
			
			
			
			
			// Cabeçalho
			PdfPTable tableTitulo0 = new PdfPTable(1);
			tableTitulo0.setWidthPercentage(90);
			tableTitulo0.setWidths(new int[] { 4 });
			PdfPCell cellTitulo0;
			
			cellTitulo0 = new PdfPCell(new Phrase("Dados do Objeto Principal", tituloFont) );
			cellTitulo0.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo0.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo0.addCell(cellTitulo0);			
			
			
			
			
			int linha = 0;
			
			//Instanciando o tipo de tabela
			PdfPTable table = new PdfPTable(3);
			table.setWidthPercentage(90);
			table.setWidths(new int[] { 30, 30, 30 });
			
			//Cabeçalho do corpo
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Ord", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Cód", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Nome", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			
			// Corpo para primeira lista
			if(objetoPrincipal.getListaGrupoUsuario() != null) {
				for (int i=0; i<objetoPrincipal.getListaGrupoUsuario().size();i++) {
	
					PdfPCell cell;
					
					linha = linha+1;
					cell = new PdfPCell(new Phrase( String.valueOf(linha) ,corpoFont2));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
	
					cell = new PdfPCell(new Phrase( String.valueOf( objetoPrincipal.getListaGrupoUsuario().get(i).getId()  ) ,corpoFont2) );
					cell.setPaddingLeft(5);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
	
					
					String nome = "";
					if(objetoPrincipal.getListaGrupoUsuario().get(i).getNome()!=null) {nome = objetoPrincipal.getListaGrupoUsuario().get(i).getNome();}
					
					cell = new PdfPCell(new Phrase(String.valueOf( nome ) ,corpoFont2) );
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
				}
			}
			
			
			
			//Instanciando o tipo de tabela
			PdfPTable table1 = new PdfPTable(4);
			table1.setWidthPercentage(90);
			table1.setWidths(new int[] { 30, 30, 30, 30 });
			
			//Cabeçalho do corpo
			PdfPCell hcell1;
			hcell1 = new PdfPCell(new Phrase("Ord", cabecalhoFont));
			hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(hcell1);

			hcell1 = new PdfPCell(new Phrase("Cód", cabecalhoFont));
			hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(hcell1);

			hcell1 = new PdfPCell(new Phrase("Nome", cabecalhoFont));
			hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(hcell1);			
			
			hcell1 = new PdfPCell(new Phrase("Estado", cabecalhoFont));
			hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(hcell1);
			
			
			
			
			// Corpo para segunda lista
			if(objetoPrincipal.getListaCidades() != null) {
				for (int i=0; i<objetoPrincipal.getListaCidades().size();i++) {
	
					PdfPCell cell;
					
					linha = linha+1;
					cell = new PdfPCell(new Phrase( String.valueOf(linha) ,corpoFont2));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell);
	
					cell = new PdfPCell(new Phrase( String.valueOf( objetoPrincipal.getListaCidades().get(i).getId()  ) ,corpoFont2) );
					cell.setPaddingLeft(5);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell);
	
					String nomeCidade = "";
					if(objetoPrincipal.getListaCidades().get(i).getNomeCidade()!=null) {nomeCidade= objetoPrincipal.getListaCidades().get(i).getNomeCidade();}
					
					cell = new PdfPCell(new Phrase(String.valueOf( nomeCidade  ) ,corpoFont2) );
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell);
					
					
					String estado = "";
					if(objetoPrincipal.getListaCidades().get(i).getIdUfFk()!=null) {
						if(objetoPrincipal.getListaCidades().get(i).getIdUfFk().getNomeUf()!=null) {
							estado = objetoPrincipal.getListaCidades().get(i).getIdUfFk().getNomeUf();
						}
					}
					
					cell = new PdfPCell(new Phrase(String.valueOf( estado ) ,corpoFont2) );
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell);
				}
			}
			
			
			
			
			//Instanciando o tipo de tabela
			PdfPTable table2 = new PdfPTable(4);
			table2.setWidthPercentage(90);
			table2.setWidths(new int[] { 30, 30, 30, 30 });
			
			//Cabeçalho do corpo
			PdfPCell hcell2;
			hcell2 = new PdfPCell(new Phrase("Ord", cabecalhoFont));
			hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(hcell2);

			hcell2 = new PdfPCell(new Phrase("Cód", cabecalhoFont));
			hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(hcell2);

			hcell2 = new PdfPCell(new Phrase("Nome", cabecalhoFont));
			hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(hcell2);			
			
			hcell2 = new PdfPCell(new Phrase("Descricao", cabecalhoFont));
			hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(hcell2);
			
			
			
			
			
			// Corpo para terceira lista
			if(objetoPrincipal.getListaCids() != null) {
				for (int i=0; i<objetoPrincipal.getListaCids().size();i++) {
	
					PdfPCell cell;
					
					linha = linha+1;
					cell = new PdfPCell(new Phrase( String.valueOf(linha) ,corpoFont2));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2.addCell(cell);
	
					cell = new PdfPCell(new Phrase( String.valueOf( objetoPrincipal.getListaCids().get(i).getId()  ) ,corpoFont2) );
					cell.setPaddingLeft(5);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2.addCell(cell);
	
					String codigoCid = "";
					if(objetoPrincipal.getListaCids().get(i).getCodCid()!=null) {codigoCid = objetoPrincipal.getListaCids().get(i).getCodCid();}
					
					cell = new PdfPCell(new Phrase(String.valueOf( codigoCid ) ,corpoFont2) );
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2.addCell(cell);
					
					String descricaoCid = "";
					if(objetoPrincipal.getListaCids().get(i).getDescricaoCid()!=null) {descricaoCid = objetoPrincipal.getListaCids().get(i).getDescricaoCid();}
					
					cell = new PdfPCell(new Phrase(String.valueOf( descricaoCid ) ,corpoFont2) );
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2.addCell(cell);
				}
			}
		

			
			
			// Titulo 7
			PdfPTable tableTitulo7 = new PdfPTable(1);
			tableTitulo7.setWidthPercentage(90);
			tableTitulo7.setWidths(new int[] { 4 });
			PdfPCell cellTitulo7;
			
			cellTitulo7 = new PdfPCell(new Phrase("Todos os valores correspondem apenas ao pagamento de gratificações, extras e prestadores.", cabecalhoFont2) );
			cellTitulo7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo7.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo7.addCell(cellTitulo7);			
			
			
			
			
			
			
						
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
			
			
			document.add(table);
			document.add(table1);
			document.add(table2);
			
			document.add(tableTitulo7);
			
			document.add(tableRodape);

			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}

	
	
	
	
}
