package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;

@Repository
public interface PessoaFuncionariosReposytory extends JpaRepository<PessoaFuncionarios, Long> {

	public List<PessoaFuncionarios> findAllByOrderByMatriculaAsc();

	public List<PessoaFuncionarios> findByMatriculaContainingOrderByMatriculaAsc(String matricula);
	
	public List<PessoaFuncionarios> findByIdPessoaFk(Pessoa pessoa);
}
