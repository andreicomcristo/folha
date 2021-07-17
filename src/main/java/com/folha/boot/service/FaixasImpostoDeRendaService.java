package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.FaixasImpostoDeRendaReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasImpostoDeRenda;

@Service
@Transactional(readOnly = false)
public class FaixasImpostoDeRendaService {

	@Autowired
	private FaixasImpostoDeRendaReposytory reposytory;
	
	@Autowired
	private AnoMesService anoMesService;

	public void salvar(FaixasImpostoDeRenda faixasImpostoDeRenda) {
		// TODO Auto-generated method stub
		reposytory.save(faixasImpostoDeRenda);
	}

	public void editar(FaixasImpostoDeRenda faixasImpostoDeRenda) {
		// TODO Auto-generated method stub
		reposytory.save(faixasImpostoDeRenda);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public FaixasImpostoDeRenda buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<FaixasImpostoDeRenda> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc();
	}
	
	@Transactional(readOnly = true)
	public List<FaixasImpostoDeRenda> buscarPorAnoMes(String anoMes) {
		return reposytory.findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc(anoMes);
	}
	
	@Transactional(readOnly = true)
	public List<FaixasImpostoDeRenda> buscarPorAnoMesExato(AnoMes anoMes) {
		return reposytory.findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc(anoMes);
	}
	
	@Transactional(readOnly = true)
	public Page<FaixasImpostoDeRenda> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc(  pageable);
	}

	@Transactional(readOnly = true)
	public Page<FaixasImpostoDeRenda> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc(  nome.toUpperCase().trim(), pageable);
	}
	
	
	//Herdar de um mes para o outro
	public void herdarDeUmMesParaOOutro(Long anoMesInicial, Long anoMesFinal) {
		
		List<FaixasImpostoDeRenda> listaInicial = buscarPorAnoMesExato(anoMesService.buscarPorId(anoMesInicial)); 
		List<FaixasImpostoDeRenda> listaFinal = buscarPorAnoMesExato(anoMesService.buscarPorId(anoMesFinal));
		
		if( (!listaInicial.isEmpty())  &&  (listaFinal.isEmpty()) ) {
			for(int i=0;i<listaInicial.size();i++) {
				FaixasImpostoDeRenda f = new FaixasImpostoDeRenda();
				f.setId(null);
				f.setAliquota(listaInicial.get(i).getAliquota());
				f.setIdAnoMesFk(anoMesService.buscarPorId(anoMesFinal));
				f.setBaseCalculoValorFinal(listaInicial.get(i).getBaseCalculoValorFinal());
				f.setBaseCalculoValorInicial(listaInicial.get(i).getBaseCalculoValorInicial());
				f.setIdFaixasImpostoDeRendaNomeFk(listaInicial.get(i).getIdFaixasImpostoDeRendaNomeFk());
				f.setParcelaADevolver(listaInicial.get(i).getParcelaADevolver());
				f.setParcelaASubtrair(listaInicial.get(i).getParcelaASubtrair());
				
				salvar(f);
			}
		}
	}
	
	
	
}
