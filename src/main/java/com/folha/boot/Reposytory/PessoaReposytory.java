package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Pessoa;

@Repository
public interface PessoaReposytory extends JpaRepository<Pessoa, Long> {
	
	//Metodos para Sede
	public Page<Pessoa> findByDtCancelamentoIsNullOrderByNomeAsc(final Pageable page);
	public Page<Pessoa> findByNomeContainingAndDtCancelamentoIsNullOrderByNomeAsc(final Pageable page, String nome);
	public Page<Pessoa> findByCpfContainingAndDtCancelamentoIsNullOrderByNomeAsc(final Pageable page, String cpf);
	
	
	
	public List<Pessoa> findByDtCancelamentoIsNullOrderByNomeAsc();

	public List<Pessoa> findByNomeContainingAndDtCancelamentoIsNullOrderByNomeAsc(String nome);
	
	public List<Pessoa> findByCpfAndDtCancelamentoIsNullOrderByNomeAsc(String nome);
}
