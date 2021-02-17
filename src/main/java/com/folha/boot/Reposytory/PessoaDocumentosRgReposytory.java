package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.PessoaDocumentosRg;

@Repository
public interface PessoaDocumentosRgReposytory extends JpaRepository<PessoaDocumentosRg, Long> {

	public List<PessoaDocumentosRg> findAllByOrderByRgNumeroAsc();

	public List<PessoaDocumentosRg> findByRgNumeroContainingOrderByRgNumeroAsc(String rgNumero);
}
