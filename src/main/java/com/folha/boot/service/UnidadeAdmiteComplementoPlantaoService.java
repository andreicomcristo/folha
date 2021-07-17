package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.UnidadeAdmiteComplementoPlantaoReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.UnidadeAdmiteComplementoPlantao;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class UnidadeAdmiteComplementoPlantaoService {

	@Autowired
	private UnidadeAdmiteComplementoPlantaoReposytory reposytory;
	
	@Autowired
	private AnoMesService anoMesService;
	

	public void salvar(UnidadeAdmiteComplementoPlantao unidadeAdmiteComplementoPlantao) {
		// TODO Auto-generated method stub
		reposytory.save(unidadeAdmiteComplementoPlantao);
	}

	public void editar(UnidadeAdmiteComplementoPlantao unidadeAdmiteComplementoPlantao) {
		// TODO Auto-generated method stub
		reposytory.save(unidadeAdmiteComplementoPlantao);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public UnidadeAdmiteComplementoPlantao buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<UnidadeAdmiteComplementoPlantao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc();
	}
	@Transactional(readOnly = true)
	public List<UnidadeAdmiteComplementoPlantao> buscarPorNome(String nome) {
		return reposytory.findByIdUnidadeFkNomeFantasiaContainingOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(nome);
	}
	
	@Transactional(readOnly = true)
	public List<UnidadeAdmiteComplementoPlantao> buscarPorUnidade(Unidades unidades) {
		return reposytory.findByIdUnidadeFkOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(unidades);
	}
	
	@Transactional(readOnly = true)
	public List<UnidadeAdmiteComplementoPlantao> buscarPorMesExato(AnoMes anoMes) {
		return reposytory.findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(anoMes);
	}
	
	@Transactional(readOnly = true)
	public List<UnidadeAdmiteComplementoPlantao> buscarPorMesExatoUnidade(AnoMes anoMes, Unidades unidade) {
		return reposytory.findByIdAnoMesFkAndIdUnidadeFkOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(anoMes, unidade);
	}
	
	
	public Page<UnidadeAdmiteComplementoPlantao> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(pageable);
	}

	public Page<UnidadeAdmiteComplementoPlantao> findPaginatedAnoMes(int pageNo, int pageSize, String nomeCidade) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(nomeCidade.toUpperCase().trim(), pageable);
	}
	
	//Herdar de um mes para o outro
	public void herdarDeUmMesParaOOutro(Long anoMesInicial, Long anoMesFinal) {
		
		List<UnidadeAdmiteComplementoPlantao> listaInicial = buscarPorMesExato(anoMesService.buscarPorId(anoMesInicial)); 
		List<UnidadeAdmiteComplementoPlantao> listaFinal = buscarPorMesExato(anoMesService.buscarPorId(anoMesFinal));
		
		if( (!listaInicial.isEmpty())  &&  (listaFinal.isEmpty()) ) {
			for(int i=0;i<listaInicial.size();i++) {
				UnidadeAdmiteComplementoPlantao f = new UnidadeAdmiteComplementoPlantao();
				f.setId(null);
				f.setIdUnidadeFk(listaInicial.get(i).getIdUnidadeFk());
				f.setIdAnoMesFk(anoMesService.buscarPorId(anoMesFinal));
				
				salvar(f);
			}
		}
	}
	
	

	
}
