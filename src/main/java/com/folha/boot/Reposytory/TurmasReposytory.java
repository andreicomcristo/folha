package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Turmas;

@Repository
public interface TurmasReposytory extends JpaRepository<Turmas, Long>{
	
	public List<Turmas> findAllByOrderByDescricaoTurmaAsc();
	
	public Turmas findFirstByNomeTurmaOrderByDescricaoTurmaAsc(String nome);
}
