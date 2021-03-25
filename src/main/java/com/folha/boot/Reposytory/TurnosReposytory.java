package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.Turnos;

@Repository
public interface TurnosReposytory extends JpaRepository<Turnos, Long>{

}
