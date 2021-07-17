package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.TiposDeFolhaVinculoReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.TiposDeFolhaVinculo;
import com.folha.boot.domain.Vinculos;

@Service
@Transactional(readOnly = false)
public class TiposDeFolhaVinculoService {

	@Autowired
	private TiposDeFolhaVinculoReposytory reposytory;
	
	@Autowired
	private AnoMesService anoMesService;
	

	public void salvar(TiposDeFolhaVinculo tiposDeFolhaVinculo) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeFolhaVinculo);
	}

	public void editar(TiposDeFolhaVinculo tiposDeFolhaVinculo) {
		// TODO Auto-generated method stub
		reposytory.save(tiposDeFolhaVinculo);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public TiposDeFolhaVinculo buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<TiposDeFolhaVinculo> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc();
	}
	@Transactional(readOnly = true)
	public List<TiposDeFolhaVinculo> buscarPorNome(String nome) {
		return reposytory.findByIdTipoDeFolhaFkNomeTipoFolhaContainingOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(nome);
	}
	
	@Transactional(readOnly = true)
	public List<TiposDeFolhaVinculo> buscarPorMesExato(AnoMes anoMes) {
		return reposytory.findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(anoMes);
	}
	
	@Transactional(readOnly = true)
	public List<TiposDeFolhaVinculo> buscarPorMesVinculo(AnoMes anoMes, Vinculos vinculo) {
		return reposytory.findByIdAnoMesFkAndIdVinculoFkOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(anoMes, vinculo);
	}
	
	
	public Page<TiposDeFolhaVinculo> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(pageable);
	}

	public Page<TiposDeFolhaVinculo> findPaginatedAnoMes(int pageNo, int pageSize, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdTipoDeFolhaFkNomeTipoFolhaAsc(nome.toUpperCase().trim(), pageable);
	}
	
	//Herdar de um mes para o outro
	public void herdarDeUmMesParaOOutro(Long anoMesInicial, Long anoMesFinal) {
		
		List<TiposDeFolhaVinculo> listaInicial = buscarPorMesExato(anoMesService.buscarPorId(anoMesInicial)); 
		List<TiposDeFolhaVinculo> listaFinal = buscarPorMesExato(anoMesService.buscarPorId(anoMesFinal));
		
		if( (!listaInicial.isEmpty())  &&  (listaFinal.isEmpty()) ) {
			for(int i=0;i<listaInicial.size();i++) {
				TiposDeFolhaVinculo f = new TiposDeFolhaVinculo();
				f.setId(null);
				f.setIdVinculoFk(listaInicial.get(i).getIdVinculoFk());
				f.setIdAnoMesFk(anoMesService.buscarPorId(anoMesFinal));
				f.setIdTipoDeFolhaFk(listaInicial.get(i).getIdTipoDeFolhaFk());
				
				salvar(f);
			}
		}
	}
	
	

	
}
