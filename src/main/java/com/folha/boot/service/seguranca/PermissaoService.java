package com.folha.boot.service.seguranca;
/*

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

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
public class PermissaoService implements GenericService<Permissao> {

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Override
    public void salvar(Permissao permissao) {
        permissaoRepository.save(permissao);
    }

    @Override
    public void excluir(Long id) {
        permissaoRepository.deleteById(id);
    }

    @Override
    public Permissao buscarPorId(Long id) {
        return permissaoRepository.findById(id).get();
    }

    @Override
    public List<Permissao> buscarTodos() {
        return permissaoRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Page<Permissao> listAll(int numeroPagina){
        Pageable pageable = PageRequest.of(numeroPagina - 1, 20);

        return permissaoRepository.findAll(pageable);
    }

    public Page<Permissao> listAll(int numeroPagina, String pesquisa){
        Pageable pageable = PageRequest.of(numeroPagina - 1, 20);
        List<Permissao> lista = null;

        lista = permissaoRepository.findAllTable(pesquisa.toUpperCase());

        return new PageImpl(lista, pageable, lista.size());
    }

    public ByteArrayInputStream exportarExcel() {
        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("Permissões");

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

            List<Permissao> lista = buscarTodos();

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

            hcell = new PdfPCell(new Phrase("Descrição", cabecalhoFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);


            // Corpo
            for (Permissao a : buscarTodos()) {

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
            cellTitulo = new PdfPCell(new Phrase("Permissões", tituloFont) );
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
*/