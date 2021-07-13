package com.folha.boot.service.calculos.escala;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Fonte;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaBancos;
import com.folha.boot.domain.RubricaPensaoObsVencimento;
import com.folha.boot.domain.RubricaVencimento;
import com.folha.boot.domain.models.calculos.TxtFinanceiro;
import com.folha.boot.service.PessoaBancosService;
import com.folha.boot.service.RubricaPensaoObsVencimentoService;
import com.folha.boot.service.RubricaVencimentoService;
import com.folha.boot.service.calculos.folha.CalcularCalculadoraService;
import com.folha.boot.service.util.UtilidadesMatematicas;

@Service
@Transactional(readOnly = false)
public class TxtFinanceiroService {

	@Autowired
	private RubricaVencimentoService rubricaVencimentoService;
	@Autowired
	private CalcularCalculadoraService calcularCalculadoraService;
	@Autowired
	private PessoaBancosService pessoaBancosService;
	@Autowired
	private RubricaPensaoObsVencimentoService rubricaPensaoObsVencimentoService;
	
	
	public ByteArrayInputStream exportarExcel(AnoMes anoMes, Fonte fonte) {
		
		//Buscando Pessoas Com Rubrica Vencimento
		List<Pessoa> listaPessoasComRubricaVencimento = calcularCalculadoraService.listarPessoasComRubrica(anoMes);
		
		//Dados para impressao
		List<TxtFinanceiro> lista = new ArrayList<>();
		
		for(int i=0;i<listaPessoasComRubricaVencimento.size();i++) {
			
			//Criando o objeto que vai para a lista para impressao
			TxtFinanceiro txtFinanceiro = new TxtFinanceiro();
			txtFinanceiro.setAnoMes(anoMes);
			txtFinanceiro.setFonte(fonte);
			txtFinanceiro.setPessoa(listaPessoasComRubricaVencimento.get(i));
			txtFinanceiro.setValor(0.0);
			
			//Pegando todos os vencimentos da pessoa
			List<RubricaVencimento> listaVencimentos = rubricaVencimentoService.buscarPorMesDescontoOuVantagemPorPessoa(anoMes, "V", listaPessoasComRubricaVencimento.get(i));
			
			//Inserindo os valores
			for(int j=0;j<listaVencimentos.size();j++) {
				if(listaVencimentos.get(j).getIdFuncionarioFk().getIdPessoaFk().equals(listaPessoasComRubricaVencimento.get(i))) {
					if(listaVencimentos.get(j).getIdFonteFk().equals(fonte)) {
						txtFinanceiro.setValor(txtFinanceiro.getValor()+listaVencimentos.get(j).getValorLiquido());
					}
				}
			}
			
			//Colocando linha na lista para impressao
			if(txtFinanceiro.getValor()>0) {lista.add(txtFinanceiro);}
			
		}
		
		
		//Colocando os bancos de cada pessoa
		for(int i=0;i<lista.size();i++) {
			
			//Fazendo a observacao ficar vazia
			lista.get(i).setObs("");
			
			//Coletando bancos individualmente
			List<PessoaBancos> listaPessoaBanco = pessoaBancosService.buscarPorPessoa(lista.get(i).getPessoa());
			
			//Pegando a conta prioritaria
			for(int j=0;j<listaPessoaBanco.size();j++) {
				if(listaPessoaBanco.get(j).getIdPrioritarioFk().getSigla().equalsIgnoreCase("S")) {
					lista.get(i).setBanco(listaPessoaBanco.get(j));
				}
			}
			
			//Pegando a conta NAO prioritaria
			for(int j=0;j<listaPessoaBanco.size();j++) {
				if(lista.get(i).getBanco()==null) {
					lista.get(i).setBanco(listaPessoaBanco.get(j));
				}
			}
			
		}
		
		
		//Buscando Pensoes
		List<RubricaPensaoObsVencimento> listaPensoes = rubricaPensaoObsVencimentoService.buscarPorMes(anoMes);
		List<TxtFinanceiro> listaPensoesA = new ArrayList<>();
		
		for(int i=0;i<listaPensoes.size();i++) {
			TxtFinanceiro txtFinanceiro = new TxtFinanceiro();
			txtFinanceiro.setAnoMes(anoMes);
			
			txtFinanceiro.setNome(listaPensoes.get(i).getIdRubricaPensaoObsFk().getIdRubricaPensaoFk().getNomeBeneficiario());
			txtFinanceiro.setCpf(listaPensoes.get(i).getIdRubricaPensaoObsFk().getIdRubricaPensaoFk().getCpfBeneficiario());
			
			PessoaBancos b = new PessoaBancos();
			b.setIdBancoFk( listaPensoes.get(i).getIdRubricaPensaoObsFk().getIdRubricaPensaoFk().getIdBancoFk() );
			txtFinanceiro.setBanco(b);
			
			txtFinanceiro.setNomeBanco(listaPensoes.get(i).getIdRubricaPensaoObsFk().getIdRubricaPensaoFk().getIdBancoFk().getNomeBanco());
			txtFinanceiro.setCodigoBanco(listaPensoes.get(i).getIdRubricaPensaoObsFk().getIdRubricaPensaoFk().getIdBancoFk().getCodigoBanco());
			txtFinanceiro.setAgencia(listaPensoes.get(i).getIdRubricaPensaoObsFk().getIdRubricaPensaoFk().getAgencia());
			
			String conta = listaPensoes.get(i).getIdRubricaPensaoObsFk().getIdRubricaPensaoFk().getConta()+listaPensoes.get(i).getIdRubricaPensaoObsFk().getIdRubricaPensaoFk().getDvConta();
			if(listaPensoes.get(i).getIdRubricaPensaoObsFk().getIdRubricaPensaoFk().getIdBancoFk().getCodigoBanco().equalsIgnoreCase("104")) {
				conta = listaPensoes.get(i).getIdRubricaPensaoObsFk().getIdRubricaPensaoFk().getOperacaoVariacao()+conta;
			}
			txtFinanceiro.setConta(conta);
			
			txtFinanceiro.setAnoMes(anoMes);
			txtFinanceiro.setFonte(fonte);
			txtFinanceiro.setPessoa(null);
			
			
			
			txtFinanceiro.setValor(listaPensoes.get(i).getValorDescontado());
			listaPensoesA.add(txtFinanceiro);
		}		
		
		List<String> listaCpfsPensao = new ArrayList<>(); 
		for(int i=0;i<listaPensoesA.size();i++) {
			if(!listaCpfsPensao.contains(listaPensoesA.get(i).getCpf())) {
				listaCpfsPensao.add(listaPensoesA.get(i).getCpf());
			}
		}
		
		//Juntando pensoes
		List<TxtFinanceiro> listaPensoesB = new ArrayList<>();
		for(int i=0;i<listaCpfsPensao.size();i++) {
			
			TxtFinanceiro txtFinanceiro = new TxtFinanceiro();
			Double valor = 0.0;
			
			for(int j=0;j<listaPensoesA.size();j++) {
				if(listaCpfsPensao.get(i).equalsIgnoreCase(listaPensoesA.get(j).getCpf())) {
					valor = valor+listaPensoesA.get(j).getValor();
					txtFinanceiro.setAnoMes(anoMes);
					txtFinanceiro.setFonte(fonte);
					txtFinanceiro.setAgencia(listaPensoesA.get(j).getAgencia());
					txtFinanceiro.setBanco(listaPensoesA.get(j).getBanco());
					txtFinanceiro.setCodigoBanco(listaPensoesA.get(j).getCodigoBanco());
					txtFinanceiro.setConta(listaPensoesA.get(j).getConta());
					txtFinanceiro.setCpf(listaPensoesA.get(j).getCpf());
					txtFinanceiro.setJuncao("");
					txtFinanceiro.setNome(listaPensoesA.get(j).getNome());
					txtFinanceiro.setNomeBanco(listaPensoesA.get(j).getNomeBanco());
					
					Pessoa p = new Pessoa();
					p.setNome(listaPensoesA.get(j).getNome());
					p.setCpf(listaPensoesA.get(j).getCpf());
					
					txtFinanceiro.setPessoa(p);
					
				}
			}
			txtFinanceiro.setValor(valor);
			
			listaPensoesB.add(txtFinanceiro);
		}
		
		
		//Colocando pensoes na lista principal
		for(int i=0;i<listaPensoesB.size();i++) {
			listaPensoesB.get(i).setObs("PENSAO");
			lista.add(listaPensoesB.get(i));
		}
		
		//Arredondando Valores
		for(int i=0;i<lista.size();i++) {
			lista.get(i).setValor( UtilidadesMatematicas.ajustaValorDecimal(lista.get(i).getValor(), 2) );
		}
		
		//Arrumando juncao
		for(int i=0;i<lista.size();i++) {
			
			String nome = "";
			if(lista.get(i).getPessoa().getNome()!=null) {nome = lista.get(i).getPessoa().getNome();}
			
			String cpf = "|";
			if(lista.get(i).getPessoa().getCpf()!=null) {cpf = lista.get(i).getPessoa().getCpf()+cpf;}
			
			String codigoBanco = "|";
			if(lista.get(i).getBanco()!=null){ 
				if(lista.get(i).getBanco().getIdBancoFk()!=null){codigoBanco = lista.get(i).getBanco().getIdBancoFk().getCodigoBanco()+codigoBanco;}
			}
			
			String nomeBanco = "";
			if(lista.get(i).getBanco()!=null){ 
				if(lista.get(i).getBanco().getIdBancoFk()!=null){nomeBanco = lista.get(i).getBanco().getIdBancoFk().getNomeBanco();}
			}
			
			String agencia = "|";
			if(lista.get(i).getBanco()!=null){ 
				if(lista.get(i).getBanco().getAgenciaNumero()!=null){agencia = lista.get(i).getBanco().getAgenciaNumero()+agencia;}
			}
			
			String conta = "";
			if(lista.get(i).getBanco()!=null){ 
				if(lista.get(i).getBanco().getContaNumero()!=null){conta = lista.get(i).getBanco().getContaNumero();}
				if(lista.get(i).getBanco().getContaDv()!=null){conta = conta+ lista.get(i).getBanco().getContaDv();}
				
				//Colocando operacao da conta da caixa economica na frente
				if(codigoBanco.length()>2) {
					if(lista.get(i).getBanco().getIdBancoFk().getCodigoBanco().equalsIgnoreCase("104")) {
						if(lista.get(i).getBanco().getOperacaoVariacao()!=null) {conta = lista.get(i).getBanco().getOperacaoVariacao()+conta;}
					}
				}
			conta = conta+"|";
			}
			if(conta.length()==0) {conta = "|";}
		
			String valor = String.valueOf(lista.get(i).getValor()).replace(".", ",");
			//Cuidando das casas decimais
			if(!valor.contains(",") && valor.length()>0 ) {valor = valor+",00";}
			if(valor.length()>=2) {
				if(valor.substring(valor.length()-2, valor.length()-1).equalsIgnoreCase(",")) {
					valor = valor + "0";
				}
			}
			
			//Colocando zeros a frente do valor para dar a quantidade de 
			while(valor.length()<13) {
				valor = "0"+valor;
			}
			
			//Montando a juncao
			lista.get(i).setJuncao( cpf+codigoBanco+agencia+conta+valor );
			//Montando dados em paralelo
			
			lista.get(i).setNome(nome.replace("|", ""));
			lista.get(i).setCpf(cpf.replace("|", ""));
			lista.get(i).setAgencia(agencia.replace("|", ""));
			lista.get(i).setCodigoBanco(codigoBanco.replace("|", ""));
			lista.get(i).setNomeBanco(nomeBanco.replace("|", ""));
			lista.get(i).setConta(conta.replace("|", ""));
			lista.get(i).setValorString(valor.replace("|", ""));
			
		}
		
		
		
		try(Workbook workbook = new XSSFWorkbook()){
			Sheet sheet = workbook.createSheet(anoMes.getNomeAnoMes()+"-"+fonte.getNome());
			
			Row row = sheet.createRow(0);
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        // Creating header
	        
	        Cell cell = row.createCell(0);
	        cell.setCellValue("Ordem");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(1);
	        cell.setCellValue("TXT");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(2);
	        cell.setCellValue("Nome");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(3);
	        cell.setCellValue("Cpf");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(4);
	        cell.setCellValue("Valor");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(5);
	        cell.setCellValue("Banco");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(6);
	        cell.setCellValue("Codigo");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(7);
	        cell.setCellValue("Agencia");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(8);
	        cell.setCellValue("Conta");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(9);
	        cell.setCellValue("Mes");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(10);
	        cell.setCellValue("Fonte");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(11);
	        cell.setCellValue("Obs");
	        cell.setCellStyle(headerCellStyle);
	        
	        // Creating data rows for each customer
	        for(int i = 0; i < lista.size(); i++) {
	        	Row dataRow = sheet.createRow(i + 1);
	        	dataRow.createCell(0).setCellValue((i+1));
	        	dataRow.createCell(1).setCellValue(lista.get(i).getJuncao());
	        	dataRow.createCell(2).setCellValue(lista.get(i).getNome());
	        	dataRow.createCell(3).setCellValue(lista.get(i).getCpf());
	        	dataRow.createCell(4).setCellValue(lista.get(i).getValorString());
	        	dataRow.createCell(5).setCellValue(lista.get(i).getNomeBanco());
	        	dataRow.createCell(6).setCellValue(lista.get(i).getCodigoBanco());
	        	dataRow.createCell(7).setCellValue(lista.get(i).getAgencia());
	        	dataRow.createCell(8).setCellValue(lista.get(i).getConta());
	        	dataRow.createCell(9).setCellValue(lista.get(i).getAnoMes().getNomeAnoMes());
	        	dataRow.createCell(10).setCellValue(lista.get(i).getFonte().getNome());
	        	dataRow.createCell(11).setCellValue(lista.get(i).getObs());
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
	        
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        workbook.write(outputStream);
	        return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}


	
	
}
