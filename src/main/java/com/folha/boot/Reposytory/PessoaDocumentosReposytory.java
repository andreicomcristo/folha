package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.PessoaDocumentos;

@Repository
public interface PessoaDocumentosReposytory extends JpaRepository<PessoaDocumentos, Long> {

}
