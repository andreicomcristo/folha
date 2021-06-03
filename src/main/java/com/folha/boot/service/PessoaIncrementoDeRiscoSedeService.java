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
import com.folha.boot.Reposytory.PessoaIncrementoDeRiscoSedeReposytory;
import com.folha.boot.Reposytory.UnidadeAdmiteChDifReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaChDif;
import com.folha.boot.domain.PessoaCodDiferenciado;
import com.folha.boot.domain.PessoaIncrementoDeRiscoSede;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.UnidadeAdmiteChDif;
import com.folha.boot.domain.UnidadeAdmiteIncrementoDeRisco;
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
public class PessoaIncrementoDeRiscoSedeService {

	@Autowired
	private PessoaIncrementoDeRiscoSedeReposytory reposytory;
	
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	private UnidadeAdmiteIncrementoDeRiscoService unidadeAdmiteIncrementoDeRiscoService;
	@Autowired
	private SimNaoService simNaoService;
	

	public void salvar(PessoaIncrementoDeRiscoSede pessoaIncrementoDeRiscoSede) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaIncrementoDeRiscoSede);
	}

	public void editar(PessoaIncrementoDeRiscoSede pessoaIncrementoDeRiscoSede) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaIncrementoDeRiscoSede);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public PessoaIncrementoDeRiscoSede buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	public List<PessoaIncrementoDeRiscoSede> buscarPorUnidadeEPessoa(Unidades unidades, Pessoa pessoa) {
		return reposytory.findByIdUnidadeFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc(unidades, pessoa);
	}
	
	public List<PessoaIncrementoDeRiscoSede> buscarPorPessoa( Pessoa pessoa) {
		return reposytory.findByIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc( pessoa);
	}
	
	
	@Transactional(readOnly = true)
	public List<PessoaIncrementoDeRiscoSede> buscarTodos(Unidades unidades) {
		// TODO Auto-generated method stub
		return reposytory.findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc(unidades);
	}
	@Transactional(readOnly = true)
	public List<PessoaIncrementoDeRiscoSede> buscarPorNome(String nome, Unidades unidades) {
		return reposytory.findByIdUnidadeFkAndIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc(unidades, nome.toUpperCase());
	}
	
	public Page<PessoaIncrementoDeRiscoSede> findPaginated(int pageNo, int pageSize, Unidades unidades) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc( pageable);
	}

	
	public Page<PessoaIncrementoDeRiscoSede> findPaginatedNome(int pageNo, int pageSize, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc(nome.toUpperCase(), pageable);
	}
	
	public List<AnoMes> buscarMesesCompativeis(Unidades unidades){
		List<UnidadeAdmiteIncrementoDeRisco> lista = unidadeAdmiteIncrementoDeRiscoService.buscarPorUnidade(unidades);
		List <AnoMes> listaMeses= new ArrayList<>();
		
		for(int i=0;i<lista.size();i++) {
			if(!listaMeses.contains(lista.get(i).getIdAnoMesFk())) {
				listaMeses.add(lista.get(i).getIdAnoMesFk());
			}
		}
		return listaMeses;
	}

	public List<SimNao> listaSimNaoCompativelComPessoa(Unidades unidades, Pessoa pessoa){
		List<SimNao> lista = new ArrayList<>();
		lista.add(simNaoService.buscarPorSigla("N").get(0));
		if(cadastrado(unidades, pessoa)==true) {
			lista.add(simNaoService.buscarPorSigla("S").get(0));
		}
		return lista;
	}
	
	public boolean cadastrado(Unidades unidades, Pessoa pessoa) {
		boolean resposta = false;
		if(!reposytory.findByIdUnidadeFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc( unidades,  pessoa).isEmpty()) {resposta = true;}
		return resposta;
	}
	
}
