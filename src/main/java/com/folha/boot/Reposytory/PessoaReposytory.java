package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.Pessoa;

@Repository
public interface PessoaReposytory extends JpaRepository<Pessoa, Long> {
	
	public List<Pessoa> findAllByOrderByNomeAsc();

	public List<Pessoa> findByNomeContainingOrderByNomeAsc(String nome);
}
