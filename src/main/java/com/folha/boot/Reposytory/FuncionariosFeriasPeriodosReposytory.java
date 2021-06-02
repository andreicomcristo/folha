package com.folha.boot.Reposytory;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.FuncionariosFerias;
import com.folha.boot.domain.FuncionariosFeriasPeriodos;

@Repository
public interface FuncionariosFeriasPeriodosReposytory extends JpaRepository<FuncionariosFeriasPeriodos, Long>{ 
	
	public List<FuncionariosFeriasPeriodos> findByIdFeriasFk(FuncionariosFerias ferias); 

	public List<FuncionariosFeriasPeriodos> findByDtInicialLessThanEqualAndDtFinalGreaterThanEqualAndDtCancelamentoIsNullOrderByIdFeriasFkIdFuncionarioFkIdPessoaFkCpfAsc (Date dataFinal, Date dataInicial);
	
}
