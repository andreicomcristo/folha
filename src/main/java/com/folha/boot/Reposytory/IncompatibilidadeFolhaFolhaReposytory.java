package com.folha.boot.Reposytory;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.IncompatibilidadeFolhaFolha;
import com.folha.boot.domain.TiposDeFolha;

@Repository
public interface IncompatibilidadeFolhaFolhaReposytory extends JpaRepository<IncompatibilidadeFolhaFolha, Long> {
	
	public List<IncompatibilidadeFolhaFolha> findAllByOrderByIdFolhaFkNomeTipoFolhaAscIdFolhaIncompativelFkNomeTipoFolhaAsc( );
	
	public List<IncompatibilidadeFolhaFolha> findByIdFolhaFkNomeTipoFolhaContainingOrderByIdFolhaFkNomeTipoFolhaAscIdFolhaIncompativelFkNomeTipoFolhaAsc(String nome);
	
	public List<IncompatibilidadeFolhaFolha> findByIdFolhaFkOrderByIdFolhaFkNomeTipoFolhaAscIdFolhaIncompativelFkNomeTipoFolhaAsc(TiposDeFolha tiposDeFolha);
	
	public List<IncompatibilidadeFolhaFolha> findByIdFolhaIncompativelFkOrderByIdFolhaFkNomeTipoFolhaAscIdFolhaIncompativelFkNomeTipoFolhaAsc(TiposDeFolha tiposDeFolha);
	
	public List<IncompatibilidadeFolhaFolha> findByIdFolhaFkAndIdFolhaIncompativelFkOrderByIdFolhaFkNomeTipoFolhaAscIdFolhaIncompativelFkNomeTipoFolhaAsc(TiposDeFolha tiposDeFolha, TiposDeFolha tiposDeFolhaIncompativel);
	
	
	public Page<IncompatibilidadeFolhaFolha> findAllByOrderByIdFolhaFkNomeTipoFolhaAscIdFolhaIncompativelFkNomeTipoFolhaAsc( final Pageable pageable);
	
	public Page<IncompatibilidadeFolhaFolha> findByIdFolhaFkNomeTipoFolhaContainingOrderByIdFolhaFkNomeTipoFolhaAscIdFolhaIncompativelFkNomeTipoFolhaAsc(String nome, final Pageable pageable);
	
	
}
