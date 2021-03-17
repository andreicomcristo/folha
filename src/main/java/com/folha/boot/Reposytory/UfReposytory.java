package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.Uf;

@Repository
public interface UfReposytory extends JpaRepository<Uf, Long> {

	public List<Uf> findAllByOrderByNomeUfAsc();
	
	public List<Uf> findByNomeUfContainingOrderByNomeUfAsc(String nomeUf);	
	
}
