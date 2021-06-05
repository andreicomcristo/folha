package com.folha.boot.service.seguranca;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import com.folha.boot.Reposytory.GrupoUsuarioReposytory;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.seguranca.GrupoUsuario;
import com.folha.boot.service.GenericService;
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
public class GrupoUsuarioService implements GenericService<GrupoUsuario> {

    @Autowired
    private GrupoUsuarioReposytory reposytory;

	

	//@Override
	public void editar(GrupoUsuario grupoUsuario) {
		reposytory.save(grupoUsuario);

	}

	

	@Transactional(readOnly = true)
	//@Override
	public List<GrupoUsuario> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeAsc();
	}
	
	//@Override
	public List<GrupoUsuario> buscarPorNome(String nome) {
		return reposytory.findByNomeContainingOrderByNomeAsc(nome.toUpperCase().trim());
	}
	
	@Transactional(readOnly = true)
	public Page<GrupoUsuario> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByNomeAsc(  pageable);
	}
	    
    
    
    @Override
    public void salvar(GrupoUsuario GrupoUsuario) {
    	reposytory.save(GrupoUsuario);
    }

    @Override
    public void excluir(Long id) {
    	reposytory.deleteById(id);
    }

    @Override
    public GrupoUsuario buscarPorId(Long id) {
        return reposytory.findById(id).get();
    }

    
    
	
   
    
    
    
    
    

    public Page<GrupoUsuario> listAll(int numeroPagina){
        Pageable pageable = PageRequest.of(numeroPagina - 1, 20);
        return reposytory.findAll(pageable);
    }

    
    public Page<GrupoUsuario> listAll(int numeroPagina, String pesquisa){
        Pageable pageable = PageRequest.of(numeroPagina - 1, 20);
        List<GrupoUsuario> lista = null;
        
        
//        if (pesquisa.matches("^[0-9]*$")){
//            AtendimentoSpecification spec1 =
//                    new AtendimentoSpecification(new SearchCriteria("id", ":", pesquisa));
//
//
//            lista = atendimentoRepository.findAll(Specification.where(spec1));
//        }else{
//        	AtendimentoSpecification spec2 =
//                    new AtendimentoSpecification(new SearchCriteria("paciente.nomeCivil", ":", pesquisa.toUpperCase()));
//
//            lista = atendimentoRepository.findAll(Specification.where(spec2));
//        }

        lista = reposytory.findAllTable(pesquisa.toUpperCase());

        return new PageImpl(lista, pageable, lista.size());
    }

    public ByteArrayInputStream exportarExcel() {
        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("Grupos de Usuários");

            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            // Creating header

            Cell cell = row.createCell(0);
            cell.setCellValue("Código");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Nome");
            cell.setCellStyle(headerCellStyle);

            List<GrupoUsuario> lista = buscarTodos();

            IntStream.range(0, lista.size()).forEach(i -> {
                Row dataRow = sheet.createRow(i + 1);
                dataRow.createCell(0).setCellValue((lista.get(i).getId()));
                dataRow.createCell(1).setCellValue(lista.get(i).getNome());
            });

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ByteArrayInputStream exportarPdf() {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(90);
            table.setWidths(new int[] { 2, 5 });

            // Tipos de Fonte
            com.itextpdf.text.Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14);
            com.itextpdf.text.Font cabecalhoFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,8);
            com.itextpdf.text.Font corpoFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8);
            com.itextpdf.text.Font nomeSistemaFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 6);
            Font rodapeFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 4);

            //Cabeçalho
            PdfPCell hcell;

            hcell = new PdfPCell(new Phrase("Código", cabecalhoFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Nome", cabecalhoFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);


            // Corpo
            for (GrupoUsuario a : buscarTodos()) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(String.valueOf(a.getId()) ,corpoFont));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(a.getNome() ,corpoFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);


            }

            // Titulo
            PdfPTable tableTitulo = new PdfPTable(1);
            tableTitulo.setWidthPercentage(90);
            tableTitulo.setWidths(new int[] { 6 });
            PdfPCell cellTitulo;
            cellTitulo = new PdfPCell(new Phrase("Grupos de usuários", tituloFont) );
            cellTitulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cellTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableTitulo.addCell(cellTitulo);

            // Rodape
            PdfPTable tableRodape = new PdfPTable(1);
            tableRodape.setWidthPercentage(90);
            tableRodape.setWidths(new int[] { 6 });
            PdfPCell cellRodape;

            cellRodape = new PdfPCell(new Phrase("GESTHOSP - GESTÃO HOSPITALAR", nomeSistemaFont) );
            cellRodape.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cellRodape.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableRodape.addCell(cellRodape);

            cellRodape = new PdfPCell(new Phrase("Emitido em " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()) ,rodapeFont)  );
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
            ex.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
