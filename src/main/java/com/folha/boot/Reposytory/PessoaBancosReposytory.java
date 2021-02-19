package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.PessoaBancos;

@Repository
public interface PessoaBancosReposytory extends JpaRepository<PessoaBancos, Long> {

	public List<PessoaBancos> findAllByOrderByPrioritarioAsc();

	public List<PessoaBancos> findByPrioritarioContainingOrderByPrioritarioAsc(String prioritario);

}
