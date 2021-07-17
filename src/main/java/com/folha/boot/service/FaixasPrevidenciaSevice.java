package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.FaixasPrevidenciaReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasPrevidencia;

@Service
@Transactional(readOnly = false)
public class FaixasPrevidenciaSevice {

	@Autowired
	private AnoMesService anoMesService;
	
	@Autowired
	private FaixasPrevidenciaReposytory reposytory;

	public void salvar(FaixasPrevidencia faixasPrevidencia) {
		// TODO Auto-generated method stub
		reposytory.save(faixasPrevidencia);
	}

	public void editar(FaixasPrevidencia faixasPrevidencia) {
		// TODO Auto-generated method stub
		reposytory.save(faixasPrevidencia);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public FaixasPrevidencia buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<FaixasPrevidencia> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc();
	}
	@Transactional(readOnly = true)
	public List<FaixasPrevidencia> buscarPorAnoMes(String anoMes) {
		return reposytory.findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc(anoMes);
	}
	
	@Transactional(readOnly = true)
	public List<FaixasPrevidencia> buscarPorAnoMesExato(AnoMes anoMes) {
		return reposytory.findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc(anoMes);
	}
	
	
	@Transactional(readOnly = true)
	public Page<FaixasPrevidencia> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc(  pageable);
	}

	@Transactional(readOnly = true)
	public Page<FaixasPrevidencia> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdAnoMesFkNomeAnoMesContainingOrderByIdAnoMesFkNomeAnoMesDescBaseCalculoValorInicialAsc(  nome.toUpperCase().trim(), pageable);
	}
	
	//Herdar de um mes para o outro
	public void herdarDeUmMesParaOOutro(Long anoMesInicial, Long anoMesFinal) {
		
		List<FaixasPrevidencia> listaInicial = buscarPorAnoMesExato(anoMesService.buscarPorId(anoMesInicial)); 
		List<FaixasPrevidencia> listaFinal = buscarPorAnoMesExato(anoMesService.buscarPorId(anoMesFinal));
		
		if( (!listaInicial.isEmpty())  &&  (listaFinal.isEmpty()) ) {
			for(int i=0;i<listaInicial.size();i++) {
				FaixasPrevidencia f = new FaixasPrevidencia();
				f.setId(null);
				f.setAliquota(listaInicial.get(i).getAliquota());
				f.setIdAnoMesFk(anoMesService.buscarPorId(anoMesFinal));
				f.setBaseCalculoValorFinal(listaInicial.get(i).getBaseCalculoValorFinal());
				f.setBaseCalculoValorInicial(listaInicial.get(i).getBaseCalculoValorInicial());
				f.setIdFaixasPrevidenciaNomeFk(listaInicial.get(i).getIdFaixasPrevidenciaNomeFk());
				f.setParcelaADevolver(listaInicial.get(i).getParcelaADevolver());
				f.setParcelaASubtrair(listaInicial.get(i).getParcelaASubtrair());
				
				salvar(f);
			}
		}
	}
	
	
	
}
