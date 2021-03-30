package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AcessoOperadoresCoordenacao;
import com.folha.boot.domain.PessoaOperadores;

@Repository
public interface AcessoOperadoresCoordenacaoReposytory extends JpaRepository<AcessoOperadoresCoordenacao, Long>{

	public List<AcessoOperadoresCoordenacao> findByIdOperadorFk(PessoaOperadores pessoaOperadores);
	
}
