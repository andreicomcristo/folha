package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFilhos;

@Repository
public interface PessoaFilhosReposytory extends JpaRepository<PessoaFilhos, Long> {

	public List<PessoaFilhos> findAllByOrderByNomeFilhoAsc();

	public List<PessoaFilhos> findByNomeFilhoContainingOrderByNomeFilhoAsc(String nomeFilho);
	
	public List<PessoaFilhos> findByIdPessoaFkOrderByNomeFilhoAsc(Pessoa pessoa);
}
