package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.ConversaoFontePorFolhaReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.ConversaoFontePorFolha;
import com.folha.boot.domain.TiposDeFolha;

@Service
@Transactional(readOnly = false)
public class ConversaoFontePorFolhaService {

	@Autowired
	private ConversaoFontePorFolhaReposytory reposytory;
	
	@Autowired
	private AnoMesService anoMesService;
	

	public void salvar(ConversaoFontePorFolha conversaoFontePorFolha) {
		// TODO Auto-generated method stub
		reposytory.save(conversaoFontePorFolha);
	}

	public void editar(ConversaoFontePorFolha conversaoFontePorFolha) {
		// TODO Auto-generated method stub
		reposytory.save(conversaoFontePorFolha);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public ConversaoFontePorFolha buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<ConversaoFontePorFolha> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDescIdFolhaFkNomeTipoFolhaAsc();
	}
	@Transactional(readOnly = true)
	public List<ConversaoFontePorFolha> buscarPorNome(String nome) {
		return reposytory.findByIdFolhaFkNomeTipoFolhaContainingOrderByIdAnoMesFkNomeAnoMesDescIdFolhaFkNomeTipoFolhaAsc(nome);
	}
	
	@Transactional(readOnly = true)
	public List<ConversaoFontePorFolha> buscarPorMesExato(AnoMes anoMes) {
		return reposytory.findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescIdFolhaFkNomeTipoFolhaAsc(anoMes);
	}
	
	@Transactional(readOnly = true)
	public List<ConversaoFontePorFolha> buscarPorMesVinculo(AnoMes anoMes, TiposDeFolha folha) {
		return reposytory.findByIdAnoMesFkAndIdFolhaFkOrderByIdAnoMesFkNomeAnoMesDescIdFolhaFkNomeTipoFolhaAsc(anoMes, folha);
	}
	
	
	public Page<ConversaoFontePorFolha> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDescIdFolhaFkNomeTipoFolhaAsc(pageable);
	}

	public Page<ConversaoFontePorFolha> findPaginatedAnoMes(int pageNo, int pageSize, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescIdFolhaFkNomeTipoFolhaAsc(nome.toUpperCase().trim(), pageable);
	}
	
	//Herdar de um mes para o outro
	public void herdarDeUmMesParaOOutro(Long anoMesInicial, Long anoMesFinal) {
		
		List<ConversaoFontePorFolha> listaInicial = buscarPorMesExato(anoMesService.buscarPorId(anoMesInicial)); 
		List<ConversaoFontePorFolha> listaFinal = buscarPorMesExato(anoMesService.buscarPorId(anoMesFinal));
		
		if( (!listaInicial.isEmpty())  &&  (listaFinal.isEmpty()) ) {
			for(int i=0;i<listaInicial.size();i++) {
				ConversaoFontePorFolha f = new ConversaoFontePorFolha();
				f.setId(null);
				f.setIdAnoMesFk(anoMesService.buscarPorId(anoMesFinal));
				f.setIdFolhaFk(listaInicial.get(i).getIdFolhaFk());
				f.setIdFonteFk(listaInicial.get(i).getIdFonteFk());
				
				salvar(f);
			}
		}
	}
	
	

	
}
