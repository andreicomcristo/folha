package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.TiposDeAnexo;

@Repository
public interface TiposDeAnexoReposytory extends JpaRepository<TiposDeAnexo, Long>{

}
