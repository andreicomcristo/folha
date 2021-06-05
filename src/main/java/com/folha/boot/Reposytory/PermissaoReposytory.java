package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.seguranca.Perfil;
import com.folha.boot.domain.seguranca.Permissao;

@Repository
public interface PermissaoReposytory extends JpaRepository<Permissao, Long> {
	
	public List<Permissao> findAllByOrderByNomeAsc();

	public List<Permissao> findByNomeContainingOrderByNomeAsc(String nome);
	
	
	
	public Page<Permissao> findAllByOrderByNomeAsc( final Pageable page);
	
	public Page<Permissao> findByNomeContainingOrderByNomeAsc( String nome, final Pageable page);
	
	
}
