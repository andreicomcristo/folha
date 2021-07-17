package com.folha.boot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PessoaIncrementoDeRiscoReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaIncrementoDeRisco;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.UnidadeAdmiteIncrementoDeRisco;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class PessoaIncrementoDeRiscoService {

	@Autowired
	private PessoaIncrementoDeRiscoReposytory reposytory;
	
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	private UnidadeAdmiteIncrementoDeRiscoService unidadeAdmiteIncrementoDeRiscoService;
	@Autowired
	private SimNaoService simNaoService;
	

	public void salvar(PessoaIncrementoDeRisco pessoaIncrementoDeRisco) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaIncrementoDeRisco);
	}

	public void editar(PessoaIncrementoDeRisco pessoaIncrementoDeRisco) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaIncrementoDeRisco);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public PessoaIncrementoDeRisco buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	public List<PessoaIncrementoDeRisco> buscarPorUnidadeEPessoa(Unidades unidades, Pessoa pessoa) {
		return reposytory.findByIdUnidadeFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, pessoa);
	}
	
	@Transactional(readOnly = true)
	public List<PessoaIncrementoDeRisco> buscarTodos(Unidades unidades) {
		// TODO Auto-generated method stub
		return reposytory.findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades);
	}
	@Transactional(readOnly = true)
	public List<PessoaIncrementoDeRisco> buscarPorNome(String nome, Unidades unidades) {
		return reposytory.findByIdUnidadeFkAndIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, nome);
	}
	
	
	@Transactional(readOnly = true)
	public List<PessoaIncrementoDeRisco> buscarPorMesExato(AnoMes anoMes, Unidades unidades) {
		return reposytory.findByIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, anoMes);
	}
	
	@Transactional(readOnly = true)
	public List<PessoaIncrementoDeRisco> buscarPorMesExatoUnidadePessoa(AnoMes anoMes, Unidades unidades, Pessoa pessoa) {
		return reposytory.findByIdUnidadeFkAndIdAnoMesFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, anoMes, pessoa);
	}
	
	
	public Page<PessoaIncrementoDeRisco> findPaginated(int pageNo, int pageSize, Unidades unidades) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, pageable);
	}

	public Page<PessoaIncrementoDeRisco> findPaginatedAnoMes(int pageNo, int pageSize, String nome, Unidades unidades) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeFkAndIdAnoMesFkNomeAnoMesContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, nome.toUpperCase().trim(), pageable);
	}
	
	
	
	//Herdar de um mes para o outro
	public void herdarDeUmMesParaOOutro(Unidades unidade, PessoaOperadores pessoaOperadores, Long anoMesInicial, Long anoMesFinal) {
		
		List<PessoaIncrementoDeRisco> listaInicial = buscarPorMesExato(anoMesService.buscarPorId(anoMesInicial), unidade); 
		List<PessoaIncrementoDeRisco> listaFinal = buscarPorMesExato(anoMesService.buscarPorId(anoMesFinal), unidade);
		
		if( (!listaInicial.isEmpty())  &&  (listaFinal.isEmpty()) ) {
			for(int i=0;i<listaInicial.size();i++) {
				PessoaIncrementoDeRisco f = new PessoaIncrementoDeRisco();
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
		List<UnidadeAdmiteIncrementoDeRisco> lista = unidadeAdmiteIncrementoDeRiscoService.buscarPorUnidade(unidades);
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
