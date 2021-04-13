package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.GrupoUsuario;

@Repository
public interface GrupoUsuarioReposytory extends JpaRepository<GrupoUsuario, Long> {
	
	public List<GrupoUsuario> findAllByOrderByNomeAsc();
	
	public List<GrupoUsuario> findByNomeContainingOrderByNomeAsc(String nome);	
}
