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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.FaixasValoresParametrosCalculoFolhasExtrasReposytory;
import com.folha.boot.Reposytory.TiposDeFolhaNivelCargoReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.TiposDeFolhaNivelCargo;
import com.folha.boot.domain.Unidades;
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
public class TiposDeFolhaNivelCargoService {

	@Autowired
	private TiposDeFolhaNivelCargoReposytory reposytory;
	
	@Autowired
	private AnoMesService anoMesService;
	

	public void salvar(TiposDeFolhaNivelCargo tiposDeFolhaNivelCargo) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeFolhaNivelCargo);
	}

	public void editar(TiposDeFolhaNivelCargo tiposDeFolhaNivelCargo) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeFolhaNivelCargo);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public TiposDeFolhaNivelCargo buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<TiposDeFolhaNivelCargo> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc();
	}
	@Transactional(readOnly = true)
	public List<TiposDeFolhaNivelCargo> buscarPorNome(String nome) {
		return reposytory.findByIdTipoDeFolhaFkNomeTipoFolhaContainingOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(nome);
	}
	
	
	@Transactional(readOnly = true)
	public List<TiposDeFolhaNivelCargo> buscarPorMesExato(AnoMes anoMes) {
		return reposytory.findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(anoMes);
	}
	
	
	public Page<TiposDeFolhaNivelCargo> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(pageable);
	}

	public Page<TiposDeFolhaNivelCargo> findPaginatedAnoMes(int pageNo, int pageSize, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(nome.toUpperCase().trim(), pageable);
	}
	
	//Herdar de um mes para o outro
	public void herdarDeUmMesParaOOutro(Long anoMesInicial, Long anoMesFinal) {
		
		List<TiposDeFolhaNivelCargo> listaInicial = buscarPorMesExato(anoMesService.buscarPorId(anoMesInicial)); 
		List<TiposDeFolhaNivelCargo> listaFinal = buscarPorMesExato(anoMesService.buscarPorId(anoMesFinal));
		
		if( (!listaInicial.isEmpty())  &&  (listaFinal.isEmpty()) ) {
			for(int i=0;i<listaInicial.size();i++) {
				TiposDeFolhaNivelCargo f = new TiposDeFolhaNivelCargo();
				f.setId(null);
				f.setIdNivelCargoFk(listaInicial.get(i).getIdNivelCargoFk());
				f.setIdAnoMesFk(anoMesService.buscarPorId(anoMesFinal));
				f.setIdTipoDeFolhaFk(listaInicial.get(i).getIdTipoDeFolhaFk());
				
				salvar(f);
			}
		}
	}
	
	

	
}
