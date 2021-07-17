package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentosCtps;

@Repository
public interface PessoaDocumentosCtpsReposytory extends JpaRepository<PessoaDocumentosCtps, Long> {

	public List<PessoaDocumentosCtps> findAllByOrderByNumeroAsc();

	public List<PessoaDocumentosCtps> findByNumeroContainingOrderByNumeroAsc(String numero);
	
	public List<PessoaDocumentosCtps> findByIdPessoaFk(Pessoa pessoa);
}
