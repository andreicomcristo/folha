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

import com.folha.boot.Reposytory.PessoaComplementoDePlantaoReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaComplementoDePlantao;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.UnidadeAdmiteComplementoPlantao;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class PessoaComplementoDePlantaoService {

	@Autowired
	private PessoaComplementoDePlantaoReposytory reposytory;
	
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	private UnidadeAdmiteComplementoPlantaoService unidadeAdmiteComplementoDePlantaoService;
	@Autowired
	private SimNaoService simNaoService;
	

	public void salvar(PessoaComplementoDePlantao pessoaComplementoDePlantao) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaComplementoDePlantao);
	}

	public void editar(PessoaComplementoDePlantao pessoaComplementoDePlantao) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaComplementoDePlantao);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public PessoaComplementoDePlantao buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	public List<PessoaComplementoDePlantao> buscarPorUnidadeEPessoa(Unidades unidades, Pessoa pessoa) {
		return reposytory.findByIdUnidadeFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, pessoa);
	}
	
	@Transactional(readOnly = true)
	public List<PessoaComplementoDePlantao> buscarTodos(Unidades unidades) {
		// TODO Auto-generated method stub
		return reposytory.findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades);
	}
	@Transactional(readOnly = true)
	public List<PessoaComplementoDePlantao> buscarPorNome(String nome, Unidades unidades) {
		return reposytory.findByIdUnidadeFkAndIdPessoaFkNomeContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, nome);
	}
	
	
	@Transactional(readOnly = true)
	public List<PessoaComplementoDePlantao> buscarPorMesExato(AnoMes anoMes, Unidades unidades) {
		return reposytory.findByIdUnidadeFkAndIdAnoMesFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, anoMes);
	}
	
	@Transactional(readOnly = true)
	public List<PessoaComplementoDePlantao> buscarPorMesExatoUnidadePessoa(AnoMes anoMes, Unidades unidades, Pessoa pessoa) {
		return reposytory.findByIdUnidadeFkAndIdAnoMesFkAndIdPessoaFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, anoMes, pessoa);
	}
	
	
	public Page<PessoaComplementoDePlantao> findPaginated(int pageNo, int pageSize, Unidades unidades) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeFkAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, pageable);
	}

	public Page<PessoaComplementoDePlantao> findPaginatedAnoMes(int pageNo, int pageSize, String nome, Unidades unidades) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeFkAndIdAnoMesFkNomeAnoMesContainingAndDtCancelamentoIsNullOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAscIdPessoaFkNomeAsc(unidades, nome.toUpperCase().trim(), pageable);
	}
	
	
	
	//Herdar de um mes para o outro
	public void herdarDeUmMesParaOOutro(Unidades unidade, PessoaOperadores pessoaOperadores, Long anoMesInicial, Long anoMesFinal) {
		
		List<PessoaComplementoDePlantao> listaInicial = buscarPorMesExato(anoMesService.buscarPorId(anoMesInicial), unidade); 
		List<PessoaComplementoDePlantao> listaFinal = buscarPorMesExato(anoMesService.buscarPorId(anoMesFinal), unidade);
		
		if( (!listaInicial.isEmpty())  &&  (listaFinal.isEmpty()) ) {
			for(int i=0;i<listaInicial.size();i++) {
				PessoaComplementoDePlantao f = new PessoaComplementoDePlantao();
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
		List<UnidadeAdmiteComplementoPlantao> lista = unidadeAdmiteComplementoDePlantaoService.buscarPorUnidade(unidades);
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
