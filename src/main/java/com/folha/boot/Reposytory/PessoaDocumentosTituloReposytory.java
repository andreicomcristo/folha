package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.PessoaDocumentosTitulo;

@Repository
public interface PessoaDocumentosTituloReposytory extends JpaRepository<PessoaDocumentosTitulo, Long> {

	public List<PessoaDocumentosTitulo> findAllByOrderByNumeroTituloAsc();

	public List<PessoaDocumentosTitulo> findByNumeroTituloContainingOrderByNumeroTituloAsc(String numeroTitulo);
}
