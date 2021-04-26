package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.AreasDeCapacitacaoReposytory;
import com.folha.boot.Reposytory.EscalaCodDiferenciadoReposytory;
import com.folha.boot.Reposytory.PessoaCodDiferenciadoReposytory;
import com.folha.boot.domain.AreasDeCapacitacao;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.EscalaCodDiferenciado;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaCodDiferenciado;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class EscalaCodDiferenciadoService {
	@Autowired
	private  EscalaCodDiferenciadoReposytory reposytory;
	
	public void salvar(EscalaCodDiferenciado escalaCodDiferenciado) {
		reposytory.save(escalaCodDiferenciado);
	}

	public void editar(EscalaCodDiferenciado escalaCodDiferenciado) {
		reposytory.save(escalaCodDiferenciado);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public EscalaCodDiferenciado buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<EscalaCodDiferenciado> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findByDtCancelamentoIsNullOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAsc();
	}
	
	public List<EscalaCodDiferenciado> buscarPorEscala(Escala escala) {
		return reposytory.findByIdEscalaFkAndDtCancelamentoIsNullOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAsc(escala);
	}
	
	public List<EscalaCodDiferenciado> buscarPorEscalaECodDiferenciado(Escala escala, CodigoDiferenciado codigoDiferenciado) {
		return reposytory.findByIdEscalaFkAndIdCodigoDiferenciadoFkAndDtCancelamentoIsNullOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAsc(escala, codigoDiferenciado);
	}
	
	public boolean escalaCodDiferenciadoCadastrado (Escala escala, CodigoDiferenciado codigoDiferenciado) {
		boolean resposta = false;
		List<EscalaCodDiferenciado> lista = buscarPorEscalaECodDiferenciado( escala,  codigoDiferenciado);
		if(!lista.isEmpty()) {resposta = true;}
		return resposta;
	}
	
	//Listagem Paginada

	@Transactional(readOnly = true)
	public Page<EscalaCodDiferenciado> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByDtCancelamentoIsNullOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAsc(  pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<EscalaCodDiferenciado> findPaginatedEscala(Escala escala, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdEscalaFkAndDtCancelamentoIsNullOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAsc(escala,  pageable);
	}

	
	
	
	
}
