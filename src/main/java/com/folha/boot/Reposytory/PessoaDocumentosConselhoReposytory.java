package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentosConselho;

@Repository
public interface PessoaDocumentosConselhoReposytory extends JpaRepository<PessoaDocumentosConselho, Long> {

	public List<PessoaDocumentosConselho> findAllByOrderByNumeroConselhoAsc();

	public List<PessoaDocumentosConselho> findByNumeroConselhoContainingOrderByNumeroConselhoAsc(String numeroConselho);
	
	public List<PessoaDocumentosConselho> findByIdPessoaFk(Pessoa pessoa);
	
	public List<PessoaDocumentosConselho> findByIdPessoaFkOrderByDtValidadeDesc (Pessoa pessoa);
}
