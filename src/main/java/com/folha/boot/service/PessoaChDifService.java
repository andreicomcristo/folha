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
import com.folha.boot.Reposytory.FaixasValoresParametrosCalculoFolhasExtrasReposytory;
import com.folha.boot.Reposytory.PessoaChDifReposytory;
import com.folha.boot.Reposytory.UnidadeAdmiteChDifReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaChDif;
import com.folha.boot.domain.PessoaCodDiferenciado;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.UnidadeAdmiteChDif;
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
public class PessoaChDifService {

	@Autowired
	private PessoaChDifReposytory reposytory;
	
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	UnidadeAdmiteChDifService unidadeAdmiteChDifService;
	@Autowired
	SimNaoService simNaoService;
	

	public void salvar(PessoaChDif pessoaChDif) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaChDif);
	}

	public void editar(PessoaChDif pessoaChDif) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaChDif);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public PessoaChDif buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	public List<PessoaChDif> buscarPorUnidadeEPessoa(Unidades unidades, Pessoa pessoa) {
		return reposytory.findByIdUnidadeFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, pessoa);
	}
	
	@Transactional(readOnly = true)
	public List<PessoaChDif> buscarTodos(Unidades unidades) {
		// TODO Auto-generated method stub
		return reposytory.findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades);
	}
	@Transactional(readOnly = true)
	public List<PessoaChDif> buscarPorNome(String nome, Unidades unidades) {
		return reposytory.findByIdUnidadeFkAndIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, nome);
	}
	
	
	@Transactional(readOnly = true)
	public List<PessoaChDif> buscarPorMesExato(AnoMes anoMes, Unidades unidades) {
		return reposytory.findByIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, anoMes);
	}
	
	
	public Page<PessoaChDif> findPaginated(int pageNo, int pageSize, Unidades unidades) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, pageable);
	}

	public Page<PessoaChDif> findPaginatedAnoMes(int pageNo, int pageSize, String nome, Unidades unidades) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeFkAndIdAnoMesFkNomeAnoMesContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, nome.toUpperCase().trim(), pageable);
	}
	
	//Herdar de um mes para o outro
	public void herdarDeUmMesParaOOutro(Unidades unidade, PessoaOperadores pessoaOperadores, Long anoMesInicial, Long anoMesFinal) {
		
		List<PessoaChDif> listaInicial = buscarPorMesExato(anoMesService.buscarPorId(anoMesInicial), unidade); 
		List<PessoaChDif> listaFinal = buscarPorMesExato(anoMesService.buscarPorId(anoMesFinal), unidade);
		
		if( (!listaInicial.isEmpty())  &&  (listaFinal.isEmpty()) ) {
			for(int i=0;i<listaInicial.size();i++) {
				PessoaChDif f = new PessoaChDif();
				f.setId(null);
				f.setIdUnidadeFk(listaInicial.get(i).getIdUnidadeFk());
				f.setIdAnoMesFk(anoMesService.buscarPorId(anoMesFinal));
				f.setDtCadastro(new Date());
				f.setIdOperadorCadastroFk(pessoaOperadores);
				f.setDtCancelamento(listaInicial.get(i).getDtCancelamento());
				f.setIdOperadorCancelamentoFk(listaInicial.get(i).getIdOperadorCancelamentoFk());
				f.setIdPessoaFk(listaInicial.get(i).getIdPessoaFk());
				
				salvar(f);
			}
		}
	}
	
	
	
	public List<AnoMes> buscarMesesCompativeis(Unidades unidades){
		List<UnidadeAdmiteChDif> lista = unidadeAdmiteChDifService.buscarPorUnidade(unidades);
		List <AnoMes> listaMeses= new ArrayList<>();
		
		for(int i=0;i<lista.size();i++) {
			if(!listaMeses.contains(lista.get(i).getIdAnoMesFk())) {
				listaMeses.add(lista.get(i).getIdAnoMesFk());
			}
		}
		return listaMeses;
	}
	
	public List<SimNao> listaSimNaoCompativelComPessoa(Unidades unidades, Pessoa pessoa, AnoMes anoMes){
		List<SimNao> lista = new ArrayList<>();
		lista.add(simNaoService.buscarPorSigla("N").get(0));
		if(cadastrado(unidades, pessoa, anoMes)==true) {
			lista.add(simNaoService.buscarPorSigla("S").get(0));
		}
		return lista;
	}
	
	public boolean cadastrado(Unidades unidades, Pessoa pessoa, AnoMes anoMes) {
		boolean resposta = false;
		if(!reposytory.findByIdUnidadeFkAndIdPessoaFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc( unidades,  pessoa,  anoMes).isEmpty()) {resposta = true;}
		return resposta;
	}
	
	
}
