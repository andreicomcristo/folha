package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.TurnosReposytory;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.Turnos;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class TurnosService {

	@Autowired
	private  TurnosReposytory reposytory;

	public void salvar(Turnos turnos) {
		reposytory.save(turnos);
	}

	public void editar(Turnos turnos) {
		reposytory.save(turnos);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public Turnos buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<Turnos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomeTurnoAsc();
	}
	
	@Transactional(readOnly = true)
	public Turnos buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return reposytory.findFirstByNomeTurnoOrderByNomeTurnoAsc(nome);
	}
	
	
	@Transactional(readOnly = true)
	public Page<Turnos> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByNomeTurnoAsc(  pageable);
	}

	@Transactional(readOnly = true)
	public Page<Turnos> findPaginatedNome( String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByDescricaoTurnoContainingOrderByNomeTurnoAsc( nome.toUpperCase().trim(), pageable);
	}
	
}
