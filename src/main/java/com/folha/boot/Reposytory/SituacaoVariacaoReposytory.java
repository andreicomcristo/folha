package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.SituacaoVariacao;

@Repository
public interface SituacaoVariacaoReposytory extends JpaRepository<SituacaoVariacao, Long> {

	public List<SituacaoVariacao> findAllByOrderByNomeAsc();
	
	public List<SituacaoVariacao> findByNomeContainingOrderByNomeAsc(String nome);

}
