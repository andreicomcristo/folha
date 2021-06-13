package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.FuncionariosFerias;
import com.folha.boot.domain.PessoaFuncionarios;

@Repository
public interface FuncionariosFeriasReposytory extends JpaRepository<FuncionariosFerias, Long> {

	public List<FuncionariosFerias> findByDtCancelamentoIsNullOrderByAnoReferenciaDesc();

	public List<FuncionariosFerias> findByAnoReferenciaContainingAndDtCancelamentoIsNullOrderByAnoReferenciaDesc(String anoReferencia);
	
	public List<FuncionariosFerias> findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByAnoReferenciaDesc(PessoaFuncionarios funcionario);
	
}
