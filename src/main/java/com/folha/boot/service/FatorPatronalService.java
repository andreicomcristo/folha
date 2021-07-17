package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.FatorPatronalReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FatorPatronal;

@Service
@Transactional(readOnly = false)
public class FatorPatronalService {

	@Autowired
	private FatorPatronalReposytory reposytory;
	
	@Autowired
	private AnoMesService anoMesService;
	

	public void salvar(FatorPatronal fatorPatronal) {
		// TODO Auto-generated method stub
		reposytory.save(fatorPatronal);
	}

	public void editar(FatorPatronal fatorPatronal) {
		// TODO Auto-generated method stub
		reposytory.save(fatorPatronal);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public FatorPatronal buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<FatorPatronal> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	}
	
	
	@Transactional(readOnly = true)
	public List<FatorPatronal> buscarPorMesExato(AnoMes anoMes) {
		return reposytory.findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(anoMes);
	}
	
	
	public Page<FatorPatronal> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDesc(pageable);
	}

	public Page<FatorPatronal> findPaginatedAnoMes(int pageNo, int pageSize, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDesc(nome.toUpperCase().trim(), pageable);
	}
	
	//Herdar de um mes para o outro
	public void herdarDeUmMesParaOOutro(Long anoMesInicial, Long anoMesFinal) {
		
		List<FatorPatronal> listaInicial = buscarPorMesExato(anoMesService.buscarPorId(anoMesInicial)); 
		List<FatorPatronal> listaFinal = buscarPorMesExato(anoMesService.buscarPorId(anoMesFinal));
		
		if( (!listaInicial.isEmpty())  &&  (listaFinal.isEmpty()) ) {
			for(int i=0;i<listaInicial.size();i++) {
				FatorPatronal f = new FatorPatronal();
				f.setId(null);
				f.setFator(listaInicial.get(i).getFator());
				f.setIdAnoMesFk(anoMesService.buscarPorId(anoMesFinal));
				
				salvar(f);
			}
		}
	}
	
	
	

	
}
