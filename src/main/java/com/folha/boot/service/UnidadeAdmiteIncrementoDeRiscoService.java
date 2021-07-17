package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.UnidadeAdmiteIncrementoDeRiscoReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.UnidadeAdmiteIncrementoDeRisco;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class UnidadeAdmiteIncrementoDeRiscoService {

	@Autowired
	private UnidadeAdmiteIncrementoDeRiscoReposytory reposytory;
	
	@Autowired
	private AnoMesService anoMesService;
	

	public void salvar(UnidadeAdmiteIncrementoDeRisco unidadeAdmiteIncrementoDeRisco) {
		// TODO Auto-generated method stub
		reposytory.save(unidadeAdmiteIncrementoDeRisco);
	}

	public void editar(UnidadeAdmiteIncrementoDeRisco unidadeAdmiteIncrementoDeRisco) {
		// TODO Auto-generated method stub
		reposytory.save(unidadeAdmiteIncrementoDeRisco);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public UnidadeAdmiteIncrementoDeRisco buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<UnidadeAdmiteIncrementoDeRisco> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc();
	}
	@Transactional(readOnly = true)
	public List<UnidadeAdmiteIncrementoDeRisco> buscarPorNome(String nome) {
		return reposytory.findByIdUnidadeFkNomeFantasiaContainingOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(nome);
	}
	
	@Transactional(readOnly = true)
	public List<UnidadeAdmiteIncrementoDeRisco> buscarPorUnidade(Unidades unidades) {
		return reposytory.findByIdUnidadeFkOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(unidades);
	}
	
	@Transactional(readOnly = true)
	public List<UnidadeAdmiteIncrementoDeRisco> buscarPorMesExato(AnoMes anoMes) {
		return reposytory.findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(anoMes);
	}
	
	@Transactional(readOnly = true)
	public List<UnidadeAdmiteIncrementoDeRisco> buscarPorMesExatoUnidade(AnoMes anoMes, Unidades unidade) {
		return reposytory.findByIdAnoMesFkAndIdUnidadeFkOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(anoMes, unidade);
	}
	
	public Page<UnidadeAdmiteIncrementoDeRisco> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(pageable);
	}

	public Page<UnidadeAdmiteIncrementoDeRisco> findPaginatedAnoMes(int pageNo, int pageSize, String nomeCidade) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdUnidadeFkNomeFantasiaAsc(nomeCidade.toUpperCase().trim(), pageable);
	}
	
	//Herdar de um mes para o outro
	public void herdarDeUmMesParaOOutro(Long anoMesInicial, Long anoMesFinal) {
		
		List<UnidadeAdmiteIncrementoDeRisco> listaInicial = buscarPorMesExato(anoMesService.buscarPorId(anoMesInicial)); 
		List<UnidadeAdmiteIncrementoDeRisco> listaFinal = buscarPorMesExato(anoMesService.buscarPorId(anoMesFinal));
		
		if( (!listaInicial.isEmpty())  &&  (listaFinal.isEmpty()) ) {
			for(int i=0;i<listaInicial.size();i++) {
				UnidadeAdmiteIncrementoDeRisco f = new UnidadeAdmiteIncrementoDeRisco();
				f.setId(null);
				f.setIdUnidadeFk(listaInicial.get(i).getIdUnidadeFk());
				f.setIdAnoMesFk(anoMesService.buscarPorId(anoMesFinal));
				
				salvar(f);
			}
		}
	}
	
	

	
}
