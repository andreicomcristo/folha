package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.seguranca.Perfil;

@Repository
public interface PerfilReposytory extends JpaRepository<Perfil, Long> {

	List<Perfil> findFirstByIdOperadorFkAndIdUnidadeFk(PessoaOperadores pessoaopOperadores, Unidades unidades);
}
