package com.folha.boot.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.RubricaPensaoObs;
import com.folha.boot.domain.RubricaVencimento;
import com.folha.boot.domain.RubricaVencimentoObs;
import com.folha.boot.service.util.UtilidadesDeTexto;
import com.folha.boot.service.util.UtilidadesMatematicas;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
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
	@Autowired
	private RubricaPensaoObsService rubricaPensaoObsService;

	
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
		
		List <RubricaVencimentoObs> listaObservacoes1 = rubricaVencimentoObsService.buscarPorMesEPessoa(anoMes, pessoa);
		List <RubricaVencimentoObs> listaObservacoes = new ArrayList();
		for(int i=0;i<listaObservacoes1.size();i++) {
			boolean jaTem = false;
			for(int j=0;j<listaObservacoes.size();j++) {
				if(listaObservacoes1.get(i).getObservacao().toString().equalsIgnoreCase(listaObservacoes.get(j).getObservacao().toString())) {jaTem = true;}
			}
			if(jaTem==false) {listaObservacoes.add(listaObservacoes1.get(i));}
		}
		
		List<RubricaVencimento> listaVencimentos = rubricaVencimentoService.buscarPorMesEPessoa(anoMes, pessoa);
		List<RubricaPensaoObs> listaPensao = rubricaPensaoObsService.buscarPorMesEPessoa(anoMes, pessoa);
		
		
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
			if(listaObservacoes.get(i).getObservacao()!=null) {
				if(!listaObservacoes.get(i).getObservacao().equalsIgnoreCase("")) {
					observacao = observacao+listaObservacoes.get(i).getObservacao();
				}
			}
		}
		
		
		
		
		
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
				descontos = descontos+listaVencimentos.get(i).getValorBruto();
			}
		}
		
		
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
			
			
			
			
			
			// Titulo 0
			PdfPTable tableTitulo0 = new PdfPTable(2);
			tableTitulo0.setWidthPercentage(90);
			tableTitulo0.setWidths(new int[] { 2, 6 });
			PdfPCell cellTitulo0;
			
			// Colocando imagem
			Image image = Image.getInstance("./src/main/resources/static/image/logo.png");
			image.scaleAbsolute(30,30);
									
			cellTitulo0 = new PdfPCell( image );
			cellTitulo0.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellTitulo0.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo0.setPaddingTop(1);
			cellTitulo0.setPaddingBottom(1);
			tableTitulo0.addCell(cellTitulo0);
			
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
			
			String cargo = "";
			String chSemanal = "";
			String vinculo = "";
			for(int i=0;i<pessoa.getPessoaFuncionariosList().size();i++) {
				if(pessoa.getPessoaFuncionariosList().get(i).getDtCancelamento()==null) {
					if(pessoa.getDtCancelamento()==null) {
						if(!cargo.contains( pessoa.getPessoaFuncionariosList().get(i).getIdEspecialidadeAtualFk().getIdCargoFk().getNomeCargo()+"-"+pessoa.getPessoaFuncionariosList().get(i).getIdEspecialidadeAtualFk().getNomeEspecialidadeCargo()+";"  )) {
							cargo = cargo + pessoa.getPessoaFuncionariosList().get(i).getIdEspecialidadeAtualFk().getIdCargoFk().getNomeCargo()+"-"+pessoa.getPessoaFuncionariosList().get(i).getIdEspecialidadeAtualFk().getNomeEspecialidadeCargo()+";";
							chSemanal = chSemanal + String.valueOf(pessoa.getPessoaFuncionariosList().get(i).getIdCargaHorariaAtualFk().getCargaHoraria())+";";
							vinculo = vinculo + String.valueOf(pessoa.getPessoaFuncionariosList().get(i).getIdVinculoAtualFk().getNomeVinculo())+";";}
					}
				}
			}
			cargo.replace(";", "; ");
			chSemanal.replace(";", "; ");
			cargo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cargo);
			chSemanal = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(chSemanal);
			
			// Titulo 1a
			PdfPTable tableTitulo1a = new PdfPTable(3);
			tableTitulo1a.setWidthPercentage(90);
			tableTitulo1a.setWidths(new int[] { 4, 2, 3 });
			PdfPCell cellTitulo1a;
			
			cellTitulo1a = new PdfPCell(new Phrase("Cargo", cabecalhoFont) );
			cellTitulo1a.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo1a.addCell(cellTitulo1a);
			
			cellTitulo1a = new PdfPCell(new Phrase("CH Semanal", cabecalhoFont) );
			cellTitulo1a.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo1a.addCell(cellTitulo1a);
			
			cellTitulo1a = new PdfPCell(new Phrase("Vínculo", cabecalhoFont) );
			cellTitulo1a.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo1a.addCell(cellTitulo1a);
			
			cellTitulo1a = new PdfPCell(new Phrase( String.valueOf( cargo ) ,corpoFont) );
			cellTitulo1a.setPaddingLeft(5);
			cellTitulo1a.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo1a.addCell(cellTitulo1a);
			
			cellTitulo1a = new PdfPCell(new Phrase( String.valueOf( chSemanal ) ,corpoFont) );
			cellTitulo1a.setPaddingLeft(5);
			cellTitulo1a.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo1a.addCell(cellTitulo1a);
			
			cellTitulo1a = new PdfPCell(new Phrase( String.valueOf( vinculo ) ,corpoFont) );
			cellTitulo1a.setPaddingLeft(5);
			cellTitulo1a.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo1a.addCell(cellTitulo1a);
			
			
			
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
			
			
			int linha = 0;
			
			// Titulo 4
			PdfPTable tableTitulo4 = new PdfPTable(1);
			tableTitulo4.setWidthPercentage(90);
			tableTitulo4.setWidths(new int[] { 4 });
			PdfPCell cellTitulo4;
			
			cellTitulo4 = new PdfPCell(new Phrase("Vencimentos", cabecalhoFont) );
			cellTitulo4.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo4.addCell(cellTitulo4);
			
			
			
			
			
			//Cabeçalho
			PdfPTable table = new PdfPTable(7);
			table.setWidthPercentage(90);
			table.setWidths(new int[] { 1, 3, 6, 6, 3, 3, 3 });
			
			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Ord", cabecalhoFont));
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
			
			hcell = new PdfPCell(new Phrase("Proporção(%)", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Vantagem", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Deconto", cabecalhoFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			
			// Corpo
			for (int i=0; i<listaVencimentos.size();i++) {

				PdfPCell cell;
				
				linha = linha+1;
				cell = new PdfPCell(new Phrase( String.valueOf(linha) ,corpoFont2));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase( String.valueOf( listaVencimentos.get(i).getCodigo() +"-"+listaVencimentos.get(i).getVariacao()  ) ,corpoFont2) );
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(listaVencimentos.get(i).getDescricao() ,corpoFont2) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(listaVencimentos.get(i).getIdUnidadeFk().getNomeFantasia() ,corpoFont2) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				Double proporcao = listaVencimentos.get(i).getPercentagem();
				String proporcaoString = String.valueOf(proporcao);
				if(listaVencimentos.get(i).getIdNaturezaFk().getSigla().equalsIgnoreCase("D")) {proporcaoString="";}
				
				cell = new PdfPCell(new Phrase(  String.valueOf( proporcaoString )  ,corpoFont2) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			
				Double valorVantagem = 0.0;
				Double valorDesconto = 0.0;
				if(listaVencimentos.get(i).getIdNaturezaFk().getSigla().equalsIgnoreCase("V")) {valorVantagem = valorVantagem+listaVencimentos.get(i).getValorBruto();}
				if(listaVencimentos.get(i).getIdNaturezaFk().getSigla().equalsIgnoreCase("D")) {valorVantagem = valorDesconto+listaVencimentos.get(i).getValorBruto();}
				valorVantagem = UtilidadesMatematicas.ajustaValorDecimal(valorVantagem, 2);
				valorDesconto = UtilidadesMatematicas.ajustaValorDecimal(valorDesconto, 2);
				String valorVantagemString = "";
				String valorDescontoString = "";
				if(valorVantagem!=0) {valorVantagemString = String.valueOf(valorVantagem);}
				if(valorDesconto!=0) {valorDescontoString = String.valueOf(valorDesconto);}
				
				cell = new PdfPCell(new Phrase( String.valueOf( valorVantagemString ) ,corpoFont2) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);	
				
				cell = new PdfPCell(new Phrase( String.valueOf( valorDescontoString ) ,corpoFont2) );
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);	
			}
			
			
			
			PdfPCell cell;
			//Colocando inss
			if(previdencia>0) {
			linha = linha+1;
			
			cell = new PdfPCell(new Phrase( String.valueOf(linha) ,corpoFont2));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase( String.valueOf( "PREVIDENCIA"  ) ,corpoFont2) );
			cell.setPaddingLeft(5);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("DESCONTOS PREVIDENCIARIOS" ,corpoFont2) );
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase( "" ,corpoFont2) );
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(  String.valueOf("")  ,corpoFont2) );
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase( String.valueOf( "" ) ,corpoFont2) );
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);	
			
			cell = new PdfPCell(new Phrase( String.valueOf( UtilidadesMatematicas.ajustaValorDecimal( previdencia, 2 )  ) ,corpoFont2) );
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);	
		}
			
			
			
			//Colocando pensao
			
			if(!listaPensao.isEmpty()) {
				for(int i=0;i<listaPensao.size();i++){
					linha = linha+1;
				
					cell = new PdfPCell(new Phrase( String.valueOf(linha) ,corpoFont2));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
		
					cell = new PdfPCell(new Phrase( String.valueOf( "PENSAO"  ) ,corpoFont2) );
					cell.setPaddingLeft(5);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
		
					cell = new PdfPCell(new Phrase("BENEFICIARIO :"+listaPensao.get(i).getIdRubricaPensaoFk().getNomeBeneficiario() ,corpoFont2) );
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
					
					cell = new PdfPCell(new Phrase( "" ,corpoFont2) );
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
					
					cell = new PdfPCell(new Phrase(  String.valueOf("")  ,corpoFont2) );
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
					
					cell = new PdfPCell(new Phrase( String.valueOf( "" ) ,corpoFont2) );
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);	
					
					cell = new PdfPCell(new Phrase( String.valueOf(  UtilidadesMatematicas.ajustaValorDecimal(  listaPensao.get(i).getValorDescontado() ,2) ) ,corpoFont2) );
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);	
					
					pensao = pensao + listaPensao.get(i).getValorDescontado();
				}
			}	
			
			
			
		//Colocando IR
		if(ir>0) {
			linha = linha+1;
			
			cell = new PdfPCell(new Phrase( String.valueOf(linha) ,corpoFont2));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase( String.valueOf( "IR"  ) ,corpoFont2) );
			cell.setPaddingLeft(5);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("IMPOSTO DE RENDA NA FONTE" ,corpoFont2) );
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase( "" ,corpoFont2) );
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(  String.valueOf("")  ,corpoFont2) );
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase( String.valueOf( "" ) ,corpoFont2) );
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);	
			
			cell = new PdfPCell(new Phrase( String.valueOf(  UtilidadesMatematicas.ajustaValorDecimal(  ir ,2) ) ,corpoFont2) );
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);	
		}
			
			

			
			//Calculando bruto e líquido
			bruto = vantagens;
			for(int i=0;i<listaVantagens.size();i++) {
				liquido = liquido + listaVantagens.get(i).getValorLiquido();
			}
			Double descontosDocontracheque = bruto - liquido;
			bruto = UtilidadesMatematicas.ajustaValorDecimal(bruto, 2);
			liquido = UtilidadesMatematicas.ajustaValorDecimal(liquido, 2);
			descontosDocontracheque = UtilidadesMatematicas.ajustaValorDecimal(descontosDocontracheque, 2);
			
			
			
			
			
			// Titulo 7
			PdfPTable tableTitulo7 = new PdfPTable(1);
			tableTitulo7.setWidthPercentage(90);
			tableTitulo7.setWidths(new int[] { 4 });
			PdfPCell cellTitulo7;
			
			cellTitulo7 = new PdfPCell(new Phrase("Todos os valores correspondem apenas ao pagamento de gratificações, extras e prestadores.", cabecalhoFont2) );
			cellTitulo7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo7.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo7.addCell(cellTitulo7);			
			
			
			//Colocando observacoes de pensao nas observações
			for(int i=0;i<listaPensao.size();i++) {
				if(listaPensao.get(i).getObservacao()!=null) {
					if(!listaPensao.get(i).getObservacao().equalsIgnoreCase("")) {
						observacao = observacao+listaPensao.get(i).getObservacao()+";";
					}
				}
			}
			
			
			observacao = observacao.replace(";", "; ");
			observacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(observacao);
			
			// Titulo 8
			PdfPTable tableTitulo8 = new PdfPTable(1);
			tableTitulo8.setWidthPercentage(90);
			tableTitulo8.setWidths(new int[] { 4 });
			PdfPCell cellTitulo8;
			
			cellTitulo8 = new PdfPCell(new Phrase("Observações", cabecalhoFont2) );
			cellTitulo8.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo8.addCell(cellTitulo8);
			
			cellTitulo8 = new PdfPCell(new Phrase( String.valueOf( observacao ) ,corpoFont3) );
			cellTitulo8.setPaddingLeft(5);
			cellTitulo8.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo8.addCell(cellTitulo8);			
			
			
			// Titulo 9
			PdfPTable tableTitulo9 = new PdfPTable(3);
			tableTitulo9.setWidthPercentage(90);
			tableTitulo9.setWidths(new int[] { 3, 3, 3});
			PdfPCell cellTitulo9;
			
			cellTitulo9 = new PdfPCell(new Phrase("Bruto", cabecalhoFont) );
			cellTitulo9.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitulo9.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tableTitulo9.addCell(cellTitulo9);
			
			cellTitulo9 = new PdfPCell(new Phrase("Descontos", cabecalhoFont) );
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
			
			cellTitulo9 = new PdfPCell(new Phrase( String.valueOf(  UtilidadesMatematicas.ajustaValorDecimal(bruto-liquido, 2)  ) ,corpoFont) );
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
			document.add(tableTitulo1a);
			document.add(tableTitulo2);
			document.add(tableTitulo3);
			document.add(tableTitulo4);
			document.add(table);
			document.add(tableTitulo9);
			document.add(tableTitulo7);
			document.add(tableTitulo8);
			
			
			
			document.add(tableRodape);

			document.close();

		} catch (DocumentException ex) {

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ByteArrayInputStream(out.toByteArray());
	}

	
	
	
	
}
