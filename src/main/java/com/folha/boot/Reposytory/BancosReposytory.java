package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.Bancos;

@Repository
public interface BancosReposytory extends JpaRepository<Bancos, Long> {
	
	

}
