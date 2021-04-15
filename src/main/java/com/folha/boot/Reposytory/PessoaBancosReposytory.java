package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaBancos;
import com.folha.boot.domain.PessoaDocumentos;

@Repository
public interface PessoaBancosReposytory extends JpaRepository<PessoaBancos, Long> {

	public List<PessoaBancos> findAllByOrderByIdPrioritarioFkSiglaAsc();

	public List<PessoaBancos> findByIdBancoFkNomeBancoContainingOrderByIdPrioritarioFkSiglaAsc(String nome);
	
	public List<PessoaBancos> findByIdPessoaFk(Pessoa pessoa);
	
}
