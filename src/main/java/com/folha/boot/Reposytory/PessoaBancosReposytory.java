package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaBancos;
import com.folha.boot.domain.PessoaDocumentos;

@Repository
public interface PessoaBancosReposytory extends JpaRepository<PessoaBancos, Long> {

	public List<PessoaBancos> findByAndDtCancelamentoIsNullOrderByIdPrioritarioFkSiglaAsc();

	public List<PessoaBancos> findByIdBancoFkNomeBancoContainingAndDtCancelamentoIsNullOrderByIdPrioritarioFkSiglaAsc(String nome);
	
	public List<PessoaBancos> findByIdPessoaFkAndDtCancelamentoIsNull(Pessoa pessoa);
	
	public List<PessoaBancos> findByIdPessoaFkAndIdPrioritarioFkSiglaAndDtCancelamentoIsNull(Pessoa pessoa, String  sim_nao);
	
}
