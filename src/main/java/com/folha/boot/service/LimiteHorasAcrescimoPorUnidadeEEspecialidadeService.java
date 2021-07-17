package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.LimiteHorasAcrescimoPorUnidadeEEspecialidadeReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.domain.LimiteHorasAcrescimoPorUnidadeEEspecialidade;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class LimiteHorasAcrescimoPorUnidadeEEspecialidadeService {

	@Autowired
	private  LimiteHorasAcrescimoPorUnidadeEEspecialidadeReposytory reposytory;
	
	@Autowired
	private AnoMesService anoMesService;

	public void salvar(LimiteHorasAcrescimoPorUnidadeEEspecialidade limiteHorasAcrescimoPorUnidadeEEspecialidade) {
		reposytory.save(limiteHorasAcrescimoPorUnidadeEEspecialidade);
	}

	public void editar(LimiteHorasAcrescimoPorUnidadeEEspecialidade limiteHorasAcrescimoPorUnidadeEEspecialidade) {
		reposytory.save(limiteHorasAcrescimoPorUnidadeEEspecialidade);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public LimiteHorasAcrescimoPorUnidadeEEspecialidade buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> buscarPorMesExato(AnoMes anoMes) {
		return reposytory.findByIdAnoMesFkOrderByIdAnoMesFkNomeAnoMesDesc(anoMes);
	}
	
	public List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> buscarNaUnidade(String nome) {
		return reposytory.findByIdUnidadeFkNomeFantasiaContainingOrderByIdAnoMesFkNomeAnoMesDesc(nome.toUpperCase().trim());
	}
	
	public List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> buscarTodos() {
		return reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDesc();
	}
	
	public List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> buscarLimite(Unidades unidades, AnoMes anoMes, CargosEspecialidade cargosEspecialidade) {
		return reposytory.findFirstByIdUnidadeFkAndIdAnoMesFkAndIdEspecialidadeFkOrderByIdAnoMesFkNomeAnoMesDesc(unidades , anoMes, cargosEspecialidade);
	}
	
	
	@Transactional(readOnly = true)
	public Page<LimiteHorasAcrescimoPorUnidadeEEspecialidade> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdAnoMesFkNomeAnoMesDesc( pageable);
	}

	@Transactional(readOnly = true)
	public Page<LimiteHorasAcrescimoPorUnidadeEEspecialidade> findPaginatedUnidade(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeFkNomeFantasiaContainingOrderByIdAnoMesFkNomeAnoMesDesc( nome.toUpperCase().trim(),  pageable);
	}
	
	//Herdar de um mes para o outro
		public void herdarDeUmMesParaOOutro(Long anoMesInicial, Long anoMesFinal) {
			
			List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> listaInicial = buscarPorMesExato(anoMesService.buscarPorId(anoMesInicial)); 
			List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> listaFinal = buscarPorMesExato(anoMesService.buscarPorId(anoMesFinal));
			
			if( (!listaInicial.isEmpty())  &&  (listaFinal.isEmpty()) ) {
				for(int i=0;i<listaInicial.size();i++) {
					LimiteHorasAcrescimoPorUnidadeEEspecialidade f = new LimiteHorasAcrescimoPorUnidadeEEspecialidade();
					f.setId(null);
					f.setIdAnoMesFk(anoMesService.buscarPorId(anoMesFinal));
					f.setHoras( listaInicial.get(i).getHoras() );
					f.setIdEspecialidadeFk(listaInicial.get(i).getIdEspecialidadeFk());
					f.setIdUnidadeFk(listaInicial.get(i).getIdUnidadeFk());
					f.setMotivo(listaInicial.get(i).getMotivo());
					
					salvar(f);
				}
			}
		}
	
}
