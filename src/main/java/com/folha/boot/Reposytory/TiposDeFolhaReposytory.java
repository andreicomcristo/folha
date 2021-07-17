package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.TiposDeFolha;

@Repository
public interface TiposDeFolhaReposytory extends JpaRepository<TiposDeFolha, Long> {

	public List<TiposDeFolha> findAllByOrderByNomeTipoFolhaAsc();

	public List<TiposDeFolha> findByNomeTipoFolhaContainingOrderByNomeTipoFolhaAsc(String nomeTipoFolha);
	
	public List<TiposDeFolha> findByIdFolhaEfetivaSimNaoFkSiglaOrderByNomeTipoFolhaAsc(String sigla);
	
	public List<TiposDeFolha> findByIdFolhaEfetivaSimNaoFkSiglaAndIdTipoRemuneracaoFkNomeTipoRemuneracaoOrderByNomeTipoFolhaAsc(String sigla, String nome);
	
}
