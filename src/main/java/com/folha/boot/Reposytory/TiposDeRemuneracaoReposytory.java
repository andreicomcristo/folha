package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.TiposDeRemuneracao;

@Repository
public interface TiposDeRemuneracaoReposytory extends JpaRepository<TiposDeRemuneracao, Long> {

	public List<TiposDeRemuneracao> findAllByOrderByNomeTipoRemuneracaoAsc();

	public List<TiposDeRemuneracao> findByNomeTipoRemuneracaoContainingOrderByNomeTipoRemuneracaoAsc(String nome);
	
}
