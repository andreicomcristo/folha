package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.CargosEspecialidade;

@Repository
public interface CargosEspecialidadeReposytory extends JpaRepository<CargosEspecialidade, Long> {

}
