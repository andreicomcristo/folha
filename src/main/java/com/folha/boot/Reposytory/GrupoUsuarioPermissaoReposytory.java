package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.seguranca.GrupoUsuario;
import com.folha.boot.domain.seguranca.GrupoUsuarioPermissao;

@Repository
public interface GrupoUsuarioPermissaoReposytory extends JpaRepository<GrupoUsuarioPermissao, Long> {
	
	public List<GrupoUsuarioPermissao> findByIdGrupoUsuarioFkOrderByIdPermissaoFkAsc(GrupoUsuario grupoUsuario);
	
	
}
