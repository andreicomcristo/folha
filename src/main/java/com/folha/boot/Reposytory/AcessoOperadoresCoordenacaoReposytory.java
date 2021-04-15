package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.AcessoOperadoresCoordenacao;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.Unidades;

@Repository
public interface AcessoOperadoresCoordenacaoReposytory extends JpaRepository<AcessoOperadoresCoordenacao, Long>{

	public List<AcessoOperadoresCoordenacao> findByIdOperadorFk(PessoaOperadores pessoaOperadores);
	
	public List<AcessoOperadoresCoordenacao> findByIdOperadorFkAndIdCoordenacaoFkIdLocalidadeFkIdUnidadeFk(PessoaOperadores pessoaOperadores, Unidades unidades);
	
}
