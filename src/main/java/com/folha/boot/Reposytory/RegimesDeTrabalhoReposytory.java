package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.folha.boot.domain.RegimesDeTrabalho;

public interface RegimesDeTrabalhoReposytory extends JpaRepository<RegimesDeTrabalho, Long> {

	public List<RegimesDeTrabalho> findAllByOrderByNomeRegimeDeTrabalhoAsc();

	public List<RegimesDeTrabalho> findByNomeRegimeDeTrabalhoContainingOrderByNomeRegimeDeTrabalhoAsc(String nomeRegimeDeTrabalho);
	
}
