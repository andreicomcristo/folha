package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.FuncionariosFerias;
import com.folha.boot.domain.PessoaFuncionarios;

@Repository
public interface FuncionariosFeriasReposytory extends JpaRepository<FuncionariosFerias, Long> {

	public List<FuncionariosFerias> findAllByOrderByAnoReferenciaAsc();

	public List<FuncionariosFerias> findByAnoReferenciaContainingOrderByAnoReferenciaAsc(String anoReferencia);
	
	public List<FuncionariosFerias> findByIdFuncionarioFk(PessoaFuncionarios funcionario);
	
}
