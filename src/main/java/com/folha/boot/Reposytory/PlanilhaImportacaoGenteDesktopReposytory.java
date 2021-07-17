package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.PlanilhaImportacaoGenteDesktop;

@Repository
public interface PlanilhaImportacaoGenteDesktopReposytory extends JpaRepository<PlanilhaImportacaoGenteDesktop, Long>{

}
