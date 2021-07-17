package com.folha.boot.Reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.folha.boot.domain.RubricaPensao;
import com.folha.boot.domain.RubricaPensaoDependente;

public interface RubricaPensaoDependenteReposytory extends JpaRepository<RubricaPensaoDependente, Long>{

	public List<RubricaPensaoDependente> findByIdRubricaPensaoFk(RubricaPensao pensao); 
}
