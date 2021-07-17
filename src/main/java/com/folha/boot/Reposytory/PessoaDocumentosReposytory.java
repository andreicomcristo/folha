package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;

@Repository
public interface PessoaDocumentosReposytory extends JpaRepository<PessoaDocumentos, Long> {

	public List<PessoaDocumentos> findAllByOrderByNumeroDocumentoAsc();

	public List<PessoaDocumentos> findByNumeroDocumentoContainingOrderByNumeroDocumentoAsc(String numeroDocumento);
	
	public List<PessoaDocumentos> findByIdPessoaFk(Pessoa pessoa);
}
