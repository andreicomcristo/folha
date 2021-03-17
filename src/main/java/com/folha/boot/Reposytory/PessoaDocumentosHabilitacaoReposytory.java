package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentosHabilitacao;

@Repository
public interface PessoaDocumentosHabilitacaoReposytory extends JpaRepository<PessoaDocumentosHabilitacao, Long> {

	public List<PessoaDocumentosHabilitacao> findAllByOrderByNumeroRegistroAsc();

	public List<PessoaDocumentosHabilitacao> findByNumeroRegistroContainingOrderByNumeroRegistroAsc(String numeroRegistro);
	
	public List<PessoaDocumentosHabilitacao> findByIdPessoaFk(Pessoa pessoa);
}
