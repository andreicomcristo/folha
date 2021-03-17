package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFotos;

@Repository
public interface PessoaFotosReposytory extends JpaRepository<PessoaFotos, Long> {

	public List<PessoaFotos> findByIdPessoaFk(Pessoa pessoa);
}
