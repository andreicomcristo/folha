package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.Enderecos;
import com.folha.boot.domain.Pessoa;

@Repository
public interface EnderecosReposytory extends JpaRepository<Enderecos, Long> {

	public List<Enderecos> findAllByOrderByEnderecoLogradouroAsc();

	public List<Enderecos> findByEnderecoLogradouroContainingOrderByEnderecoLogradouroAsc(String enderecoLogradouro);
	
	public List<Enderecos> findByIdPessoaFk(Pessoa pessoa);
}
